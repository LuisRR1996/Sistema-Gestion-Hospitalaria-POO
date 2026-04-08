package servicio;

import java.util.ArrayList;
import model.HistoriaClinica;
import model.Paciente;
import model.Usuario;

public class ClinicaServicio {
    // Aquí simulamos nuestra base de datos con ArrayList
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Usuario> listaUsuarios;

    public ClinicaServicio() {
        listaPacientes = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        
        // Creamos un usuario por defecto para poder iniciar sesión en el sistema
        listaUsuarios.add(new Usuario("admin", "12345"));
    }

    // 1. Método para validar el Login
    public boolean iniciarSesion(String username, String password) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true; // Credenciales correctas
            }
        }
        return false; // Credenciales incorrectas
    }

    // 2. Método para registrar un paciente nuevo
    public boolean registrarPaciente(Paciente nuevoPaciente) {
        // Primero verificamos que el paciente no esté registrado ya
        if (buscarPacientePorDni(nuevoPaciente.getDni()) == null) {
            listaPacientes.add(nuevoPaciente);
            return true; // Se registró con éxito
        }
        return false; // Error: El DNI ya existe
    }

    // 3. Método para buscar paciente por DNI
    public Paciente buscarPacientePorDni(String dni) {
        for (Paciente p : listaPacientes) {
            if (p.getDni().equals(dni)) {
                return p; // Retorna el paciente si lo encuentra
            }
        }
        return null; // Retorna nulo si no existe
    }
}
