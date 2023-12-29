package Game.State;

import Game.Game;

import java.util.ArrayList;

public class FastGameState extends ProcessGameState {
    private int round;

    public FastGameState(Game game) {
        super(game);
        currentCompetitors = new ArrayList<>(game.getPlayers());
        round = 0;
    }

    @Override
    public boolean doStage() {
        RunCompetitionStep();

        currentPlayerIndex += 1;
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size();

        boolean isRoundComplete = currentPlayerIndex == currentCompetitors.size();
        if (isRoundComplete) {
            currentPlayerIndex = 0;
            currentRivalIndex = 1;
            ++round;

            boolean isGameFinished = round == game.getGameRules().getRoundsCount();
            if (isGameFinished) {
                game.switchGameState(new EndGameState(game));
            }
        }

        return false;
    }
}
