package uk.co.mruoc.html;

import org.jsoup.Jsoup;
import uk.co.mruoc.ScraperException;

import java.io.IOException;

public class DefaultHtmlGetter implements HtmlGetter {

    @Override
    public String getHtml(String url) {
        try {
            return Jsoup.connect(url).get().html();
        } catch (IOException | IllegalArgumentException e) {
            throw new ScraperException("could not load html from url: " + url, e);
        }
    }

}
