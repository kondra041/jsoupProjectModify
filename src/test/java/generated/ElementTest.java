package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class ElementTest {
    private Element element;

    @BeforeEach
    public void setUp() {
        Document document = new Document("");
        element = mock(Element.class);
        when(element.tagName()).thenReturn("div");
    }

    @Test
    public void testPrependChild() {
        Node child = new TextNode("", "test");
        element.prependChild(child);
        verify(element).prependChild(child);
        assertEquals(1, element.childNodes().size());
        assertTrue(element.childNodes().contains(child));
    }
}