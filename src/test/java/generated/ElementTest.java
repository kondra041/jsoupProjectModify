package generated;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementTest {

    private Element element;

    @BeforeEach
    void setUp() {
        element = new Element(Tag.valueOf("div"), "");
    }

    @Test
    void testAppendChild() {
        Node childNode = mock(Node.class);
        when(childNode.parentNode()).thenReturn(null);

        // Test appending a node without parent
        element.appendChild(childNode);

        verify(childNode).setParentNode(element);
        assertEquals(Arrays.asList(childNode), element.childNodes());
        
        // Test adding a second node
        Node anotherChildNode = mock(Node.class);
        when(anotherChildNode.parentNode()).thenReturn(null);

        element.appendChild(anotherChildNode);

        verify(anotherChildNode).setParentNode(element);
        assertEquals(Arrays.asList(childNode, anotherChildNode), element.childNodes());

        // Test appending a node with an existing parent
        Node childWithExistingParent = mock(Node.class);
        when(childWithExistingParent.parentNode()).thenReturn(new Element(Tag.valueOf("div"), ""));

        assertThrows(IllegalArgumentException.class, () -> element.appendChild(childWithExistingParent));
    }

}