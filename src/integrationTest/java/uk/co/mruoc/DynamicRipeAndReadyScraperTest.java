package uk.co.mruoc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicRipeAndReadyScraperTest {

    private static final String TWO_DP_KB_REGEX = "[0-9]+(\\.[0-9]([0-9])?)?kb";

    private Scraper scraper = new DynamicRipeAndReadyScraper();

    @Test
    public void shouldScrapeDataFromDynamicallyLoadedPages() {
        String result = scraper.scrape();

        JSONObject json = new JSONObject(result);
        assertThat(json.getString("total")).isEqualTo("35.50");

        JSONArray results = json.getJSONArray("results");
        assertThat(results.length()).isEqualTo(16);

        JSONObject firstPage = results.getJSONObject(0);
        System.out.println(firstPage.getString("size"));
        assertThat(matchesSizeFormat(firstPage.getString("size"))).isTrue();
        assertThat(firstPage.getString("description")).isEqualTo("Apricots");
        assertThat(firstPage.getString("title")).isEqualTo("Sainsbury's Apricot Ripe & Ready x5");
        assertThat(firstPage.getString("unit_price")).isEqualTo("3.50");

        JSONObject lastPage = results.getJSONObject(15);
        assertThat(matchesSizeFormat(lastPage.getString("size"))).isTrue();
        assertThat(lastPage.getString("description")).isEqualTo("by Sainsbury's Ripe and Ready White Flesh Nectarines");
        assertThat(lastPage.getString("title")).isEqualTo("Sainsbury's White Flesh Nectarines, Ripe & Ready x4");
        assertThat(lastPage.getString("unit_price")).isEqualTo("3.50");
    }

    private boolean matchesSizeFormat(String size) {
        return Pattern.matches(TWO_DP_KB_REGEX, size);
    }

}
