package model;

import java.io.Serializable;

public class User  implements Serializable {
    protected static int ID_Product = 1;
    protected int id;
    protected String fullName;
    protected long phoneNumber;
    protected String address;
    protected Account account;

    public User() {
    }

    public User(String fullName, long phoneNumber, String address, Account account) {
        this.id = ID_Product++;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public static int getID_Product() {
        return ID_Product;
    }

    public static void setID_Product(int ID_Product) {
        User.ID_Product = ID_Product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", account=" + account +
                '}';
    }
}