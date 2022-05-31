import java.util.Objects;
import java.util.UUID;

public class Product {
    private final String productId;
    private final String name;

    public Product(String name) {
        this.name = name;
        productId = UUID.randomUUID().toString();
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name);
    }
}