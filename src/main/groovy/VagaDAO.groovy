import groovy.sql.Sql

class VagaDAO {
 
  String url = 'postgresql+psycopg2://postgres:postgres@localhost:5432/linketinderdb'
  String dbUser = 'postgres'
  String dbPassword = 'postgres'
  String dbDriver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, dbUser, dbPassword, dbDriver)

  List<Vaga> listar() {
    List<Vaga> retorno = new ArrayList<>();
    sql.query('SELECT * FROM vaga') { resultSet ->
      while (resultSet.next()) {
        Vaga vaga = new Vaga()
        vaga.setId(resultSet.getInt("id"))
        vaga.setDescricao(resultSet.getString("descricao"))
        vaga.setLocal_da_vaga(resultSet.getString("local_da_vaga"))
        vaga.setIdEmpresa(resultSet.getInt("idEmpresa"))
        retorno.add(vaga)
      }
    }
    return retorno
  }
  
  boolean inserir(Vaga vaga) {
   String insertSql = 'INSERT INTO vaga(descricao, local_da_vaga, idEmpresa) VALUES(?, ?, ?)'
   def params = [vaga.getDescricao(), vaga.getLocal_da_vaga(), vaga.getIdEmpresa()]
   sql.execute insertSql, params
   return true;
  }
 
  boolean alterar(Vaga vaga) {
   String updateSql = 'UPDATE vaga SET descricao=?, local_da_vaga=?, idEmpresa=? WHERE id=?'
   def params = [vaga.getDescricao(), vaga.getLocal_da_vaga(), vaga.getIdEmpresa(), vaga.getId()]
   sql.execute updateSql, params
   return true;
  }
 
  boolean remover(Integer id) {
   String deleteSql = 'DELETE FROM vaga WHERE id=?'
   def params = vaga.getId()
   sql.execute deleteSql, params
   return true;
  }
}
