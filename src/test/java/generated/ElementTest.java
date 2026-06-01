package generated;

import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    @Test
    public void testGetDeepChild() {
        // Arrange
        Element parent = mock(Element.class);
        Element child1 = mock(Element.class);
        Element child2 = mock(Element.class);
        Element grandchild = mock(Element.class);
        
        when(parent.children()).thenReturn(Arrays.asList(child1, child2));
        when(child1.children()).thenReturn(Collections.emptyList());
        when(child2.children()).thenReturn(Arrays.asList(grandchild));
        when(grandchild.children()).thenReturn(Collections.emptyList());
        
        // Act
        Element result = getDeepChild(parent);
        
        // Assert
        assertEquals(grandchild, result);
    }
    
    private Element getDeepChild(Element el) {
        List<Element> children = el.children();
        if (children.size() > 0)
            return getDeepChild(children.get(0));
        else
            return el;
    }
}