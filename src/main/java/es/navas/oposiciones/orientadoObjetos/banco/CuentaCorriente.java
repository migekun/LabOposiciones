package es.navas.oposiciones.orientadoObjetos.banco;

/**
 * Clase Cuenta que permite almacenar información de una cuenta bancaria (corriente)
 * @author manavas
 */
public abstract class CuentaCorriente extends Cuenta{

    /**
     * Constructor con parámetros
     * @param numeroCuenta Número de la cuenta
     * @param saldo Saldo de la cuenta
     */
    public CuentaCorriente(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

   
}
