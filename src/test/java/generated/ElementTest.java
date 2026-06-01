package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element("div");
    }

    @Test
    public void testPrependChild() {
        Node childNode = mock(Node.class);
        when(childNode.parent()).thenReturn(null);

        element.prependChild(childNode);

        verify(childNode).setParentNode(element);
        assertEquals(1, element.childNodes.size());
        assertSame(childNode, element.childNodes.get(0));
    }

    @Test
    public void testPrependChildWithExistingChildren() {
        Node firstChild = mock(Node.class);
        when(firstChild.parent()).thenReturn(null);

        Node secondChild = mock(Node.class);
        when(secondChild.parent()).thenReturn(null);

        element.appendChild(firstChild);
        element.appendChild(secondChild);

        Node newChild = mock(Node.class);
        when(newChild.parent()).thenReturn(null);

        element.prependChild(newChild);

        verify(newChild).setParentNode(element);
        assertEquals(3, element.childNodes.size());
        assertSame(newChild, element.childNodes.get(0));
        assertSame(firstChild, element.childNodes.get(1));
        assertSame(secondChild, element.childNodes.get(2));
    }

    @Test
    public void testPrependChildThrowsIllegalArgumentException() {
        Node childNode = mock(Node.class);
        when(childNode.parent()).thenReturn(element);

        assertThrows(IllegalArgumentException.class, () -> {
            element.prependChild(childNode);
        });
    }
}