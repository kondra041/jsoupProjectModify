package generated;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head><title>Test</title></head><body></body></html>";
        Document expectedDoc = Jsoup.parse(html);
        Document actualDoc = Parser.parse(html, "http://example.com");
        
        assertEquals(expectedDoc.html(), actualDoc.html());
    }
}