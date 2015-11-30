package uk.co.mruoc.html;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class HtmlLoader {

    public String loadHtml(String path) {
        URL url = ProductPageUrlExtractorTest.class.getResource(path);
        StringBuilder html = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {
            stream.forEach(html::append);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return html.toString();
    }

}