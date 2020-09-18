package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Endereco

fun testaFuncoesEscopo() {
    //    val endereco = Endereco(logradouro = "Rua da Consolação", numero = 3185)
//    val enderecoMaisculo ="${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    print(enderecoMaisculo)

    run {
        println("execução do run!")
    }

    val endereco = Endereco()
        .also { println("Criando Endereço") }
        .apply {
            logradouro = "rua palmeiras"
            numero = 4865
        }

    with(endereco) {
        "$logradouro, $numero".toUpperCase()
    }.let(::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "Apartamento")
    )
        .filter(predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = (::println))
}