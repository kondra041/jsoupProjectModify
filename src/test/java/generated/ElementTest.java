package generated;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Collector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementTest {

    private Element element;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        element = mock(Element.class);
    }

    @Test
    void testGetElementsByTag_ReturnsMatchingElements() {
        // Arrange
        String tagName = "div";
        Element div1 = mock(Element.class);
        Element div2 = mock(Element.class);
        when(element.getAllElements()).thenReturn(List.of(div1, div2));
        when(div1.tagName()).thenReturn("div");
        when(div2.tagName()).thenReturn("div");

        // Act
        Elements result = element.getElementsByTag(tagName);

        // Assert
        assertEquals(List.of(div1, div2), result);
    }

    @Test
    void testGetElementsByTag_ReturnsEmptyListIfNoMatch() {
        // Arrange
        String tagName = "span";
        Element span = mock(Element.class);
        when(element.getAllElements()).thenReturn(List.of(span));
        when(span.tagName()).thenReturn("div");

        // Act
        Elements result = element.getElementsByTag(tagName);

        // Assert
        assertTrue(result.isEmpty());
    }
}