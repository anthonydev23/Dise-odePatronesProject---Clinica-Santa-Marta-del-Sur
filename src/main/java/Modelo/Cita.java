package Modelo;

public abstract class Cita {

    protected Paciente paciente;

    public Cita(Paciente paciente) {
        this.paciente = paciente;
    }

    public abstract void mostrar();
}