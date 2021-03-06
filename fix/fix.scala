/*
 * 以下のファイルは「本当のScala」プログラムではありません。
 * さまざまな宣言が、object宣言に包含されていないからです。
 */

def simple(a: Int, n: Int): Int = {
  def aux(a: Int, i: Int) {
    if (i > n) a else aux(a + i, i + 1)
  }
  aux(a, 1);
}

println("1 + 2 + ... + 10 = " + simple(10, 1))
