package player.strategy

import game.Decision
import player.IPlayerStrategyFacade
import kotlin.random.Random

class KindForgivingRepeaterStrategy : IStrategy {
    private val forgiveThreshold = 5

    override fun makeDecision(player: IPlayerStrategyFacade, rivalId: Int): Decision {
        val decision = player.rivalDecisionsById[rivalId]?.lastOrNull() ?: Decision.Cooperate

        if (decision == Decision.Defect && Random.nextInt(1, 6) >= forgiveThreshold)
            return Decision.Cooperate

        return decision
    }

}
