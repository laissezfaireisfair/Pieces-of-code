package game.state

import game.Game

class FastGameState(game: Game) : ProcessGameState(game) {
    override val currentCompetitors = game.players
    private var round = 0

    override fun doStage(): Boolean {
        runCompetitionStep()

        ++currentPlayerIndex
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size

        val isRoundComplete = currentPlayerIndex == currentCompetitors.size
        if (isRoundComplete) {
            currentPlayerIndex = 0
            currentRivalIndex = 1
            ++round

            val isGameFinished = round == game.gameRules.roundsCount
            if (isGameFinished) {
                game.gameState = EndGameState(game)
            }
        }

        return false
    }
}
