package uk.co.mruoc;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        scrapeStaticallyLoadedPage();
        System.out.println();
        scrapeDynamicallyLoadedPage();
    }

    private static void scrapeDynamicallyLoadedPage() {
        Scraper scraper = new DynamicRipeAndReadyScraper();
        System.out.println(scraper.scrape());
    }

    private static void scrapeStaticallyLoadedPage() {
        Scraper scraper = new StaticRipeAndReadyScraper();
        System.out.println(scraper.scrape());
    }

}
