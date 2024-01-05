package application.commands

import application.Audio
import kotlin.math.min

class MuteCommand(private val muteFromSec: Int, private val muteToSec: Int) : ICommand {
    override val description = "Mute from $muteFromSec to $muteToSec seconds"

    override fun run(audioToModify: Audio) {
        val muteFromSample = muteFromSec * Audio.SAMPLES_PER_SECOND
        val muteToSample = min(muteToSec * Audio.SAMPLES_PER_SECOND, audioToModify.samplesCount)

        for (sampleIndex in muteFromSample..<muteToSample)
            audioToModify[sampleIndex] = 0
    }
}
