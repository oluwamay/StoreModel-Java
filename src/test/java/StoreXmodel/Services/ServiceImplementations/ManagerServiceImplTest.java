package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Services.Interfaces.ManagerService;
import StoreXmodel.Store;
import StoreXmodel.Users.Applicant;
import StoreXmodel.Users.Cashier;
import StoreXmodel.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {
    Store store;
    Manager manager;
    Applicant applicant1;
    Applicant applicant2;
    ManagerService MN;
    Cashier cashier1;
    Cashier cashier2;
    @BeforeEach
    void setUp(){
        store = new Store("StoreX");
        manager = new Manager("Debby", 130, store);
        MN = new ManagerServiceImpl(manager);
        applicant1 = new Applicant("Great", 11, true, 24 );
        applicant2 = new Applicant("Simbi", 12, true, 20);

        cashier1 = new Cashier(applicant1.getName(), applicant1.getUserID(), 5000, store);
        cashier2 = new Cashier(applicant2.getName(), applicant2.getUserID(), 5000, store);
    }

    @Test
    @DisplayName("Check if qualified applicant is hired")
    void hireCashier() {
        MN.hireCashier(applicant1);
        MN.hireCashier(applicant2);

        assertTrue(applicant1.getStatus());
        assertTrue(applicant2.getStatus());
    }

    @Test
    @DisplayName("Check if hired applicant has been made a cashier")
    void addToCashierList() {

        MN.addToCashierList(cashier1);
        MN.addToCashierList(cashier2);

        assertEquals(2, manager.getStore().getCashiersList().size());
    }


    @Test
    @DisplayName("Check if cashier wages are paid")
    void payWage() {
        manager.getStore().setStoreBalance(40000);
       MN.addToCashierList(cashier2);
       MN.addToCashierList(cashier1);

       MN.payWage(cashier1);
       MN.payWage(cashier2);

       assertEquals(30000, manager.getStore().getStoreBalance());
    }
}