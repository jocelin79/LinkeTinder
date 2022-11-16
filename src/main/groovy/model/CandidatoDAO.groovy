package model

import groovy.sql.Sql

class CandidatoDAO implements ICandidatoDAO{

  private IConnection _connection

  CandidatoDAO(IConnection connection) {
    _connection = connection
  }

  List<Candidato> listar() {
    List<Candidato> retorno = new ArrayList<>()
    Sql sql = _connection.connecting()
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
  
  void inserir(Candidato candidato) {
    Sql sql = _connection.connecting()
   String insertSql = 'INSERT INTO candidato(nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)'
   def params = [candidato.getNome(), candidato.getSobrenome(), candidato.getData_nascimento(), candidato.getEmail(), candidato.getCpf(), candidato.getPais_onde_reside(), candidato.getCep(), candidato.getDescricao(), candidato.getSenha()]
   sql.execute insertSql, params
  }
 
 void alterar(Candidato candidato) {
   Sql sql = _connection.connecting()
   String updateSql = 'UPDATE candidato SET nome=?, sobrenome=?, data_nascimento=?, email=?, cpf=?, pais_onde_reside=?, cep=?, descricao=?, senha=? WHERE id=?'
   def params = [candidato.getNome(), candidato.getSobrenome(), candidato.getData_nascimento(), candidato.getEmail(), candidato.getCpf(), candidato.getPais_onde_reside(), candidato.getCep(), candidato.getDescricao(), candidato.getSenha(), candidato.getId()]
   sql.execute updateSql, params
  }

 void remover(Integer id) {
   Sql sql = _connection.connecting()
   String deleteSql = 'DELETE FROM candidato WHERE id=?'
   Integer params = id
   sql.execute deleteSql, params
  }
}
