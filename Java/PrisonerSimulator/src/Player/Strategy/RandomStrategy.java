package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

import java.util.Random;

public class RandomStrategy implements IStrategy {
    private final Random random;

    public RandomStrategy() {
        random = new Random();
    }

    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        boolean isCooperating = random.nextBoolean();
        return isCooperating ? Decision.Cooperate : Decision.Defect;
    }
}
