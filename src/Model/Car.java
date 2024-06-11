package Model;
public class Car {
    private int ID;
    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private boolean available; // 0 available , 1 Rented, 2 Deleted

    public Car() { }

    public int getID() {
        return ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
