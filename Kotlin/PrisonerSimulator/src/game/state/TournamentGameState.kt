package game.state

import game.Game
import player.IPlayerPlayFacade

class TournamentGameState(game: Game) : ProcessGameState(game) {
    override val currentCompetitors = mutableListOf<IPlayerPlayFacade>()
    private var round = 0
    private val waitingGroups = mutableListOf<List<IPlayerPlayFacade>>()

    init {
        for (i in 0..<game.players.size - 2)
            for (j in i..<game.players.size - 1)
                for (k in j..<game.players.size)
                    waitingGroups.add(listOf(game.players[i], game.players[j], game.players[k]))

        loadNextPlayerGroup()
    }

    override fun doStage(): Boolean {
        runCompetitionStep()

        ++currentPlayerIndex
        currentRivalIndex = (currentRivalIndex + 1) % currentCompetitors.size

        val isRoundComplete = currentPlayerIndex == currentCompetitors.size
        if (isRoundComplete) {
            currentPlayerIndex = 0
            currentRivalIndex = 1
            ++round

            val isLastRound = round == game.gameRules.roundsCount
            if (isLastRound) {
                if (waitingGroups.isEmpty()) {
                    game.gameState = EndGameState(game)
                } else {
                    printGroupCompetitionResult()
                    loadNextPlayerGroup()
                    round = 0
                }
            }
        }

        return false
    }

    private fun loadNextPlayerGroup() {
        waitingGroups.lastOrNull()?.let { newGroup ->
            currentCompetitors.clear()
            newGroup.forEach { currentCompetitors.add(it) }
            waitingGroups.removeLast()
        }
    }

    private fun printGroupCompetitionResult() {
        println("Group competition performed")
        currentCompetitors.forEach { println("${it.name}: ${it.score}") }
        println()
    }
}
