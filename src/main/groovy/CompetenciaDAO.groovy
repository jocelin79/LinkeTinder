import groovy.sql.Sql

class CompetenciaDAO implements ICompetenciaDAO{

    private IConnection _connection

    CompetenciaDAO(IConnection connection) {
        _connection = connection
    }

  List<Competencia> listar() {
    List<Competencia> retorno = new ArrayList<>()
      Sql sql = _connection.connecting()
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
  
  void inserir(Competencia competencia) {
      Sql sql = _connection.connecting()
   String insertSql = 'INSERT INTO competencia(descricao) VALUES(?)'
   def params = [competencia.getDescricao()]
   sql.execute insertSql, params
  }
 
 void alterar(Competencia competencia) {
     Sql sql = _connection.connecting()
   String updateSql = 'UPDATE competencia SET descricao=? WHERE id=?'
   def params = [competencia.getDescricao(), competencia.getId()]
   sql.execute updateSql, params
  }
 
 void remover(Integer id) {
     Sql sql = _connection.connecting()
   String deleteSql = 'DELETE FROM competencia WHERE id=?'
   def params = id
   sql.execute deleteSql, params
  }
}
