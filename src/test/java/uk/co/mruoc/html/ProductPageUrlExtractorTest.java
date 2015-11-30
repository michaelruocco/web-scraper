package uk.co.mruoc.html;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageUrlExtractorTest {

    private static final String TEST_HTML_PATH = "/listing_page.html";
    private static final String URL_1 = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-apricot-ripe---ready-320g";
    private static final String URL_2 = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-avocado-xl-pinkerton-loose-300g";
    private static final String URL_3 = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-avocado--ripe---ready-x2";

    private ProductPageUrlExtractor urlExtractor = new ProductPageUrlExtractor();
    private HtmlLoader htmlLoader = new HtmlLoader();

    @Test
    public void shouldExtractProductPageUrlsFromListingPageHtml() {
        String html = loadTestHtml();

        List<String> urls = urlExtractor.getUrls(html);

        assertThat(urls.contains(URL_1)).isTrue();
        assertThat(urls.contains(URL_2)).isTrue();
        assertThat(urls.contains(URL_3)).isTrue();
    }

    private String loadTestHtml() {
        return htmlLoader.loadHtml(TEST_HTML_PATH);
    }

}
