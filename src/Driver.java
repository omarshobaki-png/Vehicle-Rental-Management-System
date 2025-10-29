package assigment2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Vehicle[] availableVehicles = {
                new Vehicle("Car", "ABC123", "Toyota", 50.0, true),
                new Vehicle("Bike", "DEF456", "Honda", 20.0, true),
                new Vehicle("Truck", "GHI789", "Ford", 80.0, true),
                new Vehicle("Car", "JKL012", "Hyundai", 55.0, true),
                new Vehicle("Bike", "MNO345", "Yamaha", 160.0, true)
        };

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int cstmrs = input.nextInt();
        while (cstmrs <= 0) {
            System.out.println("Enter a positive number of customers");
            cstmrs = input.nextInt();
        }
        input.nextLine();

        Customer[] customers = new Customer[cstmrs];
        int printedList = 0;
        String reg = ""; // Declare once and reuse
        Vehicle rent = null; // Declare once and reuse

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer();
            System.out.println("\nEnter the details for customer number " + (i + 1));
            String namee;
            int nameExists;
            do {
                nameExists = 0;
                System.out.print("Enter name: ");
                namee = input.nextLine();
                for (int j = 0; j < i; j++) {
                	String k= customers[j].getName().toLowerCase();
                    if (k.equals(namee.toLowerCase())) {
                        nameExists = 1;
                        System.out.println("This name is already taken enter a different name");
                        break;
                    }
                }
            } while (nameExists==1);
            customers[i].setName(namee);
            int idd;
            int idExists; 
            do {
                idExists = 0;
                System.out.print("Enter id: ");
                idd = input.nextInt();
                input.nextLine(); // Consume newline
                for (int j = 0; j < i; j++) {
                    if (customers[j].getId() == idd) {
                        idExists = 1;
                        System.out.println("This id is already taken enter a different id");
                        break;
                    }
                }
            } while (idExists==1);
            customers[i].setId(idd);
            System.out.print("Enter license number: ");
            String license = input.nextLine();
            customers[i].setLicenseNumber(license);
            System.out.print("Enter the max number of vehicles the customer will rent: ");
            int max = input.nextInt();
            input.nextLine();
            Vehicle[] maxVehicles = new Vehicle[max];
            customers[i].setVehiclesRented(maxVehicles);
            System.out.print("Enter the number of cars to rent now: ");
            int rentNow = input.nextInt();
            input.nextLine();
            int c = 0;

            while (c < rentNow) {
                if (printedList == 0) {
                    System.out.println("\nList of available vehicles: \n");
                    for (int j = 0; j < availableVehicles.length; j++) {
                        System.out.print((j + 1) + ". ");
                        availableVehicles[j].printInfo();
                    }
                    printedList++;
                }
                System.out.print("\nEnter the registration number of vehicle number " + (c + 1) + " you wish to rent: ");
                reg = input.nextLine();
                rent = null;

                for (int m = 0; m < availableVehicles.length; m++) {
                    if (availableVehicles[m].getRegistrationNumber().equals(reg.toUpperCase()) && availableVehicles[m].isAvailable()) {
                        rent = availableVehicles[m];
                        rent.setAvailable(false);
                        break;
                    }
                }

                while (rent == null) {
                    System.out.print("Please enter a valid or an available registration number: ");
                    reg = input.nextLine();
                    for (int k = 0; k < availableVehicles.length; k++) {
                        if (availableVehicles[k].getRegistrationNumber().equals(reg) && availableVehicles[k].isAvailable()) {
                            rent = availableVehicles[k];
                            rent.setAvailable(false);
                            break;
                        }
                    }
                }

                System.out.print("For how many days do you wish to rent the vehicle: ");
                int dayss = input.nextInt();
                input.nextLine();
                customers[i].rentVehicle(rent, dayss);
                c++;
            }
        }

        int operation = 1;
        while (operation != 0) {
            System.out.println("\nList of available operations: ");
            System.out.println("1: Print Customer Information");
            System.out.println("2: Display Total Rental Cost for a Customer");
            System.out.println("3: Count Rented Vehicles by Type ");
            System.out.println("4: Rent a New Vehicle ");
            System.out.println("5: Return a Vehicle ");
            System.out.println("6: Display All Available Vehicles in Ascending Order of Price");
            System.out.println("7: Display All Available Vehicles in Alphabetical Order of Type");
            System.out.println("8: Exit");
            System.out.print("\nEnter the operation you want: ");
            int op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Enter the name of the customer you want the info for: ");
                    String nameee = input.nextLine();
                    int ch = 0;
                    for (int i = 0; i < customers.length; i++) {
                        String c = customers[i].getName().toLowerCase();
                        if (c.equals(nameee.toLowerCase())) {
                            customers[i].printInfo();
                            ch++;
                        }
                        if (ch == 0) {
                            System.out.println("Invalid name");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the customer's ID: ");
                    int iden = input.nextInt();
                    Customer res = findCustomerById(customers, iden);
                    while (res == null) {
                        System.out.print("Enter a valid id");
                        iden = input.nextInt();
                        res = findCustomerById(customers, iden);
                    }
                    double rentt = res.calculateRent();
                    System.out.println("Rent due by "+ res.getName()+" is $" + rentt);
                    break;
                case 3:
                    System.out.print("Enter the customer's ID: ");
                    int ide = input.nextInt();
                    Customer result = findCustomerById(customers, ide);
                    while (result == null) {
                        System.out.print("Invalid ID. Please enter a valid customer ID:");
                        ide = input.nextInt();
                        result = findCustomerById(customers, ide);
                    }
                    System.out.print("Enter the type of vehicle:");
                    String typee = input.next();
                    int count = result.countVehicleByType(typee);
                    System.out.println("The number of " + typee.toLowerCase() + "(s) rented by "+ result.getName()+ " is: " + count);
                    break;
                case 4:
                    System.out.print("Enter the customer's ID: ");
                    int ident = input.nextInt();
                    input.nextLine();
                    Customer resu = findCustomerById(customers, ident);
                    while (resu == null) {
                        System.out.print("Enter a valid ID: ");
                        ident = input.nextInt();
                        input.nextLine();
                        resu = findCustomerById(customers, ident);
                    }
                    System.out.print("Enter the type of vehicle you wish to rent: ");
                    String ty = input.nextLine();
                    int count2 = 0;
                    System.out.println("\nList of available"+ ty+"s: \n");
                    for (int i = 0; i < availableVehicles.length; i++) {
                        String y = availableVehicles[i].getType().toLowerCase();
                        if (y.equals(ty.toLowerCase()) && availableVehicles[i].isAvailable()) {
                            availableVehicles[i].printInfo();
                            count2++;
                        }
                    }
                    if (count2 == 0) {
                        System.out.println("No vehicles of this type available");
                    } else {
                        System.out.print("Enter the registration number of the vehicle you wish to rent: ");
                        reg = input.nextLine();
                        rent = findVehicleByRegistrationNumber(availableVehicles, reg);
                        if (rent != null && rent.isAvailable()) {
                            System.out.print("For how many days do you wish to rent the vehicle: ");
                            int days = input.nextInt();
                            resu.rentVehicle(rent, days);
                            System.out.println("Vehicle "+ reg+" rented successfully");
                        } else {
                            System.out.println("This vehicle is not available");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter the customer's ID: ");
                    int identi = input.nextInt();
                    Customer re = findCustomerById(customers, identi);
                    while (re == null) {
                        System.out.print("Enter a valid ID");
                        identi = input.nextInt();
                        re = findCustomerById(customers, identi);
                    }
                    Vehicle[] veh = re.getVehiclesRented();
                    for (int i = 0; i < re.getNumberOfCurrentRented(); i++) {
                        veh[i].printInfo();
                    }
                    System.out.print("Enter the registration number of the car you wish to return: ");
                    String regNum = input.next();
                    Vehicle vehicle = findVehicleByRegistrationNumber(re.getVehiclesRented(), regNum);
                    if (vehicle != null) {
                        re.returnVehicle(vehicle);
                        System.out.println("Vehicle " +regNum+" returned successfully!");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 6:
                    displayVehiclesByPrice(availableVehicles);
                    break;
                case 7:
                    displayVehiclesByType(availableVehicles);
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    operation = 0;
                    break;
                default:
                    System.out.print("Choose a valid number 1-8.");
            }
        }
    }

    public static Customer findCustomerById(Customer[] customers, int customerId) {
        Customer res = null;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == customerId) {
                res = customers[i];
            }
        }
        return res;
    }

    public static Vehicle findVehicleByRegistrationNumber(Vehicle[] vehicles, String regNumber) {
        Vehicle res = null;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null && vehicles[i].getRegistrationNumber().equals(regNumber)) {
                res = vehicles[i];
            }
        }
        return res;
    }

    public static void displayVehiclesByPrice(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            for (int j = 0; j < vehicles.length - 1; j++) {
                if (vehicles[j].getRentalRatePerDay() > vehicles[j + 1].getRentalRatePerDay()) {
                    Vehicle temp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = temp;
                }
            }
        }
        int allRented=0;
        System.out.println("Available vehicles sorted by rental rate:");
        for (int u = 0; u < vehicles.length; u++) {
            if (vehicles[u].isAvailable()) {
                vehicles[u].printInfo();
                allRented=1;
            }
        }
        if(allRented==0) {
        	System.out.println("No available vehicles to display");
        }
    }

    public static void displayVehiclesByType(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length - 1; i++) {
            for (int j = 0; j < vehicles.length - 1 - i; j++) {
                if (vehicles[j].getType().compareTo(vehicles[j + 1].getType()) > 0) {
                    Vehicle temp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = temp;
                }
            }
        }
        int allRented=0;
        System.out.println("Available vehicles in alphabetical order of type:");
        for (int u = 0; u < vehicles.length; u++) {
            if (vehicles[u].isAvailable()) {
                vehicles[u].printInfo();
                allRented=1;
            }
        }
        if(allRented==0) {
        	System.out.println("No available vehicles to display");
        }
    }
}



