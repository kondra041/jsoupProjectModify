package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementPrependChildTest {

    private Element element;
    private Node childNode;
    private List<Node> childNodes;

    @BeforeEach
    public void setUp() {
        // Initialize the Element with an empty list of child nodes.
        this.childNodes = new ArrayList<>();
        this.element = spy(new Element("div", null, childNodes));
        
        // Mock a Node that doesn't have a parent initially.
        this.childNode = mock(Node.class);
        when(childNode.parentNode()).thenReturn(null);
    }

    @Test
    public void testPrependChild_AddsNodeAtStart() {
        element.prependChild(childNode);

        // Verify the child node was added at the start of the list.
        verify(childNodes).add(0, childNode);
        
        // Ensure that the parent of the child is set correctly.
        verify(childNode).setParentNode(element);
    }

    @Test
    public void testPrependChild_ReturnsElementForChaining() {
        Element returnedElement = element.prependChild(childNode);

        // Verify that the method returns the same instance for chaining.
        assertSame(element, returnedElement);
    }
    
    @Test
    public void testPrependChild_ThrowsExceptionOnNullChild() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            element.prependChild(null);
        });

        String expectedMessage = "Child node must not be null";
        assertEquals(expectedMessage, exception.getMessage());
    }

}