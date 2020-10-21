package com.company;

    import java.io.IOException; import java.nio.file.Files; import java.nio.file.Paths; import java.time.LocalDate; import java.util.ArrayList; import java.util.List;
    public class ProductManager {
        private ArrayList<Product> products;
        public ProductManager() { products = new ArrayList<>();
        }
        public void toScreen() { System.out.println("Products: ["); for (Product product : products) {
            System.out.println(product); }
            System.out.println("]");
        }
        public ArrayList<Product> findByName(String name) {
            ArrayList<Product> productsByName = new ArrayList<>();
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    productsByName.add(product); }
            }
            return productsByName;
        }

        public ArrayList<Product> findByNameAndPrice(String name, Double price) { ArrayList<Product> productsByNameAndPrice = new ArrayList<>();
            for (Product product : products) {
                if (product.getName().equals(name) && product.getPrice() <=
                        price) {
                    productsByNameAndPrice.add(product); }
            }
            return productsByNameAndPrice;
        }
        public ArrayList<Product> findByExpiryDate(LocalDate localDate) { ArrayList<Product> productsByExpiryDate = new ArrayList<>();
            for (Product product : products) {
                if (product.getExpiryDay().isBefore(LocalDate.now())) {
                    productsByExpiryDate.add(product); }
            }
            return productsByExpiryDate;
        }
        public void readFromFile(String fileName) { try {
            List<String> productsStrings = Files.readAllLines(Paths.get(fileName));
            this.products = new ArrayList<>();
            for (String productsString : productsStrings) {
                String[] data = productsString.split("@"); Product product = new Product();
                product.setId(Integer.valueOf(data[0])); product.setName(data[1]); product.setUpc(data[2]); product.setProducer(data[3]); product.setPrice(Double.valueOf(data[4])); product.setExpiryDay(LocalDate.parse(data[5])); product.setAmount(Integer.valueOf(data[6]));
                products.add(product); }
        } catch (IOException e) { e.printStackTrace();
        }
        }
}
