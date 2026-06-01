package generated;

import java.util.LinkedList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ParserTest {

    @Test
    public void testParse() {
        String html = "<html><head><title>Test</title></head><body><p>Hello World!</p></body></html>";
        String baseUri = "http://example.com";
        Parser parser = spy(new Parser(html, baseUri, false));
        Document document = parser.parse();
        assertNotNull(document);
    }
}