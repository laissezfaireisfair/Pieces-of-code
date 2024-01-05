package application.commands

import application.Audio

class MixCommand(private val mixAfterSec: Int, private val audioToMixWith: Audio) : ICommand {
    override val description = "Mix with ${audioToMixWith.name} after $mixAfterSec seconds"

    override fun run(audioToModify: Audio) {
        val mixAfterSample = mixAfterSec * Audio.SAMPLES_PER_SECOND
        val endOfMixedBlock = mixAfterSample + audioToMixWith.samplesCount

        if (endOfMixedBlock > audioToModify.samplesCount)
            audioToModify.extend(endOfMixedBlock + 1)

        for (sampleIndex in 0..<audioToMixWith.samplesCount)
            audioToModify[mixAfterSample + sampleIndex] = (audioToModify[mixAfterSample + sampleIndex] + audioToMixWith[sampleIndex]) / 2
    }

}
