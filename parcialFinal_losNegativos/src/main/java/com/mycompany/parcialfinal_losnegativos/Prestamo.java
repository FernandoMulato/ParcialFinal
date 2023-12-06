package com.mycompany.parcialfinal_losnegativos;

import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 * @author 104623010370 Laura Isabel Sanchez Fernandez
 */
public @Data class Prestamo {

    public String fechaInicio;
    public String fechaFin;
    public Multa multaN;

    public Prestamo(String fechaInicio) {
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

    public void generalMulta() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Convertir la fecha de fin a LocalDate
        LocalDate fechaFinLocalDate = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Comparar la fecha actual con la fecha de fin
        if (fechaActual.isAfter(fechaFinLocalDate)) {
            // Calcular la cantidad de días de retraso
            long diasDeRetraso = fechaActual.toEpochDay() - fechaFinLocalDate.toEpochDay();

            // Calcular la multa (por ejemplo, $5 por día de retraso)
            double multa = diasDeRetraso * 5;

            System.out.println("¡Libro devuelto con retraso!");
            System.out.println("Días de retraso: " + diasDeRetraso);
            System.out.println("Multa generada: $" + multa);
        } else {
            System.out.println("Libro devuelto a tiempo. No se genera multa.");
        }
    }
}
