package uk.co.mruoc;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        Scraper scraper = new StaticRipeAndReadyScraper();
        System.out.println(scraper.scrape());
    }

}
