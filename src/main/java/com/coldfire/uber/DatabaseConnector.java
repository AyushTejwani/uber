package com.coldfire.uber;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
private final String url;
private final Properties properties;

    public DatabaseConnector(String host,String databasename,String username,String password)
    {
        this.url="jdbc:postgresql://"+host+"/"+databasename;
        this.properties=new Properties();
        this.properties.setProperty("user",username);
        this.properties.setProperty("password", password);
    }
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(this.url,this.properties);
    }
}
