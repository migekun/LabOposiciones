package es.navas.oposiciones.autoevaluacion.retos.miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */

/**
 * Una red IOT, está compuesta por 5 nodos, de los cuales 3 son sensores, (1 de temperatura, 1 de humedad, y otro de luminosidad) y 2 son actuadores (1 sirve para encender/apagar una bomba de riego, y el otro para encender/apagar la iluminación).

 Los sensores están construidos con microcontroladores Arduino uno, y todos ellos disponen de un módulo de radio RF (433Mhz) para enviar los datos a un nodo central, formado también por un Arduino uno, que hace de Gateway entre la red IOT y la red TCP/IP(wifi), que dispone de un módulo RF (433Mhz) para recibir los datos de los sensores, y de un módulo Wifi, para conectarse a la red wifi de un router, que a su vez está conectado a internet.

 Nodos:

 Los nodos Arduino envían los datos a través de RF (433Mhz), y este módulo funciona a través del puerto serie del Arduino (COM13 por ejemplo) es decir los datos que se envían al puerto serie, serán enviados por RF.

 Nodos Sensores:  (Arduino Uno + sensor + modulo RF 433Mhz)

 En los nodos sensores, el nodo leerá el valor del sensor, y formará un string, que enviará por el puerto serie (RF). El string que se deberá formar, tendrá el siguiente formato:

 “INI::ID:XXXXX::VALOR:XXXX::FIN” (Longitud total de la trama: 30)

 Donde:

 -          INI:Indicará el inicio de una trama.

 -          ID servirá para identificar al nodo en la red IOT, será un valor numérico entero y estará formado por dos partes: id_red (identificador de la red iot:2 numeros) e id_nodo (identificador del noto iot: 3 numeros- longitud total 5).

 -          VALOR: Valor del sensor: será un valor numérico entero entre 0 y 1024 (tendrá 4 digitos siempre)

 -          FIN: indicará el fin  de una trama.

 -          Los :: dobles sirven de separador de campos.

 Ejemplo: Sensor de temperatura “INI::ID:01001::VALOR:0010::FIN”

 Implementa una clase llamada: nodo_sensor que simule este nodo.

 Nodos Actuadores: (Arduino Uno + rele + modulo RF 433Mhz)

 En los nodos actuadores, el nodo leerá el estado del actuador (encendido-apagado), y formará un string, que enviará por el puerto serie (RF). El string que se deberá formar, tendrá el siguiente formato:

 “INI::ID:XXXXX::ESTADO:X::FIN” (Longitud total de la trama: 28)

 Donde:

 -          INI:Indicará el inicio de una trama.

 -          ID servirá para identificar al nodo en la red IOT, será un valor numérico entero y estará formado por dos partes: id_red (identificador de la red iot:2 numeros) e id_nodo (identificador del noto iot: 3 numeros- longitud total 5).

 -          ESTADO: Indicará el estado del actuador del nodo. Tendrá dos posibles valores 0 (apagado). 1 (Encendido) (1 dígito entero)

 -          FIN: indicará el fin  de una trama.

 -          Los :: dobles sirven de separador de campos.

 Ejemplo: Actuador Motor “INI::ID:01003::ESTADO:0::FIN” (Longitud total de la trama: 28)

 Por otra parte, este nodo deberá disponer de un método que le permita leer los datos a través del puerto serie para actualizar el estado del actuador (encender-apagar el motor de forma remota).

 Implementa una clase llamada: nodo_actuador que simule este nodo.

 GATEWAY:  (Arduino Uno + modulo RF 433Mhz + modulo WIFI + tarjeta SD)

 En el Gateway se utilizaran las mismas clases para almacenar los datos recibidos, (nodo_sensor y nodo_actuador, pero sin los métodos de envío de datos.

 Por tanto se dispondrá de tres objetos llamados: sensor1, sensor2 y sensor3 para almacenar los datos recibidos de los sensores, y de dos objetos llamados: actuador1 y actuador2, para almacenar los datos de los actuadores.

 En el Gateway se pretende almacenar un log con los valores de los sensores para el análisis posterior de los datos recibidos.

 Para ello, crea una clase estática llamada Little data, que dispondrá de un método estático que analice los datos recibidos procedentes del puerto serie de forma periódica, y los almacene en los objetos correspondientes: sensor1, sensor2, sensor3 ó actuador1 ó actuador2. (En los objetos se almacenará el último valor recibido)

 Además, en caso de que los datos recibidos correspondan a sensores, se analizarán los mensajes recibidos y se almacenarán los datos en  3 ficheros de texto, uno para cada tipo de sensor, llamados: temperatura.txt, humedad.txt y luminosidad.txt.

 En definitiva, se trata de crear tres clases: nodo_sensor, nodo_actuador y little_data que simulen la implementación de este mini-protocolo de comunicación.
 */

public class Principal {

    public static void main(String[] args){

    }

}
