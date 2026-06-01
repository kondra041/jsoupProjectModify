package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setup() {
        element = new Element("div", "", Parser.parse(new String("<div></div>")));
    }

    @Test
    public void testGetDeepChild_WhenParentHasNoChildren_ReturnsParent() {
        // Arrange

        // Act
        Element child = getDeepChild(element);

        // Assert
        assertEquals(element, child);
    }

    @Test
    public void testGetDeepChild_WhenParentHasOneChild_ReturnsGrandchild() {
        // Arrange
        TextNode textNode = new TextNode("Hello", "");
        element.appendChild(textNode);

        Element grandchild = new Element("p", "", Parser.parse(new String("<div><p>Hello</p></div>")));
        textNode.appendChild(grandchild);

        // Act
        Element child = getDeepChild(element);

        // Assert
        assertEquals(grandchild, child);
    }

    private Element getDeepChild(Element el) {
        List<Element> children = el.children();
        if (children.size() > 0)
            return getDeepChild(children.get(0));
        else
            return el;
    }
}