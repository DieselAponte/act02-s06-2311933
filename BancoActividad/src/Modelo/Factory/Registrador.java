package Modelo.Factory;

import Modelo.Producto.CuentaAhorro;
import Excepciones.CuentaException;

import java.util.HashMap;
import java.util.Map;

public class Registrador {
    private static final Map<String, CuentaAhorroFactory> creators = new HashMap<>();

    static {
        creators.put("Sueldo", new CuentaSueldoFactory());
        creators.put("Digital", new CuentaDigitalFactory());
        creators.put("Mancomunada", new CuentaMancomunadaFactory());
        creators.put("Plazo Fijo", new PlazoFijoFactory());
        creators.put("Menores", new CuentaMenoresFactory());
    }

    public static CuentaAhorro crearCuenta(String tipo, String numeroCuenta, Object... parametros) throws CuentaException {
        CuentaAhorroFactory creator = creators.get(tipo);
        if (creator == null) {
            throw new CuentaException("Tipo de cuenta no soportado: " + tipo);
        }
        return creator.crearCuenta(numeroCuenta, parametros);
    }
}
