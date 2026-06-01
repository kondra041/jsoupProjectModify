import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class ElementGetElementsByTagTest {

    private Document document;

    void setup() {
        document = Jsoup.parse("<html><body></body></html>");
    }

    @org.junit.jupiter.api.Test
    void testNestedElements() {
        String html =
            "<div id='container'>" +
                "<div class='nested'><p><h1>Heading</h1></p></div>" +
            "</div>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element container = doc.getElementById("container");
        
        List<Element> h1Elements = container.getElementsByTag("h1");
        assertEquals(1, h1Elements.size());
        assertAll("h1 element",
            () -> assertEquals("h1", h1Elements.get(0).tagName()),
            () -> assertEquals("Heading", h1Elements.get(0).text())
        );
    }

    @org.junit.jupiter.api.Test
    void testDirectChildren() {
        String html = "<div><h1>One</h1><h1>Two</h1></div>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element container = doc.getElementsByTag("div").first();
        
        List<Element> h1Elements = container.getElementsByTag("h1");
        assertEquals(2, h1Elements.size());
        assertAll("h1 elements",
            () -> assertEquals("One", h1Elements.get(0).text()),
            () -> assertEquals("Two", h1Elements.get(1).text())
        );
    }

    @org.junit.jupiter.api.Test
    void testCaseInsensitivity() {
        String html = "<div><H2>Test</H2></div>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element container = doc.getElementsByTag("div").first();
        
        List<Element> h2Elements = container.getElementsByTag("h2");
        assertEquals(1, h2Elements.size());
        assertAll("h2 element",
            () -> assertEquals("h2", h2Elements.get(0).tagName()),
            () -> assertEquals("Test", h2Elements.get(0).text())
        );
    }

    @org.junit.jupiter.api.Test
    void testWhitespaceTrimming() {
        String html = "<div> <P> Hello </P> </div>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element container = doc.getElementsByTag("div").first();
        
        List<Element> pElements = container.getElementsByTag(" P ");
        assertEquals(1, pElements.size());
        assertAll("p element",
            () -> assertEquals("p", pElements.get(0).tagName()),
            () -> assertEquals("Hello", pElements.get(0).text())
        );
    }

    @org.junit.jupiter.api.Test
    void testSelfMatching() {
        String html = "<h3>Test</h3>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element h3Element = doc.getElementsByTag("h3").first();
        
        List<Element> h3Elements = h3Element.getElementsByTag("h3");
        assertEquals(1, h3Elements.size());
        assertAll("self element",
            () -> assertEquals("h3", h3Elements.get(0).tagName()),
            () -> assertEquals("Test", h3Elements.get(0).text())
        );
    }

    @org.junit.jupiter.api.Test
    void testNoMatches() {
        String html = "<div>Content</div>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element container = doc.getElementsByTag("div").first();
        
        List<Element> noElements = container.getElementsByTag("nonexistent");
        assertEquals(0, noElements.size());
    }

    @org.junit.jupiter.api.Test
    void testScriptAndStyleTags() {
        String html =
            "<script><h1>Script</h1></script>" +
            "<style><h2>Style</h2></style>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.getElementsByTag("body").first();
        
        List<Element> h1Elements = body.getElementsByTag("h1");
        assertEquals(1, h1Elements.size());
        List<Element> h2Elements = body.getElementsByTag("h2");
        assertEquals(1, h2Elements.size());
    }
}