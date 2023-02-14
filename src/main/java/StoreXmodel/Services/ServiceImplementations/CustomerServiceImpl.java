package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Product;
import StoreXmodel.Services.Interfaces.CustomerService;
import StoreXmodel.Users.Customer;

public class CustomerServiceImpl implements CustomerService {
    private Customer customer;

    public CustomerServiceImpl(Customer customer){
        this.customer = customer;
    }

    @Override
    public void deposit(Customer customer, double deposit){
        customer.deposit(customer, deposit);
    }
    @Override
    public void buyProduct(Product product, int quantity){
        customer.buyProduct(product, quantity);
    }
}
