package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.exception.FalhaAutenticacaoExceotion
import br.com.mmlima.mackbank.exception.SaldoInsuficienteException
import br.com.mmlima.mackbank.model.Cliente
import br.com.mmlima.mackbank.model.ContaCorrente
import br.com.mmlima.mackbank.model.ContaPoupanca

fun testaComportamentosConta() {

    val miguel = Cliente(nome = "Miguel", cpf = "123.123.123-77", senha = 22)

    val contaMiguel = ContaCorrente(titular = miguel, numero = 1000)
    contaMiguel.deposita(200.0)

    val michele = Cliente(nome = "Michele", cpf = "111.111.111-88", senha = 11)

    val contaMichele = ContaPoupanca(numero = 1001, titular = michele)
    contaMichele.deposita(300.0)

    println(contaMichele.titular)
    println(contaMichele.numero)
    println(contaMichele.saldo)

    println(contaMiguel.titular)
    println(contaMiguel.numero)
    println(contaMiguel.saldo)

    println("depositando na conta do Miguel")
    contaMiguel.deposita(50.0)
    println(contaMiguel.saldo)

    println("depositando na conta da Michele")
    contaMichele.deposita(70.0)
    println(contaMichele.saldo)

    println("sacando na conta do Miguel")
    contaMiguel.saca(250.0)
    println(contaMiguel.saldo)

    println("sacando na conta da Michele")
    contaMichele.saca(100.0)
    println(contaMichele.saldo)

    println("saque em excesso na conta do Miguel")
    contaMiguel.saca(100.0)
    println(contaMiguel.saldo)

    println("saque em excesso na conta da Michele")
    contaMichele.saca(500.0)
    println(contaMichele.saldo)

    println("Transferência da conta da Michele para o Miguel")

    try {
        contaMichele.transfere(destino = contaMiguel, valor = 250.0, senha = 2)
        println("Transferência sucedida")
    } catch (e: SaldoInsuficienteException) {
        println("Falha na transferência")
        println("Saldo Insuficiente")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoExceotion) {
        println("Falha na transferência")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e: Exception) {
        println("Erro desconhecido")
        e.printStackTrace()
    }


    println(contaMiguel.saldo)
    println(contaMichele.saldo)
}