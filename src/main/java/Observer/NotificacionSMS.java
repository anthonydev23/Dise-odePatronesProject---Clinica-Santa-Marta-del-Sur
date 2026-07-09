package Observer;

public class NotificacionSMS
        implements Observador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println(
                "[SMS] " + mensaje);
    }
}