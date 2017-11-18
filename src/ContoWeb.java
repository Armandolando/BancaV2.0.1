public class ContoWeb extends ContoCorrente {
    protected String psw;
    boolean test = true;


    public ContoWeb(String iban, String cf) {
        super(iban, cf);
        this.psw = "changename";
    }

    public boolean password(String pass){
        if(test){
            this.psw = pass;
            test = false;
            return true;
        }
        return false;
    }

    public boolean login(String pass){
        if(this.psw.equals(pass)){
            return true;
        }
        return false;
    }


    public boolean operazioni(double amnt, String pass) {
        if(login(pass) && !(test)){
           return super.operazioni(amnt);
        }
        System.out.println("Password sbagliata o non ancora cambiata quella di default");
        return false;
    }



    @Override
    public double getSaldo() {
        return this.saldo;
    }


    public String toString() {
        return "IBAN: "+getIban()+" Codice Fiscale: "+getCf()+" Saldo: "+getSaldo();
    }

}
