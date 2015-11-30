package uk.co.mruoc;

import uk.co.mruoc.html.ChromeWebDriver;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        try (ChromeWebDriver webDriver = new ChromeWebDriver()) {
            RipeAndReadyScraper scraper = new RipeAndReadyScraper(webDriver);
            System.out.println(scraper.scrape());
        }
    }

}
