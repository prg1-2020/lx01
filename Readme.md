# `lx01` プロジェクト

`sbt` を起動するときは `lx01` ディレクトリで起動して下さい。

なんで `lx01` なの？ → `sbt` を実行するとき、プロジェクトの定義ファイル (`build.sbt`) を探します。そのプロジェクト定義ファイルが `lx01` にあるため、そこで実行するのです。

# [`hello1.scala`](src/hello1.scala)

Scala の最小構成のプログラムの例。

- `object` 宣言のなかで各種の定義をします。ここでは `main` 関数を定義しています。

- 実行文は `main` 関数のなかに記述します。`main` 関数は Scala のプログラムで最初に呼び出される関数。Scala は関数の名前だけでなく、その引数の型も使って最初に呼び出す関数を探すので、`main` 関数の引数の型 (`Array[String]`) を間違えると実行されません。

    `main` 関数の引数の型を元に戻し、関数の名前を変更して実行してから `sbt run` したときに何が起きるか実験してみましょう。(例えば関数名 `niam` に変更したらどうなるでしょう。)

    `main` 関数の引数の型を変更してから `sbt run` したときに何が起きるか実験してみましょう。（例えば `Int` に変更してみるとか）

- `println` は Scala から文字列を標準出力に送るための関数。


# [`hello2.scala`](src/hello2.scala)

`main` 関数の定義が面倒だと思う横着者のためのプログラム例。

- `App` という名前の機能に追加定義することで `Hello2` オブジェクトを定義しています。`App` という機能のなかで `main` が定義され、`sbt run` するとそれが呼び出されます。`App` の `main` 関数の呼び出しに先駆けて `Hello2` オブジェクトのなかで宣言された定義が初期化されます。このときに `Hello2` オブジェクト内に含まれる文が実行され、ここで `println` 関数が実行されます。


# [`hello3.scala`](src/hello3.scala)

複数の文を順次実行する例。特に難しいこともなく、期待する順序で文を並べればその順に実行されます。


# [`hello4.scala`](src/hello4.scala)

定数定義は `val 定数名 = 定数の値` の形式を取ります。定数のスコープ内であれば、どこからも定数の値を定数名で参照できます。


# [`hello5.scala`](src/hello5.scala)

Scala における普通の関数定義の方法は以下の通りです。

```
def 関数名(引数名1: 型1, ...): 返り値の型 = {
  関数の本体
}
```

特に関数の本体がひとつの式だけで構成されている場合は：

```
def 関数名(引数名1: 型1, ...): 返り値の型 = 返り値の式
```

関数が値を返さない場合、返り値の型として `Unit` を宣言します：

```
def 関数名(引数名1: 型1, ...): Unit = {
  関数の本体
}
```

`hello5.scala` で定義された `hello` 関数は値を返さないため最後の形式で定義してあります。

## [`hello5a.scala`](hello5a.scala): おまけの便利機能（文字列補完）

2つの文字列型の変数 `role` と `professor` があって、これらを使った文を構成することを考えます。このとき `+` 演算子を使って、`role + "担当は" + professor + "です。"`と書くことができます。でも、この書き方では引用符や演算子が邪魔をして、何が出力するのか理解しにくい場合もあります。Scalaは文字列定数の前に`s`と書いておけば、文字列のなかに変数の値を埋め込むことができます。
    s"${role}担当は${professor}です。"
この例で、`role = 講義`、`professor = 脇田 建`の場合、"講義担当は脇田 建です"という文字列が構成されます。


# [`hello6.scala`](hello6.scala): 文字列補完で複雑な式を埋め込む場合

`hello5a.scala`の例題では、文字列補完の機能を用いて、文字列のなかに変数の値を埋め込めることを見ました。文字列補完の機能では、変数の値だけでなく、任意のScalaの式の値を埋め込むことができます。

たとえば、`s"${role}担当は${instructors(instr)}です。"`の場合、`List`型の変数`instructors`の`instr`番目の要素を埋め込んでいます。