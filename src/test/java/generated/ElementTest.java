import org.jsoup.nodes.Element;
import org.jsoup.nodes.Elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetElementsByTagTest {

    @Test
    public void shouldReturnMatchingElements() {
        // Create an element with the tag "div".
        Element element = new Element("div");

        // Create a new element with the tag "p".
        Element pElement = new Element("p");

        // Add the p element to the div element.
        element.appendChild(pElement);

        // Get the elements by tag name.
        Elements elements = element.getElementsByTag("p");

        // Assert that the elements list contains the p element.
        assertEquals(1, elements.size());
        assertEquals(pElement, elements.get(0));
    }
}