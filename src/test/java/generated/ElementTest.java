import org.jsoup.nodes.Element;

public class ElementTest {

    @Test
    public void testEquals() {
        Element element1 = new Element("div");
        Element element2 = new Element("div");

        assertEquals(element1, element2); // Pass

        element1.attr("id", "test-id");

        assertNotEquals(element1, element2); // Fail
    }
}