package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

class KindDumbassStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision = Decision.Cooperate
}
