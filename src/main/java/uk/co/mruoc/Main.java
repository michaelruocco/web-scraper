package uk.co.mruoc;

import uk.co.mruoc.html.ChromeWebDriver;
import uk.co.mruoc.html.DefaultHtmlGetter;
import uk.co.mruoc.html.HtmlGetter;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        try (ChromeWebDriver webDriver = new ChromeWebDriver()) {
            HtmlGetter htmlGetter = new DefaultHtmlGetter(webDriver);
            RipeAndReadyScraper scraper = new RipeAndReadyScraper(htmlGetter);
            System.out.println(scraper.scrape());
        }
    }

}
