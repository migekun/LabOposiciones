package es.navas.oposiciones.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Laura Folgado Galache
 */
public class Ficheros {
    
    private static Scanner sc;

	/**
     * Programa principal que muestra al usuario un menú para trabajar con ficheros
     * @param args 
     */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("************ MENU DE FICHEROS ****************");
            System.out.println("1. Listar los ficheros de un directorio");
            System.out.println("2. Crear un fichero de números");
            System.out.println("3. Mostrar un fichero");
            System.out.println("4. Sumar un fichero de números ya existente");
            System.out.println("5. Borrar un fichero creado");
            System.out.println("6. Salir del programa");
            System.out.println("Introduce una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    listar();
                    break;
                case 2:
                    crear();
                    break;
                case 3:
                    mostrar();
                    break;
                case 4:
                    suma();
                    break;
                case 5:
                    borrar();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el programa!");
                    break;
                default:
                    System.out.println("Opción errónea");
            }

            System.out.println("Pulsa una tecla para continuar... ");
            sc.nextLine();

        } while (opcion != 6);
    }

    /**
     * Obtiene un listado de todos los ficheros y directorios que se encuentran en el directorio actual del programa
     */
    public static void listar() {
        File fichero = new File("."); //La ruta se introduce entre comillas y el punto indica el directorio actual

        String[] listaArchivos = fichero.list();

        //Recorre toda la lista de ficheros y los muestra
        for (String nombreArchivo : listaArchivos) {
            System.out.println(nombreArchivo);
        }
    }

    /**
     * Crea un fichero y permite al usuario introducir enteros en él hasta que introduzca el número -1
     */
    public static void crear() {
        sc = new Scanner(System.in);
        String fichero = "";

        System.out.println("Introduce el nombre del fichero que deseas crear: ");
        fichero = sc.nextLine();
        try {
            //Abrimos el flujo de datos de escritura
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            int numero;

            System.out.println("Introduce números positivos; para salir escribe -1");
            do {
                System.out.println("Introduce un número: ");
                numero = sc.nextInt();
                if (numero != -1) {
                    //Escribimos el número en el fichero (como cadena) y un salto de línea
                    bw.write(String.valueOf(numero) + "\n");
                }
            } while (numero != -1);
            bw.close(); //Cerramos el flujo
        } catch (IOException ioe) {
            System.out.println("Error de escritura.");
        }
    }

    /**
     * Recorre el fichero de texto cuyo nombre ha introducido el usuario y lo muestra línea a lína
     */
    public static void mostrar() {
        sc = new Scanner(System.in);
        String fichero = "";

        System.out.println("Introduce el nombre del fichero que deseas visualizar: ");
        fichero = sc.nextLine();

        try {
            //Abrimos el flujo de datos de lectura
            BufferedReader br = new BufferedReader(new FileReader(fichero));

            String linea = "";

            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();//Cerramos el flujo
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el fichero " + fichero);
        } catch (IOException ioe) {
            System.out.println("No se puede leer el fichero " + fichero);
        }
    }

    /**
     * Realiza la suma de todos los números que se encuentran en el fichero cuyo nombre ha indicado el usuario
     */
    public static void suma() {
        sc = new Scanner(System.in);
        String fichero = "";

        System.out.println("Introduce el nombre del fichero del que deseas sumar los números: ");
        fichero = sc.nextLine();
        try {
            //Abrimos el flujo de datos de lectura
            BufferedReader br = new BufferedReader(new FileReader(fichero));

            String linea = "0";
            double suma = 0;

            while (linea != null) {
                suma += Double.parseDouble(linea);
                //Leemos línea a línea y sumamos el resultado (en double a la variable suma)
                linea = br.readLine();
            }
            br.close(); //Cerramos el flujo
            System.out.println("La suma es " + suma);
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el fichero " + fichero);
        } catch (IOException ioe) {
            System.out.println("No se puede leer el fichero " + fichero);
        }
    }

    /**
     * Borra un fichero cuyo nombre solicitamos al usuario
     */
    public static void borrar() {
        sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del fichero que deseas borrar: ");
        String nombreFichero = sc.nextLine();
        
        File fichero = new File(nombreFichero);

        if (fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero " + nombreFichero + " ha sido borrado correctamente");
        } else {
            System.out.println("El fichero " + nombreFichero + "no existe");
        }
    }
}
