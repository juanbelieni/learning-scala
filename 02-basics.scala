object Basics extends App {
  val meaningOfLife: Int = 42

  val aBoolean = false

  val aString              = "Hello, Scala"
  val aComposedString      = "Hello, " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  val anExpression = 2 + 3

  val ifExpression =
    if (meaningOfLife != 42) "Impossible"
    else "The meaning of life is 42"
  val chainedIfExpression =
    if (meaningOfLife > 43) "Impossible"
    else if (meaningOfLife < 41) "Impossible"
    else "The meaning of life is 42"

  val aCodeBlock = {
    val aLocalValue = 67
    aLocalValue + 3
  }

  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  def myUnitReturningFunction(): Unit = println("Hello, Scala")
}
