package com.mycompany.parcialfinal_losnegativos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Multa {

    public String fechaInicio;
    public String fechaFin;

    public Multa(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = "";
    }

    public void calcularFechaFin(int dias) {
        // Convertir la fecha de inicio a LocalDate
        LocalDate fechaInicioLocalDate = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Calcular la fecha final sumando los días de préstamo
        LocalDate fechaFinLocalDate = fechaInicioLocalDate.plusDays(dias);

        // Convertir la fecha final de nuevo a String y asignarla
        this.fechaFin = fechaFinLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
