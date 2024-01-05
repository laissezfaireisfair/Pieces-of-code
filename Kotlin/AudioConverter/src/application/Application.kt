package application

import application.commands.ICommand

class Application(parameters: AppParameters) : IAudioPoolFacade {
    val audioPool = listOf<Audio>()
    val commands = listOf<ICommand>()
    val outputFileName = parameters.outputFileName

    init {
        TODO("Read files and commands")
    }

    fun run() {
        TODO("Not yet implemented")
    }

    override fun getAudioByIndex(index: Int): Audio? {
        TODO("Not yet implemented")
    }
}
