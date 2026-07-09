package Modelo;

public class CitaPresencial extends Cita {

    public CitaPresencial(Paciente paciente) {
        super(paciente);
    }

    @Override
    public void mostrar() {
        System.out.println(
                "Cita PRESENCIAL registrada para "
                        + paciente.getNombre());
    }
}