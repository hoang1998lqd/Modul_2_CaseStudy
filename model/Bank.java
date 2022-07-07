package model;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Bank implements Serializable {
    public static int ID_Bank = 1;
    protected int id;
    protected String accountNumber; // Số tài khoản 13 số
    protected  int money; // Số dư tài khoản
    protected  String code; // Mã Pin 6 số

    public Bank() {
    }

    public Bank( String accountNumber, int money, String code) {
        this.id = ID_Bank ++;
        this.accountNumber = accountNumber;
        this.money = money;
        this.code = code;
    }

    public static int getID_Bank() {
        return ID_Bank;
    }

    public static void setID_Bank(int ID_Bank) {
        Bank.ID_Bank = ID_Bank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String changeBalanceCustomer(){
        int a = money;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String money = numberFormat.format(a);
        return money;
    }

    @Override
    public String toString() {
        return "Tài khoản ngân hàng {" +
                "id=" + id +
                ", Số tài khoản: '" + accountNumber + '\'' +
                ", Số dư toàn khoản: " + changeBalanceCustomer() +
                ", Mã pin: '" + code + '\'' +
                '}';
    }
}
