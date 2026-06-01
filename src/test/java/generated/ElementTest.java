import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ElementTest {

    @Mock
    private Collector collector;

    @Mock
    private Evaluator evaluatorId;

    @Mock
    private Elements elementsMock;

    private Element elementUnderTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(evaluatorId.evaluate(any(Element.class))).thenReturn(elementsMock);

        // Setup a mock Node to represent the found element
        Node mockFoundElement = mock(Node.class);
        when(mockFoundElement instanceof Element).thenReturn(true);
        when(((Element) mockFoundElement).tagName()).thenReturn("mock");

        when(elementsMock.size()).thenReturn(1);
        when(elementsMock.get(0)).thenReturn(mockFoundElement);

        // Initialize the elementUnderTest with mocked collector
        elementUnderTest = new Element(Tag.valueOf("div"), "").attr("id", "root");
    }

    @Test
    void testGetElementById_FindsElement() {
        // Arrange
        String idToFind = "foundId";
        when(evaluatorId.evaluate(any(Element.class))).thenReturn(elementsMock);
        when(((Element) mockFoundElement).attributes().get("id")).thenReturn(idToFind);

        // Act
        Element result = elementUnderTest.getElementById(idToFind);

        // Assert
        assertNotNull(result);
        assertEquals("mock", result.tagName());
    }

    @Test
    void testGetElementById_NoMatchingId() {
        // Arrange
        String idToFind = "nonExistentId";
        when(elementsMock.size()).thenReturn(0);

        // Act
        Element result = elementUnderTest.getElementById(idToFind);

        // Assert
        assertNull(result);
    }

    @Test
    void testGetElementById_NullId() {
        // Arrange

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> elementUnderTest.getElementById(null));

        // Assert
        assertEquals("ID must not be empty", exception.getMessage());
    }

    @Test
    void testGetElementById_EmptyId() {
        // Arrange

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> elementUnderTest.getElementById(""));

        // Assert
        assertEquals("ID must not be empty", exception.getMessage());
    }
}