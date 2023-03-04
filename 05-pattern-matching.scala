object PatternMatching extends App {
  val anInt = 42
  val order = anInt match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => s"${anInt}th"
  } // 42th

  case class Person(name: String, age: Int)
  val john = Person("John Doe", 42)

  val greeting = john match {
    case Person(name, age) => s"Hi, my name is $name and I'm $age years old"
    case null              => "I don't know who I am"
  } // Hi, my name is John Doe and I'm 42 years old

  val aTuple = ("Desafinado", "João Gilberto")
  val song = aTuple match {
    case (title, artist) => s"$title by $artist"
    case null            => "Unknown song"
  } // Desafinado by João Gilberto

  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(1, _, _) => "List starting with 1 and having 3 elements"
    case List(1, _*) => "List starting with 1 and having any number of elements"
    case _           => "Unknown list"
  } // List starting with 1 and having 3 elements

}
