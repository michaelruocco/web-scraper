package uk.co.mruoc;

import uk.co.mruoc.html.HtmlGetter;
import uk.co.mruoc.html.JSoupHtmlGetter;

public class StaticRipeAndReadyScraper implements Scraper {

    private static final String LISTING_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com" +
            "/2015_Developer_Scrape/5_products.html";

    private final HtmlGetter htmlGetter = new JSoupHtmlGetter();
    private final Scraper scraper = new RipeAndReadyScraper(htmlGetter, LISTING_URL);

    @Override
    public String scrape() {
        return scraper.scrape();
    }

}
