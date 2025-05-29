package io.github.kelari.annotation.v3.responses;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.headers.Header;
import io.github.kelari.annotation.v3.links.Link;
import io.github.kelari.annotation.v3.media.Content;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes a possible response of an operation. The {@code ApiResponse} annotation is used to specify
 * metadata for a given HTTP response, such as the response code, description, content, headers, links,
 * and additional vendor-specific extensions.
 *
 * <p>This annotation can be used on methods, types (classes), and other annotations. It supports
 * being repeatable through the use of {@link ApiResponses} container.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#response-object">OpenAPI Specification v3.1.0 - Response Object</a></li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @ApiResponse(
 *     responseCode = "200",
 *     description = "Successful operation",
 *     content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MyModel.class))}
 * )
 * }
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
@Repeatable(value=ApiResponses.class)
public @interface ApiResponse {

    /**
     * An array containing descriptions of potential response payloads, for different media types.
     * @return Array of content.
     * */
    Content[] content() default {};
    /**
     * A short description of the response.
     * @return Description of the response.
     * */
    String description();
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * An array of response headers. Allows additional information to be included with response.
     * @return Array of headers.
     * */
    Header[] headers() default {};
    /**
     * An array of operation links that can be followed from the response.
     * @return Array of links.
     * */
    Link[]  links() default {};
    /**
     * A reference to a response defined in components responses.
     * @return The reference.
     * */
    String ref() default "";
    /**
     * The HTTP response code, or 'default', for the supplied response. May only have 1 default entry.
     * @return Response code.
     * */
    String responseCode() default "default";
}