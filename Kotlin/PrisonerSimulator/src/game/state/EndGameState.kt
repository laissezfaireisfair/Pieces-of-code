package game.state

import game.Game

class EndGameState(val game: Game) : IGameState {
    override fun doStage(): Boolean {
        println("Simulation finished\nScores")

        game.players.forEach { println("${it.name} ${it.score} points") }

        println()

        return true
    }
}
