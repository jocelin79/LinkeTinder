import groovy.sql.Sql

class CandidatoDAO {
 
  def url = 'url do banco criado'
  def user = 'postgres'
  def password = 'postgres'
  def driver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, user, password, driver)

  CandidatoDAO() {}

  List<Candidato> listar() {
    List<Candidato> retorno = new ArrayList<>():
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
        retorno.add(candidato)
      }
    }
    return retorno
  }
}
