package model;

import java.util.ArrayList;

public class Store {
    protected ArrayList<User> users = new ArrayList<>();
    protected ArrayList<order> orders = new ArrayList<>();


    public Store(ArrayList<User> users, ArrayList<order> orders) {
        this.users = users;
        this.orders = orders;
    }



    public long turnover(){
        long total = 0;
        for (order order : orders){
            total += order.getTotalPrice();
        }
        return total;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Cửa hàng: {" +
                ",Tổng doanh thu: " + turnover() + " VNĐ" +
                '}';
    }
}
