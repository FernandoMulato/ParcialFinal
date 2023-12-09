package com.mycompany.exepcionesPersonalizadas;

import com.google.gson.Gson;
import lombok.Data;

/**
 *
 * @author 104623010375 Henry Fernando Mulato Llanten
 */

public @Data class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}