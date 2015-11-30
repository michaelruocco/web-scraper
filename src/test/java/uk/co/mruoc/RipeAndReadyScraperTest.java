package uk.co.mruoc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.html.FakeHtmlGetter;
import uk.co.mruoc.html.HtmlGetter;

import static org.assertj.core.api.Assertions.assertThat;

public class RipeAndReadyScraperTest {

    private HtmlGetter htmlGetter = new FakeHtmlGetter();
    private RipeAndReadyScraper scraper = new RipeAndReadyScraper(htmlGetter);

    @Test
    public void shouldScrapeDataFromFakeHtmlGetter() {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        assertThat(json.getString("total")).isEqualTo("5.00");

        JSONArray results = json.getJSONArray("results");
        assertThat(results.length()).isEqualTo(2);

        JSONObject result1 = results.getJSONObject(0);
        assertThat(result1.getString("size")).isEqualTo("133.95kb");
        assertThat(result1.getString("description")).isEqualTo("Apricots");
        assertThat(result1.getString("title")).isEqualTo("Sainsbury's Apricot Ripe & Ready x5");
        assertThat(result1.getString("unit_price")).isEqualTo("3.50");

        JSONObject result2 = results.getJSONObject(1);
        assertThat(result2.getString("size")).isEqualTo("129.93kb");
        assertThat(result2.getString("description")).isEqualTo("Avocados");
        assertThat(result2.getString("title")).isEqualTo("Sainsbury's Avocado Ripe & Ready XL Loose 300g");
        assertThat(result2.getString("unit_price")).isEqualTo("1.50");
    }

}
