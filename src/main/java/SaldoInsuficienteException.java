
public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(){
        super("Não há saldo suficiente para esta operação");
    }
}