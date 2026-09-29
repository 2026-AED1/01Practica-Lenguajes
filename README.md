# Práctica 1: Configuración del Entorno y Análisis de Rendimiento de los Lenguajes de Programación

**Asignatura**: Algoritmia y Estructuras de Datos (AED I) — Bloque I
**Titulación**: Ingeniería Informática – Inteligencia Artificial
**Duración**: 2 h en clase + 1 h en casa
**Peso**: 5% de la nota del bloque

> Este es el **enunciado**: qué hay que hacer. La explicación paso a paso de la sesión está en las diapositivas (`diapositivas/`).

---

## Contenido del repositorio

| Carpeta | Contenido |
|---------|-----------|
| `cpp/` | Código base en C++ |
| `python/` | Código base en Python |
| `java/` | Código base en Java |
| `diapositivas/` | Diapositivas de la sesión en PDF |

Para descargarlo: `git clone <URL del repositorio>` o botón **Code → Download ZIP**.

---

## Objetivos

- Configurar un entorno de ejecución con Python, C++ y Java.
- Entender la sintaxis básica de los tres lenguajes mediante programas sencillos.
- Medir tiempos de ejecución reales, comparar el rendimiento (benchmark) y entender los *trade-offs* entre lenguajes.
- Usar el entorno de programación competitiva (juez virtual DOMJudge) que se empleará en la evaluación del curso.

---

## Materiales necesarios (se puede traer instalado antes de clase)

| Lenguaje | Versión mínima | Compilador / intérprete | Entorno (IDE) |
|----------|----------------|-------------------------|---------------|
| Python | 3.8+ | Intérprete Python + pip | PyCharm Community / Jupyter Notebook / VS Code con extensión Python |
| C++ | C++17 | g++ (MinGW / Xcode) | Code::Blocks / CLion / VS Code con extensión C++ |
| Java | Java SE 11+ (LTS) | OpenJDK | IntelliJ IDEA Community / Eclipse / VS Code con extensión Java |
| Terminal / Bash | — | — | Compilación y ejecución |

Nota: VS Code sirve para los tres lenguajes.

### Instalación

| Sistema operativo | Comando | Python | C++ | Java |
|-------------------|---------|--------|-----|------|
| Windows | `choco install` | `python` | `mingw` | `openjdk11` |
| macOS | `brew install` | `python3` | `gcc` (o `xcode-select --install`) | `openjdk@11` |
| Linux | `sudo apt update && sudo apt install` | `python3 python3-pip` | `build-essential` | `openjdk-11-jdk` |

### Verificación

```bash
python --version   # → Python 3.8+
java -version      # → OpenJDK 11+
javac -version     # → javac 11+
g++ --version      # → g++ 9+ (con soporte C++17)
```

**Consejos**
- Crea una carpeta por práctica: `practica1/` con subcarpetas `python/`, `java/` y `cpp/`.
- Problema común en Windows: `g++` no está en el `PATH`. Solución: usar MinGW-w64 o WSL2.

---

## Ejercicios de la sesión

| Fase | Duración | Actividad |
|------|----------|-----------|
| Instalación y verificación del entorno | 15 min | Verificar versiones |
| Ejercicio 1: Hola Mundo | 10 min | Escribir, compilar y ejecutar en los 3 lenguajes |
| Ejercicio 2: Factorial | 20 min | Implementar y medir |
| Ejercicio 3: Comparativa de rendimiento | 30 min | Suma de matriz, medir tiempos y discutir resultados |
| Ejercicio 4: Juez virtual | 25 min | Preparar y enviar el programa al juez |
| Cierre y reflexión | 10 min | Tabla comparativa, elección de lenguaje para competición |

### Verificación del entorno
Ejecutar los comandos de versión de los tres lenguajes y hacer una captura de pantalla de cada uno.

### Ejercicio 1 — Hola Mundo (en los tres lenguajes)
Crear, compilar (si procede) y ejecutar un programa que imprima un saludo:

```bash
python hola.py                                    # Python: no necesita compilación
g++ -std=c++17 -O2 hola.cpp -o hola && ./hola     # C++: compilación a código nativo
javac HolaMundo.java && java HolaMundo            # Java: bytecode + JVM
```

### Ejercicio 2 — Factorial iterativo (en los tres lenguajes)
- Implementar `factorial(n)` de forma iterativa, con `n` entero no negativo.
- Casos: `factorial(0) == 1`, `factorial(5) == 120`, `factorial(10) == 3628800`.
- Medir el tiempo para `n = 1.000`.
- Observar el comportamiento con números grandes: Python usa enteros de precisión arbitraria, mientras que en C++ (`unsigned long long`) y Java (`long`) el resultado desborda a partir de `n = 21`.

### Ejercicio 3 — Comparativa de rendimiento: suma de los elementos de una matriz
- Implementar un método que sume todos los elementos de una matriz de enteros `int[N][N]`, en Python, C++ y Java.
- Tamaños: `N = 10000` y `N = 20000`.
- En Python, comparar la versión con listas puras frente a la versión con NumPy.
- Medir el tiempo **solo** de la suma (no de la inicialización), con el mecanismo propio de cada lenguaje:
  - Python: `time.time()`
  - C++: `std::chrono::high_resolution_clock`
  - Java: `System.nanoTime()`
- Completar la tabla comparativa:

| Tamaño | Python | C++ | Java |
|--------|--------|-----|------|
| N = 10000 | ms | ms | ms |
| N = 20000 | ms | ms | ms |

### Ejercicio 4 — Uso del juez virtual (DOMJudge)
Plataforma: **https://complicaus.eii.us.es**

Crear un programa que use el método `factorial`, lea varios números enteros de la entrada estándar y escriba el factorial de cada uno en la salida estándar.

| Entrada (stdin) | Salida (stdout) |
|-----------------|-----------------|
| 10 | 3628800 |
| 50 | 815915283247897734345611269596115894272000000000 |

**Veredictos del juez**
- **AC** (Accepted): solución correcta.
- **WA** (Wrong Answer): la salida no coincide con la esperada (¡ojo con espacios, saltos de línea y formatos!).
- **TLE / MLE** (Time / Memory Limit Exceeded): el programa es demasiado lento o consume demasiada memoria.
- **RTE / CE** (Runtime Error / Compilation Error): error en ejecución o en compilación.

---

## Actividad para casa (1 h) — Benchmark de ordenación

Escribir un programa en Python, C++ y Java que:

1. Genere una lista/vector de 10.000.000 de números enteros aleatorios.
2. Mida el tiempo exacto que tarda en ordenarlos con la función nativa de cada lenguaje:
   - Python: `list.sort()` (Timsort)
   - C++: `std::sort()`
   - Java: `Arrays.sort()`
3. *(Opcional, en Python)*: comparar `list.sort()` frente a una implementación propia del algoritmo de la burbuja con solo 20.000 elementos.

---

## Entregables

1. **Código fuente**: Hola Mundo y Factorial en los tres lenguajes (6 archivos).
2. **Código de medición de rendimiento** del Ejercicio 3 en los tres lenguajes.
3. **Capturas de pantalla**: versiones instaladas y ejecución correcta de cada programa.
4. **Informe breve de rendimiento** (media página): tabla de tiempos del Ejercicio 3 y una hipótesis propia de por qué el resultado se ajusta o no a lo esperado teóricamente.
5. **Confirmación de envío** al juez virtual (Ejercicio 4).
6. **Benchmark de ordenación** (actividad para casa): código y tiempos obtenidos.

---

## Recursos

| Recurso | Para qué |
|---------|----------|
| [Python Tutorial](https://docs.python.org/3/tutorial/) | Sintaxis y buenas prácticas |
| [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/) | Fundamentos de Java |
| [LearnCpp.com](https://www.learncpp.com/) | C++ moderno paso a paso |
| [cppreference.com](https://en.cppreference.com/) | Documentación completa de C++ |
| [Competitive Programmer's Handbook](https://cses.fi/book/book.pdf) | Referencia de programación competitiva (gratuita) |

---

**Siguiente práctica**: ArrayList dinámico.