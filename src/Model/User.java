package Model;

import java.util.Scanner;

public abstract class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    // TYPE 0 => Client
    //      1 => Admin
    //      2 => DeletedClientAccount
    //      3 => DeletedAdminAccount

    public User(){}

    public int getID(){
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public abstract void showList(Database database, Scanner scanner);

}
