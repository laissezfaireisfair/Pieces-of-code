import game.Configurator
import game.Game
import java.io.File
import java.util.*

const val MIN_ARGUMENTS = 3

fun main(args: Array<String>) {
    if (args.size < MIN_ARGUMENTS) {
        println("Not enough arguments, expected at least $MIN_ARGUMENTS, got: ${args.size}")
        return
    }

    Configurator.strategyNames = getNamesFromArguments(args)
    getModeFromArguments(args)?.let { Configurator.modeName = it }
    getStepsFromArguments(args)?.let { Configurator.roundsCount = it.toInt() }
    getMatrixPathFromArguments(args)?.let { readMatrix(it) }

    val game = Game()

    try {
        game.run()
    } catch (exception: Exception) {
        println("Exception. End of simulation.\n$exception")
    }
}

fun getNamesFromArguments(args: Array<String>) =
    args.filter { !it.startsWith("--") }

fun getModeFromArguments(args: Array<String>) =
    args.firstOrNull { it.startsWith("--mode=") }
        ?.substring(7)

fun getStepsFromArguments(args: Array<String>) =
    args.firstOrNull { it.startsWith("--steps=") }
        ?.substring(8)

fun getMatrixPathFromArguments(args: Array<String>) =
    args.firstOrNull { it.startsWith("--matrix=") }
        ?.substring(8)

fun readMatrix(path: String) =
    with(Scanner(File(path))) {
        nextInt().let { Configurator.cooperationReward = it }
        nextInt().let { Configurator.cooperationFine = it }
        nextInt().let { Configurator.defectReward = it }
        nextInt().let { Configurator.defectFine = it }

        close()
    }
