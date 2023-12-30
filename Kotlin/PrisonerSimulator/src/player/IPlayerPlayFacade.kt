package player

import game.Decision

interface IPlayerPlayFacade {
    val id: Int

    val name: String

    val score: Int

    fun makeDecision(rivalId: Int): Decision

    fun storeDecision(rivalId: Int, decision: Decision)

    fun updateScore(delta: Int, rivalId: Int)

    fun getLastDelta(rivalId: Int): Int?

    fun getLastDecision(rivalId: Int): Decision?
}
