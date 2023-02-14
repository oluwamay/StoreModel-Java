package StoreXmodel;

import StoreXmodel.Users.Cashier;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private double StoreBalance = 0;
    private String name;
    private List<Product> productsInStock;

    private List<Cashier> cashiersList;

    public Store(String name) {
        this.name = name;
         this.cashiersList = new ArrayList<>();
         this.productsInStock =new ArrayList<>();
        System.out.println(name + " is OPEN !");
    }

    public double getStoreBalance() {
        return StoreBalance;
    }

    public void setStoreBalance(double storeBalance) {
        this.StoreBalance += storeBalance;
    }

    public void setStoreBalanceAfterWagePayment(double amount) {
        //deducts Cashier's wage from StoreXmodel.Services.Users.Store balance
        this.StoreBalance -= amount;
    }

    public List<Cashier> getCashiersList() {
        return cashiersList;
    }

    public List<Product> getProductsInStock() {
        return productsInStock;
    }

    public void setProductsInStock(Product product) {
        this.productsInStock.add(product);
    }

    public void setCashiersList(Cashier cashiersList) {
        this.cashiersList.add(cashiersList);
    }

    public String getName() {
        return name;
    }

}
