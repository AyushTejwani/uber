package com.coldfire.uber;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    private String username;
    private String password;
    public void setUsername()
    {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your username");
        String username=scanner.nextLine();
        this.username=username;
    }
    public void setPassword()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your password");
        String pass=scanner.nextLine();
        this.password=pass;
    }
    public void store()
    {
        DatabaseConnector dc = new DatabaseConnector("127.0.0.1", "uber", "postgres", "Ayush81298!");
        try {
            Connection connection = dc.getConnection();
            String sql = "INSERT INTO users VALUES (?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            stmt.executeUpdate();
            System.out.println("Registration successfull!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
