public class Abbonamento extends AbstractAccountable {

    public Abbonamento(AccountableType tipo, double importo) {
        super(tipo, importo);
    }

    @Override
    public double getImporto() {
        return importo;
    }
}
