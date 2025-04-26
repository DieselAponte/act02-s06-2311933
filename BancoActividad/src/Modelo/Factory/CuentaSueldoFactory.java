package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;
import Modelo.Producto.CuentaSueldo;

public class CuentaSueldoFactory extends CuentaAhorroFactory {
    @Override
    public CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros) {
        if (parametros.length < 1 || !(parametros[0] instanceof String)) {
            throw new IllegalArgumentException("Se requiere parámetro 'titular' (String)");
        }
        return new CuentaSueldo(numeroCuenta, (String) parametros[0]);
    }
}