import org.jsoup.nodes.Document;
import generated.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @org.junit.jupiter.api.Test
    public void parseHtmlTest() {
        String html = "<html><body><h1>Hello, world!</h1></body></html>";
        String baseUri = "file:///index.html";

        Document document = Parser.parse(html, baseUri);

        assertEquals("Hello, world!", document.body().child(0).text());
    }
}