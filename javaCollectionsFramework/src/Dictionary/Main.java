package Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();

        dict.addWord("hello", "привіт");
        dict.addWord("world", "світ");

        String translateWord = dict.getTranslations("hello").toString();
        System.out.println(translateWord);

        dict.replaceTranslation("hello", "привіт", "вітаю");

        System.out.println("Top words: " + dict.getTopWords(true));
    }
}
