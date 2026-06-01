package generated;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestParser {
    @Test
    void parse_validHtml_returnsParsedDocument() {
        String html = "<html><head></head><body>hello</body></html>";
        Document doc = Jsoup.parse(html);
        assertNotNull(doc);
        assertEquals("html", doc.tagName());
    }

    @Test
    void parse_invalidHtml_returnsEmptyDocument() {
        String html = "<html><head></head><body>";
        Document doc = Jsoup.parse(html);
        assertNotNull(doc);
        assertEquals("", doc.text());
    }

    @Test
    void parse_validHtmlWithAttributes_returnsParsedDocument() {
        String html = "<html><head></head><body attr=\"value\">hello</body></html>";
        Document doc = Jsoup.parse(html);
        assertNotNull(doc);
        Elements body = doc.select("body");
        assertEquals(1, body.size());
        assertTrue(body.hasAttr("attr"));
    }

    @Test
    void parse_invalidHtmlWithAttributes_returnsParsedDocument() {
        String html = "<html><head></head><body attr=\"value\">hello";
        Document doc = Jsoup.parse(html);
        assertNotNull(doc);
        Elements body = doc.select("body");
        assertEquals(1, body.size());
        assertTrue(body.hasAttr("attr"));
    }
}