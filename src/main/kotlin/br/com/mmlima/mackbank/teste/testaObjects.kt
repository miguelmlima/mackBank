package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Autenticavel
import br.com.mmlima.mackbank.model.Conta
import br.com.mmlima.mackbank.model.SistemaInterno

fun testaObjects() {
    val michele = object : Autenticavel {
        val nome: String = "Michele"
        val cpf: String = "123.123.123-88"
        val senha: Int = 1234

        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(michele, 1234)

    testaContasDiferentes()


    println("Total de contas: ${Conta.total}.")
}