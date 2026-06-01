package generated;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementTest {

    private Document document;
    private Element element;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        document = mock(Document.class);
        element = new Element("div", "", document);
    }

    @Test
    void testVal() {
        // Test val method for input elements
        element.attr("type", "text");
        element.val("test value");
        assertEquals("test value", element.attr("value"));

        // Test val method for textarea elements
        Element textArea = new Element("textarea", "", document);
        textArea.val("text area value");
        assertEquals("text area value", textArea.text());
    }

    @Test
    void testHtml() {
        // Test setting inner HTML and retrieving it back
        element.html("<p>Sample Paragraph</p>");
        assertEquals("<p>Sample Paragraph</p>", element.html());
    }

    @Test
    void testOuterHtml() {
        // Test setting outer HTML
        element.outerHtml("<div class=\"test\"><p>Test Content</p></div>");
        assertEquals("<div class=\"test\"><p>Test Content</p></div>", element.outerHtml());
    }

    @Test
    void testClassMethods() {
        // Test adding, removing and toggling classes
        Element testElement = new Element("span", "", document);
        testElement.addClass("new-class");
        assertTrue(testElement.hasClass("new-class"));

        testElement.removeClass("new-class");
        assertFalse(testElement.hasClass("new-class"));

        testElement.toggleClass("new-class");
        assertTrue(testElement.hasClass("new-class"));
    }

    @Test
    void testGetDeepChild() {
        // Test getDeepChild method
        Element root = new Element("root", "", document);
        Element child1 = new Element("child", "", document);
        Element child2 = new Element("grandchild", "", document);

        root.appendChild(child1);
        child1.appendChild(child2);

        Element deepChild = getDeepChild(root);
        assertEquals("grandchild", deepChild.tagName());
    }
}