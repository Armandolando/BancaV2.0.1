public abstract class AbstractAccountable implements Accountable {

    protected AccountableType tipo;
    protected double importo;

    public AbstractAccountable(AccountableType tipo, double importo) {
        this.tipo = tipo;
        this.importo = importo;
    }

    public AccountableType getTipo(){
        return tipo;
    }

    @Override
    public double getImporto() {
        return importo;
    }


}
