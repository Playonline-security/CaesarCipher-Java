package CaesarCipher;

public class Cipher {
    private final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String applyCipher(String originalText, int key, boolean invert) {
        StringBuilder result = new StringBuilder();

        for (char c : originalText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                int originalIndex = LOWERCASE_ALPHABET.indexOf(c);
                int displacement = invert ? -key : key;
                int newIndex = (originalIndex + displacement + LOWERCASE_ALPHABET.length()) % LOWERCASE_ALPHABET.length();
                result.append(LOWERCASE_ALPHABET.charAt(newIndex));

            } else if (Character.isUpperCase(c)) {
                int originalIndex = UPPERCASE_ALPHABET.indexOf(c);
                int displacement = invert ? -key : key;
                int newIndex = (originalIndex + displacement + UPPERCASE_ALPHABET.length()) % UPPERCASE_ALPHABET.length();
                result.append(UPPERCASE_ALPHABET.charAt(newIndex));

            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

}
