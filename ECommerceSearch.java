<<<<<<< HEAD
import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {
        for (Product product : products) {
            if (product.productId == id) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mobile", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Headphones", "Electronics")
        };

        int searchId = 104;

        // Linear Search
        Product result1 = linearSearch(products, searchId);

        if (result1 != null) {
            System.out.println("Linear Search Result:");
            System.out.println(result1.productId + " "
                    + result1.productName + " "
                    + result1.category);
        } else {
            System.out.println("Product not found");
        }

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        Product result2 = binarySearch(products, searchId);

        if (result2 != null) {
            System.out.println("\nBinary Search Result:");
            System.out.println(result2.productId + " "
                    + result2.productName + " "
                    + result2.category);
        } else {
            System.out.println("Product not found");
        }
    }
=======
import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {
        for (Product product : products) {
            if (product.productId == id) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mobile", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Headphones", "Electronics")
        };

        int searchId = 104;

        // Linear Search
        Product result1 = linearSearch(products, searchId);

        if (result1 != null) {
            System.out.println("Linear Search Result:");
            System.out.println(result1.productId + " "
                    + result1.productName + " "
                    + result1.category);
        } else {
            System.out.println("Product not found");
        }

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        Product result2 = binarySearch(products, searchId);

        if (result2 != null) {
            System.out.println("\nBinary Search Result:");
            System.out.println(result2.productId + " "
                    + result2.productName + " "
                    + result2.category);
        } else {
            System.out.println("Product not found");
        }
    }
>>>>>>> 07bf603f52ca267bbc8fcd875de0a2201b47b17f
}