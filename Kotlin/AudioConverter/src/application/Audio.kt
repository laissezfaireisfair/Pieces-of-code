package application

class Audio(val name: String, samplesCount: Int) {
    companion object {
        const val SAMPLES_PER_SECOND = 44100
    }

    private val samples = MutableList(samplesCount) { _ -> 0 }

    val samplesCount: Int
        get() = samples.size

    fun extend(newSize: Int) {
        if (newSize > samplesCount)
            samples.addAll(List(newSize - samplesCount) { _ -> 0 })
    }

    operator fun set(i: Int, value: Int) {
        samples[i] = value
    }

    operator fun get(i: Int): Int = samples[i]
}
