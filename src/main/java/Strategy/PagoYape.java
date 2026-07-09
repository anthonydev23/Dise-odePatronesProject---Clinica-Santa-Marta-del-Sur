package Strategy;

public class PagoYape
        implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println(
                "Pago mediante Yape: S/ "
                        + monto);
    }
}