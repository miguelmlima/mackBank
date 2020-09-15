package br.com.mmlima.mackbank.model

class Cliente(
    var nome: String,
    val cpf: String,
    val endereco: Endereco = Endereco(),// composição relacionamento
    private val senha: Int
) : Autenticavel {

    override fun autentica(senha: Int): Boolean {
        if(this.senha == senha){
            return true
        }
        return false
    }

}