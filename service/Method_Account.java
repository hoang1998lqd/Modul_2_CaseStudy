package service;

import model.CRUD;
import model.Account;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Method_Account implements CRUD<Account> {
    public Account_ReadAndWrite readAndWrite = new Account_ReadAndWrite();
    public ArrayList<Account> accountList;

    public Method_Account() {
        accountList = readAndWrite.readFile();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public int size() {
        return accountList.size();
    }

    @Override
    public Account getById(int id) {
        for (Account account : accountList){
            if (id == account.getId()){
                return account;
            }
        }
        return null;
    }

    @Override
    public Account add(Account account) {
        accountList.add(account);
        try{
            readAndWrite.writeFile(accountList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == account.getId()){
                accountList.set(i,account);
            }
        }
        try {
            readAndWrite.writeFile(accountList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Account deleteById(int id) {
        for (Account account : accountList){
            if (id == account.getId()){
                accountList.remove(account);
                return account;
            }
        }
        try {
            readAndWrite.writeFile(accountList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (Account account : accountList){
            if (id == account.getId()){
                System.out.println(account);
            }
        }
    }

    @Override
    public void displayAll() {
        for (Account account : accountList){
            System.out.println(account);
        }
    }
    public boolean checkAccount(String account){
        for (Account account1 : accountList){
            if (account1.getAccount().equals(account)){
                return false;
            }
        }
        return true;
    }

    
}
