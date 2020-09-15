package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Analista
import br.com.mmlima.mackbank.model.CalculadoraBonificacao
import br.com.mmlima.mackbank.model.Diretor
import br.com.mmlima.mackbank.model.Gerente

fun testaFuncionarios() {
    val miguel = Analista(
        nome = "miguel",
        cpf = "111.111.111-11",
        salario = 1000.0
    )

    println("nome ${miguel.nome}")
    println("cpf ${miguel.cpf}")
    println("salario ${miguel.salario}")
    println("bonificação ${miguel.bonificacao}")

    val michele = Gerente(
        nome = "michele",
        cpf = "222.222.222-22",
        salario = 2000.0,
        senha = 1234
    )

    println("nome ${michele.nome}")
    println("cpf ${michele.cpf}")
    println("salario ${michele.salario}")
    println("bonificação ${michele.bonificacao}")

    if (michele.autentica(1234)) {
        println("autenticou com sucesso")
    } else {
        println("falha na autenticação")
    }

    val andre = Diretor(
        nome = "André",
        cpf = "333.333.333-33",
        salario = 4000.0,
        senha = 4000,
        plr = 200.0
    )

    println("nome ${andre.nome}")
    println("cpf ${andre.cpf}")
    println("salario ${andre.salario}")
    println("bonificação ${andre.bonificacao}")
    println("plr ${andre.plr}")

    if (andre.autentica(4000)) {
        println("autenticou com sucesso")
    } else {
        println("falha na autenticação")
    }

    val ivone = Analista(
        nome = "Ivone",
        cpf = "444.444.444-44",
        salario = 3000.0
    )

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(miguel)
    calculadora.registra(michele)
    calculadora.registra(andre)
    calculadora.registra(ivone)

    println("total de bonificação: ${calculadora.total}")
}