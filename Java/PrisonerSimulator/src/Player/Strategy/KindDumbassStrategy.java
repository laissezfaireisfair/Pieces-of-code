package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

public class KindDumbassStrategy implements IStrategy {
    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        return Decision.Cooperate;
    }
}
