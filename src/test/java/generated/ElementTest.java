package generated;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashSet;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementPrependChildTest {

    @Test
    public void testPrependChild() {
        // Create a mock node and an element
        Node child = mock(Node.class);
        Element parent = new Element(Tag.valueOf("div"), "");

        // Prepend the child to the parent's children
        Element result = parent.prependChild(child);

        // Verify that the child was added to the beginning of the parent's children
        assertEquals(parent, result);
        assertEquals(child, parent.childNode(0));
    }
}