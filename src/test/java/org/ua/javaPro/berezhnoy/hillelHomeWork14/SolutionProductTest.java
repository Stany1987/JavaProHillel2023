package org.ua.javaPro.berezhnoy.hillelHomeWork14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionProductTest {
    List<Product> listProduct;

    @BeforeEach
    public void setup() {

        listProduct = new ArrayList<>();
        listProduct.add(new Product("Book", 250.10, true, LocalDate.parse("2023-02-11")));
        listProduct.add(new Product("Book", 100.70, false, LocalDate.parse("2023-02-17")));
        listProduct.add(new Product("Book", 17, true, LocalDate.parse("2023-01-11")));
        listProduct.add(new Product("Toy", 1200, true, LocalDate.parse("2023-01-17")));
        listProduct.add(new Product("Book", 300.70, false, LocalDate.parse("2023-03-11")));
        listProduct.add(new Product("Toy", 800.60, false, LocalDate.parse("2023-03-11")));
        listProduct.add(new Product("Book", 55, true, LocalDate.parse("2023-03-15")));
        listProduct.add(new Product("Book", 57, false, LocalDate.parse("2022-03-15")));
    }

    @Test
    void testGetAllCategoryBookAndPriceHigher() {
        List<Product> exp = new ArrayList<>();
        exp.add(new Product("Book", 250.10, true, LocalDate.parse("2023-02-11")));
        exp.add(new Product("Book", 300.70, false, LocalDate.parse("2023-03-11")));
        List<Product> act = SolutionProduct.getAllCategoryBookAndPriceHigher(listProduct, "Book", 250);
        assertEquals(exp, act);
    }

    @Test
    void testGetAllCategoryBookWithDiscount() {
        List<Product> exp = new ArrayList<>();
        exp.add(new Product("Book", 225.09, true, LocalDate.parse("2023-02-11")));
        exp.add(new Product("Book", 15.3, true, LocalDate.parse("2023-01-11")));
        exp.add(new Product("Book", 49.5, true, LocalDate.parse("2023-03-15")));
        List<Product> act = SolutionProduct.getAllCategoryBookWithDiscount(listProduct, "Book", true);
        assertEquals(exp, act);
    }

    @Test
    void testGetBookMostCheapest() {
        assertEquals(new Product("Book", 17, true, LocalDate.parse("2023-01-11")),
                SolutionProduct.getBookMostCheapest(listProduct, "Book"));
    }

    @Test
    void testExceptionGetBookMostCheapest() {
        Throwable exception = assertThrows(RuntimeException.class, () -> SolutionProduct.getBookMostCheapest(listProduct,
                "Exception"));
        assertTrue(exception.getMessage().contains("Not found this product"));
    }

    @Test
    void testLastThreeProductsAdded() {
        List<Product> exp = new ArrayList<>();
        exp.add(new Product("Book", 55, true, LocalDate.parse("2023-03-15")));
        exp.add(new Product("Book", 300.70, false, LocalDate.parse("2023-03-11")));
        exp.add(new Product("Toy", 800.60, false, LocalDate.parse("2023-03-11")));
        List<Product> act = SolutionProduct.lastThreeProductsAdded(listProduct);
        assertEquals(exp, act);
    }

    @Test
    void testTotalCostOfProducts() {
        assertEquals(SolutionProduct.totalCostOfProducts(listProduct,"Book", 75), 72);
    }

    @Test
    void testobjectGrouping() {
        Map<String, List<Product>> groupedProduct = SolutionProduct.groupByCategory(listProduct);
        assertEquals(6, groupedProduct.get("Book").size());
        assertEquals(2, groupedProduct.get("Toy").size());

    }

}