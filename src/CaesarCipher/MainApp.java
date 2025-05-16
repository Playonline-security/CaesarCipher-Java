package CaesarCipher;

/*
Nota: Este cifrador está pensado para textos en inglés utilizando únicamente
el alfabeto básico (A–Z, a–z). No contempla el manejo de caracteres con
diacríticos (por ejemplo: á, é, í, ó, ú), la letra ñ, ni símbolos con diéresis
(por ejemplo: ü) u otros signos especiales.
*/

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        Cipher cipher = new Cipher();

        String mainOption;

        while (true) {
            System.out.println("\n🔐 Bienvenido al programa de Cifrado César 🔐");
            System.out.println("Escribe 'salir' en cualquier momento para finalizar el programa.");
            System.out.println("Seleccione una opción:");
            System.out.println("1️⃣  Encriptar");
            System.out.println("2️⃣  Desencriptar");
            System.out.print("👉 Opción: ");
            mainOption = scanner.nextLine();

            if (mainOption.equalsIgnoreCase("salir")) {
                System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                break;
            }

            if (!mainOption.equals("1") && !mainOption.equals("2")) {
                System.out.println("❌ Opción inválida. Intenta nuevamente.\n");
                continue;
            }

            String subOption = "";
            if (mainOption.equals("2")) {
                do {
                    System.out.println("\n🔎 Métodos de desencriptado:");
                    System.out.println("1️⃣  Con clave");
                    System.out.println("2️⃣  Fuerza bruta");
                    System.out.println("3️⃣  Análisis estadístico");
                    System.out.print("👉 Método: ");
                    subOption = scanner.nextLine();

                    if (subOption.equalsIgnoreCase("salir")) {
                        System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                        return;
                    }

                    if (!subOption.equals("1") && !subOption.equals("2") && !subOption.equals("3")) {
                        System.out.println("❌ Método inválido. Intenta nuevamente.\n");
                    }
                } while (!subOption.equals("1") && !subOption.equals("2") && !subOption.equals("3"));
            }

            String inputPath;
            do {
                System.out.print("\n📂 Ingresa la ruta del archivo de entrada: ");
                inputPath = scanner.nextLine();
                if (inputPath.equalsIgnoreCase("salir")) {
                    System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                    return;
                }
            } while (!validator.fileExists(inputPath));

            String content = fileManager.readFile(inputPath);
            while (content == null || content.isBlank()) {
                System.out.println("⚠️ El archivo está vacío o no se pudo leer.");
                System.out.print("📂 Ingresa otra ruta válida: ");
                inputPath = scanner.nextLine();
                if (inputPath.equalsIgnoreCase("salir")) {
                    System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                    return;
                }
                if (!validator.fileExists(inputPath)) continue;
                content = fileManager.readFile(inputPath);
            }

            int key = 0;
            if (mainOption.equals("1") || (mainOption.equals("2") && subOption.equals("1"))) {
                boolean validKey = false;
                do {
                    System.out.print("🔢 Ingresa la clave (1–25): ");
                    String keyInput = scanner.nextLine();

                    if (keyInput.equalsIgnoreCase("salir")) {
                        System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                        return;
                    }

                    if (validator.isInteger(keyInput)) {
                        key = Integer.parseInt(keyInput);
                        validKey = validator.isValidKey(key);
                    }
                } while (!validKey);
            }

            String outputPath;
            do {
                System.out.print("📄 Ingresa la ruta del archivo de salida: ");
                outputPath = scanner.nextLine();

                if (outputPath.equalsIgnoreCase("salir")) {
                    System.out.println("🔒 El programa ha terminado. ¡Hasta luego!");
                    return;
                }

                if (inputPath.equals(outputPath)) {
                    System.out.println("⚠️ La ruta de salida no puede ser igual a la de entrada.");
                    outputPath = "";
                }

            } while (outputPath.isBlank());

            // Process
            String result = "";

            if (mainOption.equals("1")) {
                result = cipher.applyCipher(content, key, false);

            } else if (mainOption.equals("2")) {
                switch (subOption) {
                    case "1":
                        result = cipher.applyCipher(content, key, true);
                        break;
                    case "2":
                        BruteForce bruteForce = new BruteForce();
                        result = bruteForce.decryptByBruteForce(content);
                        break;
                    case "3":
                        StatisticalAnalyzer analyzer = new StatisticalAnalyzer();
                        int detectedKey = analyzer.findMostLikelyShift(content);
                        System.out.println("🔍 Clave detectada por análisis estadístico: " + detectedKey);
                        result = cipher.applyCipher(content, detectedKey, true);
                        break;
                }
            }

            fileManager.writeFile(result, outputPath);
            System.out.println("💾 El archivo se guardó correctamente.");
        }

        scanner.close();
    }
}
