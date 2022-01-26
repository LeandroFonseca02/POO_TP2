package JUnit;

import Exceptions.ImpossibleCalculateException;
import helperClasses.Regex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    void regex() throws ImpossibleCalculateException {
        Regex regex = new Regex("(A),[B],{C}");
        assertEquals("A", regex.regex().get(0));
        assertEquals("B", regex.regex().get(1));
        assertEquals("C", regex.regex().get(2));
    }

    @Test
    void isNumber() {
        String a = "1";
        String b = "um numero";
        assertTrue(Regex.isNumber(a));
        assertFalse(Regex.isNumber(b));
    }
}