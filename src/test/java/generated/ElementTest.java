package generated;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    @Test
    public void testPrependChild() {
        // Mock a node to be added as a child
        Node mockNode = mock(Node.class);

        // Create an element to add the node to
        Element element = new Element();

        // Add the node to the element
        element.prependChild(mockNode);

        // Verify that the node has been set as a child of the element
        assertEquals(1, element.childNodes.size());
        assertTrue(element.childNodes.contains(mockNode));
    }

    @Test
    public void testText() {
        // Create an element to set text on
        Element element = new Element();

        // Set some text on the element
        String originalText = "Hello, World!";
        element.text(originalText);

        // Verify that the text has been set correctly
        assertEquals(originalText, element.html());
    }

    @Test
    public void testHasClass() {
        // Create an element with a class attribute
        Element element = new Element();
        element.attr("class", "test-class");

        // Test if the element has the class
        assertTrue(element.hasClass("test-class"));
    }
}