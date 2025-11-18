package logica;

import dominio.Dinosaurio;

import java.util.Scanner;

public class MenuArqueologo {
    public static void mostrarMenu(SistemaSimulador sistema) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Arqueólogo ---");
            System.out.println("1. Eliminar dinosaurio");
            System.out.println("2. Ver especies extintas");
            System.out.println("3. Ver especies no extintas");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> eliminarDinosaurio(sistema, scanner);
                case 2 -> verDinosauriosPorEstado(sistema, "extinto");
                case 3 -> verDinosauriosPorEstado(sistema, "no extinto");
                case 0 -> System.out.println("Saliendo del menú arqueólogo.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void eliminarDinosaurio(SistemaSimulador sistema, Scanner scanner) {
        System.out.println("Lista de dinosaurios:");
        for (Dinosaurio d : sistema.getDinosaurios()) {
            System.out.println(d.getId() + " - " + d.getNombre());
        }
        System.out.print("Ingrese ID a eliminar: ");
        int id = scanner.nextInt();
        boolean eliminado = sistema.eliminarDinosaurioPorId(id);
        System.out.println(eliminado ? "Dinosaurio eliminado." : "ID no encontrado.");
    }

    private static void verDinosauriosPorEstado(SistemaSimulador sistema, String estado) {
        System.out.println("\nDinosaurios con estado: " + estado);
        for (Dinosaurio d : sistema.getDinosaurios()) {
            if (d.getEstado().equalsIgnoreCase(estado)) {
                System.out.println("- " + d.getNombre());
            }
        }
    }
}

