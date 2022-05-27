import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopServiceTest {
    @Test

    void shouldReturnProduct(){
        ShopService testShop = new ShopService(new ProductRepo(), new OrderRepo());
        List<Product> testList = testShop.listProducts();
        //when
        Product expected = testList.get(2);
        Product actual = testShop.getProduct(expected.getProductId());
        //then
        assertEquals(expected, actual);
    }

    @Test

    void shouldReturnListOfProducts(){
        ShopService testShop = new ShopService(new ProductRepo(), new OrderRepo());
        //when
        List<Product> testList = testShop.listProducts();
        //then
        assertEquals(3, testList.size());
    }

    @Test

    void shouldAddOrder(){
        ProductRepo testProductRepo = new ProductRepo();
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService testShop = new ShopService(testProductRepo, testOrderRepo);
        List <Product> testList = testProductRepo.list();
        Order testOrder = new Order(testProductRepo.getProduct(testList.get(0).getProductId()));
        testShop.addOrder(testOrder);
        //when
        int actual = testShop.listOrders().size();
        int expected = 1;
        //then
        assertEquals(expected, actual);
    }

    @Test

    void shouldReturnOrder(){
        ProductRepo testProductRepo = new ProductRepo();
        OrderRepo testOrderRepo = new OrderRepo();
        ShopService testShop = new ShopService(testProductRepo, testOrderRepo);
        List<Product> testProductsList = testShop.listProducts();
        Order testOrder = new Order(testProductRepo.getProduct(testProductsList.get(0).getProductId()));
        testShop.addOrder(testOrder);
        List<Order> testOrderList = testShop.listOrders();
        //when
        String expected = testOrder.getOrderId();
        String actual = testOrderList.get(0).getOrderId();
        //then
        assertEquals(expected, actual);
    }
}
