package game.state

import game.Configurator
import game.Game
import game.GameRules
import player.PlayerFactory

class InitializationGameState(private val game: Game) : IGameState {
    override fun doStage(): Boolean {
        val playerFactory = PlayerFactory()

        Configurator.strategyNames.forEach { game.players.add(playerFactory.createPlayer(it)) }

        game.gameRules = GameRules(
            Configurator.roundsCount,
            Configurator.cooperationReward,
            Configurator.cooperationFine,
            Configurator.defectFine,
            Configurator.defectReward
        )

        val newState = when (Configurator.modeName) {
            "detailed" -> DetailedGameState(game)
            "fast" -> FastGameState(game)
            "tournament" -> TournamentGameState(game)
            else -> throw IllegalArgumentException("Unknown game mode: ${Configurator.modeName}")
        }

        game.gameState = newState

        return false
    }
}
