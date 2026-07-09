package Modelo;

public class CitaVirtual extends Cita {

    public CitaVirtual(Paciente paciente) {
        super(paciente);
    }

    @Override
    public void mostrar() {
        System.out.println(
                "Cita VIRTUAL registrada para "
                        + paciente.getNombre());
    }
}