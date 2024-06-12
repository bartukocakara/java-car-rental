package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Car;
import Model.Database;
import Model.Operation;
import Model.User;

public class ViewCars implements Operation {
    
    public void operation(Database database, Scanner s, User user) {
        System.out.println();
        String select = "SELECT ID, Brand, Model, Color, `Year`, Price, Available FROM cars;";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()) {
                Car car = new Car();
                car.setID(rs.getInt("ID"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("Color"));
                car.setColor(rs.getString("Color"));
                car.setYear(rs.getInt("Year"));
                car.setPrice(rs.getDouble("Price"));
                car.setAvailable(rs.getInt("Available"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Car c : cars) {
            if(c.getAvailable() < 3){
                System.out.println("ID :\t "+c.getID());
                System.out.println("Brand :\t "+c.getBrand());
                System.out.println("Model :\t "+c.getModel());
                System.out.println("Year :\t "+c.getYear());
                System.out.println("Price :\t "+c.getPrice());
                if(c.getAvailable() == 0) {
                    System.out.println("Status:\tAvailable");
                }else {
                    System.out.println("Status:\tNot available");
                }
                System.out.println("--------------------\n");
            }
        }
    }
}
