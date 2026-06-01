package generated;

import org.jsoup.parser.Document;
import org.jsoup.parser.Parser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head></head><body>Hello, World!</body></html>";
        String baseUri = "http://example.com";

        Document doc = Parser.parse(html, baseUri);

        assertNotNull(doc);
        assertEquals("html", doc.nodeName());
    }
}