@groovy.transform.ToString
class Candidato extends Pessoa{
    Integer id
    String nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha

    Candidato() {
    }

    Candidato(String nome, String sobrenome, String data_nascimento, String email,
              String cpf, String pais_onde_reside, String cep, String descricao, String senha) {
        this.nome = nome
        this.sobrenome = sobrenome
        this.data_nascimento = data_nascimento
        this.email = email
        this.cpf = cpf
        this.pais_onde_reside = pais_onde_reside
        this.cep = cep
        this.descricao = descricao
        this.senha = senha
    }
}
