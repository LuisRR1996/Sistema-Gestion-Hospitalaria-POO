package model;
import java.util.ArrayList;

public class Paciente {
    private String dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private ArrayList<HistoriaClinica> historial;

    public Paciente(String dni, String nombres, String apellidos, int edad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.historial = new ArrayList<>(); // Inicializamos la lista vacía
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<HistoriaClinica> getHistorial() {
        return historial;
    }

    // Método para agregar una nueva historia a este paciente
    public void agregarHistoria(HistoriaClinica historia) {
        this.historial.add(historia);
    }
}
