package dominio;

public class Billetera {
    private int saldo;

    public Billetera(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int getSaldo() {
        return saldo;
    }

    public void restarSaldo(int cantidad) {
        saldo -= cantidad;
    }

    public void sumarSaldo(int cantidad) {
        saldo += cantidad;
    }
}
