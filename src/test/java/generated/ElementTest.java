package generated;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Tag;
import org.jsoup.parser.TagType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        Tag tag = mock(Tag.class);
        when(tag.getName()).thenReturn("div");
        element = new Element(tag, "http://example.com");
    }

    @Test
    public void testGetDeepChildWithNoChildren() {
        Element result = element.getDeepChild(element);
        assertEquals(element, result);
    }

    @Test
    public void testGetDeepChildWithOneLevelOfChildren() {
        Element child = new Element(Tag.valueOf("p"), "http://example.com");
        element.appendChild(child);

        Element result = element.getDeepChild(element);
        assertEquals(child, result);
    }

    @Test
    public void testGetDeepChildWithMultipleLevelsOfChildren() {
        Element child1 = new Element(Tag.valueOf("p"), "http://example.com");
        Element child2 = new Element(Tag.valueOf("span"), "http://example.com");
        element.appendChild(child1);
        child1.appendChild(child2);

        Element result = element.getDeepChild(element);
        assertEquals(child2, result);
    }
}