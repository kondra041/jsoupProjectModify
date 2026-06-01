import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void testEmptyBodyFragment() {
        Document doc = Parser.parseBodyFragment("", "http://example.com");
        assertNotNull(doc);
        assertNull(doc.body());
    }

    @Test
    void testBasicBodyFragment() {
        String html = "<div>Hello World</div>";
        Document doc = Parser.parseBodyFragment(html, "http://example.com");
        assertNotNull(doc);
        assertNotNull(doc.body());
        assertEquals(1, doc.body().children().size());
        assertEquals("Hello World", ((Element) doc.body().child(0)).text());
    }

    @Test
    void testNestedBodyFragment() {
        String html = "<div><p>Hello <b>World</b></p></div>";
        Document doc = Parser.parseBodyFragment(html, "http://example.com");
        assertNotNull(doc);
        assertNotNull(doc.body());
        assertEquals(1, doc.body().children().size());
        assertEquals("Hello World", ((Element) doc.body().child(0)).text());
    }

    @Test
    void testInvalidBodyFragment() {
        String html = "<div><p>Hello</div>";
        Document doc = Parser.parseBodyFragment(html, "http://example.com");
        assertNotNull(doc);
        assertNotNull(doc.body());
        assertEquals(1, doc.body().children().size());
        assertEquals("Hello", ((Element) doc.body().child(0)).text());
    }
}