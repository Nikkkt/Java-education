package Cipher;

public class ACipher implements ICipher {

    @Override
    public String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char encoded = (char) (((ch - 'A' + 1) % 26) + 'A');
                    sb.append(encoded);
                } else {
                    char encoded = (char) (((ch - 'a' + 1) % 26) + 'a');
                    sb.append(encoded);
                }
            }
            else sb.append(ch);
        }
        return sb.toString();
    }

    @Override
    public String decode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char decoded = (char) (((ch - 'A' - 1 + 26) % 26) + 'A');
                    sb.append(decoded);
                } else {
                    char decoded = (char) (((ch - 'a' - 1 + 26) % 26) + 'a');
                    sb.append(decoded);
                }
            } else sb.append(ch);
        }
        return sb.toString();
    }
}
