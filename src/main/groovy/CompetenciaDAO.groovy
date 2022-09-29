import groovy.sql.Sql

class CompetenciaDAO {
 
  String url = 'postgresql+psycopg2://postgres:postgres@localhost:5432/linketinderdb'
  String user = 'postgres'
  String password = 'postgres'
  String driver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, user, password, driver)

  List<Competencia> listar() {
    List<Competencia> retorno = new ArrayList<>();
    sql.query('SELECT * FROM competencia') { resultSet ->
      while (resultSet.next()) {
        Competencia competencia = new Competencia()
        competencia.setId(resultSet.getInt("id"))
        competencia.setDescricao(resultSet.getString("descricao"))
        retorno.add(competencia)
      }
    }
    return retorno
  }
  
  boolean inserir(Competencia competencia) {
   String insertSql = 'INSERT INTO competencia(descricao) VALUES(?)'
   def params = [competencia.getDescricao()]
   sql.execute insertSql, params
   return true;
  }
 
 boolean alterar(Competencia competencia) {
   String updateSql = 'UPDATE competencia SET descricao=? WHERE id=?'
   def params = [competencia.getDescricao(), competencia.getId()]
   sql.execute updateSql, params
   return true;
  }
 
 boolean remover(Integer id) {
   String deleteSql = 'DELETE FROM competencia WHERE id=?'
   def params = competencia.getId()
   sql.execute deleteSql, params
   return true;
  }
}
