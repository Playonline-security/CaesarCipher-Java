package CaesarCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {

    public String readFile(String filePath) {
        Path path = Paths.get(filePath);
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
            return null;
        }
        return contentBuilder.toString();
    }

    public void writeFile(String content, String filePath) {
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(content);
            System.out.println("✅ Archivo escrito correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al escribir el archivo: " + e.getMessage());
        }
    }
}


