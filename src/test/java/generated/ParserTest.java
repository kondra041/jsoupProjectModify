import org.jsoup.parser.Document;
import org.jsoup.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {

    @org.junit.jupiter.api.Test
    public void testParseBodyFragment() {
        String bodyHtml = "<p>Hello, world!</p>";
        String baseUri = "file:///index.html";

        Document document = Parser.parseBodyFragment(bodyHtml, baseUri);

        assertNotNull(document);
        assertEquals("p", document.body().child(0).tagName());
        assertEquals("Hello, world!", document.body().child(0).text());
    }
}