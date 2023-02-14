package StoreXmodel;

public class Product {


    private String productName;
    private String category;
    private double price;
    private int unit;

   public Product(String productName, String category, double price, int unit){
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public String getProductName() {
        return productName;
    }
    public int getUnit() {
       return unit;
    }
    public String getCategory(){return  category;}

    public void updateUnit(int unit) {
        this.unit -= unit;
    }

    @Override
    public String toString(){
       return String.format("Product name: %s%nProduct Category: %s%nPrice: %.2f%nUnits: %d",productName, category, price, unit);
    }
}
