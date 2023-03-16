package EX5_TuningTrouble

object TuningTroubleHelper {

  val a = "bvwbjplbgvbhsrlpgdmjqwftvncz"
  val b = "nppdvjthqldpwncqszvftbrmjlhg"
  val c = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
  val d = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"


  def decoder(code: String) = {

    val A = code.toList
      val result =
        if (A.indexOf('j')>=4) A.splitAt(A.indexOf('j')+1)._1.length
       else A.splitAt(A.indexOf('j'))._2.indexOf('j'+1)
    result
  }


}
