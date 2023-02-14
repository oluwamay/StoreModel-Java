package StoreXmodel.Services.Interfaces;

import StoreXmodel.Users.Customer;

public interface CashierService {
    void sellProduct(Customer customer);
    void dispenseReceipt(Customer customer);
    void deposit(Customer customer, double deposit);
}
