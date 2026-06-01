package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class ParserTest {
    private static final Logger logger = LoggerFactory.getLogger(ParserTest.class);

    @Test
    void testParse() {
        String html = "<html><head><title>Test</title></head><body><h1>Hello</h1></body></html>";
        Document doc = Parser.parse(html, "http://example.com");
        
        assertNotNull(doc);
        assertEquals("http://example.com", doc.baseUri());
        assertEquals("Test", doc.title().text());
        assertEquals(2, doc.childrenSize()); // html and head
    }

    @Test
    void testParseBodyFragment() {
        String bodyHtml = "<body><p>Test fragment</p></body>";
        Document doc = Parser.parseBodyFragment(bodyHtml, "http://example.com");
        
        assertNotNull(doc);
        assertEquals("http://example.com", doc.baseUri());
        assertEquals(1, doc.body().childrenSize()); // p
    }

    @Test
    void testBaseTagChange() {
        String html = "<html><head></head><base href='http://new.com'/><p>Test</p></html>";
        Document doc = Parser.parse(html, "http://old.com");
        
        assertEquals("http://new.com", doc.baseUri());
        assertEquals(1, doc.body().childrenSize()); // p
    }

    @Test
    void testSelfClosingTag() {
        String html = "<img src='test.jpg' />";
        Document doc = Parser.parseBodyFragment(html, "http://example.com");
        
        assertNotNull(doc.body().firstElement());
        assertEquals("img", doc.body().firstElement().tagName());
        assertEquals("test.jpg", doc.body().firstElement().attr("src"));
    }

    @Test
    void testCDATASection() {
        String cdata = "<![CDATA[<>&'\"]]>";
        Document doc = Jsoup.parse("<div>" + cdata + "</div>", "");
        
        assertEquals("&lt;&gt;&apos;&quot;", doc.body().text());
    }
}