import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopServiceTest {
    //Hilfsmethoden
    private ShopService buildShop(){
        Product p1 = new Product("Wasser");
        Product p2 = new Product("Bier");
        Product p3 = new Product("Messer");
        Product p4 = new Product("Teller");

        ProductRepo testRepo = new ProductRepo(List.of(p1,p2,p3,p4));
    }

    @Test

    void shouldReturnProduct(){
        //GIVEN
        ShopService testShop = new ShopService(new ProductRepo(), new OrderRepo());
        List<Product> testList = testShop.listProducts();
        //WHEN
        Product expected = testList.get(2);
        Product actual = testShop.getProduct(expected.getProductId());
        //THEN
        assertEquals(expected, actual);
        //shouldThrowWithInvalidId()   assertThrows(NoSuchElementException.class, () -> testService.getProduct("Invalid"));
    }

    @Test

    void shouldReturnListOfProducts(){
        //GIVEN
        ShopService testShop = new ShopService(new ProductRepo(), new OrderRepo());
        //WHEN
        List<Product> testList = testShop.listProducts();
        //THEN
        assertEquals(3, testList.size());
    }

    @Test

    void shouldAddOrder(){
        //GIVEN
        ProductRepo testProductRepo = new ProductRepo();
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService testShop = new ShopService(testProductRepo, testOrderRepo);
        List <Product> testList = testProductRepo.list();
        Order testOrder = new Order(testProductRepo.getProduct(testList.get(0).getProductId()));
        testShop.addOrder(testOrder);
        //WHEN
        int actual = testShop.listOrders().size();
        int expected = 1;
        //THEN
        assertEquals(expected, actual);
    }

    @Test

    void shouldReturnOrder(){
        //GIVEN
        ProductRepo testProductRepo = new ProductRepo();
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService testShop = new ShopService(testProductRepo, testOrderRepo);
        List<Product> testProductsList = testShop.listProducts();
        Order testOrder = new Order(testProductRepo.getProduct(testProductsList.get(0).getProductId()));
        testShop.addOrder(testOrder);
        List<Order> testOrderList = testShop.listOrders();
        //WHEN
        String expected = testOrder.getOrderId();
        String actual = testOrderList.get(0).getOrderId();
        //THEN
        assertEquals(expected, actual);
    }
}
