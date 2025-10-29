package assigment2;

public class Vehicle {
    private String type;
    private String registrationNumber;
    private String brand;
    private double rentalRatePerDay;
    private int rentDays;
    private boolean available;

    public Vehicle(String type, String registrationNumber, String brand, double rentalRatePerDay, boolean available) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.rentalRatePerDay = rentalRatePerDay;
        this.available = available;
    }

    public Vehicle() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public void setRentalRatePerDay(double rentalRatePerDay) {
        this.rentalRatePerDay = rentalRatePerDay;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printInfo() {
        System.out.println(type + " (Registration: " + registrationNumber + "), " + brand + " - $" + rentalRatePerDay + "/day");
    }
}



