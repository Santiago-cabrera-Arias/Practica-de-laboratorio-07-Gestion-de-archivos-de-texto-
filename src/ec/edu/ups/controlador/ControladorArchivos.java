/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author santi
 */
public class ControladorArchivos {

    //Atributos de tipo String
    private String ruta;
    private String archivos;

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
    
    

}
