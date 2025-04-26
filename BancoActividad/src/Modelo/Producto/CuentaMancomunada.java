package Modelo.Producto;

import Excepciones.CuentaException;

import java.util.List;

public class CuentaMancomunada implements CuentaAhorro{
    private String numeroCuenta;
    private double saldo;
    private List<String> titulares;

    public CuentaMancomunada(String numeroCuenta, List<String> titulares) {
        this.numeroCuenta = numeroCuenta;
        this.titulares = titulares;
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
        saldo -= monto;
    }

    @Override
    public String getTipoCuenta() { return "Mancomunada"; }

    @Override
    public String getDetalles() {
        return String.format("Cuenta Mancomunada - Nro: %s, Titulares: %s, Saldo: $%.2f",
                numeroCuenta, String.join(", ", titulares), saldo);
    }
}
