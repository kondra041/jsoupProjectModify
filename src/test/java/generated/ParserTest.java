package generated;

import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    void testParse() {
        String html = "<html><head><title>My Page</title></head><body><h1>Hello World</h1></body></html>";
        String baseUri = "https://example.com";
        Document doc = Parser.parse(html, baseUri);
        assertEquals("My Page", doc.title());
        assertEquals("Hello World", doc.body().text());
    }
}