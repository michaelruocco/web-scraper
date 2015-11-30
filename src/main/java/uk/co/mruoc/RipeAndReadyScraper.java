package uk.co.mruoc;

import uk.co.mruoc.model.ProductPage;
import uk.co.mruoc.model.ProductPages;
import uk.co.mruoc.format.ProductPagesJsonFormatter;
import uk.co.mruoc.html.HtmlGetter;
import uk.co.mruoc.html.HtmlParser;
import uk.co.mruoc.html.ProductUrlExtractor;

import java.util.List;

public class RipeAndReadyScraper {

    private static final String LISTING_URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay" +
            "?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&" +
            "langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&" +
            "promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&" +
            "top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true";

    private final HtmlGetter htmlGetter;
    private final ProductUrlExtractor extractor = new ProductUrlExtractor();

    public RipeAndReadyScraper(HtmlGetter htmlGetter) {
        this.htmlGetter = htmlGetter;
    }

    public String scrape() {
        String listingHtml = htmlGetter.getHtml(LISTING_URL);
        List<String> productUrls = extractor.getUrls(listingHtml);
        ProductPages productPages = scrape(productUrls);
        return toJson(productPages);
    }

    private ProductPages scrape(List<String> productUrls) {
        ProductPages productPages = new ProductPages();
        for (String productUrl : productUrls) {
            ProductPage productPage = getProductPage(productUrl);
            productPages.add(productPage);
        }
        return productPages;
    }

    private ProductPage getProductPage(String productUrl) {
        String html = htmlGetter.getHtml(productUrl);
        HtmlParser parser = new HtmlParser(html);
        return new ProductPage.ProductPageBuilder()
                .setTitle(parser.getTitle())
                .setDescription(parser.getDescription())
                .setUnitPrice(parser.getPricePerUnit())
                .setSize(parser.getPageSize())
                .build();
    }

    private String toJson(ProductPages productPages) {
        ProductPagesJsonFormatter formatter = new ProductPagesJsonFormatter(productPages);
        return formatter.toJsonString();
    }

}
