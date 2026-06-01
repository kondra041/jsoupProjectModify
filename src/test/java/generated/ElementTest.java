package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ElementTest {

    private Document doc;

    @BeforeEach
    public void setUp() {
        String html = "<html><head></head><body>" +
                      "<div id='first'>First Div</div>" +
                      "<div id='second'>Second Div</div>" +
                      "</body></html>";
        doc = Parser.parse(html, "");
    }

    @Test
    public void testGetElementById() {
        Element firstDiv = doc.getElementById("first");
        assertNotNull(firstDiv);
        assertEquals("First Div", firstDiv.text());

        Element secondDiv = doc.getElementById("second");
        assertNotNull(secondDiv);
        assertEquals("Second Div", secondDiv.text());

        Element nonExistentDiv = doc.getElementById("nonexistent");
        assertNull(nonExistentDiv);
    }

    @Test
    public void testText() {
        Element body = doc.body();
        assertEquals("First DivSecond Div", body.text());
        assertEquals("", body.child(0).text()); // Empty text for first div

        body.text("New Text");
        assertEquals("New Text", body.text());

        List<Node> nodes = body.childNodes();
        assertEquals(1, nodes.size());
        assertTrue(nodes.get(0) instanceof TextNode);
    }

    @Test
    public void testHtml() {
        Element body = doc.body();
        String originalHtml = body.html();
        assertEquals("<div id=\"first\">First Div</div><div id=\"second\">Second Div</div>", originalHtml);

        body.html("<p>New HTML Content</p>");
        assertEquals("<p>New HTML Content</p>", body.html());
    }

    @Test
    public void testAttributes() {
        Element firstDiv = doc.getElementById("first");
        assertEquals("first", firstDiv.attr("id"));
        assertEquals("", firstDiv.attr("nonexistent"));

        firstDiv.attr("newAttr", "newValue");
        assertEquals("newValue", firstDiv.attr("newAttr"));
    }

    @Test
    public void testClassNames() {
        Element firstDiv = doc.getElementById("first");
        assertFalse(firstDiv.hasClass("some-class"));
        firstDiv.addClass("some-class");
        assertTrue(firstDiv.hasClass("some-class"));

        Set<String> classNames = firstDiv.classNames();
        assertEquals(Collections.singleton("some-class"), classNames);

        firstDiv.removeClass("some-class");
        assertFalse(firstDiv.hasClass("some-class"));
    }
}