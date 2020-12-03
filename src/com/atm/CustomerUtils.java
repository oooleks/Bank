package com.atm;

public class CustomerUtils extends Customer{

    public final static Customer JAN = new Customer("January", "jan", "01", 0);
    public final static Customer FEB = new Customer("February", "feb", "02", 0);
    public final static Customer MAR = new Customer("March", "mar", "03", 0);
    public final static Customer APR = new Customer("April", "apr", "04", 0);
    public final static Customer MAY = new Customer("May", "may", "05", 0);
    public final static Customer JUN = new Customer("June", "jun", "06", 0);
    public final static Customer JUL = new Customer("July", "jul", "07", 0);
    public final static Customer AUG = new Customer("August", "aug", "08", 0);
    public final static Customer SEP = new Customer("September", "sep", "09", 0);
    public final static Customer OCT = new Customer("October", "oct", "10", 0);
    public final static Customer NOV = new Customer("November", "nov", "11", 0);
    public final static Customer DEC = new Customer("December", "dec", "12", 0);

    public final static Customer[] all_customers =
            {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};

    public CustomerUtils(String name, String login, String password, double balance) {
        super(name, login, password, balance);
    }
}
