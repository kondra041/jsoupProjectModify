package generated;

import org.jsoup.parser.Document;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head></head><body><p>Hello, World!</p></body></html>";
        Document doc = Parser.parse(html, "http://example.com");
        
        assertNotNull(doc);
        assertEquals("Hello, World!", doc.body().text());
    }

}