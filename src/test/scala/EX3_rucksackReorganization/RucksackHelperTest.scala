package EX3_rucksackReorganization

//ON WORK.
//Exercise from:https://adventofcode.com/2022/day/4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RucksackHelperTest extends AnyFlatSpec with Matchers {

  "RucksackHelper.chooseRacksack" should "return proper rucksack" in {
    val rs1 = RucksackHelper.chooseRacksack(1)
    val rs2 = RucksackHelper.chooseRacksack(2)
    val rs6 = RucksackHelper.chooseRacksack(6)

    rs1 shouldBe RucksackHelper.rucksack1
    rs2 shouldBe RucksackHelper.rucksack2
    rs6 shouldBe RucksackHelper.rucksack6
  }

  it should "always return a default value" in {
    RucksackHelper.chooseRacksack(-1) shouldBe RucksackHelper.rucksack1
    RucksackHelper.chooseRacksack(29803) shouldBe RucksackHelper.rucksack1

  }

  "RucksachHelper.compartment" should "Return two Lists of Chars." in {

    val firstListOfChar = RucksackHelper.compartment("HereIsOneHereIsTwo")._1
    val secondListOfChar = RucksackHelper.compartment("HereIsOneHereIsTwo")._2

    firstListOfChar shouldBe List('H','e','r','e','I','s','O','n','e')
    secondListOfChar shouldBe List('H','e','r','e','I','s','T','w','o')

  }

  "RucksashHelper.IndexValue" should "Return a proper Value" in {

    val test1 = RucksackHelper.indexValue(List('L'))
    val test2 = RucksackHelper.indexValue(List('p'))
    val test3 = RucksackHelper.indexValue(List('U'))

    test1 shouldBe List(1)
    test2 shouldBe List(16)
    test3 shouldBe List(0)
  }

  "RucksashHelper.similarities" should "Return a similarities of Chars in the both of the lists"

val test1 = RucksackHelper.similarities(List('a','a','a','a'), List('a','a','b','b'))

  test1 shouldBe List('a','a')

}
