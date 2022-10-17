import groovy.sql.Sql

class CandidatoDAO {

  String url = 'jdbc:postgresql://localhost:5432/linketinderdb'
  String bdUser = 'postgres'
  String bdPassword = 'postgres'
  String bdDriver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, bdUser, bdPassword, bdDriver)

  List<Candidato> listar() {
    List<Candidato> retorno = new ArrayList<>();
    sql.query('SELECT * FROM candidato') { resultSet ->
      while (resultSet.next()) {
        Candidato candidato = new Candidato()
        candidato.setId(resultSet.getInt("id"))
        candidato.setNome(resultSet.getString("nome"))
        candidato.setSobrenome(resultSet.getString("sobrenome"))
        candidato.setData_nascimento(resultSet.getString("data_nascimento"))
        candidato.setEmail(resultSet.getString("email"))
        candidato.setCpf(resultSet.getString("cpf"))
        candidato.setPais_onde_reside(resultSet.getString("pais_onde_reside"))
        candidato.setCep(resultSet.getString("cep"))
        candidato.setDescricao(resultSet.getString("descricao"))
        candidato.setSenha(resultSet.getString("senha"))
        retorno.add(candidato)
      }
    }
    return retorno
  }
  
  boolean inserir(Candidato candidato) {
   String insertSql = 'INSERT INTO candidato(nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)'
   def params = [candidato.getNome(), candidato.getSobrenome(), candidato.getData_nascimento(), candidato.getEmail(), candidato.getCpf(), candidato.getPais_onde_reside(), candidato.getCep(), candidato.getDescricao(), candidato.getSenha()]
   sql.execute insertSql, params
   return true;
  }
 
 boolean alterar(Candidato candidato) {
   String updateSql = 'UPDATE candidato SET nome=?, sobrenome=?, data_nascimento=?, email=?, cpf=?, pais_onde_reside=?, cep=?, descricao=?, senha=? WHERE id=?'
   def params = [candidato.getNome(), candidato.getSobrenome(), candidato.getData_nascimento(), candidato.getEmail(), candidato.getCpf(), candidato.getPais_onde_reside(), candidato.getCep(), candidato.getDescricao(), candidato.getSenha(), candidato.getId()]
   sql.execute updateSql, params
   return true;
  }
 
 boolean remover(Integer id) {
   String deleteSql = 'DELETE FROM candidato WHERE id=?'
   def params = id
   sql.execute deleteSql, params
   return true
  }
}
