package Modelo.Producto;

import Excepciones.CuentaException;

public class CuentaDigital implements CuentaAhorro{
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private String email;

    public CuentaDigital(String numeroCuenta, String titular, String email) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.email = email;
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
        if (monto > 1000) throw new CuentaException("Límite de retiro excedido para cuenta digital");
        saldo -= monto;
    }

    @Override
    public String getTipoCuenta() { return "Digital"; }

    @Override
    public String getDetalles() {
        return String.format("Cuenta Digital - Nro: %s, Titular: %s, Email: %s, Saldo: $%.2f",
                numeroCuenta, titular, email, saldo);
    }

}
