import Adapter.ProcesadorSeguro;
import Adapter.SeguroRimacAdapter;
import Factory.CitaFactory;
import Modelo.Cita;
import Modelo.Paciente;
import Observer.GestorNotificaciones;
import Observer.NotificacionCorreo;
import Observer.NotificacionSMS;
import Servicio.PacienteService;
import Strategy.MetodoPago;
import Strategy.PagoEfectivo;
import Strategy.PagoTarjeta;
import Strategy.PagoYape;

import java.util.Scanner;

public class Main {

    static Scanner sc =
            new Scanner(System.in);

    static PacienteService pacienteService =
            new PacienteService();

    static GestorNotificaciones gestor =
            new GestorNotificaciones();

    public static void main(String[] args) {

        gestor.agregar(
                new NotificacionCorreo());

        gestor.agregar(
                new NotificacionSMS());

        int opcion;

        do {

            System.out.println("\n===== CLINICA SANTA MARTA DEL SUR =====");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Registrar Cita");
            System.out.println("4. Validar Seguro");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    registrarPaciente();
                    break;

                case 2:
                    pacienteService.listarPacientes();
                    break;

                case 3:
                    registrarCita();
                    break;

                case 4:
                    validarSeguro();
                    break;

                case 5:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 5);
    }

    private static void registrarPaciente() {

        sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        if (pacienteService.buscarPorDni(dni) != null) {
            System.out.println("El paciente ya existe.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        Paciente paciente =
                new Paciente(
                        dni,
                        nombre,
                        telefono);

        pacienteService
                .registrarPaciente(
                        paciente);

        System.out.println(
                "Paciente registrado correctamente.");
    }

    private static void registrarCita() {

        sc.nextLine();

        System.out.print(
                "Ingrese DNI del paciente: ");

        String dni =
                sc.nextLine();

        Paciente paciente =
                pacienteService
                        .buscarPorDni(dni);

        if (paciente == null) {
            System.out.println(
                    "Paciente no encontrado.");
            return;
        }

        System.out.println(
                "1. Cita Presencial");
        System.out.println(
                "2. Cita Virtual");
        System.out.print(
                "Seleccione: ");

        int tipo =
                sc.nextInt();

        Cita cita =
                CitaFactory
                        .crearCita(
                                tipo,
                                paciente);

        if (cita == null) {
            System.out.println(
                    "Tipo de cita invalido.");
            return;
        }

        cita.mostrar();

        System.out.println(
                "\nMetodo de Pago");
        System.out.println(
                "1. Efectivo");
        System.out.println(
                "2. Tarjeta");
        System.out.println(
                "3. Yape");

        int opcion =
                sc.nextInt();

        MetodoPago pago =
                null;

        switch (opcion) {

            case 1:
                pago =
                        new PagoEfectivo();
                break;

            case 2:
                pago =
                        new PagoTarjeta();
                break;

            case 3:
                pago =
                        new PagoYape();
                break;

            default:
                System.out.println(
                        "Metodo de pago invalido.");
                return;
        }

        pago.pagar(100);

        gestor.notificar(
                "La cita de "
                        + paciente.getNombre()
                        + " fue registrada.");
    }

    private static void validarSeguro() {

        ProcesadorSeguro seguro =
                new SeguroRimacAdapter();

        seguro.validar();
    }
}