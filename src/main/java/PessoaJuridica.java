import java.math.BigDecimal;

public class PessoaJuridica extends Pessoa {

    protected String razaoSocial;

    protected String cnpj;

    protected Conta contaInvestimento;

    public void abrirContaCorrente(BigDecimal saldo){
        this.conta = new Conta(saldo, BigDecimal.ZERO);
    }

    public void abrirContaInvestimento(BigDecimal saldo, BigDecimal taxa){
        BigDecimal taxaJuridica = taxa.add(BigDecimal.valueOf(0.02));
        this.contaInvestimento = new Conta(saldo, taxaJuridica);
    }

    public void investir(BigDecimal valor){
        BigDecimal taxaInvestimento = contaInvestimento.getTaxaRendimento();
        BigDecimal valorInvestido = valor.multiply(taxaInvestimento.add(BigDecimal.valueOf(1)));
        this.contaInvestimento.setSaldo(contaInvestimento.getSaldo().add(valorInvestido));
    }

    public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if(valor.compareTo(this.conta.getSaldo()) <= 0) {
            this.conta.setSaldo(this.conta.getSaldo().subtract(valor.multiply(BigDecimal.valueOf(1.005))));
            return;
        }
        throw new SaldoInsuficienteException();
    }

    public void transferir(BigDecimal valor, Pessoa outro) throws SaldoInsuficienteException {
        this.sacar(valor);
        outro.depositar(valor);
    }

    public BigDecimal consultarSaldoInvestimento(){
        return contaInvestimento.getSaldo();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(Conta contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }
}
