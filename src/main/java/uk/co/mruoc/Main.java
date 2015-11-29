package uk.co.mruoc;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        try (HtmlGetter htmlGetter = new HtmlGetter()) {
            RipeAndReadyScraper scraper = new RipeAndReadyScraper(htmlGetter);
            System.out.println(scraper.scrape());
        }
    }

}
