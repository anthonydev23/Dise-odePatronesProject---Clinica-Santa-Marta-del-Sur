package Observer;

import java.util.ArrayList;

public class GestorNotificaciones {

    private ArrayList<Observador>
            observadores =
            new ArrayList<>();

    public void agregar(
            Observador o) {
        observadores.add(o);
    }

    public void notificar(
            String mensaje) {

        for (Observador o :
                observadores) {

            o.actualizar(mensaje);
        }
    }
}