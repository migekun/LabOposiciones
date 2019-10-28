package es.navas.oposiciones.autoevaluacion.retos.miniProtocolo;

/**
 * Created by manavas on 24/10/19.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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

public class Gateway {

    public static void main(String[] args){

        LittleData.analiza();

    }

    static class LittleData {

        private static final Random RANDOM = new Random();

        static void analiza() {
            long t= System.currentTimeMillis();
            long end = t + 1000; //1 segundos de simulación
            while(System.currentTimeMillis() < end) {
                Nodo nodoSensorTemperatura = new NodoSensor(obtenNumeroRed(), obtenNodo(), obtenValor());
//                System.out.println(nodoSensorTemperatura.leerValor());
                Nodo nodoSensorHumedad = new NodoSensor(obtenNumeroRed(), obtenNodo(), obtenValor());
//                System.out.println(nodoSensorHumedad.leerValor());
                Nodo nodoSensorLuminosidad = new NodoSensor(obtenNumeroRed(), obtenNodo(), obtenValor());
//                System.out.println(nodoSensorLuminosidad.leerValor());
                Nodo nodoActuador1 = new NodoActuador(obtenNumeroRed(), obtenNodo(), RANDOM.nextInt(1));
//                System.out.println(nodoActuador1.leerValor());
                Nodo nodoActuador2 = new NodoActuador(obtenNumeroRed(), obtenNodo(), RANDOM.nextInt(2));
//                System.out.println(nodoActuador2.leerValor());
                log("temperatura.txt", nodoSensorTemperatura);
                log("humedad.txt", nodoSensorHumedad);
                log("luminosidad.txt", nodoSensorLuminosidad);
            }
        }

        private static String obtenNumeroRed() {
            int numeroRed = RANDOM.nextInt(98) + 1; //avoid cero
            return numeroRed < 10 ? "0" + numeroRed : String.valueOf(numeroRed);
        }

        private static String obtenNodo() {
            int numeroNodo = RANDOM.nextInt(998) + 1; //avoid cero
            return numeroNodo < 10 ? "00" + numeroNodo :
                    (numeroNodo < 100 ? "0" + numeroNodo : String.valueOf(numeroNodo));
        }
        private static String obtenValor() {
            int numeroValor = RANDOM.nextInt(1024);
            return numeroValor < 10 ? "000" + numeroValor:
                    (numeroValor < 100 ? "00" + numeroValor:
                            (numeroValor < 1000 ? "0"  + numeroValor:
                            String.valueOf(numeroValor)));
        }


        public static void log(String nombre, Nodo informacion) {
            try {
                File fichero = new File(nombre);
                BufferedWriter bw;
                if (fichero.exists()) {
                    bw = new BufferedWriter(new FileWriter(fichero, true));
                } else {
                    bw = new BufferedWriter(new FileWriter(nombre));
                }

                bw.write(informacion.leerValor() + "\n");
                bw.close(); //Cerramos el flujo
            } catch (IOException ioe) {
                System.out.println("Error de escritura.");
            }
        }

    }



}
