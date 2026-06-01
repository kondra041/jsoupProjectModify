package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ParserTest {

    @Test
    void testParseBodyFragment() {
        String bodyHtml = "<p>Hello world!</p>";
        String baseUri = "http://example.com";
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);
        assertNotNull(doc);
        assertEquals("Hello world!", doc.body().text());
    }
}