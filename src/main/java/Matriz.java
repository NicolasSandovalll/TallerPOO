import java.util.*;

public class Matriz {
    public static void main(String[] args) {
        iniciarPrograma();
    }
    public static void iniciarPrograma() {
        Scanner scanner = new Scanner(System.in);
        int opcion ;
        do {
            menu();
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        } while (opcion != 6);
        scanner.close();
    }
    public static void menu(){
        System.out.println("\nMenú:");
        System.out.println("Opcion 1: ");
        System.out.println("Opcion 2:");
        System.out.println("Opcion 3:");
        System.out.println("Opcion 4:");
        System.out.println("Opcion 5:");
        System.out.println("Opcion 6:");
        System.out.print("Ingrese su opción:");
    }
    public static void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> crearMatriz(3 ,3 );
            case 2 -> System.out.println("Saliendo del programa.");
            default -> System.out.println("Opcion inválida. intente de nuevo.");
        }
    }

    public static int pedirFila() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cantidad de filas: ");
        return scanner.nextInt();
    }

    public static int pedirColumna() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cantidad de columnas: ");
        return scanner.nextInt();
    }

    public static boolean validarLongitud(int fila, int columna) {
        return fila > 0 && columna > 0;
    }

    public static int[][] crearMatriz(int fila, int columna) {
        return new int[fila][columna];
    }
    public static List<Integer> generarListaAleatoria() {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Collections.shuffle(numeros);
        return numeros;
    }

    public static int[][] rellenarMatriz(int[][] matriz,List<Integer> numeros) {
        for ( int i = 0; 1 < matriz.length - 1; i++) {
            for (int j = 0; 1 < matriz.length - 1; j++) {
                matriz[i][j] = numeros.get(i);
            }
        }
        return matriz;
    }

}
