package game.state

import game.Game

class DetailedGameState(game: Game) : ProcessGameState(game) {
    override val currentCompetitors = game.players
    private var round = 0

    private fun printCompetitionStepInfo() {
        val (player, rival) = currentCompetitors[currentPlayerIndex] to currentCompetitors[currentRivalIndex]
        val (playerDecision, rivalDecision) = player.getLastDecision(rival.id) to rival.getLastDecision(player.id)

        println("Step complete")
        println("${player.name}: $playerDecision Delta: ${player.getLastDelta(rival.id)} (Score = ${player.score})")
        println("${rival.name}: $rivalDecision Delta: ${rival.getLastDelta(player.id)} (Score = ${rival.score})")
    }

    override fun doStage(): Boolean {
        runCompetitionStep()
        printCompetitionStepInfo()

        ++currentPlayerIndex
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size

        val isRoundComplete = currentPlayerIndex == currentCompetitors.size
        if (isRoundComplete) {
            currentPlayerIndex = 0
            currentRivalIndex = 1
            println("Round $round finished\n\n")
            ++round

            val isGameFinished = round == game.gameRules.roundsCount
            if (isGameFinished) {
                game.gameState = EndGameState(game)
            }
        }

        return false
    }
}
