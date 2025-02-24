import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductStreamProcessing {
    public static void main(String[] args) {
        
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.0));
        products.add(new Product("Phone", "Electronics", 800.0));
        products.add(new Product("Table", "Furniture", 150.0));
        products.add(new Product("Chair", "Furniture", 85.0));
        products.add(new Product("Headphones", "Electronics", 250.0));
        products.add(new Product("Sofa", "Furniture", 700.0));
        products.add(new Product("T-shirt", "Clothing", 25.0));
        products.add(new Product("Jeans", "Clothing", 45.0));

        System.out.println("Grouping products by category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveProductInCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, 
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        mostExpensiveProductInCategory.forEach((category, productOptional) -> {
            productOptional.ifPresent(product -> 
                System.out.println(category + ": " + product));
        });

        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
