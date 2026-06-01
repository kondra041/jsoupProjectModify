package generated;

import static org.junit.jupiter.api.Assertions.*;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head></head><body><p>Hello, World!</p></body></html>";
        String baseUri = "http://example.com";

        Document document = Parser.parse(html, baseUri);

        assertNotNull(document);
        assertEquals("Hello, World!", document.body().text());
    }

    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "<p>Hello, Fragment!</p>";
        String baseUri = "http://example.com";

        Document document = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(document);
        assertEquals("Hello, Fragment!", document.body().text());
    }
}