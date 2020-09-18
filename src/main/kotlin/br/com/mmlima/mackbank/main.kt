package br.com.mmlima.mackbank

import br.com.mmlima.mackbank.model.Cliente
import br.com.mmlima.mackbank.model.ContaPoupanca
import br.com.mmlima.mackbank.model.Endereco
import br.com.mmlima.mackbank.teste.testaHOF


fun main() {
    testaHOF()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("taxa mensal $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Miguel", cpf = "123.123.123.77", senha = 123), 1000)
    contaPoupanca
        .run {
            deposita(500.0)
            saldo * taxaMensal
        }.let { rendimentoMensal ->
            println("rendimento mensal $rendimentoMensal")
        }


    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) { it ->
            saldo += saldo * taxaMensal
        }
        saldo
    }
    println("Simulação rendimento anual $rendimentoAnual")
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "rua da consolação"
        numero = 3185
        bairro = "Higienópolis"
        cidade = "São Paulo"
        estado = "SP"
        cep = "01235-258"
        complemento = "vila buarque"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}







