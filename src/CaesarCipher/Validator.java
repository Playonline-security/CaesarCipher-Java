package CaesarCipher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

    public boolean fileExists(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            System.out.println("❌ La ruta del archivo no puede estar vacía.");
            return false;
        }

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("❌ El archivo no existe.");
            return false;
        }

        if (!Files.isRegularFile(path)) {
            System.out.println("❌ La ruta no corresponde a un archivo regular.");
            return false;
        }

        return true;
    }

    public boolean isValidKey(int key) {
        if (key < 1 || key > 25) {
            System.out.println("🔐 La clave debe estar entre 1 y 25 (no puede ser 0).");
            return false;
        }
        return true;
    }

    public boolean isInteger(String input) {
        if (input == null || input.isBlank()) {
            System.out.println("⚠️ No se ingresó una clave.");
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("⚠️ La clave debe ser un número entero.");
            return false;
        }
    }
}
