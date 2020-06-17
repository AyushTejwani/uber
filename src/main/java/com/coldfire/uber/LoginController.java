package com.coldfire.uber;

import java.sql.*;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;


public class LoginController  {
    private String username;
    private String password;

    public void setUsername()
    {
        System.out.println("Enter your username");
        Scanner scan=new Scanner(System.in);

        this.username=scan.nextLine();
    }
    public void setPassword()
    {
        System.out.println("Enter your password");
        Scanner scan=new Scanner(System.in);

        this.password=scan.nextLine();
    }


    public void connecttodatabase() {


            DatabaseConnector dc = new DatabaseConnector("127.0.0.1", "uber", "postgres", "Ayush81298!");
        try {
            Connection connection = dc.getConnection();
            String sql = "SELECT username FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                System.out.println("Welcome " + rs.getString(1)+ "you are logged in! ");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
