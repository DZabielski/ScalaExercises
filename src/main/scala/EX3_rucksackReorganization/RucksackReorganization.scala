package EX3_rucksackReorganization

//Exercise from: https://adventofcode.com/2022/day/3

object RucksackReorganization extends App {
  import RucksackHelper._

  runGame()

  def runGame(): Unit = {

    val choice = chooseRacksack(RucksackHelper.inputChoice())

    val (l1, l2) = compartment(choice)
    val score = indexValue(similarities(l1, l2))

    println("your score is: " + score.sum)
    runGame()
  }
}




