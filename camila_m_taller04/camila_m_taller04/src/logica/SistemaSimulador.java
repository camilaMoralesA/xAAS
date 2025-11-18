package logica;
import dominio.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaSimulador {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Dinosaurio> dinosaurios = new ArrayList<>();
    private ArrayList<Armamento> armamentos = new ArrayList<>();

    public void cargarUsuario(Usuario u) { usuarios.add(u); }
    public void cargarDinosaurio(Dinosaurio d) { dinosaurios.add(d); }
    public void cargarArmamento(Armamento a) { armamentos.add(a); }

    public ArrayList<Usuario> getUsuarios() { return usuarios; }
    public ArrayList<Dinosaurio> getDinosaurios() { return dinosaurios; }
    public ArrayList<Armamento> getArmamentos() { return armamentos; }

    public Usuario iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuario: ");
        String user = scanner.nextLine();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
        return null;
    }
    public boolean eliminarDinosaurioPorId(int id) {
        return dinosaurios.removeIf(d -> d.getId() == id);
    }

    public boolean eliminarArmamentoPorId(int id) {
        return armamentos.removeIf(a -> a.getId() == id);
    }

}