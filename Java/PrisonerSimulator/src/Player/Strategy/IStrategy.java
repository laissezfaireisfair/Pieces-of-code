package Player.Strategy;

import Game.Decision;
import Player.IPlayerStrategyFacade;

public interface IStrategy {
    Decision MakeDecision(IPlayerStrategyFacade player, int rivalId);
}
