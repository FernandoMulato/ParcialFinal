package com.mycompany.parcialfinal_losnegativos;

import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Copia {

    public String identidicador;
    public String estado;

    public Copia(String identidicador, String estado) {
        this.identidicador = identidicador;
        this.estado = estado;
    }

    public void devolver() {
    }

    public void prestar() {
    }
}
