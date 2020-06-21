package com.coldfire.uber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Uber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true) {
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Forgot Password");
            System.out.println("Please select a valid option");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {

                    LoginController loginController = new LoginController();
                    loginController.setUsername();
                    loginController.setPassword();
                    loginController.connecttodatabase();
                    String login = loginController.getUsername();
                    if (login == null) {
                        System.out.println("Please login first");
                        break;
                    }
                    Ridedetails rd=new Ridedetails(login);
                    rd.setPickup_location();
                    rd.setDrop_location();
                    rd.ridedetialstodbb();
                    rd.waiting();


                    break;
                }
                case 2: {
                    Register register = new Register();
                    register.setUsername();
                    register.setPassword();
                    register.getEmail();
                    register.getPhoneNumber();
                    register.store();
                    break;
                }
                case 3: {

                    break;
                }
                default:
                    System.out.println("Please select a valid option");
            }
        }
    }
}
