package application

interface IAudioPoolFacade {
    fun getAudioByIndex(index: Int): Audio?
}