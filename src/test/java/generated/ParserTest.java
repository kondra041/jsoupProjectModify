package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseBodyFragment() {
        String html = "<html><body><p>Hello, World!</p></body></html>";
        Document doc = Parser.parseBodyFragment(html, "http://example.com");
        
        assertEquals("html", doc.tagName());
        assertNotNull(doc.selectFirst("body"));
        assertEquals("Hello, World!", doc.selectFirst("body p").text());
    }
}