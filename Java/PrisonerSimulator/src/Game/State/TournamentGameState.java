package Game.State;

import Game.Game;
import Player.IPlayerPlayFacade;

import java.util.ArrayList;
import java.util.List;

public class TournamentGameState extends ProcessGameState {
    private final ArrayList<List<IPlayerPlayFacade>> waitingGroups;

    private int round;

    public TournamentGameState(Game game) {
        super(game);
        var allPlayers = game.getPlayers();

        waitingGroups = new ArrayList<>();
        for (var i = 0; i < allPlayers.size() - 2; ++i) {
            for (var j = i + 1; j < allPlayers.size() - 1; ++j) {
                for (var k = j + 1; k < allPlayers.size(); ++k) {
                    waitingGroups.add(List.of(allPlayers.get(i), allPlayers.get(j), allPlayers.get(k)));
                }
            }
        }

        round = 0;

        currentCompetitors = new ArrayList<>();
        loadNextPlayerGroup();
    }

    private void loadNextPlayerGroup() {
        if (waitingGroups.isEmpty()) return;

        var newGroup = waitingGroups.get(waitingGroups.size() - 1);
        waitingGroups.remove(waitingGroups.size() - 1);

        currentCompetitors = newGroup;
    }

    private void PrintGroupCompetitionResult() {
        System.out.println("Group competition performed");

        for (var player : currentCompetitors) {
            System.out.printf("%s score: %d\n", player.getName(), player.getScore());
        }

        System.out.println();
    }

    @Override
    public boolean doStage() {
        RunCompetitionStep();

        currentPlayerIndex += 1;
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size();

        boolean is_round_complete = currentPlayerIndex == currentCompetitors.size();
        if (is_round_complete) {
            currentPlayerIndex = 0;
            currentRivalIndex = 1;
            ++round;

            boolean is_last_round = round == game.getGameRules().getRoundsCount();
            if (is_last_round) {
                if (waitingGroups.isEmpty()) {
                    game.switchGameState(new EndGameState(game));
                } else {
                    PrintGroupCompetitionResult();
                    loadNextPlayerGroup();
                    round = 0;
                }
            }
        }

        return false;
    }
}
