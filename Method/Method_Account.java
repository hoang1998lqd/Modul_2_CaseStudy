package Method;

import All_Classes.CRUD;
import All_Classes.ReadAndWrite;
import All_Classes.account;

import java.io.IOException;
import java.util.ArrayList;


public class Method_Account implements CRUD<account> {
    public ReadAndWrite<account> readAndWrite = new Account_ReadAndWrite();
    public ArrayList<account> accountList = readAndWrite.readFile();

    public ArrayList<account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public account getById(int id) {
        for (account account : accountList){
            if (id == account.getId()){
                return account;
            }
        }
        return null;
    }

    @Override
    public account add(account account) {
        accountList.add(account);
        try{
            readAndWrite.writeFile(accountList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(account account) {
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
    public account deleteById(int id) {
        for (account account : accountList){
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
        for (account account : accountList){
            if (id == account.getId()){
                System.out.println(account);
            }
        }
    }

    @Override
    public void displayAll() {
        for (account account : accountList){
            System.out.println(account);
        }
    }
    
}
