package uk.co.mruoc.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPageTest {

    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final double UNIT_PRICE = 9.99;
    private static final double SIZE = 33;

    private final ProductPage productPage = new ProductPageBuilder()
            .setTitle(TITLE)
            .setDescription(DESCRIPTION)
            .setUnitPrice(UNIT_PRICE)
            .setSize(SIZE)
            .build();

    @Test
    public void shouldReturnValues() {
        assertThat(productPage.getTitle()).isEqualTo(TITLE);
        assertThat(productPage.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(productPage.getUnitPrice()).isEqualTo(UNIT_PRICE);
        assertThat(productPage.getSize()).isEqualTo(SIZE);
    }

}
