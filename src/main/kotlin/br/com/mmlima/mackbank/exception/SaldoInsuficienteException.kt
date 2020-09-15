package br.com.mmlima.mackbank.exception

class SaldoInsuficienteException(
    mensagem: String = "Saldo insuficiente!"
) : Exception(mensagem)