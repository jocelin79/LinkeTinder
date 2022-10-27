import groovy.sql.Sql

class PostgreConnection implements IConnection {

    String url = 'jdbc:postgresql://localhost:5432/linketinderdb'
    String bdUser = 'postgres'
    String bdPassword = 'postgres'
    String bdDriver = 'org.postgresql.Driver'

    Sql connecting () {
        Sql sql = Sql.newInstance(url, bdUser, bdPassword, bdDriver)
        return sql
    }
}
