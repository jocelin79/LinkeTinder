package model

import groovy.sql.Sql

class EmpresaDAO implements IEmpresaDAO{

  private IConnection _connection

  EmpresaDAO(IConnection connection) {
    _connection = connection
  }

  List<Empresa> listar() {
    List<Empresa> retorno = new ArrayList<>()
    Sql sql = _connection.connecting()
    sql.query('SELECT * FROM empresa') { resultSet ->
      while (resultSet.next()) {
        Empresa empresa = new Empresa()
        empresa.setId(resultSet.getInt("id"))
        empresa.setNome(resultSet.getString("nome"))
        empresa.setCnpj(resultSet.getString("cnpj"))
        empresa.setEmail(resultSet.getString("email"))
        empresa.setPais_onde_reside(resultSet.getString("pais_onde_reside"))
        empresa.setCep(resultSet.getString("cep"))
        empresa.setDescricao(resultSet.getString("descricao"))
        retorno.add(empresa)
      }
    }
    return retorno
  }
  
  void inserir(Empresa empresa) {
    Sql sql = _connection.connecting()
   String insertSql = 'INSERT INTO empresa(nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES(?, ?, ?, ?, ?, ?, ?)'
   def params = [empresa.getNome(), empresa.getCnpj(), empresa.getEmail(), empresa.getPais_onde_reside(), empresa.getCep(), empresa.getDescricao(), empresa.getSenha()]
   sql.execute insertSql, params
  }
 
 void alterar(Empresa empresa) {
   Sql sql = _connection.connecting()
   String updateSql = 'UPDATE empresa SET nome=?, cnpj=?, email=?, pais_onde_reside=?, cep=?, descricao=?, senha=? WHERE id=?'
   def params = [empresa.getNome(), empresa.getCnpj(), empresa.getEmail(), empresa.getPais_onde_reside(), empresa.getCep(), empresa.getDescricao(), empresa.getSenha(), empresa.getId()]
   sql.execute updateSql, params
  }
 
 void remover(Integer id) {
   Sql sql = _connection.connecting()
   String deleteSql = 'DELETE FROM empresa WHERE id=?'
   Integer params = id
   sql.execute deleteSql, params
  }
}
