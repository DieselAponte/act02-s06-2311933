package Modelo.Producto;

import Excepciones.CuentaException;

public class CuentaMenores implements CuentaAhorro{
    private String numeroCuenta;
    private double saldo;
    private String menor;
    private String tutor;

    public CuentaMenores(String numeroCuenta, String menor, String tutor) {
        this.numeroCuenta = numeroCuenta;
        this.menor = menor;
        this.tutor = tutor;
        this.saldo = 0.0;
    }

    @Override
    public String getNumeroCuenta() { return numeroCuenta; }

    @Override
    public double getSaldo() { return saldo; }

    @Override
    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    @Override
    public void retirar(double monto) throws CuentaException {
        if (monto <= 0) throw new CuentaException("Monto de retiro inválido");
        if (saldo < monto) throw new CuentaException("Saldo insuficiente");
        if (monto > 200) throw new CuentaException("Límite de retiro excedido para cuenta de menores");
        saldo -= monto;
    }

    @Override
    public String getTipoCuenta() { return "Menores"; }

    @Override
    public String getDetalles() {
        return String.format("Cuenta Menores - Nro: %s, Menor: %s, Tutor: %s, Saldo: $%.2f",
                numeroCuenta, menor, tutor, saldo);
    }
}
