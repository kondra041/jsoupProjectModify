package generated;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element("div");
    }

    @Test
    public void testGetDeepChildWithChildren() {
        // Arrange
        Element child1 = new Element("p");
        Element child2 = new Element("span");
        element.appendChild(child1);
        child1.appendChild(child2);

        // Act
        Element deepChild = element.getDeepChild(element);

        // Assert
        assertNotNull(deepChild);
        assertEquals("span", deepChild.tagName());
    }

    @Test
    public void testGetDeepChildWithNoChildren() {
        // Arrange

        // Act
        Element deepChild = element.getDeepChild(element);

        // Assert
        assertNotNull(deepChild);
        assertEquals("div", deepChild.tagName());
    }
}