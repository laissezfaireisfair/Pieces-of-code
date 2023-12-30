package player

import game.Decision
import player.strategy.IStrategy

class Player(
    override val id: Int,
    override val name: String,
    private val strategy: IStrategy
) : IPlayerPlayFacade, IPlayerStrategyFacade {
    override var score = 0
    override val myDecisionsByRivalId = hashMapOf<Int, MutableList<Decision>>()
    override val rivalDecisionsById = hashMapOf<Int, MutableList<Decision>>()
    private val lastDeltaById = hashMapOf<Int, Int>()

    override fun makeDecision(rivalId: Int): Decision {
        val decision = strategy.makeDecision(this, rivalId)

        myDecisionsByRivalId.getOrPut(rivalId) { mutableListOf() }.add(decision)

        return decision
    }

    override fun storeDecision(rivalId: Int, decision: Decision) {
        rivalDecisionsById.getOrPut(rivalId) { mutableListOf() }.add(decision)
    }

    override fun updateScore(delta: Int, rivalId: Int) {
        score += delta

        lastDeltaById[rivalId] = delta
    }

    override fun getLastDelta(rivalId: Int): Int? = lastDeltaById[rivalId]

    override fun getLastDecision(rivalId: Int): Decision? = myDecisionsByRivalId[rivalId]?.lastOrNull()
}
