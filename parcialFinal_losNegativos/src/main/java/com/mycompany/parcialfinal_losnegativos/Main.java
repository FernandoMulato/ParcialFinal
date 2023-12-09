package com.mycompany.parcialfinal_losnegativos;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.mycompany.exepcionesPersonalizadas.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */

/*Enlaces:
    http://localhost:4567/autores
    http://localhost:4567/agregarAutor/Sofia%20Guitierrez/Argentina/03%20de%20enero%20de%201978
    http://localhost:4567/autores
    http://localhost:4567/libros
    http://localhost:4567/agregarLibro/La%20Choza/Terror/Caucanistan/2019/Sofia%20Guitierrez
    http://localhost:4567/libros
    http://localhost:4567/autores
    http://localhost:4567/libros
    http://localhost:4567/crearCopia/1123/En%20Biblioteca/La%20Choza
    http://localhost:4567/copias        
    http://localhost:4567/libros
    http://localhost:4567/agregarLector/1234/Juan/Martinez%20Rueda/Calle%206%20n%2052
    http://localhost:4567/lectores
    http://localhost:4567/prestarUnaCopia/1234/2222
    http://localhost:4567/copias
    http://localhost:4567/prestamos
    http://localhost:4567/lectores
    http://localhost:4567/devolverUnaCopia/1234/2222
    http://localhost:4567/copias
    http://localhost:4567/lectores
    http://localhost:4567/prestamos
    http://localhost:4567/generarMulta
    http://localhost:4567/comprobarMultasPendientes/1234

 */
public class Main {

    public static void main(String[] args) {
        /*
        * Esto nos sirve para generar un formato json para retornar la data del array
        * sin tener que acomodarla bonita de manera manual
         */
        Gson gson = new Gson();

        LinkedList<Autor> autores = new LinkedList<>();
        LinkedList<Libro> libros = new LinkedList<>();
        LinkedList<Copia> copias = new LinkedList<>();
        LinkedList<Lector> lectores = new LinkedList<>();
        LinkedList<Prestamo> prestamos = new LinkedList<>();
        LinkedList<Multa> multas = new LinkedList<>();

        Libro libroA = new Libro("La Gloria de Lucho", "Novela", "PopayorkTH", "2012");
        libroA.agregarAutor("Fernando Guzman");
        libros.add(libroA);
        Autor autorA = new Autor("Fernando Guzman", "Colombiano", "1968/03/12");
        autorA.agregarLibro("La Gloria de Lucho");
        autores.add(autorA);
        Copia copiaA = new Copia("2222", "En biblioteca");
        copiaA.setNombreLibroOriginal("La Gloria de Lucho");
        copias.add(copiaA);
        libroA.agregarCopia(copiaA);
        Lector lectorA = new Lector("9876", "Luis", "Guerrero Lopez", "Calle 7 n 34");
        lectores.add(lectorA);

        // Registro del filtro de excepciones global
        exception(Exception.class, new GlobalExceptionHandler());

        // Listado de libros
        get("/libros", (req, res) -> {
            res.type("application/json");
            return gson.toJson(libros);
        });

        // Listado de autores
        get("/autores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(autores);
        });

        // Listado de copias
        get("/copias", (req, res) -> {
            res.type("application/json");
            return gson.toJson(copias);
        });
        // Listado de lectores
        get("/lectores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });
        // Listado de prestamos
        get("/prestamos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(prestamos);
        });
        // Listado de multas
        get("/multas", (req, res) -> {
            res.type("application/json");
            return gson.toJson(prestamos);
        });

        // endpoint GET para agregar un libro
        get("/agregarLibro/:nombre/:tipo/:editorial/:anio/:nombreAutor", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String nombre = req.params(":nombre");
            String tipo = req.params(":tipo");
            String editorial = req.params(":editorial");
            String anio = req.params(":anio");
            String nombreAutor = req.params(":nombreAutor");

            // Crear un nuevo libro y agregarlo a la biblioteca
            Libro nuevoLibro = new Libro(nombre, tipo, editorial, anio);

            try {
                if (libros.stream().anyMatch(m -> m.getNombre().equals(nombre))) {
                    throw new LibroExisteException("Error, el libro ya se encuentra en la biblioteca");
                }

                libros.add(nuevoLibro);

                // Buscar el autor por su nombre y agregar el libro al autor
                Autor autor = autores.stream().filter(a -> a.getNombre().equals(nombreAutor)).findFirst().orElse(null);
                if (autor != null) {
                    autor.agregarLibro(nombre); // Agrega el nombre del libro al autor
                    nuevoLibro.agregarAutor(nombreAutor); // Agrega el nombre del autor al libro
                }

            } catch (LibroExisteException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(nuevoLibro);
        });

        // endpoint GET para agregar un autor
        get("/agregarAutor/:nombre/:nacionalidad/:fechaDeNacimiento", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String nombre = req.params(":nombre");
            String nacionalidad = req.params(":nacionalidad");
            String fechaDeNacimiento = req.params(":fechaDeNacimiento");

            // Crear un nuevo autor y agregarlo a la lista de autores
            Autor nuevoAutor = new Autor(nombre, nacionalidad, fechaDeNacimiento);

            try {
                if (autores.stream().anyMatch(m -> m.getNombre().equals(nombre))) {
                    throw new AutorExisteException("Error, el autor ya existe");
                }

                autores.add(nuevoAutor);

                // Actualizar la lista de libros asociados al autor
                for (Libro libro : libros) {
                    if (libro.getNombresAutores().contains(nombre)) {
                        libro.agregarAutor(nombre);
                    }
                }
            } catch (AutorExisteException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(nuevoAutor);
        });

        // endpoint GET para crear una copia
        get("/crearCopia/:identificador/:estado/:nombreDeLibroOriginal", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String estado = req.params(":estado");
            String nombreDeLibroOriginal = req.params(":nombreDeLibroOriginal");
            String identificador = req.params(":identificador");

            // Crear una nueva copia 
            Copia nuevaCopia = new Copia(identificador, estado);

            try {
                if (copias.stream().anyMatch(m -> m.getIdentificador().equals(identificador))) {
                    throw new CopiaExisteException("Error, la copia ya existe");
                }
                copias.add(nuevaCopia);

                // Actualizar el nombre del libro original a la copia
                for (Libro libroN : libros) {
                    if (libroN.getNombre().equals(nombreDeLibroOriginal)) {
                        nuevaCopia.setNombreLibroOriginal(nombreDeLibroOriginal);
                        libroN.agregarCopia(nuevaCopia); // Agregar la copia al libro
                        break;
                    }
                }

            } catch (CopiaExisteException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(nuevaCopia);
        });

        // endpoint GET para agregar un lector
        get("/agregarLector/:numSocio/:nombre/:apellidos/:direccion", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String numSocio = req.params(":numSocio");
            String nombre = req.params(":nombre");
            String apellidos = req.params(":apellidos");
            String direccion = req.params(":direccion");

            // Crear un nuevo lector 
            Lector nuevoLector = new Lector(numSocio, nombre, apellidos, direccion);

            try {
                if (lectores.stream().anyMatch(m -> m.getNumSocio().equals(numSocio))) {
                    throw new LectorExisteException("Error, el lector ya existe");
                }
                lectores.add(nuevoLector);
            } catch (LectorExisteException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(nuevoLector);
        });

        // endpoint GET para prestar una copia
        get("/prestarUnaCopia/:numSocio/:identificadorDeCopia", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String numSocio = req.params(":numSocio");
            String identificadorDeCopia = req.params(":identificadorDeCopia");

            // Crear un nuevo préstamo 
            Prestamo nuevoPrestamo = new Prestamo();
            nuevoPrestamo.obtenerFechaActual();
            nuevoPrestamo.calcularFechaFin(7);

            try {
                // Verificar si el lector está en la base de datos
                if (!lectores.stream().anyMatch(m -> m.getNumSocio().equals(numSocio))) {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, el lector no se encuentra en la base de datos");
                }

                // Verificar si la copia está en la base de datos
                if (!copias.stream().anyMatch(m -> m.getIdentificador().equals(identificadorDeCopia))) {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, la copia no se encuentra en la base de datos");
                }

                // Obtener la copia correspondiente al identificador
                Copia copiaPrestada = copias.stream().filter(c -> c.getIdentificador().equals(identificadorDeCopia)).findFirst().orElse(null);

                // Verificar si la copia fue encontrada
                if (copiaPrestada != null) {
                    // Agregar la copia al lector
                    for (Lector lector : lectores) {
                        if (lector.getNumSocio().equals(numSocio)) {
                            lector.agregarCopia(copiaPrestada);
                            copiaPrestada.setEstado("Copia prestada");
                            lector.agregarPrestamo(nuevoPrestamo, copiaPrestada);
                            break;
                        }
                    }

                    // Agregar el préstamo a la lista de préstamos
                    prestamos.add(nuevoPrestamo);
                } else {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, la copia no se encuentra en la base de datos");
                }
            } catch (NoSeEncuentraEnLaBaseDeDatosException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(nuevoPrestamo);
        });

        // endpoint GET para devolver una copia
        get("/devolverUnaCopia/:numSocio/:identificadorDeCopia", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String numSocio = req.params(":numSocio");
            String identificadorDeCopia = req.params(":identificadorDeCopia");
            String mensaje = "Error, no se devolvio";

            try {
                // Verificar si el lector está en la base de datos
                if (!lectores.stream().anyMatch(m -> m.getNumSocio().equals(numSocio))) {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, el lector no se encuentra en la base de datos");
                }

                // Verificar si la copia está en la base de datos
                if (!copias.stream().anyMatch(m -> m.getIdentificador().equals(identificadorDeCopia))) {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, la copia no se encuentra en la base de datos");
                }

                // Obtener la copia correspondiente al identificador
                Copia copiaPrestada = copias.stream().filter(c -> c.getIdentificador().equals(identificadorDeCopia)).findFirst().orElse(null);

                // Verificar si la copia fue encontrada
                if (copiaPrestada != null) {
                    // Cambiar el estado de la copia y quitarsela al lector
                    for (Lector lector : lectores) {
                        if (lector.getNumSocio().equals(numSocio)) {
                            copiaPrestada.setEstado("En biblioteca");
                            lector.devolverCopia(identificadorDeCopia);
                            // Obtener el préstamo correspondiente a la copia
                            Prestamo prestamo = lector.getPrestamos().stream()
                                    .filter(p -> p.getCopiaPrestada() != null && p.getCopiaPrestada().getIdentificador().equals(identificadorDeCopia))
                                    .findFirst().orElse(null);

                            // Eliminar el préstamo
                            if (prestamo != null) {
                                lector.eliminarPrestamo(prestamo);
                                prestamos.remove(prestamo);
                            }

                            mensaje = "Se devolvio la copia correctamente";
                            break;
                        }
                    }

                } else {
                    throw new NoSeEncuentraEnLaBaseDeDatosException("Error, la copia no se encuentra en la base de datos");
                }
            } catch (NoSeEncuentraEnLaBaseDeDatosException e) {
                throw e; // Deja que el filtro de excepciones global maneje esta excepción
            }

            return gson.toJson(mensaje);
        }
        );

        // Endpoint GET para generar multa
        get("/generarMulta", (req, res) -> {
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            for (Lector lector : lectores) {
                // Iterar sobre los préstamos del lector
                for (Prestamo prestamo : lector.getPrestamos()) {
                    // Verificar si la fecha de fin del préstamo es posterior a la fecha actual
                    LocalDate fechaFinLocalDate = LocalDate.parse(prestamo.getFechaFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    if (fechaActual.isAfter(fechaFinLocalDate)) {
                        // La fecha de fin ha pasado, generar multa
                        Multa multaGenerada = prestamo.generarMulta(lector);

                        // Si se generó una multa, agregarla a la lista de multas generadas
                        if (multaGenerada != null) {
                            multas.add(multaGenerada);
                        }
                    }
                }
            }

            // Devolver la lista de multas generadas
            return gson.toJson(multas);
        });

        // Endpoint GET para comprobar multas pendientes
        get("/comprobarMultasPendientes/:numSocio", (req, res) -> {
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            Multa multa = new Multa("");

            // Obtener parámetros de la URL
            String numSocio = req.params(":numSocio");

            for (Lector lector : lectores) {
                if (lector.getNumSocio().equals(numSocio)) {
                    multa = lector.comprobarMultasPendientes();
                }
            }

            return gson.toJson(multa);
        });
    }
}
