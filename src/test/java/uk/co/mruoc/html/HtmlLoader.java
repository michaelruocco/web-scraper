package uk.co.mruoc.html;

import uk.co.mruoc.ScraperException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class HtmlLoader {

    public String loadHtml(String path) {
        URL url = getResource(path);
        try (Stream<String> stream = getDataStreamFrom(url)) {
            return getDataAsStringFrom(stream);
        }
    }

    private URL getResource(String path) {
        return ProductPageUrlExtractorTest.class.getResource(path);
    }

    private Stream<String> getDataStreamFrom(URL url) {
        try {
            return Files.lines(Paths.get(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new ScraperException(e);
        }
    }

    private String getDataAsStringFrom(Stream<String> stream) {
        StringBuilder html = new StringBuilder();
        stream.forEach(html::append);
        return html.toString();
    }

}
