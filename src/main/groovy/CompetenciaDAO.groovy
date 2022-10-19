import groovy.sql.Sql

class CompetenciaDAO {
 
  String url = 'jdbc:postgresql://localhost:5432/linketinderdb'
  String dbUser = 'postgres'
  String dbPassword = 'postgres'
  String dbDriver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, dbUser, dbPassword, dbDriver)

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
   def params = id
   sql.execute deleteSql, params
   return true;
  }
}
