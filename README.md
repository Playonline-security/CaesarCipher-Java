# CaesarCipher-Java
Proyecto en Java que implementa un cifrador y descifrador César con métodos de encriptado, desencriptado por clave, fuerza bruta y análisis estadístico, para procesar textos en inglés mediante archivos.

# 🔐 Cifrado César - Proyecto en Java

Este proyecto implementa un cifrador y descifrador César con varias funcionalidades, incluyendo métodos de desencriptado por clave, fuerza bruta y análisis estadístico.

---

## 📋 Descripción

El cifrado César es una técnica clásica de sustitución en la que cada letra del texto original se desplaza un número fijo de posiciones en el alfabeto. Este programa permite:

- 🔒 Encriptar texto con una clave (desplazamiento).
- 🔓 Desencriptar con clave conocida.
- 🛠️ Desencriptar por fuerza bruta (probando todas las claves posibles).
- 📊 Desencriptar usando análisis estadístico para detectar la clave probable.
- 📂 Leer y escribir archivos de texto para procesar mensajes.

El programa está diseñado para texto en inglés utilizando únicamente el alfabeto básico (A-Z, a-z), sin caracteres especiales o con diacríticos.

---

## 🛠️ Tecnologías

- ☕ Java 11+
- 📁 API estándar para manejo de archivos y consola.

---

## 📂 Estructura del proyecto

CaesarCipher/
│
├── MainApp.java # Punto de entrada y menú principal.
├── Cipher.java # Lógica de cifrado y descifrado César.
├── FileManager.java # Lectura y escritura de archivos.
├── Validator.java # Validación de entradas y archivos.
├── BruteForce.java # Desencriptado por fuerza bruta.
└── StatisticalAnalyzer.java # Análisis estadístico para detectar clave.

---

## 🚀 Uso

1. Clona el repositorio o descarga el código.
2. Compila las clases Java.
3. Ejecuta `MainApp`.
4. Sigue las instrucciones en consola:
   - 1️⃣ Encriptar o 2️⃣ Desencriptar.
   - Si desencriptar, escoge método (clave, fuerza bruta o análisis estadístico).
   - 📂 Proporciona rutas válidas para archivos de entrada y salida.
   - 🔢 Ingresa la clave si es necesario.

---

## 📖 Ejemplo

🔐 Bienvenido al programa de Cifrado César 🔐
Escribe 'salir' en cualquier momento para finalizar el programa.
Seleccione una opción:
1️⃣ Encriptar
2️⃣ Desencriptar
👉 Opción: 1
📂 Ingresa la ruta del archivo de entrada: input.txt
🔢 Ingresa la clave (1–25): 3
📄 Ingresa la ruta del archivo de salida: output.txt
✅ Archivo escrito correctamente.


---

## ⚠️ Consideraciones

- Solo soporta el alfabeto inglés básico sin caracteres especiales.
- La clave debe ser un entero entre 1 y 25.
- Los archivos deben ser textos en formato UTF-8.
- 📁 La ruta de salida no puede ser igual a la de entrada para evitar sobreescritura.

---

## 👤 Autor

Jonathan Uzcategui Gonzalez

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
