package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Cliente
import br.com.mmlima.mackbank.model.Diretor
import br.com.mmlima.mackbank.model.Gerente
import br.com.mmlima.mackbank.model.SistemaInterno

fun testaAutenticacao() {
    val gerente = Gerente(
        nome = "Miguel",
        cpf = "111.111.111-11",
        salario = 1000.0,
        senha = 1000
    )
    val diretora = Diretor(
        nome = "Carla",
        cpf = "222.222.222-22",
        salario = 2000.0,
        senha = 2000,
        plr = 200.0
    )
    val cliente = Cliente(
        nome = "Débora",
        cpf = "333.333.333-33",
        senha = 1234
    )

    val sistema = SistemaInterno()
    sistema.entra(gerente, 1000)
    sistema.entra(diretora, 2000)
    sistema.entra(cliente, 1234)
}