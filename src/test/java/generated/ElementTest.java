import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {
    @Test
    public void testGetDeepChild() throws Exception {
        // Create a mock Element for testing
        Element mockElement = mock(Element.class);

        // Define the behavior of the mockElement's children method
        List<Element> childElements = List.of(mock(Element.class), mock(Element.class));
        when(mockElement.children()).thenReturn(childElements);

        // Call the getDeepChild method with the mockElement
        Element deepChild = getDeepChild(mockElement);

        // Verify that the children method of the first child element was called
        verify(childElements.get(0)).children();
    }
}