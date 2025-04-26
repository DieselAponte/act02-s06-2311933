package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;
import Modelo.Producto.CuentaDigital;

public class CuentaDigitalFactory extends CuentaAhorroFactory{
    public CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros) {
            if (parametros.length < 2) {
                throw new IllegalArgumentException("Faltan parámetros: titular y email");
            }
            String titular = (String) parametros[0];
            String email = (String) parametros[1];
            return new CuentaDigital(numeroCuenta, titular, email);
    }
}
