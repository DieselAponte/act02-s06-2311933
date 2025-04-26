package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;
import Modelo.Producto.CuentaMenores;

public class CuentaMenoresFactory extends CuentaAhorroFactory{
    @Override
    public CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros) {
        if (parametros.length < 2) {
            throw new IllegalArgumentException("Faltan parámetros: menor y tutor");
        }
        String menor = (String) parametros[0];
        String tutor = (String) parametros[1];
        return new CuentaMenores(numeroCuenta, menor, tutor);
    }
}
