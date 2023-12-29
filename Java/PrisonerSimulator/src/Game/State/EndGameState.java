package Game.State;

import Game.Game;

public class EndGameState implements IGameState {
    private final Game game;

    public EndGameState(Game game) {
        this.game = game;
    }

    @Override
    public boolean doStage() {
        System.out.println("Simulation finished.\n");

        System.out.println("Scores:");
        for (var player : game.getPlayers()) {
            System.out.printf("%s: %d points\n", player.getName(), player.getScore());
        }

        System.out.println();

        return true;
    }
}
