package Task4;

import java.io.*;
import java.util.concurrent.CountDownLatch;

public class FileMerger implements Runnable {
    private File directory;
    private String searchWord;
    private CountDownLatch latch;
    private int filesMergedCount;
    private File outputFile = new File("merged.txt");

    public FileMerger(File directory, String searchWord, CountDownLatch latch) {
        this.directory = directory;
        this.searchWord = searchWord;
        this.latch = latch;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) { processDirectory(directory, writer); }
        catch (IOException e) { e.printStackTrace(); }
        finally { latch.countDown(); }
    }

    private void processDirectory(File dir, BufferedWriter writer) throws IOException {
        if (!dir.exists() || !dir.isDirectory()) return;
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) processDirectory(file, writer);
            else {
                if (fileContainsWord(file, searchWord)) {
                    appendFileContent(file, writer);
                    filesMergedCount++;
                }
            }
        }
    }

    private boolean fileContainsWord(File file, String word) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) if(line.contains(word)) return true;
        }
        catch (IOException e) {}
        return false;
    }

    private void appendFileContent(File file, BufferedWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            writer.write("---- Початок файлу: " + file.getAbsolutePath() + " ----\n");
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write("---- Кінець файлу: " + file.getAbsolutePath() + " ----\n\n");
        }
    }

    public int getFilesMergedCount() { return filesMergedCount; }
}
