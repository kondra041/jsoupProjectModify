package generated;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElementAppendChildTest {

    @Test
    public void testAppendChild() {
        // Arrange
        Element parent = new Element("div");
        Node child1 = new Node("p", 0, parent);
        Node child2 = new Node("span", 0, parent);

        // Act
        parent.appendChild(child1);
        parent.appendChild(child2);

        // Assert
        assertEquals(2, parent.childNodes().size());
        assertEquals(child1, parent.childNodes().get(0));
        assertEquals(child2, parent.childNodes().get(1));
    }

    @Test
    public void testAppendChildWithNull() {
        // Arrange
        Element parent = new Element("div");

        // Act & Assert
        assertThrows(NullPointerException.class, () -> parent.appendChild(null));
    }

    @Test
    public void testAppendChildWithNonParentlessNode() throws Exception {
        // Arrange
        Node child = new Node("p", 0, null);
        Element parent = new Element("div");

        try {
            // Act
            parent.appendChild(child);

            // Assert
            assertEquals(parent, child.parentNode());
        } finally {
            // Clean up to ensure no side effects on subsequent tests
            child.setParentNode(null);
        }
    }

    @Test
    public void testAppendChildMultipleChildren() throws Exception {
        // Arrange
        Element parent = new Element("div");
        Node child1 = new Node("p", 0, null);
        Node child2 = new Node("span", 0, null);
        Node child3 = new Node("a", 0, null);

        try {
            // Act
            parent.appendChild(child1);
            parent.appendChild(child2);
            parent.appendChild(child3);

            // Assert
            assertEquals(3, parent.childNodes().size());
            assertEquals(child1, parent.childNodes().get(0));
            assertEquals(child2, parent.childNodes().get(1));
            assertEquals(child3, parent.childNodes().get(2));

        } finally {
            // Clean up to ensure no side effects on subsequent tests
            child1.setParentNode(null);
            child2.setParentNode(null);
            child3.setParentNode(null);
        }
    }

    @Test
    public void testAppendChildRepeatedly() throws Exception {
        // Arrange
        Element parent = new Element("div");
        Node child = new Node("p", 0, null);

        try {
            // Act
            for (int i = 0; i < 5; i++) {
                parent.appendChild(child);
            }

            // Assert
            assertEquals(1, parent.childNodes().size());
            assertEquals(child, parent.childNodes().get(0));
            assertEquals(parent, child.parentNode());

        } finally {
            // Clean up to ensure no side effects on subsequent tests
            child.setParentNode(null);
        }
    }
}