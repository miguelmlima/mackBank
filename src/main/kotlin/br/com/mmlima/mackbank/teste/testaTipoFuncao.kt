package br.com.mmlima.mackbank.teste


fun testaFuncaoLambdaAnonima() {
    val minhaFuncaoAnonima = fun(a: Int, b: Int): Int {
        println("Executa como anônima")
        return a + b
    }
    println(minhaFuncaoAnonima(40, 60))


    val calclulaBonificacaiAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.00) {
            return salario + 50
        }
        return salario + 100
    }
    println(calclulaBonificacaiAnonima(1200.0))
}

fun testaFuncaoLambda() {
    val minhaFuncaoLambda = { a: Int, b: Int ->
        a + b
    }
    println(minhaFuncaoLambda(15, 10))

    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.00) {
            return@lambda salario + 50
        }
        return@lambda salario + 100
    }
    println(calculaBonificacao(1100.0))
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()
    println(minhaFuncaoClasse(10, 10))
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b

}
