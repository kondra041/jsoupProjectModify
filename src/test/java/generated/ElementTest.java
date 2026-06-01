package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementPrependChildTest {

    private Document doc;
    private Element parentElement;
    private Node childNode;

    @BeforeEach
    public void setUp() {
        doc = new Document("<html><head></head><body></body></html>", Parser.htmlParser());
        parentElement = new Element("div", "http://example.com");
        childNode = new org.jsoup.nodes.TextNode("Hello, ", "http://example.com");
    }

    @Test
    public void testPrependChild() {
        // Act
        parentElement.prependChild(childNode);

        // Assert
        assertEquals(1, parentElement.childNodes().size());
        assertSame(childNode, parentElement.child(0));
        assertTrue(parentElement.child(0) instanceof TextNode);
        assertEquals("Hello, ", ((TextNode) parentElement.child(0)).text());
    }

    @Test
    public void testPrependChildWithExistingChildren() {
        // Arrange
        Element existingChild = new Element("span", "http://example.com");
        parentElement.appendChild(existingChild);

        // Act
        parentElement.prependChild(childNode);

        // Assert
        assertEquals(2, parentElement.childNodes().size());
        assertSame(childNode, parentElement.child(0));
        assertTrue(parentElement.child(0) instanceof TextNode);
        assertEquals("Hello, ", ((TextNode) parentElement.child(0)).text());
        assertSame(existingChild, parentElement.child(1));
    }
}