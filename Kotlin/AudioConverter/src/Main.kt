import application.AppParameters
import application.Application

const val MIN_ARGUMENTS = 3

fun main(args: Array<String>) {
    if (args.size < MIN_ARGUMENTS) {
        println("Not enough arguments, expected at least $MIN_ARGUMENTS, got: ${args.size}")
        return
    }

    val appParameters = AppParameters(
        configFileName = args[0],
        outputFileName = args[1],
        inputFileNames = args.drop(2)
    )

    try {
        val application = Application(appParameters)

        application.run()
    } catch (exception: Exception) {
        println("Critical exception. Abort")
    }
}