package application.commands

import application.Audio

class InsertCommand(private val insertAfterSec: Int, private val audioToInsert: Audio) : ICommand {
    override val description = "Insert ${audioToInsert.name} after $insertAfterSec seconds"

    override fun run(audioToModify: Audio) {
        val insertAfterSample = insertAfterSec * Audio.SAMPLES_PER_SECOND
        val endOfInsertedBlock = insertAfterSample + audioToInsert.samplesCount

        if (endOfInsertedBlock > audioToModify.samplesCount)
            audioToModify.extend(endOfInsertedBlock + 1)

        for (sampleIndex in 0..<audioToInsert.samplesCount)
            audioToModify[insertAfterSample + sampleIndex] = audioToInsert[sampleIndex]
    }
}
