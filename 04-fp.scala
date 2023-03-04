object FP extends App {
  val simpleIncrementor = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementor.apply(1) // 2
  simpleIncrementor(1)       // 2

  val stringConcat = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  stringConcat("Hello, ", "Scala") // Hello, Scala

  val doubler: Function1[Int, Int] = (x: Int) => x * 2
  doubler(2) // 4

  val adder: (Int, Int) => Int = (a, b) => a + b
  adder(1, 2) // 3

  val aList       = List(1, 2, 3)
  val aMappedList = aList.map(x => x + 1) // List(2, 3, 4)
  val aFlatMappedList = aList.flatMap { x =>
    List(x, x + 1)
  } // List(1, 2, 2, 3, 3, 4)
  val aFilteredList = aList.filter(_ % 2 == 0) // List(2)

  val allPairs = {
    val numbers = List(1, 2, 3)
    val chars   = List('a', 'b', 'c')
    numbers.flatMap(n => chars.map(c => (n, c)))
  } // List((1,a), (1,b), (1,c), (2,a), (2,b), (2,c), (3,a), (3,b), (3,c))

  val alternativePairs = for {
    number <- List(1, 2, 3)
    char   <- List('a', 'b', 'c')
  } yield (number, char) // equivalent to allPairs

  val aList2         = List(1, 2, 3, 4, 5)
  val firstElement   = aList2.head      // 1
  val rest           = aList2.tail      // List(2, 3, 4, 5)
  val aPrependedList = 0 :: aList2      // List(0, 1, 2, 3, 4, 5)
  val anExtendedList = 0 +: aList2 :+ 6 // List(0, 1, 2, 3, 4, 5, 6)

  val aSequence       = Seq(1, 2, 3, 4, 5)
  val accessedElement = aSequence(2) // 3

  val aVector = Vector(1, 2, 3)

  val aSet        = Set(1, 2, 3, 4, 1, 2, 3) // Set(1, 2, 3, 4)
  val setHas5     = aSet.contains(5)         // false
  val anAddedSet  = aSet + 5                 // Set(1, 2, 3, 4, 5)
  val aRemovedSet = aSet - 3                 // Set(1, 2, 4)

  val aRange   = 1 to 1000                // Range(1, 2, 3, ..., 1000)
  val twoByTwo = aRange.map(_ * 2).toList // List(2, 4, 6, ..., 2000)

  val aTuple = ("Tom Jobim", "Matita Perê", 1973)

  val aMap = Map(
    1 -> "a",
    2 -> "b",
    3 -> "c"
  )
}
