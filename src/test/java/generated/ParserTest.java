package generated;

import org.jsoup.parser.Parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParserTest {
    
    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "This is a body fragment";
        String baseUri = "http://example.com/";
        
        // Mock the Document and Element classes
        Document mockDocument = Mockito.mock(Document.class);
        Element mockElement = Mockito.mock(Element.class);
        when(mockDocument.createElement("body")).thenReturn(mockElement);
        when(mockElement.appendChild(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        
        // Create a new Parser instance and call the parseBodyFragment method
        Parser parser = new Parser();
        Document document = parser.parseBodyFragment(bodyHtml, baseUri);
        
        // Verify that the parseBodyFragment method was called with the correct arguments
        verify(mockDocument).createElement("body");
        verify(mockElement).appendChild(any());
        
        // Check if the returned Document instance is not null
        assertNotNull(document);
    }
}