package generated;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParserTest {

    @Test
    void testParseBodyFragment() {
        String bodyHtml = "<div>Some HTML content</div>";
        String baseUri = "http://example.com";
        Document document = Jsoup.parseBodyFragment(bodyHtml, baseUri);
        assertNotNull(document);
    }
}