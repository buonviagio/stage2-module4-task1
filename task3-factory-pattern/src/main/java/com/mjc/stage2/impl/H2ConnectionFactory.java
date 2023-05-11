package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "h2database.properties";
        Connection connection = null;

        try (FileInputStream fio = new FileInputStream(appConfigPath)) {
            Properties appProps = new Properties();
            appProps.load(fio);

            Class.forName(appProps.getProperty("jdbc_driver"));

            connection = DriverManager.getConnection(appProps.getProperty("db_url"),
                    appProps.getProperty("user"),
                    appProps.getProperty("password"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    // Write your code here!
}

