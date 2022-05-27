import java.util.UUID;

public class Product {
    private String productId;
    private String name;

    public Product(String name) {
        this.name = name;
        this.productId = UUID.randomUUID().toString();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}