package Model;

import java.util.Scanner;

public class Client extends User {
    public Client(){
        super();
    }

    @Override
    public void showList(Database database, Scanner s){
        System.out.println("\n1. View cars");
        System.out.println("2. Rent a car");
        System.out.println("3. Return car");
        System.out.println("4. Show My rents");
        System.out.println("5. Edit my data");
        System.out.println("6. Quit\n");
    }
    
}
