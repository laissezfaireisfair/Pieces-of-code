package Game.State;

import Game.Game;

public class TournamentGameState extends ProcessGameState {
    public TournamentGameState(Game game) {
        super(game);
    }

    @Override
    public boolean doStage() {
        // TODO: Implement
        game.switchGameState(new EndGameState(game));
        return false;
    }
}
