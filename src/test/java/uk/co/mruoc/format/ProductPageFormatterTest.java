package uk.co.mruoc.format;

import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.model.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPageFormatterTest {

    private static final String TITLE = "TITLE";
    private static final double SIZE = 12.333;

    private ProductPageJsonFormatter productPageJsonFormatter = new ProductPageJsonFormatter();

    @Test
    public void shouldReturnTitleInJson() {
        ProductPage productPage = new ProductPageBuilder().setTitle(TITLE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("title")).isEqualTo(TITLE);
    }

    @Test
    public void shouldReturnSizeInJson() {
        ProductPage productPage = new ProductPageBuilder().setSize(SIZE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("size")).isEqualTo("12.33kb");
    }

}
