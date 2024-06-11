package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import Model.Database;
import Model.Operation;
import Model.User;

public class AddNewCar implements Operation {
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void operation(Database database, Scanner s, User user) {
        logger.info("Enter Brand:");
        String brand = s.next();
        logger.info("Enter Model:");
        String model = s.next();
        logger.info("Enter color:");
        String color = s.next();
        logger.info("Enter year (int):");
        int year = s.nextInt();
        logger.info("Enter price:");
        double price = s.nextDouble();
        int available = 0;

        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) FROM `cars`");
            rs.next();
    
            int ID = rs.getInt("COUNT(*)");
            String insert = "INSERT INTO `cars` (`ID`, `Brand`, `Model`, `Color`, `Year`, `Price`)" +
            " VALUES ('" + ID + "','" + brand + "','" + model + "','" + color + "','" + year + "','" + price + "');";
            database.getStatement().execute(insert);
            logger.info("Car added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }
    
}
