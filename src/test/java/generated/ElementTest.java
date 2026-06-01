import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementGetElementByIdTest {

    @Test
    void testSelfElementHasId() {
        String html = "<div id=\"self\"></div>";
        Document doc = Jsoup.parse(html);
        Element div = doc.body().child(0);
        assertEquals(div, div.getElementById("self"));
    }

    @Test
    void testDirectChildHasId() {
        String html = "<div><p id=\"child\"></p></div>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Element p = body.child(0);
        assertEquals(p, body.getElementById("child"));
    }

    @Test
    void testNestedDescendantHasId() {
        String html = "<div><span><p id=\"nested\"></p></span></div>";
        Document doc = Jsoup.parse(html);
        Element div = doc.body().child(0);
        assertEquals(div.select("p").first(), div.getElementById("nested"));
    }

    @Test
    void testMultipleIdsInSubtree() {
        String html = "<div><p id=\"a\"></p><span id=\"b\"></span></div>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        assertSame(body.getElementsByTag("p").first(), body.getElementById("a"));
    }

    @Test
    void testNoMatchingId() {
        String html = "<div><p></p></div>";
        Document doc = Jsoup.parse(html);
        Element div = doc.body().child(0);
        assertNull(div.getElementById("nonExistent"));
    }
}