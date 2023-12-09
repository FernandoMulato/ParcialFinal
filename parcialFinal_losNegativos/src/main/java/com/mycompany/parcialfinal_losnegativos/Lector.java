package com.mycompany.parcialfinal_losnegativos;

import com.mycompany.exepcionesPersonalizadas.CopiaExisteException;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
public class Lector {

    @Getter
    @Setter
    public String numSocio;
    @Getter
    @Setter
    public String nombre;
    @Getter
    @Setter
    public String apellidos;
    @Getter
    @Setter
    public String direccion;
    @Getter
    public ArrayList<Prestamo> prestamos;
    @Getter
    @Setter
    public Multa multa;
    @Getter
    public Copia[] copias;

    public Lector(String numSocio, String nombre, String apellidos, String direccion) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.prestamos = new ArrayList<>();
        this.copias = new Copia[3];
        this.multa = null;

    }

    public Multa comprobarMultasPendientes() {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.multaN != null) {
                System.out.println(prestamo.multaN.toString());
            } else {
                System.out.println("No hay ninguna multa pendiente");
            }
        }
        return this.multa;
    }

    public void agregarMulta(Multa multaN) {
        if (multa == null) {
            multa = multaN;
        }
    }

    public void agregarCopia(Copia copia) throws CopiaExisteException {
        try {
            for (int i = 0; i < 3; i++) {
                if (copias[i] != null && copia.getIdentificador().equals(copias[i].getIdentificador())) {
                    throw new CopiaExisteException("Error, la copia ya existe");
                } else if (copias[i] == null) {
                    copias[i] = copia;
                    break;
                }
            }
        } catch (CopiaExisteException e) {
            throw e; // Deja que el filtro de excepciones global maneje esta excepción
        }
    }

    public void devolverCopia(String identificadorDeCopia) {
        for (int i = 0; i < 3; i++) {
            if (copias[i] != null && copias[i].getIdentificador().equals(identificadorDeCopia)) {
                copias[i] = null; // Elimina la copia (poniéndola a null)
                break;
            }
        }
    }

    public void agregarPrestamo(Prestamo prestamo, Copia copia) {
        prestamo.setCopiaPrestada(copia);
        prestamos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    @Override
    public String toString() {
        return "Lector{" + "numSocio=" + numSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + '}';
    }

}
