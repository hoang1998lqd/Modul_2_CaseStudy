package model;


import java.io.Serializable;
import java.util.ArrayList;

public class Bill extends Order implements Serializable {
    public static int ID_Bill = 1;
    protected int id;  // ID tự tăng
    protected User user;
    protected ArrayList<Order> order;
    protected int totalAllPrice;
    protected String paymentStatus;
    protected String orderStatus;

    public Bill(long count, Product product, long totalPrice, User user, ArrayList<Order> order, int totalAllPrice, String paymentStatus, String orderStatus) {
        super(count, product, totalPrice);
        this.id = ID_Bill ++;
        this.user = user;
        this.order = order;
        this.totalAllPrice = totalAllPrice;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
    }

    public static int getID_Bill() {
        return ID_Bill;
    }

    public static void setID_Bill(int ID_Bill) {
        Bill.ID_Bill = ID_Bill;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public int getTotalAllPrice() {
        return totalAllPrice;
    }

    public void setTotalAllPrice(int totalAllPrice) {
        this.totalAllPrice = totalAllPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Hóa đơn: {" +
                "id=" + id +
                ", Tên người dùng: " + user.getFullName() +
                ", Số điện thoại: " + user.getPhoneNumber() +
                ", Địa chỉ nhận hàng: " + user.getAddress() +
                "\n "  +
                ", order=" + order +
                "\n "  +
                ", Thanh toán : " + totalAllPrice + " VNĐ" +
                ", Trạng thái thanh toán: '" + paymentStatus + '\'' +
                ", Trạng thái đơn hàng: '" + orderStatus + '\'' +
                '}';
    }
}
