import org.jsoup.nodes.Element;

public class ElementTest {

    @org.junit.jupiter.api.Test
    public void getDeepChildTest() {
        Element element = new Element("div");
        element.appendChild(new Element("p"));

        Element deepChild = getDeepChild(element);

        assertEquals("p", deepChild.tagName());
    }
}