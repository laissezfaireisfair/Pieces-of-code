package player.strategy

import game.Decision
import player.IPlayerStrategyFacade

interface IStrategy {
    fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision
}
