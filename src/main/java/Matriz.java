import java.util.*;

public class Matriz {

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matriz = null; // Variable para almacenar la matriz

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        int opcion;
        do {
            menu();
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        } while (opcion != 5); // Cambiar a 5 para incluir la nueva opción
        scanner.close();
    }

    public static void menu() {
        System.out.println("\nMenú:");
        System.out.println("1: Crear y rellenar matriz");
        System.out.println("2: Mostrar matriz");
        System.out.println("3: Contar ceros en la matriz");
        System.out.println("4: Mostrar fila deseada");
        System.out.println("5: Salir"); // Cambiar a 5 para incluir la nueva opción
        System.out.print("Ingrese su opción: ");
    }

    public static void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearYRellenarMatriz();
                break;
            case 2:
                mostrarMatrizSiDisponible();
                break;
            case 3:
                contarCerosEnMatriz();
                break;
            case 4:
                mostrarFilaDeseadaPorUsuario(matriz);
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
                break;
        }
    }

    private static void crearYRellenarMatriz() {
        int fila = pedirFila();
        int columna = pedirColumna();
        if (validarLongitud(fila, columna)) {
            matriz = crearMatriz(fila, columna);
            matriz = rellenarMatrizConAleatorios(matriz);
            System.out.println("Matriz creada y rellenada.");
        } else {
            System.out.println("La cantidad de filas y columnas debe ser mayor a 0.");
        }
    }

    private static void mostrarMatrizSiDisponible() {
        if (matriz != null) {
            mostrarMatriz(matriz);
        } else {
            System.out.println("Primero debe crear y rellenar una matriz.");
        }
    }

    private static void contarCerosEnMatriz() {
        if (matriz != null) {
            int ceros = cantidadDeCeros(matriz);
            System.out.println("Cantidad de ceros en la matriz: " + ceros);
            if (esDeTipoCeroLaMatriz()) {
                System.out.println("La matriz es de tipo cero.");
            } else {
                System.out.println("La matriz no es de tipo cero.");
            }
        } else {
            System.out.println("Primero debe crear y rellenar una matriz.");
        }
    }

    public static int pedirFila() {
        System.out.print("Cantidad de filas: ");
        return scanner.nextInt();
    }

    public static int pedirColumna() {
        System.out.print("Cantidad de columnas: ");
        return scanner.nextInt();
    }

    public static boolean validarLongitud(int fila, int columna) {
        return fila > 0 && columna > 0;
    }

    public static int[][] crearMatriz(int fila, int columna) {
        return new int[fila][columna];
    }

    public static int[][] rellenarMatrizConAleatorios(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static int cantidadDeCeros(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor == 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static boolean esDeTipoCeroLaMatriz() {
        if (matriz == null) {
            return false;
        }
        int totalElementos = matriz.length * matriz[0].length;
        int ceros = cantidadDeCeros(matriz);
        return ceros > (totalElementos / 2);
    }

    public static void mostrarFilaDeseadaPorUsuario(int[][] matriz) {
        if (matriz == null) {
            System.out.println("Primero debe crear y rellenar una matriz.");
            return;
        }

        System.out.print("Ingrese el número de la fila que desea mostrar (0 a " + (matriz.length - 1) + "): ");
        int filaDeseada = scanner.nextInt();

        if (filaDeseada >= 0 && filaDeseada < matriz.length) {
            System.out.println("Fila " + filaDeseada + ": " + Arrays.toString(matriz[filaDeseada]));
        } else {
            System.out.println("Número de fila inválido.");
        }
    }
}
