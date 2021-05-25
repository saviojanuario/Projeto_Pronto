import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args){

        PessoaFisica pf = new PessoaFisica();
        pf.abrirContaCorrente(BigDecimal.valueOf(1000.0));

        PessoaJuridica pj = new PessoaJuridica();
        pj.abrirContaCorrente(BigDecimal.valueOf(1000.0));

        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

        System.out.println("--------Saque--------");
        try{
            pf.sacar(BigDecimal.valueOf(100));
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }

        try {
            pj.sacar(BigDecimal.valueOf(100));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

        System.out.println("--------Depositar--------");
        pf.depositar(BigDecimal.valueOf(100));
        pj.depositar(BigDecimal.valueOf(100));
        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

        System.out.println("--------Transferir de pf para pj--------");
        try{
            pf.transferir(BigDecimal.valueOf(100), pj);
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }

        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

        System.out.println("--------Transferir de pj para pf--------");
        try {
            pj.transferir(BigDecimal.valueOf(100), pf);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

        System.out.println("--------Consultar Saldo--------");
        System.out.println(pf.consultarSaldo());
        System.out.println(pj.consultarSaldo());

        System.out.println("--------Investir PJ--------");
        pj.abrirContaInvestimento(BigDecimal.valueOf(0), BigDecimal.valueOf(0.03));
        pj.investir(BigDecimal.valueOf(100));
        System.out.println(pj.consultarSaldoInvestimento());

        System.out.println("--------Investir PF--------");
        pf.abrirContaInvestimento(BigDecimal.valueOf(0), BigDecimal.valueOf(0.03));
        pf.investir(BigDecimal.valueOf(100));
        System.out.println(pf.consultarSaldoInvestimento());

        System.out.println("--------Investir Poupanca PF--------");
        pf.abrirContaPoupanca(BigDecimal.valueOf(0), BigDecimal.valueOf(0.02));
        pf.investirPoupanca(BigDecimal.valueOf(100));
        System.out.println(pf.consultarSaldoPoupanca());

        System.out.println("--------Transferir de pf para pj com erro--------");
        try{
            pf.transferir(BigDecimal.valueOf(1000000000), pj);
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }

        System.out.println(pf.getConta().getSaldo());
        System.out.println(pj.getConta().getSaldo());

    }

}
