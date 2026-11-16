Conta
public class Conta {
    private double Saldo=0;
    private String Nome;

    public void depositar(double Valor){
        this.Saldo = this.Saldo + Valor + (Valor * 0.10);

    }
    public double getSaldo(){
     return this.Saldo;

}
    public void setNome (String Nome) {
        this.Nome = Nome;
    }
    public String getNome(){
    return this.Nome;
    }
}
Main
public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta ();

        c1.setNome ("Bruno do Funk");
        c2.setNome("Emily do Beachtenis");

        c1.depositar(100);
        c2.depositar(200);

        System.out.println("c1 - Nome:" + c1.getNome());
        System.out.println("c1 - Saldo:" + c1.getSaldo());
        System.out.println("c2 - Nome:" + c2.getNome());
        System.out.println("c2 - Saldo:" + c2.getSaldo());
    }
}
