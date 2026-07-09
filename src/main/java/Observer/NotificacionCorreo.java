package Observer;

public class NotificacionCorreo
        implements Observador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println(
                "[CORREO] " + mensaje);
    }
}