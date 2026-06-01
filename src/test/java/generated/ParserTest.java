package generated;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head><title>Test Title</title></head><body><p>Test Paragraph</p></body></html>";
        String baseUri = "http://example.com";

        Document doc = Parser.parse(html, baseUri);

        assertNotNull(doc);
        assertEquals("http://example.com", doc.baseUri());
        assertEquals("html", doc.tagName());

        org.jsoup.nodes.Element head = doc.head();
        assertNotNull(head);
        assertEquals("head", head.tagName());

        org.jsoup.nodes.Element title = head.child(0);
        assertNotNull(title);
        assertEquals("title", title.tagName());
        assertEquals("Test Title", title.text());

        org.jsoup.nodes.Element body = doc.body();
        assertNotNull(body);
        assertEquals("body", body.tagName());

        org.jsoup.nodes.Element paragraph = body.child(0);
        assertNotNull(paragraph);
        assertEquals("p", paragraph.tagName());
        assertEquals("Test Paragraph", paragraph.text());
    }
}