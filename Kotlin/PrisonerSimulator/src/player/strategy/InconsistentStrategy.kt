package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

class InconsistentStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision =
        player.myDecisionsByRivalId[rivalId]?.lastOrNull()?.getOpposite() ?: Decision.Cooperate

}
