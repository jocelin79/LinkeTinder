import groovy.sql.Sql

class EmpresaDAO {
 
  String url = 'jdbc:postgresql://localhost:5432/linketinderdb'
  String bdUser = 'postgres'
  String bdPassword = 'postgres'
  String bdDriver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, bdUser, bdPassword, bdDriver)

  List<Empresa> listar() {
    List<Empresa> retorno = new ArrayList<>();
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
  
  boolean inserir(Empresa empresa) {
   String insertSql = 'INSERT INTO empresa(nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES(?, ?, ?, ?, ?, ?, ?)'
   def params = [empresa.getNome(), empresa.getCnpj(), empresa.getEmail(), empresa.getPais_onde_reside(), empresa.getCep(), empresa.getDescricao(), empresa.getSenha()]
   sql.execute insertSql, params
   return true;
  }
 
 boolean alterar(Empresa empresa) {
   String updateSql = 'UPDATE empresa SET nome=?, cnpj=?, email=?, pais_onde_reside=?, cep=?, descricao=?, senha=? WHERE id=?'
   def params = [empresa.getNome(), empresa.getCnpj(), empresa.getEmail(), empresa.getPais_onde_reside(), empresa.getCep(), empresa.getDescricao(), empresa.getSenha(), empresa.getId()]
   sql.execute updateSql, params
   return true;
  }
 
 boolean remover(Integer id) {
   String deleteSql = 'DELETE FROM empresa WHERE id=?'
   def params = id
   sql.execute deleteSql, params
   return true;
  }
}
