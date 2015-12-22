package uk.co.mruoc.format;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.model.ProductPage;
import uk.co.mruoc.model.ProductPages;

import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPagesJsonFormatterTest {

    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final double UNIT_PRICE = 3.33;
    private static final double SIZE = 99.99;

    private ProductPages productPages = new ProductPages();

    private ProductPagesJsonFormatter formatter = new ProductPagesJsonFormatter(productPages);

    @Test
    public void shouldReturnEmptyResultsArrayIfNoProductPagesAdded() throws JSONException {
        JSONObject results = formatter.toJson();
        JSONArray resultsArray = results.getJSONArray("results");
        assertThat(resultsArray.length()).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroTotalIfNoProductPagesAdded() throws JSONException {
        JSONObject results = formatter.toJson();
        assertThat(results.getString("total")).isEqualTo("0.00");
    }

    @Test
    public void shouldReturnProductPagesInResultsArrayIfProductPagesAdded() throws JSONException {
        productPages.add(createProductPage());
        productPages.add(createProductPage());

        JSONObject results = formatter.toJson();
        JSONArray resultsArray = results.getJSONArray("results");

        assertThat(resultsArray.length()).isEqualTo(2);
    }

    @Test
    public void shouldReturnTotalOfProductPageUnitPricesProductPagesAdded() throws JSONException {
        productPages.add(createProductPage());
        productPages.add(createProductPage());

        JSONObject results = formatter.toJson();
        assertThat(results.getString("total")).isEqualTo("6.66");
    }

    private ProductPage createProductPage() {
        return new ProductPageBuilder()
                .setDescription(DESCRIPTION)
                .setTitle(TITLE)
                .setUnitPrice(UNIT_PRICE)
                .setSize(SIZE)
                .build();
    }

}
