package uk.co.mruoc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.html.FakeHtmlGetter;
import uk.co.mruoc.html.HtmlGetter;

import static org.assertj.core.api.Assertions.assertThat;

public class ScraperTest {

    private static final String LISTING_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    private HtmlGetter htmlGetter = new FakeHtmlGetter(LISTING_URL);
    private Scraper scraper = new Scraper(htmlGetter);

    @Test
    public void shouldScrapeTotal() throws JSONException {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        assertThat(json.getString("total")).isEqualTo("5.00");
    }

    @Test
    public void shouldScrapeResults() throws JSONException {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        JSONArray results = json.getJSONArray("results");
        assertThat(results.length()).isEqualTo(2);
    }

    @Test
    public void shouldScrapeFirstResult() throws JSONException {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        JSONArray results = json.getJSONArray("results");

        JSONObject page = results.getJSONObject(0);
        assertThat(page.getString("size")).isEqualTo("133.95kb");
        assertThat(page.getString("description")).isEqualTo("Apricots");
        assertThat(page.getString("title")).isEqualTo("Sainsbury's Apricot Ripe & Ready x5");
        assertThat(page.getString("unit_price")).isEqualTo("3.50");
    }

    @Test
    public void shouldScrapeSecondResult() throws JSONException {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        JSONArray results = json.getJSONArray("results");

        JSONObject page = results.getJSONObject(1);
        assertThat(page.getString("size")).isEqualTo("129.93kb");
        assertThat(page.getString("description")).isEqualTo("Avocados");
        assertThat(page.getString("title")).isEqualTo("Sainsbury's Avocado Ripe & Ready XL Loose 300g");
        assertThat(page.getString("unit_price")).isEqualTo("1.50");
    }

}
