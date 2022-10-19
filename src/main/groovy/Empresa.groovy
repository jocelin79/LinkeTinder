@groovy.transform.ToString
class Empresa extends Pessoa{
   Integer id
   String nome, email, cnpj, pais_onde_reside, descricao, cep, senha

   Empresa() {
   }

   Empresa(String nome, String email, String cnpj, String pais_onde_reside, String descricao,
           String cep, String senha) {
      this.nome = nome
      this.email = email
      this.cnpj = cnpj
      this.pais_onde_reside = pais_onde_reside
      this.descricao = descricao
      this.cep = cep
      this.senha = senha
   }
}
