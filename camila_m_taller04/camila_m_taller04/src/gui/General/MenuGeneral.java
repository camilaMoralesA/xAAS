package gui.General;

import logica.SistemaSimulador;
import dominio.Armamento;

import java.util.Scanner;

public class MenuGeneral {
    public static void mostrarMenu(SistemaSimulador sistema) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú General ---");
            System.out.println("1. Eliminar armamento");
            System.out.println("2. Ver armamentos completos");
            System.out.println("3. Ver armamentos incompletos");
            System.out.println("0. Salir");
            System.out.print("Seleccione opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> eliminarArmamento(sistema, scanner);
                case 2 -> verArmamentosPorEstado(sistema, "completo");
                case 3 -> verArmamentosPorEstado(sistema, "incompleto");
                case 0 -> System.out.println("Saliendo del menú general.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void eliminarArmamento(SistemaSimulador sistema, Scanner scanner) {
        System.out.println("Lista de armamentos:");
        for (Armamento a : sistema.getArmamentos()) {
            System.out.println(a.getId() + " - " + a.getNombre());
        }
        System.out.print("Ingrese ID a eliminar: ");
        int id = scanner.nextInt();
        boolean eliminado = sistema.eliminarArmamentoPorId(id);
        System.out.println(eliminado ? "Armamento eliminado." : "ID no encontrado.");
    }

    private static void verArmamentosPorEstado(SistemaSimulador sistema, String estado) {
        System.out.println("\nArmamentos con estado: " + estado);
        for (Armamento a : sistema.getArmamentos()) {
            if (a.getEstado().equalsIgnoreCase(estado)) {
                System.out.println("- " + a.getNombre());
            }
        }
        // Aquí puedes agregar lógica para mostrar o dibujar imagen
    }
}
