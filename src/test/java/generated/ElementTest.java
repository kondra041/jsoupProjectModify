package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Set;

public class ElementTest {
    @org.junit.jupiter.api.Test
    public void testGetElementsByTag() {
        // Arrange
        Element element = mock(Element.class);
        String tagName = "div";
        Elements expectedResult = new Elements();
        when(element.getElementsByTag(tagName)).thenReturn(expectedResult);

        // Act
        Elements actualResult = element.getElementsByTag(tagName);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    public void testClassNames() {
        // Arrange
        Element element = mock(Element.class);
        Set<String> expectedResult = Set.of("class1", "class2");
        when(element.classNames()).thenReturn(expectedResult);

        // Act
        Set<String> actualResult = element.classNames();

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}