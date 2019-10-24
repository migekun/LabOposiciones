package es.navas.oposiciones.autoevaluacion.retos.miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */
public class NodoSensor extends Nodo {

    private String valor;

    public NodoSensor(Integer idRed, Integer idNodo, String valor) {
        super(idRed, idNodo);
        this.valor = valor;
    }

    @Override
    public String leerSensor() {
        return INIT_TRAMA + SEPARADOR_CAMPOS + IDENTIFICADOR_ID + SEPARADOR_CAMPOS + FIN_TRAMA;
    }
}
