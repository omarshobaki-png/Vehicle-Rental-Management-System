package assigment2;

public class Customer {
    private String name;
    private int id;
    private String licenseNumber;
    private int numberOfCurrentRented;
    private Vehicle[] vehiclesRented;

    public Customer() {
    }

    public Customer(String name, int id, String licenseNumber, int numberOfCurrentRented, Vehicle[] vehiclesRented) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.numberOfCurrentRented = numberOfCurrentRented;
        this.id = id;
        this.vehiclesRented = vehiclesRented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getNumberOfCurrentRented() {
        return numberOfCurrentRented;
    }

    public void setNumberOfCurrentRented(int numberOfCurrentRented) {
        this.numberOfCurrentRented = numberOfCurrentRented;
    }

    public Vehicle[] getVehiclesRented() {
        return vehiclesRented;
    }

    public void setVehiclesRented(Vehicle[] vehiclesRented) {
        this.vehiclesRented = vehiclesRented;
    }

    public void rentVehicle(Vehicle vehicle, int days) {
        if (numberOfCurrentRented < vehiclesRented.length) {
            vehiclesRented[numberOfCurrentRented] = vehicle;
            vehicle.setRentDays(days);
            vehicle.setAvailable(false);
            numberOfCurrentRented++;
        } else {
            System.out.println("You have reached the maximum number of vehicles. Please return one before you can rent again.");
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        int index = -1;
        for (int i = 0; i < numberOfCurrentRented; i++) {
            if (vehiclesRented[i] == vehicle) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Vehicle not found");
        } else {
            for (int j = index; j < vehiclesRented.length - 1; j++) {
                vehiclesRented[j] = vehiclesRented[j + 1];
            }
            vehicle.setAvailable(true);
            vehiclesRented[numberOfCurrentRented - 1] = null;
            numberOfCurrentRented--;
        }
    }

    public double calculateRent() {
        double rent = 0.0;
        for (int i = 0; i < numberOfCurrentRented; i++) {
            rent += vehiclesRented[i].getRentDays() * vehiclesRented[i].getRentalRatePerDay();
        }
        return rent;
    }

    public double calculateRentType(String type) {
        double rent = 0.0;
        for (int i = 0; i < numberOfCurrentRented; i++) {
            if (vehiclesRented[i].getType().equals(type)) {
                rent += vehiclesRented[i].getRentalRatePerDay() * vehiclesRented[i].getRentDays();
            }
        }
        return rent;
    }

    public int countVehicleByType(String type) {
        int count = 0;
        for (int i = 0; i < numberOfCurrentRented; i++) {
        	String h = vehiclesRented[i].getType().toLowerCase();
            if (h.equals(type.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public void printInfo() {
        System.out.println("Customer name: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("License number: " + licenseNumber);
        System.out.println("Number of vehicles rented: " + numberOfCurrentRented);
        for (int i = 0; i < numberOfCurrentRented; i++) {
            if (vehiclesRented[i] != null) {
                System.out.print((i + 1) + ": ");
                vehiclesRented[i].printInfo();
            }}
    }
}

