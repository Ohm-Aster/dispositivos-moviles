package com.example.imgrandom;

public class imagen {
    /*variables globales, seran los parametros que se pasan al metodo
    para mostrar la imagen en el imageview
     */
    int imagen;
    String texto;
    //crear constructor
    public imagen(int imagen, String texto) {
        this.imagen = imagen;
        this.texto = texto;
    }
    //crear getters
    public int getImagen() {    return imagen;    }
    public String getTexto() {  return texto;   }
}
