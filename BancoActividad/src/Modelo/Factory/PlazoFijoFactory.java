package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;
import Modelo.Producto.DepositoPlazoFijo;

public class PlazoFijoFactory extends CuentaAhorroFactory{
    @Override
    public CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros) {
        if (parametros.length < 3) {
            throw new IllegalArgumentException("Faltan parámetros: titular, monto, plazoDias, tasaInteres");
        }
        String titular = (String) parametros[0];
        double monto = (double) parametros[1];
        int plazoDias = (int) parametros[2];
        double tasaInteres = (double) parametros[3];
        return new DepositoPlazoFijo(numeroCuenta, titular, monto, plazoDias, tasaInteres);
    }
}
