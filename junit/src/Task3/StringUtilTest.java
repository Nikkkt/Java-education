package Task3;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testIsPalindromeTrue() {
        assertTrue(StringUtil.isPalindrome("Madam"));
        assertTrue(StringUtil.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testIsPalindromeFalse() {
        assertFalse(StringUtil.isPalindrome("Hello"));
    }

    @Test
    public void testCountVowels() {
        assertEquals(3, StringUtil.countVowels("Hello"));
        assertEquals(5, StringUtil.countVowels("Education"));
    }

    @Test
    public void testCountConsonants() {
        assertEquals(2, StringUtil.countConsonants("Hi"));
        assertEquals(4, StringUtil.countConsonants("Hello"));
    }

    @Test
    public void testCountWordOccurrences() {
        String text = "Java is fun. I love Java!";
        assertEquals(2, StringUtil.countWordOccurrences(text, "java"));
        assertEquals(1, StringUtil.countWordOccurrences(text, "fun"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTextInPalindrome() {
        StringUtil.isPalindrome(null);
    }
}