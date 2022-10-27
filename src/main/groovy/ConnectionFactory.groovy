import groovy.sql.Sql

abstract class ConnectionFactory {
    void startConnectionFactory() {
        IConnection connection = createConnection()
        connection.connecting()
    }

    protected abstract IConnection createConnection();
}
