package model

import groovy.sql.Sql

interface IConnection {
    Sql connecting()
}