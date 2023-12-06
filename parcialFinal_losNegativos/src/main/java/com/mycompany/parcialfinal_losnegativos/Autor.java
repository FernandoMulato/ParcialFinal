package com.mycompany.parcialfinal_losnegativos;

import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Autor {

    public String nombre;
    public String nacionalidad;
    public String fechaNacimiento;

    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
