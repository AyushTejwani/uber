package com.coldfire.uber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ridedetails {
    private String pickup_location;
    private String drop_location;
    private String username;

    public Ridedetails(String user) {
        this.username = user;
    }

    public void setPickup_location() {
        System.out.println("Enter your pickup location");
        Scanner scan = new Scanner(System.in);
        this.pickup_location = scan.nextLine();
    }

    public void setDrop_location() {
        System.out.println("Enter your drop location");
        Scanner scan = new Scanner(System.in);
        this.drop_location = scan.nextLine();
    }

    public void ridedetialstodbb() {
        DatabaseConnector dcm = new DatabaseConnector("127.0.0.1", "uber", "postgres", "Ayush81298!");
        try {
            Connection connection = dcm.getConnection();
            String sql = "INSERT INTO ridedetails VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, this.username);
            stmt.setString(2, this.pickup_location);
            stmt.setString(3, this.drop_location);
            stmt.setBoolean(4, false);
            stmt.executeUpdate();
            System.out.println("Waiting for rides");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

