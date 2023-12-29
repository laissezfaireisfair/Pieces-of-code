package Game.State;

import Game.Game;

import java.util.ArrayList;

public class DetailedGameState extends ProcessGameState {
    private int round;

    private void PrintCompetitionStepInfo() {
        var player = currentCompetitors.get(currentPlayerIndex);
        var rival = currentCompetitors.get(currentRivalIndex);

        System.out.println("Step complete");

        var playerLastDecision = player.getLastDecision(rival.getId()).toString();
        int playerDelta = player.getLastDelta(rival.getId());
        System.out.printf(" %s: %sm Delta: %d (Score = %d)\n", player.getName(), playerLastDecision, playerDelta, player.getScore());

        var rivalLastDecision = rival.getLastDecision(player.getId()).toString();
        int rivalDelta = rival.getLastDelta(player.getId());
        System.out.printf(" %s: %sm Delta: %d (Score = %d)\n", rival.getName(), rivalLastDecision, rivalDelta, rival.getScore());
    }

    public DetailedGameState(Game game) {
        super(game);
        currentCompetitors = new ArrayList<>(game.getPlayers());
        round = 0;
    }

    @Override
    public boolean doStage() {
        RunCompetitionStep();
        PrintCompetitionStepInfo();

        currentPlayerIndex += 1;
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size();

        boolean isRoundComplete = currentPlayerIndex == currentCompetitors.size();
        if (isRoundComplete) {
            currentPlayerIndex = 0;
            currentRivalIndex = 1;

            System.out.printf("Round %d finished\n\n", round);
            ++round;

            boolean isGameFinished = round == game.getGameRules().getRoundsCount();
            if (isGameFinished) {
                game.switchGameState(new EndGameState(game));
            }
        }

        return false;
    }
}
