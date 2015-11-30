package uk.co.mruoc.html;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class DefaultHtmlGetterTest {

    private static final String URL = "http://localhost:8080/testUrl";
    private static final String HTML = "<html><head></head><body>some body</body></html>";

    private final ChromeWebDriver webDriver = mock(ChromeWebDriver.class);
    private final HtmlGetter htmlGetter = new DefaultHtmlGetter(webDriver);

    @Test
    public void shouldReturnHtmlFromWebDriver() {
        given(webDriver.getHtml(URL)).willReturn(HTML);

        String result = htmlGetter.getHtml(URL);

        assertThat(result).isEqualTo(HTML);
    }

}
