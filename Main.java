//Jan Carlos Molina
// importacion de librerias necesarias
import java.util.ArrayList;
import java.util.Scanner;

//Clase principal
public class Main {
     // Lista de jugadores de tipo Clase almacenados en un ArrayList
    private static ArrayList<Clase> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Método principal donde inicia el programa
    public static void main(String[] args) {
        int opcion; // Variable para almacenar la opcion del menu
        do {
            mostrarMenu(); 
            opcion = scanner.nextInt();// Captura la opción seleccionada
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    agregarJugador(); // Llama al método para agregar un nuevo jugador
                    break;
                case 2:
                    buscarJugador(); // Llama al método para buscar un jugador por ID
                    break;
                case 3:
                    editarJugador(); // Llama al método para editar la información de un jugador
                    break;
                case 4:
                    eliminarJugador(); // Llama al método para eliminar un jugador por ID
                    break;
                case 5:
                    listarJugadores(); // Llama al método para mostrar la lista de jugadores
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Muestra el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Jugadores ---");
        System.out.println("1. Agregar jugador");
        System.out.println("2. Buscar jugador");
        System.out.println("3. Editar jugador");
        System.out.println("4. Eliminar jugador");
        System.out.println("5. Listar jugadores");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Agrega un nuevo jugador a la lista de jugadores
    private static void agregarJugador() {
        System.out.print("Ingrese el ID del jugador: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la posición del jugador: ");
        String posicion = scanner.nextLine();

        Clase nuevoJugador = new Clase(id, nombre, edad, posicion);// Crea un nuevo objeto jugador
        jugadores.add(nuevoJugador);// Agrega el jugador a la lista
        System.out.println("Jugador agregado: " + nuevoJugador);
    }
 // Busca un jugador en la lista por ID
    private static void buscarJugador() {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clase jugador = obtenerJugadorPorId(id);
        if (jugador != null) {
            System.out.println("Jugador encontrado: " + jugador);
        } else {
            System.out.println("Jugador con ID " + id + " no encontrado.");
        }
    }
// Método auxiliar para obtener un jugador por su ID
    private static Clase obtenerJugadorPorId(int id) {
        for (Clase jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }
// Edita la información de un jugador existente
    private static void editarJugador() {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clase jugador = obtenerJugadorPorId(id);// Busca el jugador

        if (jugador != null) {
            System.out.print("Nuevo nombre (" + jugador.getNombre() + "): ");
            String nombre = scanner.nextLine();
            System.out.print("Nueva edad (" + jugador.getEdad() + "): ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nueva posición (" + jugador.getPosicion() + "): ");
            String posicion = scanner.nextLine();

            jugador.setNombre(nombre);// Actualiza nombre
            jugador.setEdad(edad);// Actualiza edad
            jugador.setPosicion(posicion);// Actualiza posición
            System.out.println("Jugador actualizado: " + jugador);
        } else {
            System.out.println("Jugador con ID " + id + " no encontrado.");
        }
    }
// Elimina un jugador de la lista
    private static void eliminarJugador() {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clase jugador = obtenerJugadorPorId(id);// Busca el jugador

        if (jugador != null) {
            System.out.print("¿Confirma la eliminación del jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador);// Elimina el jugador de la lista
                System.out.println("Jugador eliminado.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Jugador con ID " + id + " no encontrado.");
        }
    }
// Lista todos los jugadores en la lista
    private static void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
        } else {
            System.out.println("\n--- Lista de Jugadores ---");
            for (Clase jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }
}
