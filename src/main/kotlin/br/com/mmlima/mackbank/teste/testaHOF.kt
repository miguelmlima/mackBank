package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Autenticavel
import br.com.mmlima.mackbank.model.Conta.Contador.total
import br.com.mmlima.mackbank.model.SistemaInterno

fun testaHOF() {
    soma(1, 5, resultado = { valor ->
        println(valor)
    })
    somaReceiver(1, 5, resultado = {
        println(this)
    })


    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }
    SistemaInterno().entra(autenticavel, 1234, autenticado = {
        println("realizar pagamento")
    })

    SistemaInterno().entraReceiver(autenticavel, 1234, autenticado = {
        pagamento()
    })
}
    fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
        println("antes da soma")
        resultado(a + b)
        println("depois da soma")
    }

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("antes da soma")
    resultado(a + b)
    total.resultado()
    println("depois da soma")
}
