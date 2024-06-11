package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import Model.Database;
import Model.Operation;
import Model.User;

public class AddNewAccount implements Operation {
    Logger logger = Logger.getLogger(getClass().getName());

    private int accType;

    public AddNewAccount(int accType) {
        this.accType = accType;
    }
    @Override
    public void operation(Database database, Scanner s, User user) {
        logger.info("Enter FirstName");
        String firstName = s.next();
        logger.info("Enter Last Name");
        String lastName = s.next();
        logger.info("Enter Email");
        String email = s.next();
        logger.info("Enter phone number");
        String phoneNumber = s.next();
        logger.info("Enter password");
        String password = s.next();
        logger.info("Confirm Password");
        String confirmPassword = s.next();
        while(!password.equals(confirmPassword)) {
            logger.info("Password doesn't match");
            logger.info("Enter password");
            password = s.next();
            logger.info("Confirm Password");
            confirmPassword = s.next();
        }


        try {
            ArrayList<String> emails = new ArrayList<>();
            ResultSet rs0 = database.getStatement().executeQuery("SELECT `Email` FROM `users`");
            while (rs0.next()){
                emails.add(rs0.getString("Email"));
            }
            if(emails.contains(email)) {
                logger.info("This email used before");
                return;
            }
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*);");
            rs.next();

            String insert = "INSERT INTO `users` (`FirstName`, `LastName`, `Email`, `Password`, `PhoneNumber`, `Type`)"
            + "VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+phoneNumber+"','"+accType+"');";
            database.getStatement().execute(insert);
            logger.info("Account created successfully\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
