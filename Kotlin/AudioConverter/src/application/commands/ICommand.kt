package application.commands

import application.Audio

interface ICommand {
    val description: String

    fun run(audioToModify: Audio)
}
