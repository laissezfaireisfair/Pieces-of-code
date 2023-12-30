package game

data class GameRules(
    val roundsCount: Int,
    val cooperationReward: Int,
    val cooperationFine: Int,
    val defectFine: Int,
    val defectReward: Int
)
