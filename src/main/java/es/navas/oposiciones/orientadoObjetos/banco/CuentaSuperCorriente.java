
package es.navas.oposiciones.orientadoObjetos.banco;

/**
 * Clase Cuenta que permite almacenar información de una cuenta bancaria
 * @author manavas
 */
public class CuentaSuperCorriente extends CuentaCorriente{

    /**
     * Constructor con parámetros
     * @param numeroCuenta Número de cuenta
     * @param saldo Saldo de cuenta
     */
    public CuentaSuperCorriente(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

    /**
     * Implementación del método pagarIntereses. Si no lo definimos, la clase se convierte en abstracta
     */
    @Override
    public void pagarIntereses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
