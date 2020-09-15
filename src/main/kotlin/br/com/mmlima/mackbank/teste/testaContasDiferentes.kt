package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Cliente
import br.com.mmlima.mackbank.model.ContaCorrente
import br.com.mmlima.mackbank.model.ContaPoupanca
import br.com.mmlima.mackbank.model.Endereco


fun testaContasDiferentes() {
    val contaCorrente = ContaCorrente(
        titular = Cliente(
            "Miguel",
            cpf = "123.123.123-44",
            senha = 1,
            endereco = Endereco(logradouro = "Av do Estado",numero = 10, bairro = "Mooca")
        ),
        numero = 1000
    )
    println(contaCorrente.titular)
    println("titular")
    println("nome do titular ${contaCorrente.titular.nome}")
    println("cpf do titular ${contaCorrente.titular.cpf}")
    println("endereço ${contaCorrente.titular.endereco.logradouro}")
    println("numero ${contaCorrente.titular.endereco.numero}")
    println("bairro ${contaCorrente.titular.endereco.bairro}")

    val contaPoupanca = ContaPoupanca(
        titular = Cliente("Michele", cpf = "", senha = 2),
        numero = 1001
    )

    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)

    println("saldo corrente: ${contaCorrente.saldo}")
    println("saldo poupança: ${contaPoupanca.saldo}")

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println("saldo após saque corrente: ${contaCorrente.saldo}")
    println("saldo após saque poupança: ${contaPoupanca.saldo}")

    contaCorrente.transfere(100.0, contaPoupanca,  1)

    println("saldo corrente após transferir para poupança: ${contaCorrente.saldo}")
    println("saldo poupança após receber transferência: ${contaPoupanca.saldo}")

    contaPoupanca.transfere(200.0, contaCorrente, 2)

    println("saldo poupança após transferir para corrente: ${contaPoupanca.saldo}")
    println("saldo corrente após receber transferência: ${contaCorrente.saldo}")
}