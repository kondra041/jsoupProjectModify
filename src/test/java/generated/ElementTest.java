import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ElementTest {

    public void test_getElementById() {
        Document document = new Document("html", "<div id='target'>Target</div>");
        Element element = document.getElementById("target");

        assertEquals("Target", element.text());
    }
}