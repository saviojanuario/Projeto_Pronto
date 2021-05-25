import java.math.BigDecimal;

public class PessoaFisica extends Pessoa {

    protected String nome;

    protected String cpf;

    protected Conta contaPoupanca;

    protected Conta contaInvestimento;

    public void abrirContaCorrente(BigDecimal saldo){
        this.conta = new Conta(saldo, BigDecimal.ZERO);
    }

    public void abrirContaInvestimento(BigDecimal saldo, BigDecimal taxa){
        this.contaInvestimento = new Conta(saldo, taxa);
    }

    public void investir(BigDecimal valor) {
        BigDecimal taxaInvestimento = contaInvestimento.getTaxaRendimento();
        BigDecimal valorInvestido = valor.multiply(taxaInvestimento.add(BigDecimal.valueOf(1)));
        this.contaInvestimento.setSaldo(contaInvestimento.getSaldo().add(valorInvestido));
    }

    public void abrirContaPoupanca(BigDecimal saldo, BigDecimal taxa){
        this.contaPoupanca = new Conta(saldo, taxa);
    }

    public void investirPoupanca(BigDecimal valor) {
        BigDecimal taxaInvestimento = contaPoupanca.getTaxaRendimento();
        BigDecimal valorInvestido = valor.multiply(taxaInvestimento.add(BigDecimal.valueOf(1)));
        this.contaPoupanca.setSaldo(contaPoupanca.getSaldo().add(valorInvestido));
    }

    public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if(valor.compareTo(this.conta.getSaldo()) <= 0){
            this.conta.setSaldo(this.conta.getSaldo().subtract(valor));
            return;
        }
        throw new SaldoInsuficienteException();
    }

    public void transferir(BigDecimal valor, Pessoa outro) throws SaldoInsuficienteException {
        this.sacar(valor);
        outro.depositar(valor);
    }

    public BigDecimal consultarSaldoPoupanca(){
        return contaPoupanca.getSaldo();
    }

    public BigDecimal consultarSaldoInvestimento(){
        return contaInvestimento.getSaldo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(Conta contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(Conta contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }


}
