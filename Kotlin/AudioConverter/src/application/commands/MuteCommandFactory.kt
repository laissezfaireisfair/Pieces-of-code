package application.commands

import application.IAudioPoolFacade

class MuteCommandFactory(audioPool: IAudioPoolFacade) : AbstractCommandFactory(audioPool) {
    private val parametersCount = 3

    override fun createCommand(parameters: List<String>): ICommand {
        if (parameters.size != parametersCount)
            throw IllegalArgumentException("Expected $parametersCount parameters, got: ${parameters.size}")

        val muteFromSec = parameters[1].toIntOrNull()
            ?: throw IllegalArgumentException("Expected second to mute from, got: ${parameters[1]}")

        val muteToSec = parameters[2].toIntOrNull()
            ?: throw IllegalArgumentException("Expected second to mute to, got: ${parameters[2]}")

        return MuteCommand(muteFromSec, muteToSec)
    }
}
