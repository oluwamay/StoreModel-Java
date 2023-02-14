package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Services.Interfaces.CashierService;
import StoreXmodel.Services.Interfaces.CustomerService;
import StoreXmodel.Services.Interfaces.ManagerService;
import StoreXmodel.Store;
import StoreXmodel.Users.Cashier;
import StoreXmodel.Users.Customer;
import StoreXmodel.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplTest {
    Store store;
    Manager manager;
    ManagerService MN;
    ProductExcelFileReader PR;
    Cashier cash1;
    CashierService cashS1;
    Customer customer;
    CustomerService CS;

    @BeforeEach
     void setUp(){
        store = new Store("storeX");
        manager = new Manager("Shegs", 111, store);
        MN = new ManagerServiceImpl(manager);
        PR = new ProductExcelFileReader(store);
        PR.readProductData("/Users/decagon/IdeaProjects/StoreXmodel/src/main/resources/ProductsData/product.xlsx");

        cash1 = new Cashier("Rose", 10, 30000, store);
        cashS1 = new CashierServiceImpl(cash1);

        customer = new Customer("Monroe", 1, store);
        CS = new CustomerServiceImpl(customer);

        CS.deposit(customer, 500000);
        CS.buyProduct(store.getProductsInStock().get(4), 4);

    }
    @Test
    @DisplayName("Check customer cart is properly checked out")
    void sellProduct() {
        cashS1.sellProduct(customer);
        //Amount of goods bought by the customer is 2000
        assertEquals(2000, customer.getCustomerAmount());
    }

    @Test
    @DisplayName("check if store balance is updated with customer's payment")
    void deposit() {
        cashS1.sellProduct(customer);
        cashS1.deposit(customer, customer.getCustomerAmount());

        assertNotEquals(0, store.getStoreBalance());
    }
}