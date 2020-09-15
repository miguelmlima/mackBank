package br.com.mmlima.mackbank.teste

import br.com.mmlima.mackbank.model.Endereco

fun testaAny() {
    val endereco = Endereco(
        logradouro = "Rua da Consolação",
        complemento = "abnt",
        cep = "123456-125"
    )
    val enderecoNovo = Endereco(
        logradouro = "Av do Estado",
        complemento = "CTO",
        cep = "123456-858"
    )

    println(endereco.equals(enderecoNovo))

    println(endereco.hashCode())
    println(enderecoNovo.hashCode())

    println(
        "${endereco.javaClass}@${
            Integer.toHexString(endereco.hashCode())
        }"
    )
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}