package service;

import model.CRUD;
import model.ReadAndWrite;
import model.User;

import java.io.IOException;
import java.util.ArrayList;

public class Method_User implements CRUD<User> {
    public ReadAndWrite<User> readAndWrite = new Users_ReadAndWrite();
    public ArrayList<User> UserList  = readAndWrite.readFile();

    public ArrayList<User> getUserList() {
        return UserList;
    }

    public void setUserList(ArrayList<User> userList) {
        UserList = userList;
    }

    @Override
    public User getById(int id) {
        for (User User : UserList){
            if (id == User.getId()){
                return User;
            }
        }
        return null;
    }

    @Override
    public User add(User User) {
        UserList.add(User);
        try{
            readAndWrite.writeFile(UserList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return User;
    }

    @Override
    public void update(User User) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getId() == User.getId()){
                UserList.set(i,User);
            }
        }
        try{
            readAndWrite.writeFile(UserList);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public User deleteById(int id) {
        for (User User : UserList){
            if (id == User.getId()){
                UserList.remove(User);
                return User;
            }
        }
        try{
            readAndWrite.writeFile(UserList);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (User User : UserList){
            if (id == User.getId()){
                System.out.println(User);
            }
        }
    }

    @Override
    public void displayAll() {
        for (User User : UserList){
            System.out.println(User);
        }
    }
}
