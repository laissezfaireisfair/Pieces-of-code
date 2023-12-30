package game

class Game {
    val gameState = InitializationGameState(this)

    fun run() {
        while (true) {
            val isEnded = gameState.doStage()
            if (isEnded)
                break;
        }
    }
}
