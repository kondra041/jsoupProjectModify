package generated;

import java.util.LinkedList;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.tagentities.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseBodyFragment() {
        String bodyHtml = "<div><p>Hello World</p></div>";
        String baseUri = "http://example.com";
        
        Document document = Parser.parseBodyFragment(bodyHtml, baseUri);
        
        assertNotNull(document.body(), "The body should not be null.");
        assertEquals(1, document.body().children().size(), "There should be one child element in the body.");
        
        Element divElement = document.body().childNode(0);
        assertTrue(divElement.tagName().equals("div"), "The first child of the body should be a <div> tag.");
        
        Element pElement = divElement.childNode(0);
        assertTrue(pElement.tagName().equals("p"), "The first child of <div> should be a <p> tag.");
        
        TextNode textNode = (TextNode) pElement.childNode(0);
        assertNotNull(textNode, "There should be a text node inside the <p> element.");
        assertEquals("Hello World", textNode.text(), "The text content should be 'Hello World'.");
    }
}