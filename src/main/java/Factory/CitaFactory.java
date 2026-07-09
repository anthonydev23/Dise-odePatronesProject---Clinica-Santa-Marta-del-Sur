package Factory;

import Modelo.Cita;
import Modelo.CitaPresencial;
import Modelo.CitaVirtual;
import Modelo.Paciente;

public class CitaFactory {

    public static Cita crearCita(
            int tipo,
            Paciente paciente) {

        switch (tipo) {
            case 1:
                return new CitaPresencial(paciente);

            case 2:
                return new CitaVirtual(paciente);

            default:
                return null;
        }
    }
}