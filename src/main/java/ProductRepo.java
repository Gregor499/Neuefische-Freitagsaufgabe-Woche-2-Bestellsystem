import java.util.*;

import static com.sun.tools.attach.VirtualMachine.list;

    public class ProductRepo {

        private Map<String, Product> allMyProducts = new HashMap<>();

        public ProductRepo(List<Product> products) {
            for (Product currentProduct: products) {
                allMyProducts.put(currentProduct.getProductId(), currentProduct);
            }
        }

        public List<Product> list() {
            return allMyProducts.values().stream().toList();
        }

        public Optional<Product> getProduct(String id){
            return Optional.ofNullable(allMyProducts.get(id));
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
