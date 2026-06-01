package generated;

import java.util.Collections;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElementGetElementsByTagTest {

    private Element parentElement;
    private Element childElement1;
    private Element childElement2;
    
    @BeforeEach
    public void setUp() {
        // Create mock elements using Mockito
        parentElement = mock(Element.class);
        
        childElement1 = mock(Element.class);
        when(childElement1.tagName()).thenReturn("DIV");
        
        childElement2 = mock(Element.class);
        when(childElement2.tagName()).thenReturn("SPAN");

        Elements childrenElements = mock(Elements.class);
        // Add children to the elements
        when(childrenElements.asList()).thenReturn(java.util.Arrays.asList(childElement1, childElement2));
        
        // Mock parent element with its children
        when(parentElement.children()).thenReturn(childrenElements);

        // Create a grandchild for childElement1
        Element grandChild = mock(Element.class);
        when(grandChild.tagName()).thenReturn("DIV");
        
        Elements childChildren = mock(Elements.class);
        when(childChildren.asList()).thenReturn(java.util.Arrays.asList(grandChild));

        when(childElement1.children()).thenReturn(childChildren);
    }

    @Test
    public void testGetElementsByTagWithMatchingTags() {
        // Call the method under test
        Elements elements = parentElement.getElementsByTag("div");
        
        // Verify that two elements are returned
        assertEquals(2, elements.size());
        
        // Check if the correct elements are retrieved
        assertTrue(elements.contains(childElement1));
        assertTrue(elements.contains(grandChild));
    }

    @Test
    public void testGetElementsByTagWithNoMatchingTags() {
        // Call the method under test with a non-existent tag
        Elements elements = parentElement.getElementsByTag("p");
        
        // Verify that no elements are returned
        assertEquals(0, elements.size());
    }

    @Test
    public void testGetElementsByTagCaseInsensitive() {
        // Call the method under test with uppercase tag name
        Elements elements = parentElement.getElementsByTag("SPAN");

        // Verify that one element is returned for case-insensitive match
        assertEquals(1, elements.size());

        // Check if the correct element is retrieved
        assertTrue(elements.contains(childElement2));
    }
}