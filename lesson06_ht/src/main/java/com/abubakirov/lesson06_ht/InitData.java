package com.abubakirov.lesson06_ht;

import com.abubakirov.lesson06_ht.domain.Product;

public class InitData {


    private static final Product PRODUCT_1 = new Product();
    private static final Product PRODUCT_2 = new Product();
    private static final Product PRODUCT_3 = new Product();
    private static final Product PRODUCT_4 = new Product();
    private static final Product PRODUCT_5 = new Product();
    private static final Product[] PRODUCTS = new Product[] {
            PRODUCT_1,
            PRODUCT_2,
            PRODUCT_3,
            PRODUCT_4,
            PRODUCT_5
    };

    static {
        PRODUCT_1.setTitle("Meat");
        PRODUCT_1.setPrice(100.0);

        PRODUCT_2.setTitle("Milk");
        PRODUCT_2.setPrice(50.0);

        PRODUCT_3.setTitle("Bread");
        PRODUCT_3.setPrice(35.0);

        PRODUCT_4.setTitle("Chocolate");
        PRODUCT_4.setPrice(80.0);

        PRODUCT_5.setTitle("Cookies");
        PRODUCT_5.setPrice(150.0);
    }

    public static Product getProduct1() {
        return PRODUCT_1;
    }

    public static Product getProduct2() {
        return PRODUCT_2;
    }

    public static Product getProduct3() {
        return PRODUCT_3;
    }

    public static Product getProduct4() {
        return PRODUCT_4;
    }

    public static Product getProduct5() {
        return PRODUCT_5;
    }

    public static Product[] getProducts() {
        return PRODUCTS;
    }
}
