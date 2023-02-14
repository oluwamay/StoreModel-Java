package StoreXmodel;

import StoreXmodel.Services.Interfaces.CashierService;
import StoreXmodel.Services.Interfaces.CustomerService;
import StoreXmodel.Services.Interfaces.ManagerService;
import StoreXmodel.Services.ServiceImplementations.CashierServiceImpl;
import StoreXmodel.Services.ServiceImplementations.CustomerServiceImpl;
import StoreXmodel.Services.ServiceImplementations.ManagerServiceImpl;
import StoreXmodel.Services.ServiceImplementations.ProductExcelFileReader;
import StoreXmodel.Users.Applicant;
import StoreXmodel.Users.Cashier;
import StoreXmodel.Users.Customer;
import StoreXmodel.Users.Manager;

public class Main {
    public static void main(String[] args) {
            //Instantiate store object, Filereader, manager etc
            Store store = new Store("X");
            ProductExcelFileReader PR = new ProductExcelFileReader(store);
            PR.readProductData("/Users/decagon/IdeaProjects/StoreXmodel/src/main/resources/ProductsData/product.xlsx");

            Manager manager = new Manager("Jane", 121, store);
            ManagerService MS = new ManagerServiceImpl(manager);

            Applicant applicant1 = new Applicant("Dayo", 111, true, 23);
            Applicant applicant2 = new Applicant("Sharon", 112, true, 24);
            Applicant applicant3 = new Applicant("Sharon", 112, false, 24);

            MS.hireCashier(applicant1);
            MS.hireCashier(applicant2);
            MS.hireCashier(applicant3);

            Cashier cashier1 = new Cashier(applicant1.getName(), applicant1.getUserID(), 40000, store);
            Cashier cashier2 = new Cashier(applicant2.getName(), applicant2.getUserID(), 40000, store);

            MS.addToCashierList(cashier1);
            MS.addToCashierList(cashier2);

            CashierService cashierS1 = new CashierServiceImpl(cashier1);
            CashierService cashierS2 = new CashierServiceImpl(cashier2);



            Customer customer1 = new Customer("Great", 1211, store);
            CustomerService CS1 = new CustomerServiceImpl(customer1);
            Customer customer2 = new Customer("Gift", 2211, store);
            CustomerService CS2 = new CustomerServiceImpl(customer2);
            Customer customer3 = new Customer("Tems", 3211, store);
            CustomerService CS3 = new CustomerServiceImpl(customer3);



            CS1.deposit(customer1, 176000);
            CS1.buyProduct(store.getProductsInStock().get(3), 50);
            CS1.buyProduct(store.getProductsInStock().get(4), 38);

            cashierS1.sellProduct(customer1);
            cashierS1.deposit(customer1, customer1.getCustomerAmount());

            CS2.deposit(customer2, 276000);
            CS2.buyProduct(store.getProductsInStock().get(3), 50);
            CS2.buyProduct(store.getProductsInStock().get(7), 47);


            cashierS1.sellProduct(customer2);
            cashierS1.deposit(customer2, customer2.getCustomerAmount());

            CS3.deposit(customer3, 323900);
            CS3.buyProduct(store.getProductsInStock().get(3), 7);
            CS3.buyProduct(store.getProductsInStock().get(7), 77);

            cashierS2.sellProduct(customer3);

            MS.fireCashier(cashier1);
            MS.fireCashier(cashier2);

            MS.payWage(cashier1);

    }

}
