@groovy.transform.ToString
class Candidato extends Pessoa{
    String nome, sobrenome, email, cpf, pais_onde_reside, cep, descricao, senha;
    Date data_nascimento = new Date();
}
