import groovy.sql.Sql

class EmpresaDAO {
 
  String url = 'postgresql+psycopg2://postgres:postgres@localhost:5432/linketinderdb'
  String user = 'postgres'
  String password = 'postgres'
  String driver = 'org.postgresql.Driver'
  Sql sql = Sql.newInstance(url, user, password, driver)

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
   def params = empresa.getId()
   sql.execute deleteSql, params
   return true;
  }
}
