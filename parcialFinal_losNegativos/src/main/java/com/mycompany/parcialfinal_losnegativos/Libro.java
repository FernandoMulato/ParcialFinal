package com.mycompany.parcialfinal_losnegativos;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
public class Libro {

    @Getter
    @Setter
    public String nombre;
    @Getter
    @Setter
    public String tipo;
    @Getter
    @Setter
    public String editorial;
    @Getter
    @Setter
    public String anio;
    @Getter
    public List<String> nombresAutores;
    @Getter
    private List<Copia> copias;

    public Libro(String nombre, String tipo, String editorial, String anio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.editorial = editorial;
        this.anio = anio;
        this.nombresAutores = new ArrayList<>();
        this.copias = new ArrayList<>();
    }

    public void agregarAutor(String nombreAutor) {
        nombresAutores.add(nombreAutor);
    }

    public void agregarCopia(Copia copiaN) {
        if (!copias.contains(copiaN)) {
            copias.add(copiaN);
            copiaN.setNombreLibroOriginal(this.nombre); // Asignar el nombre del libro a la copia
        }
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", tipo=" + tipo + ", editorial=" + editorial + ", anio=" + anio + ", nombresAutores=" + nombresAutores + ", copias=" + copias + '}';
    }

}
