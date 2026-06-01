package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Evaluator;
import org.jsoup.select.Elements;
import java.util.Collections;

public class ElementTest {

    @org.junit.jupiter.api.Test
    public void testGetElementById_ExistingId() {
        // Arrange
        String id = "test-id";
        Element element = mock(Element.class);
        when(element.collectorList(any(Evaluator.class))).thenReturn(new Elements(Collections.singletonList(element)));

        // Act
        Element result = element.getElementById(id);

        // Assert
        assertNotNull(result);
        assertEquals(element, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetElementById_NonExistingId() {
        // Arrange
        String id = "test-id";
        Element element = mock(Element.class);
        when(element.collectorList(any(Evaluator.class))).thenReturn(new Elements());

        // Act
        Element result = element.getElementById(id);

        // Assert
        assertNull(result);
    }
}