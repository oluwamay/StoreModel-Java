package StoreXmodel.Users;

import StoreXmodel.Product;
import StoreXmodel.Services.Interfaces.Deposit;
import StoreXmodel.Store;



public class Cashier extends User implements Deposit {
    private int sales = 0;
    private double salary ;
    private double wageBalance = 0;
    private boolean sell;
    Store store;


    public Cashier(String name, int userId, double salary, Store store){
        super(name, userId);
        this.salary = salary;
        this.store = store;

    }

     public void setWageBalance(double wage){
        this.wageBalance += wage;
    }
    public double getSalary(){
        return salary;
    }
    public int getSales(){
        return sales;
    }

    public Store getStore() {
        return store;
    }

    public void sellProduct(Customer customer){
        //Cashier validates customer payment
        //customer pays for products purchased
            for (Product product : customer.getProductList()) {
                customer.setCustomerAmount(product.getPrice() * product.getUnit());
            }
        if(customer.getBalance() < customer.getCustomerAmount()){
            System.out.println("\nYou have insufficient funds to make this purchase.");
            sell = false;
        }else if(customer.getProductList().size() == 0){
            System.out.println();
        }
        else{
            customer.setBalanceAfterPurchase(customer.getCustomerAmount());
            sell = true;
            this.dispenseReceipt(customer);
        }

    }

    public void dispenseReceipt(Customer customer){
        System.out.println("\nRECEIPT__________________________________________");
        System.out.println("Customer name: "+ customer.getName()+"\nCashier ID: "+ getUserID()
                +"\n__________________________________________");
        for(Product product : customer.getProductList()) {
            System.out.println(String.format("Product: %s%nUnit: %d%nCost: %.2f%n",  product.getProductName(), product.getUnit(), product.getPrice()* product.getUnit()));
        }
        System.out.println("__________________________________________");
        System.out.println(String.format("Total cost: %.2f",customer.getCustomerAmount()));
        System.out.println(String.format("Your wallet balance is: %.2f%n", customer.getBalance()));
    }

    @Override
    public void deposit(Customer customer, double deposit) {
        //Cashier deposits sales amount in store balance
        store.setStoreBalance(customer.getCustomerAmount());
        System.out.println(String.format("Deposit successful store balance is: %.2f", store.getStoreBalance()));
        //increase the daily sales count
        sales++;
        if(sales == 1){
            System.out.println("Great job! "+getName()+" you have made "+sales+" sale today.");
        }else {
            System.out.println("Great job! " + getName() + " you have made " + sales + " sales today.");
        }
    }
    @Override
    public String toString(){
        return "Cashier: "+ getName() +" ID: "+ getUserID()+" Wage: "+ getSalary();
    }
    public boolean getSell(){
        return sell;
    }

}
