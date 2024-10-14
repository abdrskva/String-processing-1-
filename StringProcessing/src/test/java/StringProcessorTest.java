
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    StringProcessor sp = new StringProcessor();

    // Test cases for isStrongPassword
    @Test
    public void testIsStrongPassword() {
        assertTrue(sp.isStrongPassword("Strong1!"), "Should be strong password");
        assertFalse(sp.isStrongPassword("weakpassword"), "Should not be strong password");
        assertFalse(sp.isStrongPassword("WEAKPASSWORD1"), "Should not be strong password");
        assertFalse(sp.isStrongPassword("Weak1!"), "Should not be strong password");
        assertFalse(sp.isStrongPassword("Str0ng!"), "Should not be strong password"); // Missing lowercase
    }

    // Test cases for calculateDigits
    @Test
    public void testCalculateDigits() {
        assertEquals(2, sp.calculateDigits("There are 3 apples and 2 bananas."), "Should count digits correctly");
        assertEquals(0, sp.calculateDigits("No digits here!"), "Should return 0 for no digits");
        assertEquals(5, sp.calculateDigits("12345"), "Should count all digits");
        assertEquals(1, sp.calculateDigits("One digit: 7."), "Should count single digit");
        assertEquals(6, sp.calculateDigits("Test 1, 2, 3, 4, 5, 6!"), "Should count all digits");
    }

    // Test cases for calculateWords
    @Test
    public void testCalculateWords() {
        assertEquals(5, sp.calculateWords("This is a test sentence."), "Should count words correctly");
        assertEquals(0, sp.calculateWords("   "), "Should return 0 for empty sentence");
        assertEquals(2, sp.calculateWords("Hello  world! "), "Should count words correctly");
        assertEquals(4, sp.calculateWords("  This  is  a   test.  "), "Should count words correctly");
        assertEquals(1, sp.calculateWords("Word"), "Should return 1 for single word");
    }

    // Test cases for calculateExpression
    @Test
    public void testCalculateExpression() {
        assertEquals(7.0, sp.calculateExpression("3 + 4"), 0.001, "Should evaluate simple addition");
        assertEquals(3.0, sp.calculateWords("5 * 3"), 0.001, "Should evaluate multiplication");
        assertEquals(3.0, sp.calculateWords("10 / 5"), 0.001, "Should evaluate division");
        assertEquals(3.0, sp.calculateWords("(4 + 4)"), 0.001, "Should evaluate expression in parentheses");
        assertEquals(5.0, sp.calculateWords("5 + 5 + 2"), 0.001, "Should evaluate multiple additions");
    }
}
