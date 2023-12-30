package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

class EvilRepeaterStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision =
        player.rivalDecisionsById[rivalId]?.lastOrNull() ?: Decision.Defect
}
