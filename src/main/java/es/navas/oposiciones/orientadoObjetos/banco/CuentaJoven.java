package es.navas.oposiciones.orientadoObjetos.banco;

/**
 * Clase Cuenta que permite almacenar información de una cuenta bancaria
 * @author manavas
 */
public final class CuentaJoven extends Cuenta {

    /**
     * Constructor con parámetros
     * @param numeroCuenta Número de cuenta
     * @param saldo Saldo de la cuenta
     */
    public CuentaJoven(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

    /**
     * Implementación del método pagarIntereses. Si no lo implementamos, la clase se convierte en abstracta.
     */
    @Override
    public void pagarIntereses() {
        this.setSaldo(this.getSaldo()*1.05);
    }
    
}
