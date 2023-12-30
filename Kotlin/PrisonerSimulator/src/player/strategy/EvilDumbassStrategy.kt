package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

class EvilDumbassStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision = Decision.Defect
}
