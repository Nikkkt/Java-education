package Cipher;

public class Main {
    public static void main(String[] args) {
        String original = "Hello World!";
        ICipher aCipher = new ACipher();
        ICipher bCipher = new BCipher();

        System.out.println("Оригінал: " + original);

        String aEncoded = aCipher.encode(original);
        String aDecoded = aCipher.decode(aEncoded);
        System.out.println("ACipher Encoded: " + aEncoded);
        System.out.println("ACipher Decoded: " + aDecoded);

        String bEncoded = bCipher.encode(original);
        String bDecoded = bCipher.decode(bEncoded);
        System.out.println("BCipher Encoded: " + bEncoded);
        System.out.println("BCipher Decoded: " + bDecoded);
    }
}
