package Modelo;

public class Paciente {

    private String dni;
    private String nombre;
    private String telefono;

    public Paciente(String dni, String nombre, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "DNI: " + dni +
                " | Nombre: " + nombre +
                " | Telefono: " + telefono;
    }
}