package uk.co.mruoc.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import uk.co.mruoc.ScraperException;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HtmlGetterTest {

    private final HtmlGetter htmlGetter = new DefaultHtmlGetter();

    @Test
    public void shouldThrowScraperExceptionIfCannotLoadHtml() {
        try {
            htmlGetter.getHtml("invalid");
            fail();
        } catch (ScraperException e) {
            assertThat(e.getMessage()).isEqualTo("could not load html from url: invalid");
        }
    }

    @Test
    public void shouldLoadHtml() {
        String html = htmlGetter.getHtml("http://www.google.com");
        Document document = Jsoup.parse(html);
        assertThat(document.title()).isEqualTo("Google");
    }

}
