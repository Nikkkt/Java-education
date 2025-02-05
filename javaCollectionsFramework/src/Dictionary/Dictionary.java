package Dictionary;

import java.util.*;

class Dictionary {
    private Map<String, Set<String>> words = new HashMap<>();
    private Map<String, Integer> popularity = new HashMap<>();

    public void addWord(String word, String translation) {
        words.computeIfAbsent(word, k -> new HashSet<>()).add(translation);
        popularity.put(word, 0);
    }

    public Set<String> getTranslations(String word) {
        popularity.put(word, popularity.getOrDefault(word, 0) + 1);
        return words.getOrDefault(word, Collections.emptySet());
    }

    public void removeWord(String word) {
        words.remove(word);
        popularity.remove(word);
    }

    public void replaceTranslation(String word, String oldTranslation, String newTranslation) {
        if (words.containsKey(word)) {
            words.get(word).remove(oldTranslation);
            words.get(word).add(newTranslation);
        }
    }

    public List<String> getTopWords(boolean mostPopular) {
        return popularity.entrySet().stream()
                .sorted((a, b) -> mostPopular ? b.getValue() - a.getValue() : a.getValue() - b.getValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }
}
