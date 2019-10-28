package miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */
public class NodoSensor extends Nodo {

    private static final String VALOR = "VALOR";
    private String valor;

    public NodoSensor(String idRed, String idNodo, String valor) {
        super(idRed, idNodo);
        this.valor = valor;
    }

    @Override
    /**
     * INI::ID:XXXXX::VALOR:XXXX::FIN (size==30)
     *
     */
    public String leerValor() {
        return INIT_TRAMA + SEPARADOR_CAMPOS + IDENTIFICADOR_ID + ":" + super.getID() + SEPARADOR_CAMPOS + VALOR + ":" + valor + SEPARADOR_CAMPOS + FIN_TRAMA;
    }


    /**
     *   ID servirá para identificar al nodo en la red IOT,
     *   será un valor numérico entero y estará formado por dos partes:
     *   id_red (identificador de la red iot:2 numeros) e
     *   id_nodo (identificador del noto iot: 3 numeros - longitud total 5).
     * @return
     */
    private String obtenID() {
        return null;
    }


}
