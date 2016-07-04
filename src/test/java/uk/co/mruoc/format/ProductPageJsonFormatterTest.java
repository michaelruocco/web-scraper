package uk.co.mruoc.format;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.model.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class ProductPageJsonFormatterTest {

    private static final String TITLE = "TITLE";

    private static final double SIZE_IN_BYTES = 2560;
    private static final double UNIT_PRICE = 4.444;
    private static final String DESCRIPTION = "DESCRIPTION";

    private ProductPageJsonFormatter productPageJsonFormatter = new ProductPageJsonFormatter();

    @Test
    public void shouldReturnTitleInJson() throws JSONException {
        ProductPage productPage = new ProductPageBuilder().setTitle(TITLE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("title")).isEqualTo(TITLE);
    }

    @Test
    public void shouldReturnSizeInJson() throws JSONException {
        ProductPage productPage = new ProductPageBuilder().setSize(SIZE_IN_BYTES).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("size")).isEqualTo("2.5kb");
    }

    @Test
    public void shouldReturnUnitPriceInJson() throws JSONException {
        ProductPage productPage = new ProductPageBuilder().setUnitPrice(UNIT_PRICE).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("unit_price")).isEqualTo("4.44");
    }

    @Test
    public void shouldReturnDescriptionInJson() throws JSONException {
        ProductPage productPage = new ProductPageBuilder().setDescription(DESCRIPTION).build();
        JSONObject json = productPageJsonFormatter.toJson(productPage);
        assertThat(json.getString("description")).isEqualTo(DESCRIPTION);
    }

}
