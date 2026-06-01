package generated;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementTest {

    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element("div", "http://example.com");
        element.append("<p>Paragraph 1</p><span>Span 1</span><p>Paragraph 2</p>");
    }

    @Test
    public void testGetElementsByTag() {
        Elements paragraphs = element.getElementsByTag("p");

        assertEquals(2, paragraphs.size());
        assertTrue(paragraphs.get(0).text().equals("Paragraph 1"));
        assertTrue(paragraphs.get(1).text().equals("Paragraph 2"));
    }
}