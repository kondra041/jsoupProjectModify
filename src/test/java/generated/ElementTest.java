import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ElementPrependChildTest {

    @InjectMocks
    private Element element;

    @BeforeEach
    void setUp() {
        // Mock the tag for consistency in tests
        when(element.tag()).thenReturn(mock(org.jsoup.parser.Tag.class));
    }

    @Test
    public void testAddSingleChild() {
        TextNode textNode = new TextNode("test", "");
        element.prependChild(textNode);

        List<Node> children = element.childNodes();
        assertEquals(1, children.size());
        assertSame(textNode, children.get(0));
    }

    @Test
    public void testPrependMultipleChildren() {
        TextNode first = new TextNode("first", "");
        TextNode second = new TextNode("second", "");
        TextNode third = new TextNode("third", "");

        element.prependChild(second);
        element.prependChild(first);
        element.prependChild(third);

        List<Node> children = element.childNodes();
        assertEquals(3, children.size());
        assertSame(third, children.get(0));
        assertSame(first, children.get(1));
        assertSame(second, children.get(2));
    }

    @Test
    public void testPrependMultipleNodesMaintainsOrder() {
        Element child1 = new Element("div");
        Element child2 = new Element("span");
        TextNode textChild = new TextNode("text", "");

        // Add in reverse order to ensure they are prepended correctly
        element.prependChild(textChild);
        element.prependChild(child2);
        element.prependChild(child1);

        List<Node> children = element.childNodes();
        assertEquals(3, children.size());
        assertSame(child1, children.get(0));
        assertSame(child2, children.get(1));
        assertSame(textChild, children.get(2));
    }
}