package cadEquation

import kotlin.math.sqrt

fun countDiscriminant(a: Double, b: Double, c: Double) = b * b - 4 * a * c

fun countRoots(a: Double, b: Double, c: Double): Int {
    val discriminant = countDiscriminant(a, b, c)
    return when {
        discriminant <  0.0 -> 0
        discriminant == 0.0 -> 1
        else                -> 2
    }
}

fun countLessRoot(a: Double, b: Double, c: Double): Double? {
    val discriminant = countDiscriminant(a, b, c)
    if (discriminant < 0.0)
        return null
    return (-b - sqrt(discriminant)) / (2 * a)
}

fun countBiggerRoot(a: Double, b: Double, c: Double): Double? {
    val discriminant = countDiscriminant(a, b, c)
    if (discriminant < 0.0)
        return null
    return (-b + sqrt(discriminant)) / (2 * a)
}

fun main (args: Array<String>) {
    if (args.size != 3) {
        println("Wrong number of arguments (3 coefficients required).")
        return
    }

    val a = args[0].toDoubleOrNull()
    val b = args[1].toDoubleOrNull()
    val c = args[2].toDoubleOrNull()

    if (a == null || b == null || c == null) {
        println("Some argument is not a number.")
        return
    }

    if (a == 0.0) {
        println("It does not a cad equation.")
        return
    }

    when (countRoots(a, b, c)) {
        0 -> println("This equation has no roots.")
        1 -> println("The root is $(countLessRoot(a,b,c)).")
        2 ->  {
            val root1 = countLessRoot(a, b, c)
            val root2 = countBiggerRoot(a, b, c)
            println("Roots are: $root1, $root2.")
        }
    }
    return
}
