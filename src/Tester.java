public class Tester {
    public static void main(String[] args) {
        Banca b = new Banca("NuovaBanca",10);
        Abbonamento abbTV = new Abbonamento(AccountableType.ADDEBITO,-50);
        Stipendio stipendio = new Stipendio(AccountableType.ACCREDITO,0);



        b.aggiungiConto("CF1",TipoConto.CORRENTE);
        b.aggiungiConto("CF2",TipoConto.WEB);
        b.aggiungiConto("CF3",TipoConto.DEPOSITO);
        b.aggiungiConto("CF4",TipoConto.WEB);

        b.aggAcc("ITA000CF11",abbTV.getImporto(), abbTV.getTipo());
        b.aggAcc("ITA000CF22",abbTV.getImporto(), abbTV.getTipo());
        b.aggAcc("ITA000CF33",abbTV.getImporto(), abbTV.getTipo());
        b.aggAcc("ITA000CF11", 1000, stipendio.getTipo());
        b.aggAcc("ITA000CF22", 2000, stipendio.getTipo());
        b.aggAcc("ITA000CF33", 3000, stipendio.getTipo());
        b.aggAcc("ITA000CF44", 3000, stipendio.getTipo());

        System.out.println(b.changePW("ITA000CF22","password1"));
        b.changePW("ITA000CF44","password2");

        b.operazione("ITA000CF11",100);
        b.operazione("ITA000CF22",100, "password1");
        b.operazione("ITA000CF33",100);
        b.operazione("ITA000CF11",-50);
        b.operazione("ITA000CF22",-50,"password1");
        b.operazione("ITA000CF33",-50);
        b.operazione("ITA000CF11",-150);
        b.operazione("ITA000CF22",-150, "password1");
        b.operazione("ITA000CF33",-150);
        b.operazione("ITA000CF22",100, "password1");
        b.operazione("ITA000CF44",100, "password2");
        b.operazione("ITA000CF44",100, "password3");

        b.fineMese();

        System.out.println(b.detConto("ITA000CF11"));
        System.out.println(b.detConto("ITA000CF22"));
        System.out.println(b.detConto("ITA000CF33"));
        System.out.println(b.detConto("ITA000CF44"));
    }
}
