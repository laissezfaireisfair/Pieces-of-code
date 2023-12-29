package Game;

import Game.State.IGameState;
import Game.State.InitializationGameState;
import Player.IPlayerPlayFacade;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //region PrivatePart
    private final List<IPlayerPlayFacade> players;
    private IGameState gameState;
    private GameRules gameRules;
    //endregion

    public Game() {
        gameRules = null;
        players = new ArrayList<>();
        gameState = new InitializationGameState(this);
    }

    public void switchGameState(IGameState gameState) {
        this.gameState = gameState;
    }

    public GameRules getGameRules() {
        return gameRules;
    }

    public void setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
    }

    public void addPlayer(IPlayerPlayFacade player) {
        players.add(player);
    }

    public List<IPlayerPlayFacade> getPlayers() {
        return players;
    }

    public void run() {
        while (true) {
            boolean isEnded = gameState.doStage();
            if (isEnded) break;
        }
    }
}
