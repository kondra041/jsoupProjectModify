package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Tag;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    @Test
    public void testAppendChild() {
        // Create a mock Tag and Attributes
        Tag tag = mock(Tag.class);
        Attributes attributes = mock(Attributes.class);

        // Create an Element instance
        Element element = new Element(tag, "", attributes);

        // Create a mock Node to append
        Node childNode = mock(Node.class);

        // Append the child node
        element.appendChild(childNode);

        // Verify that the parent of the child node is set to the element
        verify(childNode).setParentNode(element);

        // Verify that the child node is added to the childNodes list
        assertTrue(element.childNodes().contains(childNode));
    }

    @Test
    public void testAppendChildThrowsNullPointerException() {
        // Create a mock Tag and Attributes
        Tag tag = mock(Tag.class);
        Attributes attributes = mock(Attributes.class);

        // Create an Element instance
        Element element = new Element(tag, "", attributes);

        // Attempt to append null child node
        assertThrows(NullPointerException.class, () -> {
            element.appendChild(null);
        });
    }
}