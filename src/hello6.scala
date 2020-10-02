/*
 * 変数を宣言し、利用する例。
 * この例は整数型の変数instrを宣言しています。
 * この変数は、リストの要素を走査する目的で使われています。
 * Scalaの変数もC言語の変数と同様に参照や更新ができます。
 */

object Hello6 extends App {
  val instructors = List("脇田 建（わきた けん）", "叢 悠悠（そう ゆうゆう）")

  var instr = 0

  def hello(role: String): Unit = {
    assert(instr < instructors.length)
    println(s"${role}担当は${instructors(instr)}です。")
    instr = instr + 1
  }

  hello("講義")
  hello("演習")
}
