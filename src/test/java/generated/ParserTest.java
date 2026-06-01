package generated;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParserTest {

    @org.junit.jupiter.api.Test
    public void testParseBodyFragment() {
        String bodyHtml = "<p>This is a test</p>";
        String baseUri = "http://example.com";

        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertEquals("http://example.com", doc.baseUri());
        assertEquals("<html>\n <head></head>\n <body>\n  <p>This is a test</p>\n </body>\n</html>", doc.toString().trim());
    }
}