import java.util.Scanner;

public class ROT13Cipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt or decrypt: ");
        String inputText = scanner.nextLine();

        String encryptedText = encrypt(inputText);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char encryptedChar = (char) (base + (character - base + 13) % 26);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text) {
        return encrypt(text); // ROT13 is self-reversible
    }
}
