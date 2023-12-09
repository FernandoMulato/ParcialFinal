package com.mycompany.parcialfinal_losnegativos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
public class Multa {

    @Getter
    @Setter
    public String fechaInicio;
    @Getter
    @Setter
    public String fechaFin;
    @Getter
    @Setter
    public Lector lector;

    public Multa(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = "";
        this.lector = null;
    }

    public void calcularFechaFin(int dias) {
        // Convertir la fecha de inicio a LocalDate
        LocalDate fechaInicioLocalDate = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Calcular la fecha final sumando los días de préstamo
        LocalDate fechaFinLocalDate = fechaInicioLocalDate.plusDays(dias);

        // Convertir la fecha final de nuevo a String y asignarla
        this.fechaFin = fechaFinLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return "Multa{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
