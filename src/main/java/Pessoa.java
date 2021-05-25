import java.math.BigDecimal;

public class Pessoa {

    protected Conta conta;

    public void depositar(BigDecimal valor){
        this.conta.setSaldo(this.conta.getSaldo().add(valor));
    }

    public BigDecimal consultarSaldo(){
        return conta.getSaldo();
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
