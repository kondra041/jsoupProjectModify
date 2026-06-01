package generated;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementGetElementsByTagTest {

    @Test
    public void testGetElementsByTagName() {
        // Create an HTML string with a paragraph tag
        String html = "<p>Hello World!</p>";

        // Parse the HTML and get the document element
        Document doc = Jsoup.parse(html);
        Element root = doc.body();

        // Get the elements by tag name
        Elements paragraphs = root.getElementsByTag("p");

        // Check if the size of the list is correct
        assertEquals(1, paragraphs.size());

        // Get the text content of the paragraph element
        String text = paragraphs.first().text();

        // Check if the text matches the expected value
        assertEquals("Hello World!", text);
    }

    @Test
    public void testGetElementsByTagNameIgnoreCase() {
        // Create an HTML string with a paragraph tag (case-insensitive)
        String html = "<P>Hello World!</p>";

        // Parse the HTML and get the document element
        Document doc = Jsoup.parse(html);
        Element root = doc.body();

        // Get the elements by tag name (case-insensitive)
        Elements paragraphs = root.getElementsByTag("p");

        // Check if the size of the list is correct
        assertEquals(1, paragraphs.size());

        // Get the text content of the paragraph element
        String text = paragraphs.first().text();

        // Check if the text matches the expected value
        assertEquals("Hello World!", text);
    }

    @Test
    public void testGetElementsByTagNameEmptyList() {
        // Create an HTML string with no paragraph tags
        String html = "<div>Hello World!</div>";

        // Parse the HTML and get the document element
        Document doc = Jsoup.parse(html);
        Element root = doc.body();

        // Get the elements by tag name
        Elements paragraphs = root.getElementsByTag("p");

        // Check if the size of the list is correct
        assertEquals(0, paragraphs.size());
    }
}