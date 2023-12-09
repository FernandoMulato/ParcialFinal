#parcial final laboratorio de programación

proyecto: ParcialFinal_losNegativos

Este proyecto implementa una biblioteca online con funciones para gestionar autores, libros, copias, lectores, préstamos y multas.

#requisitos previos:
Java: Necesitas tener Java instalado en tu máquina. Puedes descargarlo desde el sitio oficial de Apache Netbeans: https://netbeans.apache.org/front/main/ . 

**1 -**	listado de autores:
utilidad: muestra la lista de todos los autores
http://localhost:4567/autores
instrucciones en README.md:
**Listado de Autores:**
  http://localhost:4567/autores

**2 -**	agregar autor:
utilidad: permite agregar un nuevo autor a la biblioteca con información especifica como nombre,nacionalidad y fecha de nacimiento
http://localhost:4567/agregarAutor/Sofia%20Guitierrez/Argentina/03%20de%20enero%20de%201978
Instrucciones en README.md:

- **Agregar Autor:**
http://localhost:4567/agregarAutor/Sofia%20Guitierrez/Argentina/03%20de%20enero%20de%201978

**3 -**	listado de libros:
utilidad: muestra el listado de libros que se encuentran en la biblioteca
http://localhost:4567/libros
Instrucciones en README.md:
- **Listado de Libros:**
  http://localhost:4567/libros

**4 -**	agregar libro:
utilidad: Permite agregar un nuevo libro a la biblioteca con información específica como título, género, editorial, año de público.
http://localhost:4567/agregarLibro/La%20Choza/Terror/Caucanistan/2019/Sofia%20Guitierrez
Instrucciones en README.md:
- **Agregar Libro:**
  http://localhost:4567/agregarLibro/La%20Choza/Terror/Caucanistan/2019/Sofia%20Guitierrez

**5 -**	listado de copias:
utilidad:Muestra la lista de todas las copias disponibles en la biblioteca.
http://localhost:4567/copias
Instrucciones en README.md:
- **Listado de Copias:**
  http://localhost:4567/copias

**6 -**	crear copia:
utilidad:Permite crear una nueva copia de un libro existente en la biblioteca, especificando su identificador, estado y el nombre del libro original.
http://localhost:4567/crearCopia/1123/En%20Biblioteca/La%20Choza
Instrucciones en README.md:
- **Crear Copia:**
  http://localhost:4567/crearCopia/1123/En%20Biblioteca/La%20Choza

**7 -**	listado de lectores:
utilidad: muestra todos los lectores.
http://localhost:4567/lectores
Instrucciones en README.md:
- **Listado de Lectores:**
  http://localhost:4567/lectores

**8 -**	agregar lector:
utilidad: permite agregar un nuevo lector a la biblioteca con información específica
http://localhost:4567/agregarLector/1234/Juan/Martinez%20Rueda/Calle%206%20n%2052
Instrucciones en README.md:
- **Agregar Lector:**
  http://localhost:4567/agregarLector/1234/Juan/Martinez%20Rueda/Calle%206%20n%2052

**9 -**	prestar una copia:
utilidad: Facilita el préstamo de una copia a un lector, generando un nuevo préstamo y actualizando el estado de las copias en  la biblioteca
http://localhost:4567/prestarUnaCopia/1234/2222
Instrucciones en README.md:
- **Prestar una Copia:**
  http://localhost:4567/prestarUnaCopia/1234/2222

**10 -**	 devolver una copia:
utilidad: permite registrar la devolución de las copias en la biblioteca.
http://localhost:4567/devolverUnaCopia/1234/2222
Instrucciones en README.md:
- **Devolver una Copia:**
  http://localhost:4567/devolverUnaCopia/1234/2222
 
**11 -**	 generar multa:
utilidad: genera multas automáticamente por no devolución de los libros o copias.
http://localhost:4567/generarMulta
Instrucciones en README.md:
- **Generar Multa:**
  http://localhost:4567/generarMulta

**12 -**	 comprobar multas pendientes:
utilidad: permite que en el sistema de la biblioteca se pueda ver las multas que tiene cada usuario y  cuales están pendientes
http://localhost:4567/comprobarMultasPendientes/1234
Instrucciones en README.md:
- **Comprobar Multas Pendientes:**
  http://localhost:4567/comprobarMultasPendientes/1234


 








