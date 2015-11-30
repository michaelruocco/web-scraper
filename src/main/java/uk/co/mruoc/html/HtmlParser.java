package uk.co.mruoc.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.charset.Charset;

public class HtmlParser {

    private static final String TITLE_SELECTOR = ".productTitleDescriptionContainer h1";
    private static final String PRICE_SELECTOR = "p.pricePerUnit";
    private static final String DESCRIPTION_SELECTOR = "div.productText";
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
        byte[] bytes = html.getBytes(Charset.defaultCharset());
        return bytes.length / BYTES_IN_KILOBYTE;
    }

    public String getDescription() {
        Elements elements = document.select(DESCRIPTION_SELECTOR);
        Element element = elements.first();
        return element.text();
    }

    private double extractPricePerUnit(String pricePerUnit) {
        int startIndex = pricePerUnit.indexOf("£") + 1;
        int endIndex = pricePerUnit.indexOf("/");
        return Double.parseDouble(pricePerUnit.substring(startIndex, endIndex));
    }

}
