package Player;

import Player.Strategy.IStrategy;
import Player.Strategy.KindRepeaterStrategy;

import java.util.InputMismatchException;
import java.util.Objects;

public class PlayerFactory {
    private int idCounter = 0;

    private IStrategy createStrategyByName(String name) {
        if (Objects.equals(name, "KindRepeaterStrategy")) {
            return new KindRepeaterStrategy();
        }
        // TODO: Implement rest of strategies

        throw new InputMismatchException(String.format("Unknown strategy name: %s", name));
    }

    public Player createPlayer(String strategy_name) {
        var strategy = createStrategyByName(strategy_name);
        int id = idCounter++;
        var name = strategy_name + id;

        return new Player(id, name, strategy);
    }
}
