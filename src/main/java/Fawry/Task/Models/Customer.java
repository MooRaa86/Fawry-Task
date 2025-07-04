package Fawry.Task.Models;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private double Balance;

    public Customer(String name, String address, String phone, double balance) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        Balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
