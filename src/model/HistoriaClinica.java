package model;

public class HistoriaClinica {
    private String fechaRegistro;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinica(String fechaRegistro, String motivoConsulta, String diagnostico, String tratamiento) {
        this.fechaRegistro = fechaRegistro;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "\n--- Fecha: " + fechaRegistro + " ---" +
               "\nMotivo: " + motivoConsulta +
               "\nDiagnóstico: " + diagnostico +
               "\nTratamiento: " + tratamiento;
    }
}
