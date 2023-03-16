package EX2_RockPaperScissors

import scala.io.StdIn.readInt

//Exercise from: https://adventofcode.com/2022/day/2

object RockPaperScissors extends App {

  val rand: scala.util.Random = scala.util.Random

  println("Hello, welcome to the RockPaperScissors game.")
  println("")
  println("Shall we play?")
  val userWins = 0
  val PCWins = 0

  runGame(userWins, PCWins)

  def runGame(userWins: Int, PCWins: Int): Unit = {

    if (userWins > 0 || PCWins > 0) println("Your Score: " + userWins + "|" + " Enemy Sore: " + PCWins)

    def inputChoice(): Int = {

      println("What do you choose: ")
      println("1. Rock")
      println("2. Paper")
      println("3. Scissors")

      val userChoice = readInt()
        userChoice
    }

    def randomNumberGenerator(): Int = {
      val x = rand.between(1, 3)
      x
    }

    def game(user: Int, PC: Int): String = {
      user match {
        case PC => "To bad, it's a draw"
        case user if user == 1 && PC == 3 || user == 2 && PC == 1 || user == 3 && PC == 2 => "Ou, you win. Good job!"
        case user if user == 1 && PC == 2 || user == 2 && PC == 3 || user == 3 && PC == 1 => "HA! You loose, maybe next time."
        case _ => "Don't know this sign"
      }
    }

    val result = game(inputChoice(), randomNumberGenerator())
    println(result)

    result match {
      case "HA! You loose, maybe next time." => runGame(userWins, PCWins + 1)
      case "Ou, you win. Good job!" => runGame(userWins + 1, PCWins)
      case _ => runGame(userWins, PCWins)
    }
  }
}

