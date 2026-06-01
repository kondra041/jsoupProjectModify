package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    private Element element;
    private Node childNode;

    @BeforeEach
    public void setUp() {
        element = new Element("div");
        childNode = mock(Node.class);
    }

    @Test
    public void testAppendChild_AddsChildToElement() {
        // Act
        element.appendChild(childNode);

        // Assert
        assertTrue(element.childNodes().contains(childNode));
    }

    @Test
    public void testAppendChild_SetsParentNodeOfChild() {
        // Act
        element.appendChild(childNode);

        // Assert
        verify(childNode).setParentNode(element);
    }

    @Test
    public void testAppendChild_ReturnsThisElementForChaining() {
        // Act
        Element result = element.appendChild(childNode);

        // Assert
        assertSame(result, element);
    }
}