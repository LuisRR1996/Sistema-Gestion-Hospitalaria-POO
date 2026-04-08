package app;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.HistoriaClinica;
import model.Paciente;
import servicio.ClinicaServicio;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClinicaServicio servicio = new ClinicaServicio();
        boolean autenticado = false;

        System.out.println("=== BIENVENIDO AL SISTEMA DE LA CLÍNICA IBEROAMERICANA ===");
        System.out.println("(Nota para evaluación: Usuario = admin | Contraseña = 12345)");

        // MÓDULO DE LOGIN
        int intentos = 0;
        while (!autenticado && intentos < 3) {
            System.out.print("\nIngrese su usuario: ");
            String user = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String pass = scanner.nextLine();

            if (servicio.iniciarSesion(user, pass)) {
                System.out.println("¡Acceso concedido! Bienvenido, " + user);
                autenticado = true;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + (3 - intentos));
            }
        }

        if (!autenticado) {
            System.out.println("Demasiados intentos fallidos. El sistema se cerrará por seguridad.");
            scanner.close();
            return; // Termina el programa
        }

        // MENÚ PRINCIPAL
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Agregar historia clínica a un paciente");
            System.out.println("3. Buscar historial de paciente por DNI");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("\n-- REGISTRO DE PACIENTE --");
                        System.out.print("DNI: ");
                        String dni = scanner.nextLine();
                        System.out.print("Nombres: ");
                        String nombres = scanner.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        Paciente nuevo = new Paciente(dni, nombres, apellidos, edad);
                        if (servicio.registrarPaciente(nuevo)) {
                            System.out.println("¡Paciente registrado con éxito!");
                        } else {
                            System.out.println("Error: Ya existe un paciente con ese DNI.");
                        }
                        break;

                    case 2:
                        System.out.println("\n-- NUEVA HISTORIA CLÍNICA --");
                        System.out.print("Ingrese el DNI del paciente: ");
                        String dniBusqueda = scanner.nextLine();
                        Paciente pEncontrado = servicio.buscarPacientePorDni(dniBusqueda);

                        if (pEncontrado != null) {
                            System.out.print("Fecha de atención (DD/MM/AAAA): ");
                            String fecha = scanner.nextLine();
                            System.out.print("Motivo de consulta: ");
                            String motivo = scanner.nextLine();
                            System.out.print("Diagnóstico: ");
                            String diagnostico = scanner.nextLine();
                            System.out.print("Tratamiento: ");
                            String tratamiento = scanner.nextLine();

                            HistoriaClinica nuevaHistoria = new HistoriaClinica(fecha, motivo, diagnostico, tratamiento);
                            pEncontrado.agregarHistoria(nuevaHistoria);
                            System.out.println("¡Historia clínica agregada correctamente!");
                        } else {
                            System.out.println("Error: Paciente no encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("\n-- BUSCAR HISTORIAL --");
                        System.out.print("Ingrese el DNI del paciente: ");
                        String dniHistorial = scanner.nextLine();
                        Paciente pHistorial = servicio.buscarPacientePorDni(dniHistorial);

                        if (pHistorial != null) {
                            System.out.println("\nPaciente: " + pHistorial.getNombres() + " " + pHistorial.getApellidos() + " | Edad: " + pHistorial.getEdad());
                            if (pHistorial.getHistorial().isEmpty()) {
                                System.out.println("El paciente aún no tiene atenciones registradas.");
                            } else {
                                for (HistoriaClinica hc : pHistorial.getHistorial()) {
                                    System.out.println(hc.toString());
                                }
                            }
                        } else {
                            System.out.println("Error: Paciente no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.println("Cerrando sesión... ¡Hasta pronto!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar el error para que el bucle no colapse
            }

        } while (opcion != 4);

        scanner.close();
    }
}
