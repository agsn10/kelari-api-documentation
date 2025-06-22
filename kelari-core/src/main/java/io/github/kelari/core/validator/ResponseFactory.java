package io.github.kelari.core.validator;

import io.github.kelari.core.model.Response;

import java.util.*;
import java.util.stream.Collectors;

public class ResponseFactory {

    public static Optional<Response> tryFromObject(Object possibleResponse) {
        if (Objects.isNull(possibleResponse)) return Optional.empty();
        String className = possibleResponse.getClass().getName();
        try {
            if (className.equals("org.springframework.http.ResponseEntity"))
                return Optional.of(fromSpringResponse(possibleResponse));
            if (className.equals("javax.ws.rs.core.Response") ||
                    className.equals("jakarta.ws.rs.core.Response"))
                return Optional.of(fromJaxRsResponse(possibleResponse));
        } catch (Exception e) {
            // log warning se necessário
        }
        return Optional.empty();
    }

    private static Response fromSpringResponse(Object springResponse) throws Exception {
        Class<?> clazz = springResponse.getClass();
        int status = (int) clazz.getMethod("getStatusCodeValue").invoke(springResponse);
        Object headersObj = clazz.getMethod("getHeaders").invoke(springResponse);
        Map<String, String> headers = toSingleValueMap(headersObj);
        Object body = clazz.getMethod("getBody").invoke(springResponse);
        return new Response(status, headers, body);
    }

    private static Map<String, String> toSingleValueMap(Object httpHeaders) throws Exception {
        Map<String, String> result = new HashMap<>();
        Class<?> headersClass = httpHeaders.getClass();
        Map<?, ?> headerMap = (Map<?, ?>) headersClass.getMethod("toSingleValueMap").invoke(httpHeaders);
        for (Map.Entry<?, ?> entry : headerMap.entrySet())
            result.put(entry.getKey().toString(), entry.getValue().toString());
        return result;
    }

    private static Response fromJaxRsResponse(Object jaxRsResponse) throws Exception {
        Class<?> clazz = jaxRsResponse.getClass();
        int status = (int) clazz.getMethod("getStatus").invoke(jaxRsResponse);
        Map<String, List<String>> headers = (Map<String, List<String>>) clazz.getMethod("getStringHeaders").invoke(jaxRsResponse);
        Object entity = clazz.getMethod("getEntity").invoke(jaxRsResponse);
        Map<String, String> flatHeaders = headers.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.join(",", e.getValue())));
        return new Response(status, flatHeaders, entity);
    }
}