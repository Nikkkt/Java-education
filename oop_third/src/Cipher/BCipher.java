package Cipher;

public class BCipher implements ICipher {

    @Override
    public String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char encoded = (char) ('Z' - (ch - 'A'));
                    sb.append(encoded);
                } else {
                    char encoded = (char) ('z' - (ch - 'a'));
                    sb.append(encoded);
                }
            }
            else sb.append(ch);
        }
        return sb.toString();
    }

    @Override
    public String decode(String input) { return encode(input); }
}
