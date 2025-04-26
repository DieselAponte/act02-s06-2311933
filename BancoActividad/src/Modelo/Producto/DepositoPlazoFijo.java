package Modelo.Producto;

import Excepciones.CuentaException;

import java.time.LocalDate;

public class DepositoPlazoFijo implements CuentaAhorro{
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private LocalDate fechaVencimiento;
    private double tasaInteres;

    public DepositoPlazoFijo(String numeroCuenta, String titular, double monto, int plazoDias, double tasaInteres) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = monto;
        this.fechaVencimiento = LocalDate.now().plusDays(plazoDias);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String getNumeroCuenta() { return numeroCuenta; }

    @Override
    public double getSaldo() { return saldo; }

    @Override
    public void depositar(double monto) {
        throw new UnsupportedOperationException("No se pueden hacer depósitos adicionales en un plazo fijo");
    }

    @Override
    public void retirar(double monto) throws CuentaException {
        if (LocalDate.now().isBefore(fechaVencimiento)) {
            throw new CuentaException("No se puede retirar antes del vencimiento");
        }
        if (monto != saldo) {
            throw new CuentaException("En un plazo fijo debe retirar el monto completo");
        }
        saldo = 0;
    }

    @Override
    public String getTipoCuenta() { return "Plazo Fijo"; }

    @Override
    public String getDetalles() {
        return String.format("Depósito Plazo Fijo - Nro: %s, Titular: %s, Saldo: $%.2f, Vencimiento: %s, Tasa: %.2f%%",
                numeroCuenta, titular, saldo, fechaVencimiento, tasaInteres * 100);
    }
}
