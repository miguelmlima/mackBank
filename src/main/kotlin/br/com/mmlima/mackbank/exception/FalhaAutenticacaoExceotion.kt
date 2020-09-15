package br.com.mmlima.mackbank.exception

class FalhaAutenticacaoExceotion(
    mensagem: String = "Falha na autenticação"
) : Exception(mensagem)