package uk.co.mruoc.html;

import uk.co.mruoc.ScraperException;

import java.util.HashMap;
import java.util.Map;

public class FakeHtmlGetter implements HtmlGetter {

    private static final String APRICOT_URL = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-apricot-ripe---ready-320g";
    private static final String AVOCADO_URL = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-avocado-xl-pinkerton-loose-300g";

    private final Map<String, String> pages = new HashMap<>();
    private final HtmlLoader htmlLoader = new HtmlLoader();

    public FakeHtmlGetter(String listingUrl) {
        pages.put(listingUrl, htmlLoader.loadHtml("/listing_page.html"));
        pages.put(APRICOT_URL, htmlLoader.loadHtml("/apricot_page.html"));
        pages.put(AVOCADO_URL, htmlLoader.loadHtml("/avocado_page.html"));
    }

    @Override
    public String getHtml(String url) {
        if (pages.containsKey(url))
            return pages.get(url);
        throw new ScraperException("html not found for url " + url);
    }

}
