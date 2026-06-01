package generated;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Tag;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        Tag tag = mock(Tag.class);
        when(tag.getName()).thenReturn("div");
        Document doc = new Document("");
        element = spy(new Element(tag, doc));
        doReturn("id").when(element).getElementId();
    }

    @Test
    public void testGetElementByIdSelfMatch() {
        String id = "test";
        Elements elements = mock(Elements.class);
        when(elements.size()).thenReturn(1);
        when(elements.get(0)).thenReturn(element);

        Element result = element.getElementById(id);
        
        verify(tag, times(1)).getName();
        verify(element).getElementId();
        assertTrue(result == element); // should return self as it matches the ID
    }

    @Test
    public void testGetElementByIdNoMatch() {
        String id = "test";
        Elements elements = mock(Elements.class);
        when(elements.size()).thenReturn(0);

        Element result = element.getElementById(id);
        
        verify(tag, times(1)).getName();
        verify(element).getElementId();
        assertNull(result); // should return null as there is no match
    }

    @Test
    public void testGetElementByIdMatchFromChildren() {
        String id = "test";
        Element childElement = mock(Element.class);
        
        when(childElement.getElementById(id)).thenReturn(null);

        Set<Node> nodes = new HashSet<>();
        nodes.add(childElement);
        element.childNodes().addAll(nodes); // adding child element to node list
        
        Elements elements = mock(Elements.class);
        when(elements.size()).thenReturn(1);
        when(elements.get(0)).thenReturn(childElement);
        
        when(childElement.getElementById(id)).thenReturn(mock(Element.class));
        
        Element result = element.getElementById(id);
        
        verify(tag, times(1)).getName();
        verify(element).getElementId();
        assertNotNull(result); // should return childElement as it matches the ID
    }

}