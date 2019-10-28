package miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */
public abstract class Nodo {
    protected final static String INIT_TRAMA = "INI";
    protected final static String FIN_TRAMA = "FIN";
    protected final static String SEPARADOR_CAMPOS = "::";
    protected final static String IDENTIFICADOR_ID = "ID";
    private String idRed;
    private String idNodo;

    public Nodo(String idRed, String idNodo) {
        this.idRed = idRed;
        this.idNodo = idNodo;
    }

    public abstract String leerValor();

    protected String getID() {
        return idRed + idNodo;
    }
    protected void setIdRed(String idRed) { this.idRed = idRed; }
    protected void setIdNodo(String idNodo) { this.idNodo = idNodo;}

}
