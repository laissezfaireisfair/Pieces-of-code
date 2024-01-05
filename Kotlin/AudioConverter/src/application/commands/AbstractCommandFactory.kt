package application.commands

import application.Audio
import application.IAudioPoolFacade

abstract class AbstractCommandFactory(private val audioPool: IAudioPoolFacade) {
    protected fun getAudioFromPoolByAlias(alias: String): Audio {
        val aliasRegex = """[$](\d)+""".toRegex()

        val index = aliasRegex.matchEntire(alias)?.groupValues?.getOrNull(1)?.toIntOrNull()
            ?: throw IllegalArgumentException("Bad audio alias: $alias")

        return audioPool.getAudioByIndex(index)
            ?: throw IllegalArgumentException("Index out of range: $index")
    }

    abstract fun createCommand(parameters: List<String>): ICommand
}
