package generated;

import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ElementTest {

    @Mock
    private Collector collector;

    private Element element;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        element = new Element("div");
    }

    @Test
    public void testGetElementsByTag() {
        // Arrange
        String tagName = "p";
        Evaluator evaluator = new Evaluator.Tag(tagName);
        Elements expectedElements = new Elements();
        when(collector.collectElements(evaluator, element)).thenReturn(expectedElements);

        // Act
        Elements result = element.getElementsByTag(tagName);

        // Assert
        assertEquals(expectedElements, result);
    }
}