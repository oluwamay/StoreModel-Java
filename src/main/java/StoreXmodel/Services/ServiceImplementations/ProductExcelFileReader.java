package StoreXmodel.Services.ServiceImplementations;

import StoreXmodel.Product;
import StoreXmodel.Store;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ProductExcelFileReader {
        private Store store;

        public ProductExcelFileReader(Store store){
            this.store = store;
        }

        public void readProductData(String filePath) {
            FileInputStream productData = null;
            try {
                //pass the product data file into the file input stream
                productData = new FileInputStream(filePath);

                //Create a workbook and sheet object
                XSSFWorkbook workbook = new XSSFWorkbook(productData);
                XSSFSheet sheet1 = workbook.getSheetAt(0);

                //Get the number of rows and columns in the Excel sheet
                int rowNum = sheet1.getLastRowNum();

                for (int row = 1; row <= rowNum; row++) {

                    String prdName = sheet1.getRow(row).getCell(0).getStringCellValue();
                    String prdCategory = sheet1.getRow(row).getCell(1).getStringCellValue();
                    double prdPrice = sheet1.getRow(row).getCell(2).getNumericCellValue();
                    int prdUnit = (int) sheet1.getRow(row).getCell(3).getNumericCellValue();

                    Product product = new Product(prdName, prdCategory, prdPrice, prdUnit);

                    //A method in the store class that adds a product to the store
                    store.setProductsInStock(product);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try{
                    productData.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
        }


    }
