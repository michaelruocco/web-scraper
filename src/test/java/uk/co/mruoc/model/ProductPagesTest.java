package uk.co.mruoc.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPagesTest {

    private final ProductPages productPages = new ProductPages();

    @Test
    public void shouldReturnResults() {
        ProductPage productPage1 = createResult();
        ProductPage productPage2 = createResult();

        productPages.add(productPage1);
        productPages.add(productPage2);
        List<ProductPage> productPageList = productPages.toList();

        assertThat(productPageList.size()).isEqualTo(2);
        assertThat(productPageList.contains(productPage1)).isTrue();
        assertThat(productPageList.contains(productPage2)).isTrue();
    }

    @Test
    public void shouldCalculateTotal() {
        productPages.add(createResultWithPrice(10.50));
        productPages.add(createResultWithPrice(5));

        assertThat(productPages.getTotal()).isEqualTo(15.50);
    }

    private ProductPage createResult() {
        return new ProductPageBuilder().build();
    }

    private ProductPage createResultWithPrice(double unitPrice) {
        return new ProductPageBuilder().setUnitPrice(unitPrice).build();
    }

}
