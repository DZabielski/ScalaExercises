package EX3_rucksackReorganization

import scala.io.StdIn.readInt

object RucksackHelper {
  val rucksack1 = "vJrwpWtwJgWrhcsFMMfFFhFp"
  val rucksack2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
  val rucksack3 = "PmmdzqPrVvPwwTWBwg"
  val rucksack4 = "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
  val rucksack5 = "ttgJtRGJQctTZtZT"
  val rucksack6 = "CrZsJsPPZsGzwwsLwLmpwMDw"

  def inputChoice(): Int = {
    println("Choose compartment: ")
    println("1 to 6:")

    readInt()
  }

  def chooseRacksack(i: Int) = {
    i match {
      case 2 => rucksack2
      case 3 => rucksack3
      case 4 => rucksack4
      case 5 => rucksack5
      case 6 => rucksack6

      case _ => rucksack1
    }

  }

  def compartment(items: String): (List[Char], List[Char]) = {
    items.toList.splitAt(items.length / 2)
  }

  def similarities(list1: List[Char], list2: List[Char]): List[Char] = {


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

  def indexValue(list: List[Char]): List[Int] = {

    val score = list.map {
      case 'L' => 1
      case 'p' => 16
      case 'P' => 42
      case 'v' => 22
      case 't' => 20
      case 's' => 19
      case _ => 0
    }
    score
  }

}
