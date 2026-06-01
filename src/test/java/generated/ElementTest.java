package generated;

import org.junit.jupiter.api.Test;
import java.util.*;

class JsoupElementTest {

	@Test
	void test() {
		org.jsoup.nodes.Element element = new org.jsoup.nodes.Element("div");
		
		element.attr("id", "my-id");
		assert element.attr("id").equals("my-id");
		
		element.html("<p>Hello world</p>");
		assert element.html().equals("<div><p>Hello world</p></div>");
		
		element.text("Hello world");
		assert element.text().equals("Hello world");
	}
}