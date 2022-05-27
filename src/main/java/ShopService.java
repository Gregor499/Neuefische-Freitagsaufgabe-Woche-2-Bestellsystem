import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ShopService {
    private ProductRepo allMyProducts;
    private OrderRepo allMyOrders;

    public ShopService(ProductRepo allMyProducts, OrderRepo allMyOrders) {
        this.allMyProducts = allMyProducts;
        this.allMyOrders = allMyOrders;
    }

    public Product getProduct(String id) {
        return allMyProducts.getProduct(id);
    }

    public List<Product> listProducts() {
        return allMyProducts.list();
    }

    public void addOrder(Order order) {
        allMyOrders.addOrder(order);
    }

    public Order getOrder(String id){
        return allMyOrders.getOrder(id);
    }

    public List<Order> listOrders() {
        return allMyOrders.list();
    }
}
