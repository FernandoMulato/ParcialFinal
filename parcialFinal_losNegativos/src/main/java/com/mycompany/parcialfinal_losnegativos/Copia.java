package com.mycompany.parcialfinal_losnegativos;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */
import com.mycompany.exepcionesPersonalizadas.CopiaExisteException;
import lombok.Getter;
import lombok.Setter;

public class Copia {

    @Getter
    @Setter
    public String identificador;
    @Getter
    @Setter
    public String estado;
    @Getter
    @Setter
    public String nombreLibroOriginal;
    @Getter
    @Setter
    public Lector lector;

    public Copia(String identificador, String estado) {
        this.identificador = identificador;
        this.estado = estado;
        this.nombreLibroOriginal = "";
        this.lector = null;
    }

    public void devolver(String identificadorDeCopia) {
        if (this.identificador.equals(identificadorDeCopia)) {
            this.estado = "En bibleoteca";
        }
    }

    public void prestar(Lector lectorN) throws CopiaExisteException {
        this.lector = lectorN;
        lector.agregarCopia(this);
        this.estado = "En Prestamo";
    }

    @Override
    public String toString() {
        return "Copia{" + "identificador=" + identificador + ", estado=" + estado + ", nombreLibroOriginal=" + nombreLibroOriginal + ", lector=" + lector.toString() + '}';
    }

}
