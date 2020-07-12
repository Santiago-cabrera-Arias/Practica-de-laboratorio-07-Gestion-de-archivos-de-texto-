/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author santi
 */
public class ControladorArchivos {

    //Atributos de tipo String
    private String ruta;
    private File archivos;

    //Utilizamos el map debido a que este no puede contener llaves duplicadas.
    private Map<String, String> texto;

    /**
     * Constructor Controlador archivos.
     *
     * Aqui instanciamos el map creado anteriormente y llamamos al metodo
     * abecedarioDiccionario.
     *
     */
    public ControladorArchivos() {

        texto = new HashMap<>();
        diccionarioabecedario();

    }

    public String encriptarTexto(String mensaje) {

        String encriptar = "";

        //recorremos toda la caena de texto ingresada
        for (int i = 0; i < mensaje.length(); i++) {

            //Obtenemos cada una de las letas escritas y las guardamos en el 
            // atributo letras.
            String letras = mensaje.charAt(i) + "";

            //le preguntamos si es que las letras no son espacion
            if (!letras.equals("")) {

                for (Map.Entry<String, String> entry : texto.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (letras.equals(key)) {

                        encriptar += value;

                    }
                }
            } else {

                encriptar = "h";

            }

        }

        return encriptar;

    }

    public void diccionarioabecedario() {
        String[] abecedario = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String[] abecedarioEncriptado = {"~", "!", "@", "#", "$", "5", "6", "%", "^", "&", "*",
            "8", "|", "]", "`", "c", "a", "r", ">", "<", "?", "/", ".", "_", "-", "h"};

    }

    public void archivoTexto(String rutas, String nombre, String texto) {

        try {
            archivos = new File(rutas + File.separator + nombre);
            //el getAbsoltePath nos proporciona la ruta absoluta de un fichero.
            String rutaC = archivos.getAbsolutePath();
            //FileWriter nos sirve para escribir caracteres en archivos.
            FileWriter archivoE = new FileWriter(rutaC, true);
            //El BufferedWriter tiene la misma funcionalidad que el FileWriter  
            BufferedWriter caracteresArchivo = new BufferedWriter(archivoE);
            //agrega los caracteres al final del builder 
            caracteresArchivo.append(texto);
            caracteresArchivo.close();

            //En caso de que se produzca una excepcion el programa es interrumpido y terminado.
        } catch (FileNotFoundException e) {

        } catch (IOException e1) {

        } catch (Exception e2) {

        }

    }

}
