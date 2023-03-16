package EX1_calorieCounter

import scala.io.StdIn.{readInt, readLine}

//Exercise from: https://adventofcode.com/2022/day/1

object CalorieCounter extends App {
  case class Event(name: String)

  val stash = listAdder()

  println("the stash you have: " + stash)

  val cals = calorieCounter(stash)

  println(if (cals == 0) "There is no calories to sum." else "your sum of calories: " + cals)

  val sortedList = sortingCalories(stash)

  println("Your Sorted list" + sortedList)

  println("The highest calories inventory is " + sortedList.last)


  def listAdder(list: List[(String, Int)] = List.empty): List[(String, Int)] = {

    println("Name the inventory or write \"out\" to end editing: ")
    val inventory = readLine()
    if (inventory == "out") list
    else {
      println("You've added: " + inventory)
      val calorie = readInt()
      println("The " + inventory + " has  " + calorie + " calories.")
      val toStash = (inventory, calorie)

      listAdder(toStash :: list)
    }
  }

  def calorieCounter(list: List[(String, Int)]): Int = {
    if (list == Nil) 0
    else {
      val sumOfCals = list.map(_._2).foldLeft(0)((a: Int, b: Int) => a + b)
      sumOfCals
    }
  }

  def sortingCalories(list: List[(String, Int)]): List[(String, Int)] = {
    val result = list.sorted(Ordering.by[(String, Int), Int](_._2))
    result
  }

}

