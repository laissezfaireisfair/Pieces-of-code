package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

class KindRepeaterStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision =
        player.rivalDecisionsById[rivalId]?.lastOrNull() ?: Decision.Cooperate
}
