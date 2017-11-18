public class Tester {
    public static void main(String[] args) throws InterruptedException {
        Banca b = new Banca("NuovaBanca",10);
        Abbonamento abbTV = new Abbonamento(AccountableType.ADDEBITO,-50);
        Stipendio stipendio = new Stipendio(AccountableType.ACCREDITO,0);



        b.aggiungiConto("CF1",TipoConto.CORRENTE);
        b.aggiungiConto("CF2",TipoConto.WEB);
        b.aggiungiConto("CF3",TipoConto.DEPOSITO);
        b.aggiungiConto("CF4",TipoConto.WEB);

        System.out.println("Aggiungo abbonamento tv a ITA000CF11");
        b.aggAcc("ITA000CF11",abbTV.getImporto(), abbTV.getTipo());
        System.out.println("Aggiungo abbonamento tv a ITA000CF22");
        b.aggAcc("ITA000CF22",abbTV.getImporto(), abbTV.getTipo());
        System.out.println("Aggiungo abbonamento tv a ITA000CF33");
        b.aggAcc("ITA000CF33",abbTV.getImporto(), abbTV.getTipo());
        System.out.println("Aggiungo stipendio a ITA000CF11");
        b.aggAcc("ITA000CF11", 1000, stipendio.getTipo());
        System.out.println("Aggiungo stipendio a ITA000CF22");
        b.aggAcc("ITA000CF22", 2000, stipendio.getTipo());
        System.out.println("Aggiungo stipendio a ITA000CF33");
        b.aggAcc("ITA000CF33", 3000, stipendio.getTipo());
        System.out.println("Aggiungo stipendio a ITA000CF44");
        b.aggAcc("ITA000CF44", 3000, stipendio.getTipo());

        System.out.println("Tentativo di transazione prima del cambio password");
        b.operazione("ITA000CF44",100, "changename");

        b.changePW("ITA000CF22","password1");
        b.changePW("ITA000CF44","password2");

        System.out.println("Deposito 100 su conto ITA000CF11 ");
        b.operazione("ITA000CF11",100);
        System.out.println("Deposito 100 su conto ITA000CF22 ");
        b.operazione("ITA000CF22",100, "password1");
        System.out.println("Deposito 100 su conto ITA000CF33 ");
        b.operazione("ITA000CF33",100);
        System.out.println("Prelievo 50 da conto ITA000CF11 ");
        b.operazione("ITA000CF11",-50);
        System.out.println("Prelievo 50 da conto ITA000CF22 ");
        b.operazione("ITA000CF22",-50,"password1");
        System.out.println("Prelievo 50 da conto ITA000CF33 ");
        b.operazione("ITA000CF33",-50);
        System.out.println("Prelievo 150 da conto ITA000CF11 ");
        b.operazione("ITA000CF11",-150);
        System.out.println("Prelievo 150 da conto ITA000CF22 ");
        b.operazione("ITA000CF22",-150, "password1");
        System.out.println("Prelievo 150 da conto ITA000CF33 ");
        b.operazione("ITA000CF33",-150);
        System.out.println("Deposito 100 su conto ITA000CF22 ");
        b.operazione("ITA000CF22",100, "password1");
        System.out.println("Deposito 100 su conto ITA000CF44 ");
        b.operazione("ITA000CF44",100, "password2");
        System.out.println("Deposito 100 su conto ITA000CF44 con password sbagliata");
        b.operazione("ITA000CF44",100, "password3");

        for(int i=0; i<12; i++) {
            b.fineMese();
            System.out.println("Saldo mese "+(i+1));
            System.out.println(b.detConto("ITA000CF11"));
            System.out.println(b.detConto("ITA000CF22"));
            System.out.println(b.detConto("ITA000CF33"));
            System.out.println(b.detConto("ITA000CF44"));
            Thread.sleep(5000);

        }
        System.out.println("%Saldo a fine anno%");
        System.out.println(b.detConto("ITA000CF11"));
        System.out.println(b.detConto("ITA000CF22"));
        System.out.println(b.detConto("ITA000CF33"));
        System.out.println(b.detConto("ITA000CF44"));
    }
}
