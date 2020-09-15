package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Endereco

fun testaTryCatch() {
    println("início main")

    val entrada: String = "1.8"
    val valorRecebido: Double? = try {
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
        e.printStackTrace()
        null
    }

    valorComTaxa(valorRecebido)

    println("valor recebido: $valorRecebido")

    funcao1()
    println("fim main")
}

//    when expression
fun valorComTaxa(valorRecebido: Double?) {
    val valorComTaxa: Double? = when {
        valorRecebido != null -> {
            valorRecebido + 0.1
        }
        else -> {
            null
        }
    }
}

fun funcao1() {
    println("início funcao2")
    try {
        funcao2()
    } catch (e: ClassCastException) {
        println(e.printStackTrace())
    }
    println("fim funcção 1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        val endereco = Any()
        endereco as Endereco
    }
    println("fim funcao2")
}




