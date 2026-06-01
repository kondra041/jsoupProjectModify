package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class ElementTest {

    private Document doc;
    private Element element;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doc = mock(Document.class);
        element = new Element(Tag.valueOf("div"), "", doc, null);
    }

    @Test
    void appendChild_ShouldAddNodeToChildNodesList() {
        TextNode textNode = new TextNode(doc, "Text", "");
        element.appendChild(textNode);
        assertEquals(1, element.childNodes().size());
        assertTrue(element.childNodes().contains(textNode));
    }

    @Test
    void html_ShouldReturnInnerHTML() {
        TextNode textNode = new TextNode(doc, "Text", "");
        element.appendChild(textNode);
        assertEquals("<p>Text</p>", element.html());
    }

    @Test
    void className_ShouldReturnClassNames() {
        element.attr("class", "header gray");
        Set<String> expected = new HashSet<>();
        expected.add("header");
        expected.add("gray");
        assertEquals(expected, element.className());
    }

    @Test
    void classNames_ShouldUpdateClassNames() {
        element.attr("class", "header gray");
        Set<String> updated = new HashSet<>();
        updated.add("new-class");
        element.classNames(updated);
        assertEquals("<div class=\"new-class\"></div>", element.outerHtml());
    }

    @Test
    void val_ShouldReturnValueOfFormElement() {
        element = new Element(Tag.valueOf("input"), "", doc, null);
        element.attr("type", "text").attr("value", "sample");
        assertEquals("sample", element.val());
    }

    @Test
    void val_ShouldSetValueOfFormElement() {
        element = new Element(Tag.valueOf("input"), "", doc, null);
        element.attr("type", "text").val("new-value");
        assertEquals("<input type=\"text\" value=\"new-value\"></input>", element.outerHtml());
    }
}