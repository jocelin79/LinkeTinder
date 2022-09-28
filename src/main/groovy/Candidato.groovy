@groovy.transform.ToString
class Candidato extends Pessoa{
    Integer id;
    String nome, sobrenome, email, cpf, pais_onde_reside, cep, descricao, senha;
    Date data_nascimento = new Date();
}
