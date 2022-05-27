import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.tools.attach.VirtualMachine.list;

    public class ProductRepo {

        private Map<String, Product> allMyProducts =new HashMap<String, Product>();

        public ProductRepo() {
            Product product1 = new Product("Eis");
            Product product2 = new Product("Blumen");
            Product product3 = new Product("Tofu");

            allMyProducts.put(product1.getProductId(), product1);
            allMyProducts.put(product2.getProductId(), product2);
            allMyProducts.put(product3.getProductId(), product3);
        }

        public List<Product> list() {
            return allMyProducts.values().stream().toList();
        }

        public Product getProduct(String id){
            return allMyProducts.get(id);
        }
}

/*    private Map<String, Product> allProducts;

    public ProductRepo(List<Product> allProducts) {
        this.allProducts = new HashMap<>();
        for (Product product : allProducts) {
            this.allProducts.put(allProducts.getProductId(), allProducts);
        }

        public Collection<Product> list() {
            return allProducts.values();
        }
    }*/
