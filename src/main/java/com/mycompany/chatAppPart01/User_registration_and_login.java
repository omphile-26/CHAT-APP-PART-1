/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatAppPart01;

/**
 *
 * @author deepl
 */import java.util.Scanner;

public class User_registration_and_login {

    String registeredUsername;
    String registeredPassword;
    String registeredCellNumber;

    // Method: check username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method: check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasUpperCase && hasDigit && hasSpecialChar;
    }

    // Method: check cell phone number
    public boolean checkCellPhoneNumber(String cellNumber) {
        return (cellNumber.startsWith("+") || cellNumber.matches("^\\d{2,}.*")) && cellNumber.length() >= 10;
    }

    // Method: register user
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that this password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        registeredUsername = username;
        registeredPassword = password;
        registeredCellNumber = cellNumber;

        return "Welcome user " + username + ", username, " + username + " user last name: It is great to see you.";
    }

    // Method: login user
    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    // Method: return login status
    public String returnLoginStatus(boolean loginSuccess) {
        return loginSuccess ? "Login successful" : "Login failed";
    }

    // Main method for console testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       User_registration_and_login authSystem = new User_registration_and_login();
        

        System.out.println("=== User Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number: ");
        String cellNumber = scanner.nextLine();

        String registrationMessage = authSystem.registerUser(username, password, cellNumber);
        System.out.println(registrationMessage);

        if (registrationMessage.contains("Welcome user")) {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = authSystem.loginUser(loginUsername, loginPassword);
            System.out.println(authSystem.returnLoginStatus(loginSuccess));
        }

        scanner.close();
    }
}

