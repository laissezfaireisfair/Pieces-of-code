package application

import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder

class WavEncoder {
    companion object {
        private data class WavHeader(
            val riffId: List<Byte> = listOf('R', 'I', 'F', 'F').map { it.code.toByte() },
            val chunkSize: Int,
            val format: List<Byte> = listOf('W', 'A', 'V', 'E').map { it.code.toByte() },
            val fmtId: List<Byte> = listOf('f', 'm', 't', ' ').map { it.code.toByte() },
            val fmtSubChunkSize: Int = 16,
            val audioFormat: Int = 1,
            val numChannels: Int = 1,
            val sampleRate: Int = 44100,
            val byteRate: Int = 88200,
            val blockAlign: Int = 2,
            val bitsPerSample: Int = 16,
            val dataId: List<Byte> = listOf('d', 'a', 't', 'a').map { it.code.toByte() },
            val dataSubChunkSize: Int,
        ) {
            constructor(buffer: ByteBuffer) : this(
                riffId = listOf<Byte>(buffer.get(), buffer.get(), buffer.get(), buffer.get()),
                chunkSize = buffer.getInt(),
                format = listOf<Byte>(buffer.get(), buffer.get(), buffer.get(), buffer.get()),
                fmtId = listOf<Byte>(buffer.get(), buffer.get(), buffer.get(), buffer.get()),
                fmtSubChunkSize = buffer.getInt(),
                audioFormat = buffer.getInt(),
                numChannels = buffer.getInt(),
                sampleRate = buffer.getInt(),
                byteRate = buffer.getInt(),
                blockAlign = buffer.getInt(),
                bitsPerSample = buffer.getInt(),
                dataId = listOf<Byte>(buffer.get(), buffer.get(), buffer.get(), buffer.get()),
                dataSubChunkSize = buffer.getInt(),
            )

            fun writeToStream(stream: BufferedOutputStream) {
                val buffer = ByteBuffer.allocate(4)
                fun writeInt(number: Int) {
                    buffer.putInt(number)
                    (0..3).forEach { stream.write(buffer[it].toInt()) }
                    buffer.clear()
                }

                riffId.forEach { stream.write(it.toInt()) }
                writeInt(chunkSize)
                format.forEach { stream.write(it.toInt()) }
                fmtId.forEach { stream.write(it.toInt()) }
                writeInt(fmtSubChunkSize)
                writeInt(audioFormat)
                writeInt(numChannels)
                writeInt(sampleRate)
                writeInt(byteRate)
                writeInt(blockAlign)
                writeInt(bitsPerSample)
                dataId.forEach { stream.write(it.toInt()) }
                writeInt(dataSubChunkSize)
            }
        }

        fun readAudio(path: String): Audio {
            val file = File(path)
            val buffer = ByteBuffer.wrap(file.readBytes()).order(ByteOrder.LITTLE_ENDIAN)
            val header = WavHeader(buffer)
            val audio = Audio(path, header.dataSubChunkSize / 2)

            var index = 0
            while (buffer.hasRemaining()) {
                audio[index] = buffer.get().toInt()
                ++index
            }

            return audio
        }

        fun writeAudio(audio: Audio, path: String) {
            val dataSubChunkSize = audio.samplesCount * 2

            val header = WavHeader(
                dataSubChunkSize = dataSubChunkSize,
                chunkSize = 36 + dataSubChunkSize
            )

            val stream = BufferedOutputStream(FileOutputStream(path))
            header.writeToStream(stream)

            for (sampleIndex in 0..<audio.samplesCount)
                stream.write(audio[sampleIndex])
        }
    }
}
