package StoreXmodel.Users;

import StoreXmodel.Product;
import StoreXmodel.Services.Interfaces.Deposit;
import StoreXmodel.Store;

import java.util.ArrayList;

public class Customer extends User implements Deposit {

    private double balance = 0;
    public String name;
    private ArrayList<Product> ProductsList;

    private Store store;
    private double customerAmount = 0;


        public Customer(String name, int userId, Store store){
            super(name, userId);
            this.store = store;
            this.ProductsList = new ArrayList<>();
            System.out.println("Welcome "+name+" we are at your service");
        }
        @Override
        public void deposit(Customer customer, double deposit){
            //Customer deposits funds that will be used to make purchase into a wallet
            this.setBalance(deposit);
            System.out.println("Wallet deposit successfull, Your balance is: " + this.getBalance());
        }

        public void buyProduct(Product product, int quantity){
            //stores the list of product purchased by customer
            Product newProduct = new Product(product.getProductName(), product.getCategory(), product.getPrice(), quantity);
            int numProducts = store.getProductsInStock().size();

            for(int i = 0; i < numProducts; i++){
                //Check if number of units of selected product is available
                if(store.getProductsInStock().get(i).getProductName().equals(newProduct.getProductName())) {
                    if (store.getProductsInStock().get(i).getUnit() == 0) {
                        System.out.println(String.format("%s OUT OF STOCK", newProduct.getProductName()));
                    } else if (store.getProductsInStock().get(i).getUnit() < newProduct.getUnit()) {
                        System.out.println("Sorry we only have " + store.getProductsInStock().get(i).getUnit() + " units of " + store.getProductsInStock().get(i).getProductName() + " in stock");

                    } else {
                        ProductsList.add(newProduct);
                        //deducts the number of unit bought by the customer from stock
                        store.getProductsInStock().get(i).updateUnit(newProduct.getUnit());

                    }
                }
            }
        }

        public void setBalance(double amount) {
            this.balance += amount;
        }
        public void setBalanceAfterPurchase(double amount){
            this.balance -= amount;
        }
        public ArrayList<Product> getProductList(){
            //prints the list of products purchased by customer
            return ProductsList;
        }

        public void setCustomerAmount(double amount){
            this.customerAmount += amount;
        }
        public double getCustomerAmount(){
            return customerAmount;
        }

        public double getBalance() {return balance;}

}
