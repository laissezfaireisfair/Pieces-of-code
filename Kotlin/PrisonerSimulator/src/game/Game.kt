package game

import game.state.IGameState
import game.state.InitializationGameState
import player.IPlayerPlayFacade

class Game {
    var gameState: IGameState = InitializationGameState(this)
    lateinit var gameRules: GameRules
    val players = mutableListOf<IPlayerPlayFacade>()

    fun run() {
        while (true) {
            val isEnded = gameState.doStage()
            if (isEnded)
                break
        }
    }
}
