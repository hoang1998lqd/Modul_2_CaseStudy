package All_Classes;

public class order {
    protected static int ID_Order = 1;
   protected int id;  // ID tự tăng
   protected long count;  // Số lượng mua hàng
   protected User user;  // Thông tin người dùng
   protected Product product; // Thông tin sản phẩm
   protected long totalPrice;

    public order(long count, User user, Product product, long totalPrice) {
        this.id = ID_Order;
        this.count = count;
        this.user = user;
        this.product = product;
        this.totalPrice = totalPrice;
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
        return count = product.getPrice() * count;
    }

    public void setCount(int count) {
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
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", user_name=" + user.getFullName() +
                ", user_address=" + user.getAddress() +
                ", product=" + product.getName_product() +
                ", product=" + product.getColor() +
                ", product=" + product.getPrice() +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
