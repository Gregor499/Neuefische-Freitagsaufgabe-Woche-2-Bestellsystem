import java.util.UUID;

public class Order {
    private String orderId;
    private Product product;

    public Order(Product product) {
        this.product = product;
        this.orderId= UUID.randomUUID().toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Product getName() {
        return product;
    }

    public void setName(String name) {
        this.product = product;
    }
}
