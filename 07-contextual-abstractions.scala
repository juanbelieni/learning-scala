object ContextualAbstractions {
  val aList         = List(1, 2, 3)
  val anOrderedList = aList.sorted

  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

  trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce(combinator.combine)

  given intCombinator: Combinator[Int] with {
    override def combine(x: Int, y: Int): Int = x + y
  }

  val aSum = combineAll(aList)

  def combineAll2[A](list: List[A])(using Combinator[A]): A = ???
  def combineAll3[A: Combinator](list: List[A]): A          = ???

  case class Person(name: String) {
    def greet(): String = s"Hello, my name is $name"
  }

  extension (string: String) {
    def greet(): String = Person(string).greet()
  }

  val aGreeting = "John".greet() // Hello, my name is John

  extension [A: Combinator](list: List[A]) {
    def combineAllValues: A = combineAll(list)
  }

  val aSum2 = aList.combineAllValues

  def main(args: Array[String]): Unit = {
    println(anOrderedList)
    println(aSum)
    println(aSum2)
  }
}
