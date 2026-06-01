package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseValidHtml() {
        String html = "<html><head><title>Test</title></head><body>Hello, World!</body></html>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parse(html, baseUri);
        
        assertNotNull(doc);
        assertEquals("http://example.com", doc.baseUri());
        assertEquals("Hello, World!", doc.body().text());
    }

    @Test
    public void testParseEmptyHtml() {
        String html = "";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parse(html, baseUri);
        
        assertNotNull(doc);
        assertTrue(doc.body().children().isEmpty());
    }

    @Test
    public void testParseWithBaseTag() {
        String html = "<html><head><base href=\"http://newbase.com\"></head><body>Content</body></html>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parse(html, baseUri);
        
        assertEquals("http://newbase.com", doc.baseUri());
    }

    @Test
    public void testParseWithBodyFragment() {
        String bodyHtml = "<div>Fragment</div>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);
        
        assertNotNull(doc);
        assertEquals("Fragment", doc.body().text());
    }

    @Test
    public void testParseInvalidHtml() {
        String html = "<html><head><title>Missing body</head></html>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parse(html, baseUri);
        
        assertNotNull(doc);
        assertTrue(doc.body().children().isEmpty());
    }

    @Test
    public void testParseWithAttributes() {
        String html = "<div id=\"main\" class=\"container\">Content</div>";
        String baseUri = "http://example.com";
        
        Document doc = Parser.parse(html, baseUri);
        
        Element div = doc.select("#main").first();
        assertNotNull(div);
        assertEquals("container", div.className());
    }
}