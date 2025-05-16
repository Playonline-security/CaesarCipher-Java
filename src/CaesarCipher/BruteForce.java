package CaesarCipher;

public class BruteForce {

    private final String[] COMMON_WORDS = {
            " the ", " and ", " of ", " to ", " a ", " in ", " that ", " is ",
            " was ", " he ", " for ", " it ", " with ", " as ", " his ", " on ",
            " be ", " at ", " by ", " i "
    };

    private final Cipher cipher = new Cipher();

    public String decryptByBruteForce(String encryptedText) {
        int bestKey = 0;
        int maxHits = -1;
        String bestResult = "";

        for (int key = 1; key <= 25; key++) {
            String attempt = cipher.applyCipher(encryptedText, key, true);
            int hits = countCommonWords(attempt);

            if (hits > maxHits) {
                maxHits = hits;
                bestKey = key;
                bestResult = attempt;
            }
        }

        System.out.println("🔍 Clave encontrada por fuerza bruta: " + bestKey);
        return bestResult;
    }

    private int countCommonWords(String text) {
        String lower = text.toLowerCase();
        int count = 0;
        for (String word : COMMON_WORDS) {
            if (lower.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
