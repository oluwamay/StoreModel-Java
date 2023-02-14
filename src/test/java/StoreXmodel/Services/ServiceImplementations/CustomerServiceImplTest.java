package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Services.Interfaces.CustomerService;
import StoreXmodel.Services.Interfaces.ManagerService;
import StoreXmodel.Store;
import StoreXmodel.Users.Customer;
import StoreXmodel.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    Store store;
    Manager manager;
    ManagerService MN;
    Customer customer;
    CustomerService CS;


    @BeforeEach
            void setUp (){
        store = new Store("storeX");
        ProductExcelFileReader PR = new ProductExcelFileReader(store);
        PR.readProductData("/Users/decagon/IdeaProjects/StoreXmodel/src/main/resources/ProductsData/product.xlsx");
        manager = new Manager("Esther", 121, store);
        MN = new ManagerServiceImpl(manager);
        customer = new Customer("Yaga", 111, store);
        CS = new CustomerServiceImpl(customer);

    }
    @Test
    @DisplayName("Check if customer deposit is added to wallet balance")
    void deposit() {
        CS.deposit(customer, 45000);
        assertEquals(45000, customer.getBalance());
    }

    @Test
    @DisplayName("Check if product bought is added to cart")
    void buyProduct() {
        CS.deposit(customer, 145000);
        CS.buyProduct(store.getProductsInStock().get(6), 5);
        CS.buyProduct(store.getProductsInStock().get(10), 15);

        assertEquals(2, customer.getProductList().size());
    }
}