import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Whitebox;

public class ElementTest {

    @Mock
    private Element mockElement;

    @Test
    public void testGetDeepChildNoChildren() {
        when(mockElement.children()).thenReturn(Collections.emptyList());
        
        Object result = Whitebox.invokeMethod(mockElement, "getDeepChild", mockElement);
        
        assertEquals(mockElement, result);
    }

    @Test
    public void testGetDeepChildOneChild() {
        Element child1 = mock(Element.class);
        when(child1.children()).thenReturn(Collections.emptyList());
        when(mockElement.children()).thenReturn(Collections.singletonList(child1));
        
        Object result = Whitebox.invokeMethod(mockElement, "getDeepChild", mockElement);
        
        assertEquals(child1, result);
    }

    @Test
    public void testGetDeepChildChain() {
        Element child1 = mock(Element.class);
        Element child2 = mock(Element.class);
        when(child2.children()).thenReturn(Collections.emptyList());
        when(child1.children()).thenReturn(Collections.singletonList(child2));
        when(mockElement.children()).thenReturn(Collections.singletonList(child1));
        
        Object result = Whitebox.invokeMethod(mockElement, "getDeepChild", mockElement);
        
        assertEquals(child2, result);
    }

    @Test
    public void testGetDeepChildMultipleBranches() {
        Element child1 = mock(Element.class);
        Element child2 = mock(Element.class);
        when(child1.children()).thenReturn(Collections.singletonList(child2));
        when(child2.children()).thenReturn(Collections.emptyList());
        
        // First child is child1, which has a deeper subtree
        when(mockElement.children()).thenReturn(Arrays.asList(child1, child2));
        
        Object result = Whitebox.invokeMethod(mockElement, "getDeepChild", mockElement);
        
        assertEquals(child2, result);
    }
}