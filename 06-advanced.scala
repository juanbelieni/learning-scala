import scala.concurrent.Future
import scala.util.{Try, Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  lazy val aLazyValue = 2
  lazy val aLazyValueWithSideEffect = {
    println("I'm so lazy")
    42
  }

  val eagerValue = aLazyValueWithSideEffect + 1 // 43 [I'm so lazy]

  def canReturnNull(): String = null
  val anOption                = Option(canReturnNull())

  val stringProcessing = anOption match {
    case Some(value) => s"The option is $value"
    case None        => "The option is empty"
  } // The option is empty

  def canThrowException(): String = throw new RuntimeException
  def aTry                        = Try(canThrowException())

  val anotherStringProcessing = aTry match {
    case Success(value) => s"Success: $value"
    case Failure(_)     => "Failure"
  } // Failure

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    42
  }

  def withImplicitArgs(implicit arg: Int) = arg + 1
  implicit val implicitArg: Int           = 42
  withImplicitArgs // 43

  implicit class RichInt(n: Int) {
    def isEven = n % 2 == 0
  }

  42.isEven // true
}
