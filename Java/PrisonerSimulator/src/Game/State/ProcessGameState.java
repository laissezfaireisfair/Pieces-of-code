package Game.State;

import Game.Decision;
import Game.Game;
import Player.IPlayerPlayFacade;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessGameState implements IGameState {
    protected final Game game;

    protected List<IPlayerPlayFacade> currentCompetitors;

    protected int currentPlayerIndex;

    protected int currentRivalIndex;

    public ProcessGameState(Game game) {
        this.game = game;
        currentCompetitors = new ArrayList<>();
        currentPlayerIndex = 0;
        currentRivalIndex = 1;
    }

    /**
     * This method assumes that indexes are correct and does not update them after the step
     */
    protected void RunCompetitionStep() {
        var player = currentCompetitors.get(currentPlayerIndex);
        var rival = currentCompetitors.get(currentRivalIndex);

        var playerId = player.getId();
        var rivalId = rival.getId();

        var playerDecision = player.makeDecision(rivalId);
        var rivalDecision = rival.makeDecision(rivalId);

        player.storeDecision(rivalId, rivalDecision);
        rival.storeDecision(playerId, playerDecision);

        var gameRules = game.getGameRules();

        if (playerDecision == Decision.Cooperate && rivalDecision == Decision.Cooperate) {
            player.updateScore(gameRules.getCooperationReward(), rivalId);
            rival.updateScore(gameRules.getCooperationReward(), playerId);
            return;
        }

        if (playerDecision == Decision.Defect && rivalDecision == Decision.Defect) {
            player.updateScore(gameRules.getDefectFine(), rivalId);
            rival.updateScore(gameRules.getDefectFine(), playerId);
            return;
        }

        if (playerDecision == Decision.Cooperate && rivalDecision == Decision.Defect) {
            player.updateScore(gameRules.getCooperationFine(), rivalId);
            rival.updateScore(gameRules.getDefectReward(), playerId);
            return;
        }

        if (playerDecision == Decision.Defect && rivalDecision == Decision.Cooperate) {
            player.updateScore(gameRules.getDefectReward(), rivalId);
            rival.updateScore(gameRules.getCooperationFine(), playerId);
        }
    }
}
