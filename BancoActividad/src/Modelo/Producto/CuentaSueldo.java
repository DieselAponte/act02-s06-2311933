package Modelo.Producto;

import Excepciones.CuentaException;

public class CuentaSueldo implements CuentaAhorro {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaSueldo(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    @Override public String getNumeroCuenta() { return numeroCuenta; }
    @Override public double getSaldo() { return saldo; }

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

    @Override public String getTipoCuenta() { return "Sueldo"; }

    @Override
    public String getDetalles() {
        return String.format("Cuenta Sueldo - Nro: %s, Titular: %s, Saldo: $%.2f",
                numeroCuenta, titular, saldo);
    }
}