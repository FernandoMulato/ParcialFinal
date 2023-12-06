package com.mycompany.parcialfinal_losnegativos;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Lector {

    public String numSocio;
    public String nomnbre;
    public String apellidos;
    public String direccion;
    public ArrayList<Prestamo> prestamos;

    public Lector(String numSocio, String nomnbre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nomnbre = nomnbre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
    }

    public void comprobarMultasPendientes() {
        for (Prestamo prestamo : prestamos) {
            prestamo.generalMulta();
        }
    }
}
