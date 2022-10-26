import groovy.sql.Sql

class VagaDAO implements IVagaDAO{

    private IConnection _connection

    CandidatoDAO(IConnection connection) {
        _connection = connection
    }

  List<Vaga> listar() {
    List<Vaga> retorno = new ArrayList<>()
      Sql sql = _connection.connecting()
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
  
  void inserir(Vaga vaga) {
      Sql sql = _connection.connecting()
   String insertSql = 'INSERT INTO vaga(descricao, local_da_vaga, idEmpresa) VALUES(?, ?, ?)'
   def params = [vaga.getDescricao(), vaga.getLocal_da_vaga(), vaga.getIdEmpresa()]
   sql.execute insertSql, params
  }
 
  void alterar(Vaga vaga) {
      Sql sql = _connection.connecting()
   String updateSql = 'UPDATE vaga SET descricao=?, local_da_vaga=?, idEmpresa=? WHERE id=?'
   def params = [vaga.getDescricao(), vaga.getLocal_da_vaga(), vaga.getIdEmpresa(), vaga.getId()]
   sql.execute updateSql, params
  }
 
  void remover(Integer id) {
      Sql sql = _connection.connecting()
   String deleteSql = 'DELETE FROM vaga WHERE id=?'
   def params = id
   sql.execute deleteSql, params
  }
}
