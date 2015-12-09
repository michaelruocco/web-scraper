package uk.co.mruoc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import uk.co.mruoc.html.FakeHtmlGetter;
import uk.co.mruoc.html.HtmlGetter;
import uk.co.mruoc.html.JSoupHtmlGetter;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticRipeAndReadyScraperTest {

    private Scraper scraper = new StaticRipeAndReadyScraper();

    @Test
    public void shouldScrapeDataFromStaticallyLoadedPages() {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        assertThat(json.getString("total")).isEqualTo("15.10");

        JSONArray results = json.getJSONArray("results");
        assertThat(results.length()).isEqualTo(7);

        JSONObject firstPage = results.getJSONObject(0);
        assertThat(firstPage.getString("size")).isEqualTo("34.92kb");
        assertThat(firstPage.getString("description")).isEqualTo("Apricots");
        assertThat(firstPage.getString("title")).isEqualTo("Sainsbury's Apricot Ripe & Ready x5");
        assertThat(firstPage.getString("unit_price")).isEqualTo("3.50");

        JSONObject lastPage = results.getJSONObject(6);
        assertThat(lastPage.getString("size")).isEqualTo("36.08kb");
        assertThat(lastPage.getString("description")).isEqualTo("Kiwi");
        assertThat(lastPage.getString("title")).isEqualTo("Sainsbury's Kiwi Fruit, Ripe & Ready x4");
        assertThat(lastPage.getString("unit_price")).isEqualTo("1.80");
    }

}
