package io.github.kelari.core.model;

import java.lang.reflect.Method;
import java.util.Map;

public class Response {
    private int statusCode;
    private Map<String, String> headers;
    private Object body;

    // Construtores
    public Response() {}

    public Response(int statusCode, Map<String, String> headers, Object body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    // Getters e Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
/*
    // Método genérico usando reflexão
    public static Response fromGenericResponse(Object response) {
        try {
            // Verificando se o objeto é do tipo ResponseEntity (Spring)
            if (response instanceof org.springframework.http.ResponseEntity) {
                return extractFromSpringResponse((org.springframework.http.ResponseEntity<?>) response);
            }

            // Verificando se o objeto é do tipo Response (JAX-RS)
            if (response instanceof javax.ws.rs.core.Response) {
                return extractFromJaxRsResponse((javax.ws.rs.core.Response) response);
            }

            throw new IllegalArgumentException("Tipo de resposta desconhecido: " + response.getClass());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Extração dos dados de ResponseEntity do Spring
    private static Response extractFromSpringResponse(org.springframework.http.ResponseEntity<?> springResponse) throws Exception {
        // Usando reflexão para acessar os métodos de ResponseEntity
        Method getStatusCodeValueMethod = springResponse.getClass().getMethod("getStatusCodeValue");
        Method getHeadersMethod = springResponse.getClass().getMethod("getHeaders");
        Method getBodyMethod = springResponse.getClass().getMethod("getBody");

        // Extraindo valores usando reflexão
        int statusCode = (int) getStatusCodeValueMethod.invoke(springResponse);
        Map<String, String> headers = (Map<String, String>) getHeadersMethod.invoke(springResponse);
        Object body = getBodyMethod.invoke(springResponse);

        return new Response(statusCode, headers, body);
    }

    // Extração dos dados de Response do JAX-RS
    private static Response extractFromJaxRsResponse(javax.ws.rs.core.Response jaxRsResponse) throws Exception {
        // Usando reflexão para acessar os métodos de Response (JAX-RS)
        Method getStatusMethod = jaxRsResponse.getClass().getMethod("getStatus");
        Method getStringHeadersMethod = jaxRsResponse.getClass().getMethod("getStringHeaders");
        Method getEntityMethod = jaxRsResponse.getClass().getMethod("getEntity");

        // Extraindo valores usando reflexão
        int statusCode = (int) getStatusMethod.invoke(jaxRsResponse);
        Map<String, String> headers = (Map<String, String>) getStringHeadersMethod.invoke(jaxRsResponse);
        Object body = getEntityMethod.invoke(jaxRsResponse);

        return new Response(statusCode, headers, body);
    } */
}
