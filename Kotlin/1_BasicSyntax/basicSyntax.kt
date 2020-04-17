package examples

fun main(args: Array<String>) {
    // Constants:
    val pi : Double = 3.14159265
    val year = 2020
    val age : Int
    age = 18

    // Variables:
    var x = 24
    var str = "x = $x"

    if (year < age)
        print("Boomer")
    else
        print("Zoomer")

    for (arg in args)
        print("$(arg) ")

    for (i in args.indices)
        print("$(args[i]) ")
}

fun divide(a: Int, b: Int): Int? {
    if (b == 0)
        return null
    return a/b
}

fun cases(name: String) {
    when (name) {
        "Andrey" -> print("Hi")
        "Ivan"   -> print("Hello")
        else     -> print("Who are you, lol")
    }
}

fun is_limited(x: Int) {
    if (x in 1..5)
        print("OK")
}