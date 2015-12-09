package uk.co.mruoc;

import uk.co.mruoc.html.*;
import uk.co.mruoc.model.ProductPage;
import uk.co.mruoc.model.ProductPages;
import uk.co.mruoc.format.ProductPagesJsonFormatter;

import java.util.List;

import static uk.co.mruoc.model.ProductPage.ProductPageBuilder;

public class RipeAndReadyScraper implements Scraper {

    private final HtmlGetter htmlGetter;
    private final String url;
    private final ProductPageUrlExtractor extractor = new ProductPageUrlExtractor();

    public RipeAndReadyScraper(HtmlGetter htmlGetter, String url) {
        this.htmlGetter = htmlGetter;
        this.url = url;
    }

    @Override
    public String scrape() {
        String listingHtml = htmlGetter.getHtml(url);
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
