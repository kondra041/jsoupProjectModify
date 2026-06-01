package generated;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElementGetElementByIdTest {

    @Mock
    private Element parentElement;
    @Mock
    private Element childElement1;
    @Mock
    private Element childElement2;

    @Test
    public void testGetElementByIdFound() {
        when(childElement1.id()).thenReturn("desiredId");
        when(parentElement.children()).thenReturn(new Elements(childElement1, childElement2));

        Element result = parentElement.getElementById("desiredId");

        assertEquals(childElement1, result);
    }

    @Test
    public void testGetElementByIdNotFound() {
        when(parentElement.children()).thenReturn(new Elements());

        Element result = parentElement.getElementById("nonExistentId");

        assertNull(result);
    }
}