package Modelo.Factory;
import java.util.List;
import Modelo.Producto.CuentaAhorro;
import Modelo.Producto.CuentaMancomunada;

public class CuentaMancomunadaFactory extends CuentaAhorroFactory{
    @Override
    public CuentaAhorro crearCuenta(String numeroCuenta, Object... parametros) {
        if (parametros.length < 1) {
            throw new IllegalArgumentException("Falta la lista de titulares");
        }
        @SuppressWarnings("unchecked")
        List<String> titulares = (List<String>) parametros[0];
        return new CuentaMancomunada(numeroCuenta, titulares);
    }
}
