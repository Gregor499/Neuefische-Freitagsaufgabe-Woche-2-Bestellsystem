import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ShopService {
    private final ProductRepo allMyProducts;
    private final OrderRepo allMyOrders;

    public ShopService(ProductRepo allMyProducts, OrderRepo allMyOrders) {
        this.allMyProducts = allMyProducts;
        this.allMyOrders = allMyOrders;
    }

    public Product getProduct(String id) {
        return allMyProducts.getProduct(id).orElseThrow();
    }

    public List<Product> listProducts() {
        return allMyProducts.list();
    }

    public void addOrder(List<String> productsToOrder) {
        List<Produkt> orderedProducts = new ArrayList<>();
        for (String id : productsToOrder) {
            orderedProducts.add(getProduct(id));
        }
        myOrders.add(new Order(orderedProducts));
        }
    }

    public Order getOrder(String id){
        return allMyOrders.getOrder(id);
    }

    public List<Order> listOrders() {
        return allMyOrders.list();
    }
}
