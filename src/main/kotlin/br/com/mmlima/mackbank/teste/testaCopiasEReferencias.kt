package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Cliente
import br.com.mmlima.mackbank.model.ContaCorrente
import br.com.mmlima.mackbank.model.ContaPoupanca

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val jose = Cliente(nome = "José", cpf = "", senha = 1)

    val contaJose = ContaCorrente(jose, 1002)
    contaJose.titular.nome = "José"
    var contaIvone = ContaPoupanca(
        Cliente(nome = "Ivone", cpf = "", senha = 2),
        1003
    )
    contaIvone.titular.nome = "Ivone"
    contaJose.titular.nome = "José"

    println("titular conta joao: ${contaJose.titular}")
    println("titular conta maria: ${contaIvone.titular}")

    println(contaJose)
    println(contaIvone)
}