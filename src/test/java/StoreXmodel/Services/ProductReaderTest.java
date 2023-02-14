package StoreXmodel.Services;

import StoreXmodel.Services.ServiceImplementations.ProductExcelFileReader;
import StoreXmodel.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductReaderTest {

    @Test
    @DisplayName("Check if the excel file data is read by the file reader method")
    void readProductData() {
        Store store = new Store("StoreX");
        ProductExcelFileReader PR =new ProductExcelFileReader(store);
        //Has the wrong file path
        String prdData = "/Users/decagon/IdeaProjects/StoreXmodel/src/main/resources/ProductsData/prodData.xlsx";
        //Has correct file path
        String product = "/Users/decagon/IdeaProjects/StoreXmodel/src/main/resources/ProductsData/product.xlsx";
        PR.readProductData(product);

        assertEquals(19, store.getProductsInStock().size());

        assertThrows(NullPointerException.class, () -> {PR.readProductData(prdData);});
    }
}