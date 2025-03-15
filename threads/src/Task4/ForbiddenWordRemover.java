package Task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ForbiddenWordRemover implements Runnable {
    private CountDownLatch latch;
    private int forbiddenWordsRemovedCount;
    private File mergedFile = new File("merged.txt");
    private File cleanedFile = new File("cleaned.txt");

    public ForbiddenWordRemover(CountDownLatch latch) { this.latch = latch; }

    @Override
    public void run() {
        try {
            latch.await();
            List<String> forbiddenWords = loadForbiddenWords();
            processFile(forbiddenWords);
        }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private List<String> loadForbiddenWords() {
        List<String> forbiddenWords = new ArrayList<>();
        File forbiddenFile = new File("forbidden.txt");
        if (!forbiddenFile.exists()) {
            System.out.println("Файл заборонених слів не знайдено");
            return forbiddenWords;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(forbiddenFile))) {
            String line;
            while ((line = reader.readLine()) != null) forbiddenWords.add(line.trim());
        }
        catch (IOException e) { e.printStackTrace(); }
        return forbiddenWords;
    }

    private void processFile(List<String> forbiddenWords) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(mergedFile))) {
            String line;
            while((line = reader.readLine()) != null) content.append(line).append(System.lineSeparator());
        }

        String originalContent = content.toString();
        String modifiedContent = originalContent;

        for (String word : forbiddenWords) {
            if (word.isEmpty()) continue;
            int count = countOccurrences(modifiedContent, word);
            forbiddenWordsRemovedCount += count;
            modifiedContent = modifiedContent.replaceAll(word, "");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cleanedFile))) { writer.write(modifiedContent); }
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }

    public int getForbiddenWordsRemovedCount() { return forbiddenWordsRemovedCount; }
}
