package es.navas.oposiciones.orientadoObjetos.banco;

/**
 * Clase Cuenta que permite almacenar información de una cuenta bancaria
 * @author Laura Folgado Galache
 */
public abstract class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private static int contador = 0; //Atributo común a todas las instancias de la clase

    /**
     * Constructor por defecto
     */
    public Cuenta() {
        System.out.println("Constructor por defecto de Cuenta");
        numeroCuenta = "";
        saldo = 0;
    }
    /**
     * Constructor con tres parámetros
     * @param numeroCuenta Número de cuenta
     * @param saldo Saldo de la cuenta
     */
    public Cuenta(String numeroCuenta, double saldo) {
        System.out.println("Constructor con parámetros de Cuenta");
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    /** 
     * Método que devuelve el saldo de la cuenta
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método que inicializa el saldo de la cuenta
     * @param saldo Saldo de la cuenta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    } 
    
    /**
     * Método abstracto que debe ser redefinido en las clases derivadas
     */
    public abstract void pagarIntereses ();
    
}
