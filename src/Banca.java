import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Banca {
    private String nomeBanca;
    private int contatore, nMax;
    Abbonamento abbTV;

    public Banca(String nomeBanca,int nMax) {

        this.nomeBanca = nomeBanca;
        this.contatore = 0;
        this.nMax = nMax;
    }

    HashMap<String,Conto> conti = new HashMap<String,Conto>();

    public boolean aggiungiConto(String cf, TipoConto tipo){
        if(contatore<nMax){
            String iban = "ITA000"+cf+(contatore+1);
            switch(tipo) {
                case CORRENTE:
                   conti.put(iban, new ContoCorrente(iban, cf));
                   break;

                case WEB:
                   conti.put(iban,new ContoWeb(iban,cf));
                   break;

                case DEPOSITO:
                    conti.put(iban,new ContoDeposito(iban,cf));
                    break;
                default:
                    return false;

            }
            contatore++;
            return true;
        }
        return false;


    }

    public boolean aggAcc(String iban, double amnt, AccountableType tipo){
        conti.get(iban).aggiungiAcc(tipo,amnt);
        return true;

    }

    public boolean fineMese(){

        for(String key: conti.keySet() ){

            conti.get(key).operazioni(conti.get(key).getImportoAcc());
            conti.get(key).operazioni(conti.get(key).getImportoAdd());


        }
        return true;

        
    }


    public String detConto(String iban){
        return conti.get(iban).toString();
    }

    public double saldoConto(String iban){
        return conti.get(iban).getSaldo();
    }

    public void operazione(String iban, double amnt){
        Conto test = conti.get(iban);
        if(!(test instanceof ContoWeb)){

            test.operazioni(amnt);
        }
    }

    public void operazione(String iban, double amnt, String pass){
        Conto test = conti.get(iban);
        if(test instanceof ContoWeb) {
            ((ContoWeb) test).operazioni(amnt, pass);
        }
    }

    public boolean changePW(String iban, String pass){
        Conto a = conti.get(iban);
        if(a instanceof ContoWeb){
            return ((ContoWeb) a).password(pass);
        }
        return false;
    }


}
