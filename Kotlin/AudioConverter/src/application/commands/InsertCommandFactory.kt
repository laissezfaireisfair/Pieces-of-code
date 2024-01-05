package application.commands

import application.IAudioPoolFacade

class InsertCommandFactory(audioPool: IAudioPoolFacade) : AbstractCommandFactory(audioPool) {
    private val parametersCount = 3

    override fun createCommand(parameters: List<String>): ICommand {
        if (parameters.size != parametersCount)
            throw IllegalArgumentException("Expected $parametersCount parameters, got: ${parameters.size}")

        val insertAfterSec = parameters[2].toIntOrNull()
            ?: throw IllegalArgumentException("Expected second to insert after, got: ${parameters[2]}")

        val audioToInsert = getAudioFromPoolByAlias(parameters[1])

        return InsertCommand(insertAfterSec, audioToInsert)
    }
}
