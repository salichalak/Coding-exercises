package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!line.equals("Revision")) {
            String[] tokens = line.split(", ");
            String shopName = tokens[0];
            String productName = tokens[1];
            Double productPrice = Double.parseDouble(tokens[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();
            if (shops.containsKey(shopName)) {
                products = shops.get(shopName);
            }

            products.put(productName, productPrice);
            shops.put(shopName, products);

            line = scanner.nextLine();
        }

        for (String shop : shops.keySet()) {
            System.out.println(shop + "->");
            LinkedHashMap<String, Double> products = shops.get(shop);

            for (String product : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, products.get(product));
            }
        }
    }
}