import java.math.BigDecimal;

public class Conta {

    protected BigDecimal saldo;

    protected BigDecimal taxaRendimento;

    public Conta(BigDecimal saldo, BigDecimal taxaRendimento) {
        this.saldo = saldo;
        this.taxaRendimento = taxaRendimento;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
