package generated;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void parseBodyFragment() {
        String bodyHtml = "<p>Hello<br></p>";
        Document doc = Jsoup.parseBodyFragment(bodyHtml);

        Element p = doc.select("p").first();
        assertEquals("Hello", p.text());
    }
}