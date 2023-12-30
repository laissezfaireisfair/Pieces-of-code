package player

import player.strategy.*

class PlayerFactory {
    private var idCounter = 0

    fun createPlayer(strategyName: String): Player {
        val strategy = when (strategyName) {
            "EvilDumbassStrategy" -> EvilDumbassStrategy()
            "EvilRepeaterStrategy" -> EvilRepeaterStrategy()
            "InconsistentStrategy" -> InconsistentStrategy()
            "KindDumbassStrategy" -> KindDumbassStrategy()
            "KindForgivingRepeaterStrategy" -> KindForgivingRepeaterStrategy()
            "KindRepeaterStrategy" -> KindRepeaterStrategy()
            "RandomStrategy" -> RandomStrategy()
            else -> throw IllegalArgumentException("Unknown strategy name: $strategyName")
        }

        return Player(++idCounter, strategyName + idCounter, strategy)
    }
}
