package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Admin;
import Model.Client;
import Model.Database;
import Model.User;

public class Login {
    public Login(Database database, Scanner s){
        System.out.println("Enter email");
        String email = s.next();
        System.out.println("Enter password");
        String password = s.next();
        ArrayList<User> users = new ArrayList<>();
        try {
            String select = "SELECT * FROM `users`";
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                User user;
                int ID = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String phoneNumber = rs.getString("PhoneNumber");
                String em = rs.getString("Email");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");
                switch (type){
                case 0:
                    user = new Client();
                    break;
                case 1:
                    user = new Admin();
                    break;
                default:
                    user = new Client();
                }
                user.setID(ID);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(User u : users) {
            if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Welcome " + u.getFirstName());
                u.showList(database, s);
            }
        }
    }
}
