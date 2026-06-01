package generated;

import org.jsoup.nodes.Element;
import java.util.List;

public class JsoupTest {

    private Element element;

    public void setUp() {
        element = new Element("div");
    }

    public void testGetDeepChild() {
        Element child1 = new Element("p");
        Element child2 = new Element("span");
        element.appendChild(child1);
        element.appendChild(child2);

        Element deepChild = getDeepChild(element);

        assertEquals(deepChild, child2);
    }
}