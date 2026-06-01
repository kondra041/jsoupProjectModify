import org.jsoup.nodes.Element;

public class ElementAppendChildTest {

    @Test
    public void appendChildTest() {
        // Create an element
        Element element = new Element("div");

        // Create a child node
        Element childNode = new Element("p");

        // Append the child node to the element
        element.appendChild(childNode);

        // Assert that the child node is appended to the element
        assertEquals(childNode, element.childNodes().get(0));
    }
}