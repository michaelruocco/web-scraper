package uk.co.mruoc.format;

import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.model.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPageFormatterTest {

    private static final String TITLE = "TITLE";
    private static final double SIZE = 12.333;
    private static final double UNIT_PRICE = 4.444;
    private static final String DESCRIPTION = "DESCRIPTION";

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

    @Test
    public void shouldReturnUnitPriceInJson() {
        ProductPage productPage = new ProductPageBuilder().setUnitPrice(UNIT_PRICE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("unit_price")).isEqualTo("4.44");
    }

    @Test
    public void shouldReturnDescriptionInJson() {
        ProductPage productPage = new ProductPageBuilder().setDescription(DESCRIPTION).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("description")).isEqualTo(DESCRIPTION);
    }

}
