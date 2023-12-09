package com.mycompany.parcialfinal_losnegativos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
public class Prestamo {

    @Getter
    @Setter
    public String fechaInicio;
    @Getter
    @Setter
    public String fechaFin;
    @Getter
    @Setter
    public Multa multaN;
    @Getter
    @Setter
    private Copia copiaPrestada;

    public Prestamo() {
        this.fechaInicio = "";
        this.fechaFin = "";
        this.multaN = null;
        this.copiaPrestada = null;
    }

    public void calcularFechaFin(int dias) {
        // Convertir la fecha de inicio a LocalDate
        LocalDate fechaInicioLocalDate = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Calcular la fecha final sumando los días de préstamo
        LocalDate fechaFinLocalDate = fechaInicioLocalDate.plusDays(dias);

        // Convertir la fecha final de nuevo a String y asignarla
        this.fechaFin = fechaFinLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void obtenerFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Convertir LocalDate a String
        String fechaActualString = fechaActual.toString();
        this.fechaInicio = fechaActualString;
    }

    public Multa generarMulta(Lector lectorN) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Convertir LocalDate a String
        String fechaActualString = fechaActual.toString();

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

            multaN = new Multa(fechaActualString);
            multaN.setLector(lectorN);
            multaN.calcularFechaFin(7);
        }

        return multaN;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", multaN=" + multaN.toString() + '}';
    }
}
