package com.mycompany.parcialfinal_losnegativos;

import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Libro {

    public String nombre;
    public String tipo;
    public String editorial;
    public String anio;

    public Libro(String nombre, String tipo, String editorial, String anio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anio = anio;
    }

}
