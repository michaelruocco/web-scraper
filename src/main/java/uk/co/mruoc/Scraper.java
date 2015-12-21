package uk.co.mruoc;

import uk.co.mruoc.html.*;
import uk.co.mruoc.model.ProductPage;
import uk.co.mruoc.model.ProductPages;
import uk.co.mruoc.format.ProductPagesJsonFormatter;

import java.util.List;

import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class Scraper {

    private static final String LISTING_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    private final ProductPageUrlExtractor extractor = new ProductPageUrlExtractor();
    private final HtmlGetter htmlGetter;

    public Scraper(HtmlGetter htmlGetter) {
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
        ProductPageParser parser = new ProductPageParser(html);
        return new ProductPageBuilder()
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
