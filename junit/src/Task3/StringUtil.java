package Task3;

public class StringUtil {

    public static boolean isPalindrome(String text) {
        if(text == null) throw new IllegalArgumentException("Text cannot be null");
        String cleaned = text.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(cleaned).reverse();
        return cleaned.equals(reversed.toString());
    }

    public static int countVowels(String text) {
        if(text == null) throw new IllegalArgumentException("Text cannot be null");
        int count = 0;
        String vowels = "aeiouAEIOU";
        for(char c : text.toCharArray()) if(Character.isLetter(c) && vowels.indexOf(c) == -1) count++;
        return count;
    }

    public static int countConsonants(String text) {
        if (text == null) throw new IllegalArgumentException("Text cannot be null");
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : text.toCharArray()) if (Character.isLetter(c) && vowels.indexOf(c) != -1) count++;
        return count;
    }

    public static int countWordOccurrences(String text, String word) {
        if(text == null || word == null || word.isEmpty()) throw new IllegalArgumentException("Text and word cannot be null/empty");
        String[] words = text.split("\\W+");
        int count = 0;
        for(String w : words) if(w.equalsIgnoreCase(word)) count++;
        return count;
    }
}