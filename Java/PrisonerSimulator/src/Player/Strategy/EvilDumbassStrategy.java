package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

public class EvilDumbassStrategy implements IStrategy {
    @Override
    public Decision MakeDecision(IPlayerStrategyFacade player, int rivalId) {
        return Decision.Defect;
    }
}
