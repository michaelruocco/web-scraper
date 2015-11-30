package uk.co.mruoc.format;

import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.model.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPageFormatterTest {

    private static final String TITLE = "TITLE";

    private ProductPageJsonFormatter productPageJsonFormatter = new ProductPageJsonFormatter();

    @Test
    public void shouldReturnTotalInJson() {
        ProductPage productPage = new ProductPageBuilder().setTitle(TITLE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("title")).isEqualTo(TITLE);
    }

}
