package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "<p>Hello, World!</p>";
        String baseUri = "http://example.com";

        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertTrue(doc.head().isEmpty());
        assertFalse(doc.body().isEmpty());

        Elements paragraphs = doc.body().getElementsByTag("p");
        assertEquals(1, paragraphs.size());
        assertEquals("Hello, World!", paragraphs.first().text());
    }

    @Test
    public void testParseBodyFragmentWithNestedTags() {
        String bodyHtml = "<div><p>Hello, World!</p></div>";
        String baseUri = "http://example.com";

        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertTrue(doc.head().isEmpty());
        assertFalse(doc.body().isEmpty());

        Elements paragraphs = doc.body().getElementsByTag("p");
        assertEquals(1, paragraphs.size());
        assertEquals("Hello, World!", paragraphs.first().text());
    }

    @Test
    public void testParseBodyFragmentWithAttributes() {
        String bodyHtml = "<div class=\"container\"><p>Hello, World!</p></div>";
        String baseUri = "http://example.com";

        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertTrue(doc.head().isEmpty());
        assertFalse(doc.body().isEmpty());

        Elements paragraphs = doc.body().getElementsByTag("p");
        assertEquals(1, paragraphs.size());
        assertEquals("Hello, World!", paragraphs.first().text());
        assertEquals("container", paragraphs.first().parent().attr("class"));
    }

    @Test
    public void testParseBodyFragmentWithEmptyElements() {
        String bodyHtml = "<img src=\"image.jpg\" alt=\"Image\">";
        String baseUri = "http://example.com";

        Document doc = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(doc);
        assertTrue(doc.head().isEmpty());
        assertFalse(doc.body().isEmpty());

        Elements images = doc.body().getElementsByTag("img");
        assertEquals(1, images.size());
        assertEquals("image.jpg", images.first().attr("src"));
        assertEquals("Image", images.first().attr("alt"));
    }
}