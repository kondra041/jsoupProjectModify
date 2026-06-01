package generated;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Element element;

    @BeforeEach
    void setUp() {
        // Create a mock Document and TextNode for testing
        Document document = mock(Document.class);
        TextNode textNode = new TextNode("", document);
        // Assume the element's text node is added to childNodes
        element = new Element("div", "", textNode, null);
    }

    @Test
    void testGetElementById() {
        String id = "testId";
        element.attr("id", id);

        // Test finding the element by ID
        assertEquals(element, element.getElementById(id));

        // Test not finding an element by ID
        Element nonExistentElement = element.getElementById("nonExistentId");
        assertNull(nonExistentElement);
    }
}