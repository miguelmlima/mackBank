package br.com.mmlima.mackbank.model

import br.com.mmlima.mackbank.exception.FalhaAutenticacaoExceotion
import br.com.mmlima.mackbank.exception.SaldoInsuficienteException
import java.lang.RuntimeException


abstract class Conta(
    val titular: Cliente,
    val numero: Int
) : Autenticavel  by titular{
    var saldo = 0.0
        protected set

    companion object Contador {
        var total = 0
            private set

    }

    init {
        println("Criando conta")
        total++
    }

    override fun autentica(senha: Int): Boolean {
        return  titular.autentica(senha)
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(
                mensagem = "O saldo insuficiente, saldo atual: $saldo, valor a ser subtraído $valor")
        }
        if(!autentica(senha)){
            throw FalhaAutenticacaoExceotion()
        }
//        throw RuntimeException()

        saldo -= valor
        destino.deposita(valor)
    }
}