import com.cra.figaro.language.{Flip, Select, Chain, Apply}
import com.cra.figaro.library.compound.If
import com.cra.figaro.algorithm.factored.VariableElimination

object HelloWorld {
  val sunnyToday = Flip(0.2)
  val sunnyTommorrow = If(sunnyToday, Flip(0.8), Flip(0.05))
  val rightSideOfBed = Flip(0.6)
  val greetingToday = If(sunnyToday,
    Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
    Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again"))
  val greetingTommorrow = If(sunnyTommorrow,
    Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
    Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again"))
  def predict() {
    val result = VariableElimination.probability(greetingToday, "Hello, world!")
    println("Today's greeting is \"Hello world!\" " + "with probability " + result + ".")
  }
  def infer() {
    greetingToday.observe("Hello, world!")
    val result = VariableElimination.probability(sunnyToday, true)
    println("If today's gretting is \"Hello, world!\", today's " + 
      "weather is sunny with probability " + result + ".")
  }
  def learnAndPredict(greeting: String) {
    greetingToday.observe(greeting)
    val result = VariableElimination.probability(greetingTommorrow, greeting)
    println(s"If today's greeting is $greeting, " +
      s"tommorow's greeting will be $greeting with probability $result")
  }
  def learnAndPredictTodaysWeather(greeting: String) {
    greetingToday.observe(greeting)
    val result = VariableElimination.probability(sunnyToday, true)
    println(s"If today's greeting is $greeting, "+
      s"the weather will be sunny with a probability of $result")
  }
  def main(args: Array[String]) {
    predict()
    infer()
    learnAndPredict("Hello, world!")
    learnAndPredict("Oh no, not again")
    learnAndPredictTodaysWeather("Oh no, not again")
  }
}
