package Player;

import Player.Strategy.*;

import java.util.InputMismatchException;
import java.util.Objects;

public class PlayerFactory {
    private int idCounter = 0;

    private IStrategy createStrategyByName(String name) {
        if (Objects.equals(name, "EvilDumbassStrategy")) {
            return new EvilDumbassStrategy();
        }
        if (Objects.equals(name, "EvilRepeaterStrategy")) {
            return new EvilRepeaterStrategy();
        }
        if (Objects.equals(name, "InconsistentStrategy")) {
            return new InconsistentStrategy();
        }
        if (Objects.equals(name, "KindDumbassStrategy")) {
            return new KindDumbassStrategy();
        }
        if (Objects.equals(name, "KindForgivingRepeaterStrategy")) {
            return new KindForgivingRepeaterStrategy();
        }
        if (Objects.equals(name, "KindRepeaterStrategy")) {
            return new KindRepeaterStrategy();
        }
        if (Objects.equals(name, "RandomStrategy")) {
            return new RandomStrategy();
        }


        throw new InputMismatchException(String.format("Unknown strategy name: %s", name));
    }

    public Player createPlayer(String strategy_name) {
        var strategy = createStrategyByName(strategy_name);
        int id = idCounter++;
        var name = strategy_name + id;

        return new Player(id, name, strategy);
    }
}
