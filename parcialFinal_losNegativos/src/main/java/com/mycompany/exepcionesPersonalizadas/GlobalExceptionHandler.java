package com.mycompany.exepcionesPersonalizadas;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */

import spark.ExceptionHandler;
import spark.Request;
import spark.Response;

public class GlobalExceptionHandler implements ExceptionHandler<Exception> {
    @Override
    public void handle(Exception exception, Request request, Response response) {
        if (exception instanceof LibroExisteException) {
            response.status(400); // Código de estado para Solicitud incorrecta
            response.body(new ErrorResponse(exception.getMessage()).toJson());
        } else {
            response.status(500); // Código de estado para Error interno del servidor
            response.body(new ErrorResponse("Error interno del servidor").toJson());
        }
        
        if (exception instanceof AutorExisteException) {
            response.status(400); // Código de estado para Solicitud incorrecta
            response.body(new ErrorResponse(exception.getMessage()).toJson());
        } else {
            response.status(500); // Código de estado para Error interno del servidor
            response.body(new ErrorResponse("Error interno del servidor").toJson());
        }
        
        if (exception instanceof CopiaExisteException) {
            response.status(400); // Código de estado para Solicitud incorrecta
            response.body(new ErrorResponse(exception.getMessage()).toJson());
        } else {
            response.status(500); // Código de estado para Error interno del servidor
            response.body(new ErrorResponse("Error interno del servidor").toJson());
        }
        
        if (exception instanceof LectorExisteException) {
            response.status(400); // Código de estado para Solicitud incorrecta
            response.body(new ErrorResponse(exception.getMessage()).toJson());
        } else {
            response.status(500); // Código de estado para Error interno del servidor
            response.body(new ErrorResponse("Error interno del servidor").toJson());
        }        
        
        if (exception instanceof NoSeEncuentraEnLaBaseDeDatosException) {
            response.status(400); // Código de estado para Solicitud incorrecta
            response.body(new ErrorResponse(exception.getMessage()).toJson());
        } else {
            response.status(500); // Código de estado para Error interno del servidor
            response.body(new ErrorResponse("Error interno del servidor").toJson());
        }      
    }
}
