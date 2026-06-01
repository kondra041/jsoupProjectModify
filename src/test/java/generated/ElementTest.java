package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {
    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element("div", "");
    }

    @Test
    public void testPrependChild() {
        Node child = mock(Node.class);
        element.prependChild(child);

        assertNotNull(element.childNodes());
        assertEquals(1, element.childNodes().size());
        assertEquals(0, element.siblingIndex());
    }
}