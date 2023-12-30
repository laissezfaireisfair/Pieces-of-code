package game.state

import game.Configurator
import game.Decision.Cooperate
import game.Decision.Defect
import game.Game
import player.IPlayerPlayFacade

abstract class ProcessGameState(protected val game: Game) : IGameState {
    protected abstract val currentCompetitors: List<IPlayerPlayFacade>
    protected var currentPlayerIndex = 0
    protected var currentRivalIndex = 1

    // This method assumes that indexes are correct and does not update them after the step
    protected open fun runCompetitionStep() {
        val (player, rival) = currentCompetitors[currentPlayerIndex] to currentCompetitors[currentRivalIndex]

        val (playerDecision, rivalDecision) = player.makeDecision(rival.id) to rival.makeDecision(player.id)

        player.storeDecision(rival.id, rivalDecision)
        rival.storeDecision(player.id, playerDecision)

        val (playerDelta, rivalDelta) = when {
            playerDecision == Cooperate && rivalDecision == Cooperate ->
                Configurator.cooperationReward to Configurator.cooperationReward

            playerDecision == Defect && rivalDecision == Defect ->
                Configurator.defectFine to Configurator.defectFine

            playerDecision == Cooperate && rivalDecision == Defect ->
                Configurator.cooperationFine to Configurator.defectReward

            playerDecision == Defect && rivalDecision == Cooperate ->
                Configurator.defectReward to Configurator.cooperationFine

            else -> throw IllegalStateException("Unknown decision: $playerDecision or $rivalDecision")
        }

        player.updateScore(playerDelta, rival.id)
        rival.updateScore(rivalDelta, player.id)
    }
}