package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setup() {
        element = new Element();
    }

    @Test
    public void testAppendChild() {
        TextNode child = mock(TextNode.class);
        when(child.getWholeText()).thenReturn("Hello, World!");

        element.appendChild(child);

        assertTrue(element.childNodes.contains(child));
        assertEquals(1, element.childNodes.size());
        verify(child).setParentNode(any(Element.class));
    }

    @Test
    public void testOuterHtml() {
        TextNode child = new TextNode("Hello", null);
        element.appendChild(child);

        StringBuilder accum = new StringBuilder();
        element.outerHtml(accum);

        assertEquals("<element><TextNode>Hello</TextNode></element>", accum.toString());
    }

    @Test
    public void testEquals() {
        Element otherElement = new Element();
        otherElement.tag = element.tag;

        assertTrue(element.equals(otherElement));
    }
}