class PostgreConnectionProduct extends ConnectionFactory{
    @Override
    protected IConnection createConnection() {
        return new PostgreConnection()
    }
}
