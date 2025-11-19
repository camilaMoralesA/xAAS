package logica;

import dominio.*;
import gui.General.MenuGeneral;
import logica.SistemaSimulador;
//import gui.Arqueologo.MenuArqueologo;
//import gui.General.MenuGeneral;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;ewqewewewq

public class App {

    public static void leerArchivos(SistemaSimulador sistema) throws FileNotFoundException {
        // Leer usuarios
        Scanner scan = new Scanner(new File("usuarios.txt"));
        while (scan.hasNextLine()) {
            String[] partes = scan.nextLine().split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre_u = partes[1];
            String password = partes[2];
            String tipo = partes[3];

            Usuario user = new Usuario(id, nombre_u, password, tipo);
            sistema.cargarUsuario(user);
        }
        scan.close();

        // Leer dinosaurios
        scan = new Scanner(new File("dinosaurios.txt"));
        while (scan.hasNextLine()) {
            String[] partes = scan.nextLine().split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String tipo = partes[2];
            String estado = partes[3];

            Dinosaurio dinosaurio = new Dinosaurio(id, nombre, tipo, estado);
            sistema.cargarDinosaurio(dinosaurio);
        }
        scan.close();

        // Leer armamentos
        scan = new Scanner(new File("armamentos.txt"));
        while (scan.hasNextLine()) {
            String[] partes = scan.nextLine().split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String tipo = partes[2];
            String estado = partes[3];

            Armamento arma = new Armamento(id,  nombre, tipo, estado);
            sistema.cargarArmamento(arma);
        }
        scan.close();
    }

    public static Usuario iniciarSesion(SistemaSimulador sistema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== INICIO DE SESIÓN ===");
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        for (Usuario user : sistema.getUsuarios()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("¡Inicio de sesión exitoso como " + user.getTipo() + "!");
                return user;
            }
        }
    

        System.out.println("Credenciales incorrectas.");
        return null;
    }

    public static void main(String[] args) {
        SistemaSimulador sistema = new SistemaSimulador();
        try {
            leerArchivos(sistema);
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontraron los archivos necesarios.");
            return;
        }

        Usuario usuario = iniciarSesion(sistema);
        if (usuario != null) {
            if (usuario.getTipo().equalsIgnoreCase("arqueologo")) {
                MenuArqueologo.mostrarMenu(sistema);
            } else if (usuario.getTipo().equalsIgnoreCase("general")) {
                MenuGeneral.mostrarMenu(sistema);
            } else {
                System.out.println("Tipo de usuario no reconocido.");
            }
        }
    }
}


