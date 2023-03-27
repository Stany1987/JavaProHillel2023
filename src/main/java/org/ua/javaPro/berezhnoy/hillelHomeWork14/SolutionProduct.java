package org.ua.javaPro.berezhnoy.hillelHomeWork14;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolutionProduct {
    //Без лямбд {{
    public static List<Product> getAllCategoryBookAndPriceHigher(List<Product> products, String category, double price) {

        return products.stream()
                .filter(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.category().equals(category) && product.price() > price;
                    }
                })
                .toList();
    }

    public static List<Product> getAllCategoryBookWithDiscount(List<Product> products, String category, boolean discount) {
        return products.stream()
                .filter(new Predicate<Product>() {
                    @Override
                    public boolean test(Product product) {
                        return product.category().equals(category) && product.discount() == discount;
                    }
                })
                .map(new Function<Product, Product>() {

                    public Product apply(Product product) {
                        double discountPrice = product.price() - (product.price() * (10.0 / 100.0));
                        BigDecimal formatDiscountPrice = new BigDecimal(discountPrice);
                        formatDiscountPrice = formatDiscountPrice.setScale(2, RoundingMode.DOWN);
                        return new Product(product.category(), formatDiscountPrice.doubleValue(), true,
                                product.date());
                    }

                })
                .toList();
    }

    //    }}
    public static Product getBookMostCheapest(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.category().equals(category))
                .sorted(Comparator.comparing(Product::price))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found this product"));
    }

    public static List<Product> lastThreeProductsAdded(List<Product> products) {
        return products.stream()
                .sorted((o1, o2) -> o2.date().compareTo(o1.date()))
                .limit(3)
                .toList();
    }

    public static double totalCostOfProducts(List<Product> products, double price) {
        return products.stream()
                .filter(product -> product.date().getYear() == LocalDate.now().getYear())
                .filter(product -> product.category().equals("Book"))
                .filter(product -> product.price() <= price)
                .mapToDouble(Product::price)
                .sum();
    }

    public static Map<String, List<Product>> objectGrouping(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy((new Function<Product, String>() {
                    @Override
                    public String apply(Product product) {
                        return product.category();
                    }
                })));
    }


}
