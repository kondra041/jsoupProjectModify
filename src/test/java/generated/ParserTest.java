package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void testParseBodyFragment() {
        String bodyHtml = "<div>Hello, world!</div>";
        String baseUri = "http://example.com";
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertEquals(1, doc.body().children().size());
        assertTrue(doc.body().child(0) instanceof Element);
        assertEquals("Hello, world!", ((Element)doc.body().child(0)).text());
    }
}