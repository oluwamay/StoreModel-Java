package StoreXmodel.Services.Interfaces;

import StoreXmodel.Product;
import StoreXmodel.Users.Customer;

public interface CustomerService {
    void deposit(Customer customer, double deposit);
    void buyProduct(Product product, int quantity);
}
