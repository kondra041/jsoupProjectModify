package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    @Test
    public void testGetElementById() {
        // Arrange
        Element element = mock(Element.class);
        when(element.id()).thenReturn("id");
        Elements elements = new Elements();
        elements.add(element);

        // Act
        Element result = elements.getElementById("id");

        // Assert
        assertNotNull(result);
        assertEquals("id", result.id());
    }

    @Test
    public void testGetElementByIdNull() {
        // Arrange
        Elements elements = new Elements();

        // Act
        Element result = elements.getElementById("non-existent-id");

        // Assert
        assertNull(result);
    }
}