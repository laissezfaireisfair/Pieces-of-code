package player

import game.Decision

interface IPlayerStrategyFacade {
    val score: Int

    val myDecisionsByRivalId: HashMap<Int, MutableList<Decision>>

    val rivalDecisionsById: HashMap<Int, MutableList<Decision>>
}
