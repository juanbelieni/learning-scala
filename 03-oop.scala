object OOP extends App {
  class Animal(val specie: String)
  val anAnimal = new Animal("Homo sapiens")

  class Dog(val breed: String) extends Animal("Canis lupus familiaris")
  val aDog                    = new Dog("Doberman")
  val aDeclaredAnimal: Animal = new Dog("Golden Retriever")

  trait Pet {
    val name: String
    def play(): Unit              = println(s"$name is playing")
    def play(place: String): Unit = println(s"$name is playing in the $place")
  }

  class Cat(override val name: String) extends Animal("Felis catus") with Pet

  val aCat = new Cat("Garfield")
  aCat play "kitchen"

  val basicMath        = 1 + 2
  val anotherBasicMath = 1.+(2)

  trait Dangerous {
    def intimidate(): Unit
  }

  val dinosaur = new Animal("Tyrannosaurus rex") with Dangerous {
    override def intimidate(): Unit = println("ROAR! I'm a dinosaur!")
  }

  object MySingleton {
    val mySpecialValue         = 123
    def mySpecialMethod(): Int = 456
    def apply(x: Int): Int     = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(42)
  MySingleton(42)

  object Animal {
    val liveOnEarth = true
  }

  val animalsLiveOnEarth = Animal.liveOnEarth

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 42)

  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  }

  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2, 3)
  val firstElement     = aList.head
  val reversedList     = aList.reverse
}
