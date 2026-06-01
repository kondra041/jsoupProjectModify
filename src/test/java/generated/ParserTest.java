package generated;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.Tag;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

class ParserTest {

    @org.junit.jupiter.api.Test
    void testParse() {
        String html = "<html><head></head><body>Hello</body></html>";
        Document doc = Parser.parse(html, "http://example.com");

        assertEquals("Hello", doc.text());
    }
}