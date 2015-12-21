package uk.co.mruoc;

import uk.co.mruoc.html.DefaultHtmlGetter;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
        Scraper scraper = new Scraper(new DefaultHtmlGetter());
        System.out.println(scraper.scrape());
    }

}
