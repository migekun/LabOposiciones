package miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */
public class NodoActuador extends Nodo {
    private static final String ESTADO = "ESTADO";
    private int estado;

    public NodoActuador(String idRed, String idNodo, int estado) {
        super(idRed, idNodo);
        this.estado = estado;
    }

    @Override
    public String leerValor() {
        return INIT_TRAMA + SEPARADOR_CAMPOS + IDENTIFICADOR_ID + ":" + super.getID() + SEPARADOR_CAMPOS + ESTADO + ":" + estado + SEPARADOR_CAMPOS +  FIN_TRAMA;
    }
}
