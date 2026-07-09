package Servicio;

import Modelo.Paciente;
import java.util.ArrayList;

public class PacienteService {

    private ArrayList<Paciente>
            pacientes =
            new ArrayList<>();

    public void registrarPaciente(
            Paciente paciente) {

        pacientes.add(paciente);
    }

    public Paciente buscarPorDni(
            String dni) {

        for (Paciente p :
                pacientes) {

            if (p.getDni()
                    .equals(dni)) {
                return p;
            }
        }

        return null;
    }

    public void listarPacientes() {

        if (pacientes.isEmpty()) {
            System.out.println(
                    "No hay pacientes registrados.");
            return;
        }

        for (Paciente p :
                pacientes) {
            System.out.println(p);
        }
    }
}