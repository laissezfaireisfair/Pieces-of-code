package application

import application.commands.ICommand
import application.commands.InsertCommandFactory
import application.commands.MixCommandFactory
import application.commands.MuteCommandFactory
import java.io.File

class Application(parameters: AppParameters) : IAudioPoolFacade {
    private val audioPool = parameters.inputFileNames.map {
        try {
            WavEncoder.readAudio(it)
        } catch (exception: Exception) {
            println("Reading file $it FAILED:\n $exception")
            throw exception
        }
    }

    private val audioToModify = audioPool.firstOrNull() ?: run {
        val message = "No audio files provided"
        println(message)
        throw Exception(message)
    }

    private val outputFileName = parameters.outputFileName

    private val commands: List<ICommand>

    init {
        val commandFactoryByNameToken = hashMapOf(
            "mute" to MuteCommandFactory(this),
            "mix" to MixCommandFactory(this),
            "insert" to InsertCommandFactory(this)
        )

        fun configLineToCommand(line: String): ICommand {
            val tokens = line.split(' ')

            return commandFactoryByNameToken[tokens.first()]?.createCommand(tokens) ?: run {
                val message = "No audio files provided"
                println(message)
                throw Exception(message)
            }
        }
        commands = File(parameters.configFileName).readLines().map { configLineToCommand(it) }
    }

    fun run() {
        commands.forEach {
            try {
                it.run(audioToModify)
            } catch (exception: Exception) {
                println("Command ${it.description} execution FAILED:\n $exception")
                throw exception
            }
        }

        try {
            WavEncoder.writeAudio(audioToModify, outputFileName)
        } catch (exception: Exception) {
            println("Writing output file to $outputFileName FAILED:\n $exception")
        }
    }

    override fun getAudioByIndex(index: Int): Audio? = audioPool.getOrNull(index)
}

