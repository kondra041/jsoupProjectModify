package generated;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "<p>Hello, World!</p>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);
        
        assertNotNull(doc);
        assertEquals(baseUri, doc.baseUri());
        assertEquals("<html><head></head><body><p>Hello, World!</p></body></html>", doc.toString());
    }

    @Test
    public void testParseEmptyBodyFragment() {
        String bodyHtml = "";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);
        
        assertNotNull(doc);
        assertEquals(baseUri, doc.baseUri());
        assertEquals("<html><head></head><body></body></html>", doc.toString());
    }

    @Test
    public void testParseWithBaseTag() {
        String bodyHtml = "<base href='http://new-base.com'><p>Updated base</p>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);
        
        assertNotNull(doc);
        assertEquals("http://new-base.com", doc.baseUri());
        assertEquals("<html><head></head><body><base href='http://new-base.com'><p>Updated base</p></body></html>", doc.toString());
    }
}