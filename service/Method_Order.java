package service;

import model.CRUD;
import model.Order;


import java.io.Serializable;
import java.util.ArrayList;

public class Method_Order implements CRUD<Order> , Serializable {

    public ArrayList<Order> orderList ;

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public int getSize(){
        return orderList.size();
    }
    @Override
    public Order getById(int id) {
        for (Order order : orderList){
            if (id == order.getId()){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order add(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public void update(Order order) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getId() == order.getId()){
                orderList.set(i,order);
            }
        }
    }

    @Override
    public Order deleteById(int id) {
        for (Order order : orderList){
            if (id == order.getId()){
                orderList.remove(order);
                return order;
            }
        }
        return null;
    }

    @Override
    public void displayById(int id) {
        for (Order order : orderList){
            if (id == order.getId()){
                System.out.println(order);
            }
        }
    }

    @Override
    public void displayAll() {
        for (Order order : orderList){
            System.out.println(order);
        }
    }
}
