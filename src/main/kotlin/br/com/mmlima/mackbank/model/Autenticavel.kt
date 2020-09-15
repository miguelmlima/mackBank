package br.com.mmlima.mackbank.model

interface Autenticavel {

    fun autentica(senha: Int): Boolean

}