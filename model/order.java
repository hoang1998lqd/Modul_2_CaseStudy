package model;

import java.io.Serializable;

public class order  implements Serializable {
    public static int ID_Order = 1;
   protected int id;  // ID tự tăng
   protected long count;  // Số lượng mua hàng
   protected User user;  // Thông tin người dùng
   protected Product product; // Thông tin sản phẩm
   protected long totalPrice;
   protected String name;
   protected String phoneNumber;
   protected String address;

    public order(long count, User user, Product product, long totalPrice) {
        this.id = ID_Order ++;
        this.count = count;
        this.user = user;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public order(long count, Product product, long totalPrice, String name, String phoneNumber, String address) {
        this.id = ID_Order ++;
        this.count = count;
        this.product = product;
        this.totalPrice = totalPrice;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public static int getID_Order() {
        return ID_Order;
    }

    public static void setID_Order(int ID_Order) {
        order.ID_Order = ID_Order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getTotalPrice() {
        return totalPrice = count * product.getPrice();
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Đơn hàng{" +
                ", Tên người dùng: " + user.getFullName() +
                ", Số điện thoại: " + user.getPhoneNumber() +
                ", Địa chỉ nhận hàng: " + user.getAddress() +
                 "\n" +
                ", Tên sản phẩm: " + product.getName_product() +
                ", Thương hiệu: " + product.getBrand().getNameBrand() +
                ", Màu sắc: " + product.getColor() +
                ", Giá sản phẩm: " + product.getPrice() +
                ", Số lượng mua: " + count +
                ", Thành tiền: " + totalPrice + " VNĐ" +
                '}';
    }
    public String string(){
        return  "Đơn hàng{" +
                ", Tên người dùng: " + name +
                ", Số điện thoại: " + phoneNumber +
                ", Địa chỉ nhận hàng: " + address +
                ", Tên sản phẩm: " + product.getName_product() +
                ", Thương hiệu: " + product.getBrand().getNameBrand() +
                ", Màu sắc: " + product.getColor() +
                ", Giá sản phẩm: " + product.getPrice() +
                ", Số lượng mua: " + count +
                ", Thành tiền: " + totalPrice + " VNĐ" +
                '}';
    }

}
