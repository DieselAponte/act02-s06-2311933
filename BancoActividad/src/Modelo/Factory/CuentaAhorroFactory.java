package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;

public abstract class CuentaAhorroFactory {
    public abstract CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros);
}