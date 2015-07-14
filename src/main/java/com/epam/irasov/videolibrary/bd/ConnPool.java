package com.epam.irasov.videolibrary.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnPool {
    public static String DRIVER = "org.h2.Driver";
    public static String CONNECT = "jdbc:h2:tcp://localhost/~/jdbcmovie";
    public static String CONNECT_ID = "1";
    public static String CONNECT_NAME = "1";

    Connection connection;
    private ConnPool() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECT, CONNECT_ID, CONNECT_NAME);
        } catch (ClassNotFoundException e) {
           throw new ConnPoolException(e);
        } catch (SQLException e) {
           throw new ConnPoolException(e);
        }
    }

    private static class ConnPoolHolder {
        private final static ConnPool instance = new ConnPool();
    }

    public static ConnPool getInstance() {
        return ConnPoolHolder.instance;
    }
}
