package application.commands

import application.IAudioPoolFacade

class MixCommandFactory(audioPool: IAudioPoolFacade) : AbstractCommandFactory(audioPool) {
    private val parametersCount = 3

    override fun createCommand(parameters: List<String>): ICommand {
        if (parameters.size != parametersCount)
            throw IllegalArgumentException("Expected $parametersCount parameters, got: ${parameters.size}")

        val mixAfterSec = parameters[2].toIntOrNull()
            ?: throw IllegalArgumentException("Expected second to mix after, got: ${parameters[2]}")

        val audioToMixWith = getAudioFromPoolByAlias(parameters[1])

        return MixCommand(mixAfterSec, audioToMixWith)
    }
}
