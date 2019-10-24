package es.navas.oposiciones.autoevaluacion.retos.miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */
public abstract class Nodo {
    protected final static String INIT_TRAMA = "INI";
    protected final static String FIN_TRAMA = "FIN";
    protected final static String SEPARADOR_CAMPOS = "::";
    protected final static String IDENTIFICADOR_ID = "ID";
    private Integer idRed;
    private Integer idNodo;

    public Nodo(Integer idRed, Integer idNodo) {
        this.idRed = idRed;
        this.idNodo = idNodo;
    }

    public abstract String leerSensor();

    public Integer getIdRed() { return idRed; }
    public void setIdRed(Integer idRed) { this.idRed = idRed; }

    public Integer getIdNodo() { return idNodo; }
    public void setIdNodo(Integer idNodo) { this.idNodo = idNodo;}

}
