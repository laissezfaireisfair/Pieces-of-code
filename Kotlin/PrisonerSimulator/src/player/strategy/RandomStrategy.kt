package player.strategy

import game.Decision
import player.IPlayerStrategyFacade
import kotlin.random.Random

class RandomStrategy : IStrategy {
    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision =
        Random.nextBoolean().let {
            when (it) {
                true -> Decision.Cooperate
                false -> Decision.Defect
            }
        }

}
