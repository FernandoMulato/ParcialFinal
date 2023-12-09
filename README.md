#parcial final **Laboratorio de Programación Orientada a Objetos**

Proyecto: **ParcialFinal_losNegativos**

Este proyecto implementa una biblioteca online con funciones para gestionar autores, libros, copias, lectores, préstamos y multas.

**#requisitos previos:**
- Java: Necesitas tener Java instalado en tu máquina. Puedes descargarlo desde el sitio oficial de Apache Netbeans: https://netbeans.apache.org/front/main/ . 
- Una vez tengas el programa instalado importa el proyecto y ejecuta el programa.
- Una vez hecho esto puedes verificar el funcionamiento de estos enlaces:

**1 -	listado de autores:**
utilidad: muestra la lista de todos los autores.

- **Listado de Autores:**
  http://localhost:4567/autores

**2 -	agregar autor:**
utilidad: permite agregar un nuevo autor a la biblioteca con información especifica como nombre,nacionalidad y fecha de nacimiento.

- **Agregar Autor:**
http://localhost:4567/agregarAutor/Sofia%20Guitierrez/Argentina/03%20de%20enero%20de%201978

Puedes verificar que el autor se agrego abriendo el listado de autores: http://localhost:4567/autores

**3 -	listado de libros:**
utilidad: muestra el listado de libros que se encuentran en la biblioteca

- **Listado de Libros:**
  http://localhost:4567/libros

**4 -	agregar libro:**
utilidad: Permite agregar un nuevo libro a la biblioteca con información específica como título, género, editorial, año de público y nombre del autor.

- **Agregar Libro:**
  http://localhost:4567/agregarLibro/La%20Choza/Terror/Caucanistan/2019/Sofia%20Guitierrez

  Puedes verificar que el libro se agrego abriendo el listado de libros: http://localhost:4567/libros
  También puedes verificar que el libro se asocio a un autor existente: http://localhost:4567/autores

**5 -	listado de copias:**
utilidad:Muestra la lista de todas las copias disponibles en la biblioteca.

- **Listado de Copias:**
  http://localhost:4567/copias

**6 -	crear copia:**
utilidad:Permite crear una nueva copia de un libro existente en la biblioteca, especificando su identificador, estado y el nombre del libro original.

- **Crear Copia:**
  http://localhost:4567/crearCopia/1123/En%20Biblioteca/La%20Choza

  Puedes verificar que la copia se agrego abriendo el listado de copias: http://localhost:4567/copias
  También puedes verificar que la copia se asocio al libro original: http://localhost:4567/libros

**7 -	listado de lectores:**
utilidad: muestra todos los lectores.

- **Listado de Lectores:**
  http://localhost:4567/lectores

**8 -	agregar lector:**
utilidad: permite agregar un nuevo lector a la biblioteca con información específica como el número de socio, nombre, apellidos y dirección.

- **Agregar Lector:**
  http://localhost:4567/agregarLector/1234/Juan/Martinez%20Rueda/Calle%206%20n%2052

  Puedes verificar que el lector se agrego abriendo el listado de lectores: http://localhost:4567/lectores

**9 -	listado de prestamos:**
utilidad: muestra todos los prestamos.

- **Listado de Prestamos:**
  http://localhost:4567/prestamos

**10 -	prestar una copia:**
utilidad: permite el préstamo de una copia a un lector, generando un nuevo préstamo y actualizando el estado de las copias en  la biblioteca, con datos especificos como lo es el número de socio a quien se le va a hacer el prestamo y el identificador de la copia que se va a prestar.

- **Prestar una Copia:**
  http://localhost:4567/prestarUnaCopia/1234/2222

  Puedes verificar que el prestamo se agrego a la lista de prestamos: http://localhost:4567/prestamos
  También puedes verificar que se presto la copia a un respectivo lector: http://localhost:4567/lectores 

**11 -	 devolver una copia:**
utilidad: permite registrar la devolución de las copias en la biblioteca, con datos especificos como el número de socio de quien va a hacer la devolución y el identificador de la copia que se va a devolver.

- **Devolver una Copia:**
  http://localhost:4567/devolverUnaCopia/1234/2222

  Puedes verificar que el prestamo se elimino de la lista de prestamos: http://localhost:4567/prestamos
  También puedes verificar que la copia se elimino del respectivo lector: http://localhost:4567/lectores

**12 -	listado de multas:**
utilidad: muestra todas las multas.

- **Listado de Multas:**
  http://localhost:4567/multas
 
**13 -	 generar multa:**
utilidad: genera multas automáticamente por no devolución de las copias al exceder el tiempo de prestamo (7 dias apartir de la fecha del prestamo, y se cobra una cantidad de $5 por dia de retraso).

- **Generar Multa:**
  http://localhost:4567/generarMulta

  Cuando se generen las respectivas multas puedes verificar en el listado de multas: http://localhost:4567/multas

**14 -	 comprobar multas pendientes:**
utilidad: permite que el sistema de la biblioteca pueda comprobar las multas tiene un usuario, con datos especificos como el número de socio del lector a quien se le va a verificar.

- **Comprobar Multas Pendientes:**
  http://localhost:4567/comprobarMultasPendientes/1234


 








