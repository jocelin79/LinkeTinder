package model

import groovy.sql.Sql

class PostgreConnection implements IConnection {

    private static PostgreConnection instance

    private PostgreConnection(){}

   Sql connecting () {
        String url = 'jdbc:postgresql://localhost:5432/linketinderdb'
        String bdUser = 'postgres'
        String bdPassword = 'postgres'
        String bdDriver = 'org.postgresql.Driver'
        Sql sql = Sql.newInstance(url, bdUser, bdPassword, bdDriver)
        return sql
    }

    static PostgreConnection getInstance() {
        if (instance == null) {
            instance = new PostgreConnection()
        }
        return instance;
    }
}
