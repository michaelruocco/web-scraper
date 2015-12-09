package uk.co.mruoc;

import uk.co.mruoc.RipeAndReadyScraper;
import uk.co.mruoc.Scraper;
import uk.co.mruoc.html.ChromeWebDriver;
import uk.co.mruoc.html.HtmlGetter;
import uk.co.mruoc.html.JSoupHtmlGetter;
import uk.co.mruoc.html.WebDriverHtmlGetter;

public class DynamicRipeAndReadyScraper implements Scraper {

    private static final String LISTING_URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay" +
            "?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&" +
            "langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&" +
            "promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&" +
            "top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

    @Override
    public String scrape() {
        try (ChromeWebDriver webDriver = new ChromeWebDriver()) {
            HtmlGetter htmlGetter = new WebDriverHtmlGetter(webDriver);
            RipeAndReadyScraper scraper = new RipeAndReadyScraper(htmlGetter, LISTING_URL);
            return scraper.scrape();
        }
    }

}
