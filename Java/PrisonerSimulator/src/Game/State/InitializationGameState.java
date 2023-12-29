package Game.State;

import Game.Configurator;
import Game.Game;
import Game.GameRules;
import Player.PlayerFactory;

import java.util.InputMismatchException;
import java.util.Objects;

public class InitializationGameState implements IGameState {
    private final Game game;

    public InitializationGameState(Game game) {
        this.game = game;
    }

    private IGameState getModeState(String modeName) {
        if (Objects.equals(modeName, "detailed")) return new DetailedGameState(game);
        if (Objects.equals(modeName, "fast")) return new FastGameState(game);
        if (Objects.equals(modeName, "tournament")) return new TournamentGameState(game);

        var message = String.format("Unknown mode name: %s", modeName);
        throw new InputMismatchException(message);
    }

    @Override
    public boolean doStage() {
        var playerFactory = new PlayerFactory();
        var configurator = Configurator.Instance();

        var strategies = configurator.getStrategyNames();
        for (var strategy : strategies) {
            game.addPlayer(playerFactory.createPlayer(strategy));
        }

        int roundsCount = configurator.getRoundsCount();
        int cooperationReward = configurator.getCooperationReward();
        int cooperationFine = configurator.getCooperationFine();
        int defectFine = configurator.getDefectFine();
        int defectReward = configurator.getDefectReward();
        var gameRules = new GameRules(roundsCount, cooperationReward, cooperationFine, defectFine, defectReward);

        game.setGameRules(gameRules);

        var newState = getModeState(configurator.getModeName());

        game.switchGameState(newState);

        return false;
    }
}
