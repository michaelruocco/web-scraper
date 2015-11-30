package uk.co.mruoc.model;

import java.util.ArrayList;
import java.util.List;

public class ProductPages {

    private List<ProductPage> productPages = new ArrayList<>();

    public void add(ProductPage productPage) {
        productPages.add(productPage);
    }

    public List<ProductPage> toList() {
        return productPages;
    }

    public double getTotal() {
        double total = 0;
        for(ProductPage productPage : productPages)
            total += productPage.getUnitPrice();
        return total;
    }

}
