package generated;

import java.util.List;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementTest {

    @Test
    public void testGetDeepChild_ReturnsLeafElement_WhenSingleLevel() {
        // Arrange
        Element leaf = mock(Element.class);
        List<Element> children = List.of();
        when(leaf.children()).thenReturn(children);

        // Act
        Element result = getDeepChild(leaf);

        // Assert
        assertEquals(leaf, result);
    }

    @Test
    public void testGetDeepChild_ReturnsInnermostLeaf_WhenMultiLevel() {
        // Arrange
        Element deepestLeaf = mock(Element.class);
        List<Element> childrenOfDeepest = List.of();
        when(deepestLeaf.children()).thenReturn(childrenOfDeepest);

        Element intermediateElement = mock(Element.class);
        List<Element> childrenOfIntermediate = List.of(deepestLeaf);
        when(intermediateElement.children()).thenReturn(childrenOfIntermediate);

        // Act
        Element result = getDeepChild(intermediateElement);

        // Assert
        assertEquals(deepestLeaf, result);
    }

    @Test
    public void testGetDeepChild_ReturnsSelf_WhenNoChildren() {
        // Arrange
        Element elementWithNoChildren = mock(Element.class);
        List<Element> childrenOfElement = List.of();
        when(elementWithNoChildren.children()).thenReturn(childrenOfElement);

        // Act
        Element result = getDeepChild(elementWithNoChildren);

        // Assert
        assertEquals(elementWithNoChildren, result);
    }

    private Element getDeepChild(Element el) {
        List<Element> children = el.children();
        if (children.size() > 0)
            return getDeepChild(children.get(0));
        else
            return el;
    }
}