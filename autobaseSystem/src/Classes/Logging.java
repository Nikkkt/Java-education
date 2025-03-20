package Classes;

import java.io.FileWriter;
import java.io.IOException;

public class Logging {
    public static void log(String message) {
        try (FileWriter writer = new FileWriter("trips_log.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
