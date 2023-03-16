package EX4_campCleanup

import scala.io.StdIn.readInt

//Exercise from: https://adventofcode.com/2022/day/4

object CampCleanup extends App {

  runGame()

  def runGame(): Unit = {

    def inputChoice(): Int = {
      println("Choose two compartments: ")
      println("1 to 6")

      val userChoice = readInt()
      userChoice
    }

    val (l1, l2) = inputChoice() match {
      case 1 => (2 to 4, 6 to 8)
      case 2 => (2 to 3, 4 to 5)
      case 3 => (5 to 7, 7 to 9)
      case 4 => (2 to 8, 3 to 7)
      case 5 => (2 to 8, 3 to 7)
      case 6 => (2 to 6, 4 to 8)
    }

    def function1(list1: List[Int], list2: List[Int]): Set[Int] = {

      val all = List.concat(list1, list2)
      all.toSet
    }

    def fullyContains(list1: List[Char], list2: List[Char]): List[Char] = {
      def loop(list1: List[Char], list2: String, acc: List[Char]): List[Char] =
        list1 match {
          case Nil => acc
          case head1 :: tail1 =>

            if (list2.contains(head1)) {
              val temp = list2.indexOf(head1)
              val (left, right) = list2.splitAt(temp)
              val list3 = left + right.tail

              loop(tail1, list3, head1 :: acc)
            }
            else {
              loop(tail1, list2, acc)
            }
        }

      loop(list1, list2.mkString(""), List.empty[Char])
    }

    def toCharList(intList: List[Int]): List[Char] = {
      val nowChar = intList.mkString.toList
      nowChar
    }
    val over = if (fullyContains(toCharList(l1.toList), toCharList(l2.toList)) == toCharList(l2.toList).reverse) true else false

    println("Does fully contains section: " + over)

    println(function1(l1.toList, l2.toList).mkString("").sorted)

    runGame()
  }
}