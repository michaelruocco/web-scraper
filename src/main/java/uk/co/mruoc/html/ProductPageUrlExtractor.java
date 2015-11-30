package uk.co.mruoc.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageUrlExtractor {

    private static final String PRODUCT_SELECTOR = "div.product";
    private static final String LINK_SELECTOR = "h3 > a[href]";
    private static final String EMPTY_STRING = "";

    public List<String> getUrls(String html) {
        Document document = Jsoup.parse(html);
        return getProductUrls(document);
    }

    private List<String> getProductUrls(Document document) {
        List<String> urls = new ArrayList<>();
        Elements products = document.select(PRODUCT_SELECTOR);
        for (Element product : products)
            urls.add(getUrlFromProduct(product));
        urls.removeAll(Collections.singleton(EMPTY_STRING));
        return urls;
    }

    private String getUrlFromProduct(Element product) {
        Elements links = product.select(LINK_SELECTOR);
        for (Element link : links)
            return link.attr("href");
        return EMPTY_STRING;
    }

}
