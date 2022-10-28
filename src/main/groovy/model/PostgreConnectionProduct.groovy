package model

class PostgreConnectionProduct extends ConnectionFactory{
    @Override
    protected IConnection createConnection() {
        PostgreConnection postgreConnection = PostgreConnection.getInstance()
        return postgreConnection
    }
}
