package com.ubots.teste.shared;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseService {

    private static final String KEY_SUCCESS = "success";
    private static final String KEY_DATA = "data";
    private static final String KEY_MESSAGE = "message";

    /**
     * A classe não deve ser instanciada
     */
    private ResponseService() {
    }

    /**
     * Retorna uma resposta, seja erro ou sucesso
     *
     * @param success
     * @param data
     * @return
     */
    public static ResponseEntity<?> setResponse(Boolean success, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put(KEY_SUCCESS, success);
        response.put(KEY_DATA, data);

        return ResponseEntity.ok(response);

    }

    /**
     * Retorna uma mensagem de erro
     *
     * @param message
     * @return
     */
    public static ResponseEntity<?> setError(String message) {

        Map<String, Object> response = new HashMap<>();
        response.put(KEY_SUCCESS, false);
        response.put(KEY_MESSAGE, message);

        return ResponseEntity.ok(response);

    }

    /**
     * Retorna uma mensagem de sucesso
     *
     * @param message
     * @return
     */
    public static ResponseEntity<?> setSuccess(String message) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put(KEY_MESSAGE, message);

        Map<String, Object> response = new HashMap<>();
        response.put(KEY_SUCCESS, true);
        response.put(KEY_DATA, errorMessage);

        return ResponseEntity.ok(response);

    }

}

