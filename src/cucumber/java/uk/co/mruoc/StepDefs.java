package uk.co.mruoc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefs {

    private Scraper scraper;
    private String result;
    private JSONObject json;
    private JSONArray results;

    @Given("^a dynamic page is loaded$")
    public void a_dynamic_page_is_loaded() throws Throwable {
        scraper = new DynamicRipeAndReadyScraper();
    }

    @Given("^a static page is loaded$")
    public void a_static_page_is_loaded() throws Throwable {
        scraper = new StaticRipeAndReadyScraper();
    }

    @When("^the page is parsed$")
    public void the_page_is_parsed() throws Throwable {
        result = scraper.scrape();
        json = new JSONObject(result);
        results = json.getJSONArray("results");
    }

    @Then("^there are (\\d+) result pages returned$")
    public void there_are_result_pages_returned(int expectedNumberOfPages) throws Throwable {
        assertThat(results.length()).isEqualTo(expectedNumberOfPages);
    }

    @Then("^there are (\\d+) result pages returned with a total value of (\\d+.\\d+)$")
    public void there_are_result_pages_returned_with_a_total_value_of(int numberOfPages, double total) throws Throwable {
        assertThat(results.length()).isEqualTo(numberOfPages);
        assertThat(json.getDouble("total")).isEqualTo(total);
    }

    @Then("^the following data is parsed from the pages$")
    public void the_following_data_is_parsed_from_the_pages(List<PageData> pageDataList) throws Throwable {
        for (PageData pageData : pageDataList) {
            JSONObject page = results.getJSONObject(pageData.getIndex());
            assertThat(page.getString("title")).isEqualTo(pageData.getTitle());
            assertThat(page.getString("description")).isEqualTo(pageData.getDescription());
            assertThat(page.getString("unit_price")).isEqualTo(pageData.getUnitPrice());
            if (!StringUtils.isEmpty(pageData.getSize()))
                assertThat(page.getString("size")).isEqualTo(pageData.getSize());
        }
    }

}
