package generated;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementGetDeepChildTest {

    private Element rootElement;

    @BeforeEach
    void setUp() {
        Document doc = mock(Document.class);
        when(doc.baseUri()).thenReturn("http://example.com");
        rootElement = new Element(Tag.valueOf("root"), doc);
        
        // Create nested structure for testing
        Element child1 = new Element(Tag.valueOf("child1"), doc);
        Element child2 = new Element(Tag.valueOf("child2"), doc);
        rootElement.appendChild(child1);
        child1.appendChild(child2);
    }

    @Test
    void testGetDeepChild() {
        // Test case where the element already has a deep child structure
        assertSame(rootElement.getDeepChild(child1), child2);

        // Test with an element that doesn't have any children should return itself
        Element noChildren = new Element(Tag.valueOf("noChildren"), rootElement.ownerDocument());
        assertEquals(noChildren, noChildren.getDeepChild(noChildren));
    }

    @Test
    void testGetDeepChildEdgeCases() {
        // Test with only one child (should return that child)
        rootElement.removeChild(rootElement.childNode(0)); // Remove original child1
        Element newChild = new Element(Tag.valueOf("newSingleChild"), rootElement.ownerDocument());
        rootElement.appendChild(newChild);
        
        assertSame(rootElement.getDeepChild(rootElement), newChild);

        // Test with an empty list of children (should return the element itself)
        rootElement.removeChild(newChild); // Remove single child
        assertSame(rootElement, rootElement.getDeepChild(rootElement));
    }
}