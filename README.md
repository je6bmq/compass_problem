# コンパス問題のシミュレータ
このリポジトリは、Rustで書かれたコンパス問題のシミュレータです。  
コンパス問題についての概要は、[こちら（togetter）](http://togetter.com/li/1047478)を参照ください。

# 使い方
compass関数は、コンパス問題のシミュレーションを行う関数です。  
各パラメータと、解の初期値として0.0を与えることで動作します。

main関数内のanalysisというクロージャで解（理論式）を定義しています。  
クロージャの引数と、問題文中のパラメータの対応は以下の通りです。

|引数|パラメータ|
|:---|:--------|
|needle|l|
|carbon|m|
|rad|theta|
|unitlen|n|
|unitexh|o|

# 検証
現在、θ=π/3,2π/3,πの場合の検証は行っています。

再帰関数の最適化とスタックの関係で、Kotlin版の方が高い精度で検証可能なようですが、Rust版も十分な精度で検証可能かと思われます。
## Rust版
Rust版は、

```
cargo run
```

で実行可能です。

## Kotlin版
Kotlin版は、

```
kotlinc Main.kt -include-runtime -d Main.jar
kotlin -classpath Main.jar MainKt
```