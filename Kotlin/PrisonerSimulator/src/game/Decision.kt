package game

enum class Decision {
    Cooperate {
        override fun getOpposite(): Decision = Defect
        override fun toString(): String = "Cooperate"
    },
    Defect {
        override fun getOpposite(): Decision = Cooperate
        override fun toString(): String = "Defect"
    };

    abstract fun getOpposite(): Decision
}
