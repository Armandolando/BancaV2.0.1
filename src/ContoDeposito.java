public class ContoDeposito extends ContoCorrente {
    public ContoDeposito(String iban, String cf) {
        super(iban, cf);
    }

    @Override
    public boolean operazioni(double amnt){

        if(amnt<0){

            System.out.println("Transazione non consentita");
            return false;
        }

        super.saldo+=amnt;
        return true;

    }

    @Override
    public String toString() {
        return "IBAN: "+getIban()+" Codice Fiscale: "+getCf()+" Saldo: "+getSaldo();
    }

}
