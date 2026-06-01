import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class ElementPrependChildTest {

    @org.junit.jupiter.api.Test
    public void testPrependChild() {
        // Create a new element
        Element element = new Element("div");

        // Create a new child node
        Node childNode = new Element("p");

        // Prepend the child node to the element
        element.prependChild(childNode);

        // Verify that the child node is the first child of the element
        assertEquals(childNode, element.childNodes().get(0));
    }
}