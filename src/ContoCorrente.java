public class ContoCorrente extends Conto {

    public ContoCorrente(String iban, String cf) {
        super(iban, cf);

    }

    @Override
    public boolean operazioni(double amnt){
        if(amnt>0){
            this.saldo+=amnt;
            return true;

        }
        else if(Math.abs(amnt)<super.saldo){
            this.saldo+=amnt;
            return true;

        }
        else{
            System.out.println("Transazione non consentita");

        }
        return false;
    }

    @Override
    public boolean operazioni1(double amnt, String pass) {
        return false;
    }


    @Override
    public String toString() {
        return "IBAN: "+getIban()+" Codice Fiscale: "+getCf()+" Saldo: "+getSaldo();
    }


    @Override
    public double getImporto() {
        return 0;
    }
}
