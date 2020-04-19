package classExamples

 open class Person(val firstName: String, val lastName: String, var birthYear: Int) {
  val fullName = firstName + lastName

  val fullName2: String
    get() {
      println("Full name generation.")
      return firstName + lastName
    }

  var age = 2020 - birthYear
    set(value) {
      birthYear = 2020 - value
      field = value
    }
}

open class User (val id: Long, firstName: String, lastName: String, birthYear: Int) : Person (
        firstName,
        lastName,
        birthYear
)

open class Admin (id, firstName: String, lastName: String, birthYear: Int) : User (
        id,
        firstName,
        lastName,
        birthYear
)