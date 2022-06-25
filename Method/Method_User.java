package Method;

import All_Classes.CRUD;
import All_Classes.User;
import java.util.ArrayList;

public class Method_User implements CRUD<User> {
    protected ArrayList<User> UserList ;

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
        return User;
    }

    @Override
    public void update(User User) {
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getId() == User.getId()){
                UserList.set(i,User);
            }
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
