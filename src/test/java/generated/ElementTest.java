import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

class ElementTest {

    @Test
    void appendTextNode() {
        // Create a div element
        Element div = new Element(Tag.valueOf("div"), "");
        
        // Create and append a text node
        TextNode textNode = new TextNode("test", "");
        div.appendChild(textNode);

        // Verify the text node is added as a child
        assertEquals(1, div.childNodes().size());
        assertEquals(textNode, div.childNodes().get(0));
        
        // Check parent reference
        assertEquals(div, textNode.parent());
    }

    @Test
    void appendElement() {
        // Create parent and child elements
        Element parent = new Element(Tag.valueOf("div"), "");
        Element child = new Element(Tag.valueOf("p"), "");

        // Append child to parent
        parent.appendChild(child);

        // Verify child is added and has correct parent
        assertEquals(1, parent.childNodes().size());
        assertEquals(child, parent.childNodes().get(0));
        assertEquals(parent, child.parent());
    }

    @Test
    void appendNodeWithExistingParent() {
        Element div1 = new Element(Tag.valueOf("div"), "");
        TextNode text = new TextNode("test", "");
        div1.appendChild(text);

        Element div2 = new Element(Tag.valueOf("div"), "");
        div2.appendChild(text);

        // After appending to div2, parent should be div2
        assertEquals(div2, text.parent());
    }
}