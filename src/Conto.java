public abstract class Conto implements Operazioni,Accountable{
    private String iban,cf;
    protected double saldo;
    protected  double importoAcc;
    private AbstractAccountable acc;


    public Conto(String iban, String cf) {
        this.iban = iban;
        this.cf = cf;
        this.saldo=0;
        this.importoAcc=0;


    }


    public boolean aggiungiAcc(AccountableType tipo,double amnt){
        System.out.println(amnt);
        switch (tipo){
            case ADDEBITO:
                importoAcc+=amnt;

                break;
            case ACCREDITO:
                importoAcc+=amnt;
                System.out.println(importoAcc);
                break;
            default:
                return false;

        }
        return true;

    }

    public String getIban() {
        return iban;
    }

    public String getCf() {
        return cf;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public AbstractAccountable getAcc() {
        return acc;
    }

    public double getImportoAcc() {
        return importoAcc;
    }
}
