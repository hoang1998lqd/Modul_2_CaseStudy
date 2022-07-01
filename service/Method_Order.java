package service;

import model.CRUD;
import model.order;


import java.io.Serializable;
import java.util.ArrayList;

public class Method_Order implements CRUD<order> , Serializable {

    public ArrayList<order> orderList ;

    public ArrayList<order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<order> orderList) {
        this.orderList = orderList;
    }

    public int getSize(){
        return orderList.size();
    }
    @Override
    public order getById(int id) {
        for (order order : orderList){
            if (id == order.getId()){
                return order;
            }
        }
        return null;
    }

    @Override
    public order add(order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public void update(order order) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == order.getId()){
                orderList.set(i,order);
            }
        }
    }

    @Override
    public order deleteById(int id) {
        for (order order : orderList){
            if (id == order.getId()){
                orderList.remove(order);
                return order;
            }
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (order order : orderList){
            if (id == order.getId()){
                System.out.println(order);
            }
        }
    }

    @Override
    public void displayAll() {
        for (order order : orderList){
            System.out.println(order);
        }
    }
}
