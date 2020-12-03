package com.atm;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    // to determine is user valid
    static Customer isLoginValid(String username, String password) {
        for (int i = 0; i < CustomerUtils.all_customers.length; i++) {
            if (username.equals(CustomerUtils.all_customers[i].getLogin()) &&
                    password.equals(CustomerUtils.all_customers[i].getPassword())) {
                return CustomerUtils.all_customers[i];
            }
        }
        return null;
    }

    // print out list of customers
    static void customerList() {
        System.out.println("List of customers:");
        for (int i = 0; i < CustomerUtils.all_customers.length; i++) {
            System.out.println(CustomerUtils.all_customers[i].getName());
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        boolean exit = false;
        Customer new_customer = null;
        while (!exit) {
            System.out.println("Welcome to the Best Bank!");
            System.out.println("__________________________________________________________");
            System.out.println("| Select: | (1) login | (2) enroll to banking | (3) exit |");
            System.out.println("----------------------------------------------------------");
            int entry_selection = myObj.nextInt();
            if (entry_selection == 1) {
                System.out.println("Enter your Username:");
                myObj.nextLine();
                String username = myObj.nextLine();
                System.out.println("Enter your Password:");
                String password = myObj.nextLine();
                if (isLoginValid(username, password) != null) {
                    System.out.println("Hello " + isLoginValid(username, password).getName());
                    while (!exit) {
                        System.out.println("____________________________________________________________________________________________________________________");
                        System.out.println("| Select: | (1) Check balance | (2) Deposit money | (3) Withdraw money (4) Send money to another customer (5) exit |");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------");
                        entry_selection = myObj.nextInt();
                        switch (entry_selection) {
                            case 1:
                                System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                break;
                            case 2:
                                System.out.println("Enter deposit amount:");
                                isLoginValid(username, password).setBalance(isLoginValid(username, password).getBalance() + myObj.nextDouble());
                                System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                break;
                            case 3:
                                System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                System.out.println("Enter withdrawal amount:");
                                double with_amount = myObj.nextDouble();
                                if (with_amount > isLoginValid(username, password).getBalance()) {
                                    System.out.println("Entered withdrawal amount is greater than your balance");
                                    break;
                                }
                                isLoginValid(username, password).setBalance(isLoginValid(username, password).getBalance() - with_amount);
                                System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                break;
                            case 4:
                                System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                System.out.println("Enter amount to transfer:");
                                double transfer_amount = myObj.nextDouble();
                                if (transfer_amount > isLoginValid(username, password).getBalance()) {
                                    System.out.println("Entered amount to transfer is greater than your balance");
                                    break;
                                } else {
                                    customerList();
                                    System.out.println("Enter name of customer to transfer money to from the list:");
                                    myObj.nextLine();
                                    String cust_name = myObj.nextLine();
                                    boolean is_name_valid = false;
                                    for (int i = 0; i < CustomerUtils.all_customers.length; i++) {
                                        if (cust_name.equals(CustomerUtils.all_customers[i].getName())) {
                                            is_name_valid = true;
                                            CustomerUtils.all_customers[i].setBalance(CustomerUtils.all_customers[i].getBalance() + transfer_amount);
                                            isLoginValid(username, password).setBalance(isLoginValid(username, password).getBalance() - transfer_amount);
                                        }
                                    }
                                    if (!is_name_valid) {
                                        System.out.println("No customer with such a name");
                                        break;
                                    }
                                    System.out.println("Your account balance: $" + isLoginValid(username, password).getBalance());
                                }
                                break;
                            case 5:
                                System.out.println("Thank you for visiting.");
                                exit = true;
                        }
                    }
                } else {
                    System.out.println("Incorrect Username and/or password");
                }
                // TODO
            } else if (entry_selection == 2) {
                System.out.println("Enter your name:");
                myObj.nextLine();
                String name = myObj.nextLine();
                System.out.println("Enter your Username:");
                String username = myObj.nextLine();
                System.out.println("Enter your Password:");
                String password = myObj.nextLine();
                new_customer = new Customer(name, username, password, 0);
                System.out.println("Hi, " + new_customer.getName() + "!");
                System.out.println("Your account balance: $" + new_customer.getBalance());
                while (!exit) {
                    System.out.println("____________________________________________________________________________________________________________________");
                    System.out.println("| Select: | (1) Check balance | (2) Deposit money | (3) Withdraw money (4) Send money to another customer (5) exit |");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    entry_selection = myObj.nextInt();
                    switch (entry_selection) {
                        case 1:
                            System.out.println("Your account balance: $" + new_customer.getBalance());
                            break;
                        case 2:
                            System.out.println("Enter deposit amount:");
                            new_customer.setBalance(new_customer.getBalance() + myObj.nextDouble());
                            System.out.println("Your account balance: $" + new_customer.getBalance());
                            break;
                        case 3:
                            System.out.println("Your account balance: $" + new_customer.getBalance());
                            System.out.println("Enter withdrawal amount:");
                            double with_amount = myObj.nextDouble();
                            if (with_amount > new_customer.getBalance()) {
                                System.out.println("Entered withdrawal amount is greater than your balance");
                                break;
                            }
                            new_customer.setBalance(new_customer.getBalance() - with_amount);
                            System.out.println("Your account balance: $" + new_customer.getBalance());
                            break;
                        case 4:
                            System.out.println("Your account balance: $" + new_customer.getBalance());
                            System.out.println("Enter amount to transfer:");
                            double transfer_amount = myObj.nextDouble();
                            if (transfer_amount > new_customer.getBalance()) {
                                System.out.println("Entered amount to transfer is greater than your balance");
                                break;
                            } else {
                                customerList();
                                System.out.println("Enter name of customer to transfer money to from the list:");
                                myObj.nextLine();
                                String cust_name = myObj.nextLine();
                                boolean is_name_valid = false;
                                for (int i = 0; i < CustomerUtils.all_customers.length; i++) {
                                    if (cust_name.equals(CustomerUtils.all_customers[i].getName())) {
                                        is_name_valid = true;
                                        CustomerUtils.all_customers[i].setBalance(CustomerUtils.all_customers[i].getBalance() + transfer_amount);
                                        new_customer.setBalance(new_customer.getBalance() - transfer_amount);
                                    }
                                }
                                if (!is_name_valid) {
                                    System.out.println("No customer with such a name");
                                    break;
                                }
                                System.out.println("Your account balance: $" + new_customer.getBalance());
                            }
                            break;
                        case 5:
                            System.out.println("Thank you for visiting.");
                            exit = true;
                    }
                }
            } else {
                System.out.println("Thank you for visiting.");
                exit = true;
            }
        }
    }
}
