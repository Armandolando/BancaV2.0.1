public class Stipendio extends AbstractAccountable{


    public Stipendio(AccountableType tipo, double importo) {
        super(tipo, importo);
    }

    @Override
    public double getImporto() {
        return 0;
    }
}
