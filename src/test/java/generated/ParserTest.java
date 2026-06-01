package generated;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;

public class ParserTest {

    @Mock
    private Parser parser;

    @InjectMocks
    public ParserTest() {
        // no-op
    }

    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "<html><body>Hello World!</body></html>";
        String baseUri = "https://example.com";
        Document document = Jsoup.parse(bodyHtml, baseUri);
        Parser parserInstance = new Parser(bodyHtml, baseUri, true);
        Document result = parserInstance.parse();
        assertEquals(document, result);
    }

}