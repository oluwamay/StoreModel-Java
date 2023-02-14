package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Services.Interfaces.CashierService;
import StoreXmodel.Services.Interfaces.Deposit;
import StoreXmodel.Users.Cashier;
import StoreXmodel.Users.Customer;

public class CashierServiceImpl implements Deposit, CashierService {
     private Cashier cashier;

      public CashierServiceImpl(Cashier cashier){
         this.cashier =cashier;
     }

     @Override
    public void sellProduct(Customer customer){
          cashier.sellProduct(customer);
    }
    @Override
    public void dispenseReceipt(Customer customer){
          cashier.dispenseReceipt(customer);
    }
    @Override
    public void deposit(Customer customer, double deposit){
          cashier.deposit(customer, deposit);
    }

}
