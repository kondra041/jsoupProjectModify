package generated;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Element element;
    private Document document;

    @BeforeEach
    public void setUp() {
        document = mock(Document.class);
        element = new Element("div");
        when(element.getBaseUri()).thenReturn("http://example.com");
        when(document.body()).thenReturn(element);
    }

    @Test
    public void testGetElementById() {
        // Arrange
        Element nestedElement = mock(Element.class);
        when(nestedElement.getId()).thenReturn("testId");
        when(element.getElementById("testId")).thenReturn(nestedElement);

        // Act
        Element result = element.getElementById("testId");

        // Assert
        assertNotNull(result);
        assertEquals(nestedElement, result);
    }

    @Test
    public void testGetElementById_NotFound() {
        // Arrange
        when(element.getElementById("nonExistentId")).thenReturn(null);

        // Act
        Element result = element.getElementById("nonExistentId");

        // Assert
        assertNull(result);
    }
}