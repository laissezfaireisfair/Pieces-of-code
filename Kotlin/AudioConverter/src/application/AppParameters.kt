package application

data class AppParameters(
    val configFileName: String,
    val outputFileName: String,
    val inputFileNames: List<String>
)
