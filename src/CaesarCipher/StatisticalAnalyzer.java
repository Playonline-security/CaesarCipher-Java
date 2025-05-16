package CaesarCipher;

import java.util.*;

public class StatisticalAnalyzer {

    private final Cipher cipher = new Cipher();
    private static final List<Character> FREQUENT_LETTERS = Arrays.asList(
            'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l'
    );

    public int findMostLikelyShift(String encryptedText) {
        Map<Character, Integer> frequencyMap = countLetterFrequencies(encryptedText.toLowerCase());
        if (frequencyMap.isEmpty()) {
            System.out.println("⚠️ No se encontraron letras para analizar.");
            return 0;
        }

        char mostCommonChar = getMostFrequentChar(frequencyMap);

        int bestKey = 0;
        int bestScore = Integer.MIN_VALUE;

        for (char referenceChar : FREQUENT_LETTERS) {
            int possibleKey = (mostCommonChar - referenceChar + 26) % 26;
            String attempt = cipher.applyCipher(encryptedText, possibleKey, true);
            int score = evaluateText(attempt);

            if (score > bestScore) {
                bestScore = score;
                bestKey = possibleKey;
            }
        }

        System.out.println("🔍 Letra más frecuente en texto cifrado: '" + mostCommonChar + "'");
        System.out.println("🔐 Clave estimada: " + bestKey);

        return bestKey;
    }

    private Map<Character, Integer> countLetterFrequencies(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }

    private char getMostFrequentChar(Map<Character, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('e');
    }

    private int evaluateText(String text) {
        String[] commonWords = {
                " el ", " la ", " de ", " en ", " que ", " y ", " los ", " se ", " por ", " con "
        };

        int count = 0;
        String lowerText = text.toLowerCase();

        for (String word : commonWords) {
            if (lowerText.contains(word)) {
                count++;
            }
        }

        return count;
    }
}
