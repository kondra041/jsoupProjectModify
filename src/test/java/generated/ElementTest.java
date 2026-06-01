package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementAppendChildTest {

    @Test
    public void testAppendChild() {
        // Arrange
        Element element = new Element("div");
        Node childNode = mock(Node.class);
        
        // Act
        element.appendChild(childNode);
        
        // Assert
        assertEquals(1, element.childNodes().size());
        assertEquals(element, childNode.getParentNode());
    }

    @Test
    public void testAppendChildWithNull() {
        // Arrange
        Element element = new Element("div");
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> element.appendChild(null));
    }
}