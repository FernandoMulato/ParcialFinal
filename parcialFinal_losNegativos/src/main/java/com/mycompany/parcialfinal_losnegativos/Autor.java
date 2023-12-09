package com.mycompany.parcialfinal_losnegativos;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
public class Autor {

    @Getter
    @Setter
    public String nombre;
    @Getter
    @Setter
    public String nacionalidad;
    @Getter
    @Setter
    public String fechaNacimiento;
    @Getter
    private List<String> nombresLibros;

    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.nombresLibros = new ArrayList<>();
    }

    public void agregarLibro(String nombreLibro) {
        nombresLibros.add(nombreLibro);
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", nombresLibros=" + nombresLibros + '}';
    }
}
