package uk.co.mruoc.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    private static final String TITLE_SELECTOR = ".productTitleDescriptionContainer h1";
    private static final String PRICE_SELECTOR = "p.pricePerUnit";
    private static final String DESCRIPTION_SELECTOR = "div.productText p";
    private static final int BYTES_IN_KILOBYTE = 1024;

    private final String html;
    private final Document document;

    public HtmlParser(String html) {
        this.html = html;
        this.document = Jsoup.parse(html);
    }

    public String getTitle() {
        Elements title = document.select(TITLE_SELECTOR);
        return title.text();
    }

    public double getPricePerUnit() {
        Elements price = document.select(PRICE_SELECTOR);
        return extractPricePerUnit(price.text());
    }

    public double getPageSize() {
        return html.length() / BYTES_IN_KILOBYTE;
    }

    public String getDescription() {
        Elements element = document.select(DESCRIPTION_SELECTOR);
        Element description = element.first();
        return description.text();
    }

    private double extractPricePerUnit(String pricePerUnit) {
        int startIndex = pricePerUnit.indexOf("£") + 1;
        int endIndex = pricePerUnit.indexOf("/");
        return Double.parseDouble(pricePerUnit.substring(startIndex, endIndex));
    }

}
