package Adapter;

public class SeguroRimacAdapter
        implements ProcesadorSeguro {

    private SeguroRimac rimac =
            new SeguroRimac();

    @Override
    public void validar() {
        rimac.verificarSeguro();
    }
}