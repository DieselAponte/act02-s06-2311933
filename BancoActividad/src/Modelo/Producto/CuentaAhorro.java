package Modelo.Producto;

import Excepciones.CuentaException;

public interface CuentaAhorro {
    String getNumeroCuenta();
    double getSaldo();
    void depositar(double monto);
    void retirar(double monto) throws CuentaException, CuentaException;
    String getTipoCuenta();
    String getDetalles();
}