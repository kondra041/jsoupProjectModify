package generated;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementTest {

    @Test
    void testPrependChild() {
        // Arrange
        Attributes attributes = mock(Attributes.class);
        Document document = mock(Document.class);
        Element parentElement = new Element("div", document, attributes);
        
        TextNode textNode1 = mock(TextNode.class);
        TextNode textNode2 = mock(TextNode.class);

        when(textNode1.getWholeText()).thenReturn("text1");
        when(textNode2.getWholeText()).thenReturn("text2");

        // Act
        parentElement.prependChild(textNode1);
        parentElement.prependChild(textNode2);

        // Assert
        assertEquals(2, parentElement.childNodes().size());
        assertEquals(textNode2, parentElement.childNode(0));
        assertEquals(textNode1, parentElement.childNode(1));

        verify(textNode1).setParentNode(parentElement);
        verify(textNode2).setParentNode(parentElement);

        // Test toString and outerHtml methods
        StringBuilder accum = new StringBuilder();
        parentElement.outerHtml(accum);
        String expectedOuterHtml = "<div><#text text2></#text><#text text1></#text></div>";
        assertEquals(expectedOuterHtml.trim(), accum.toString().trim());
    }
}