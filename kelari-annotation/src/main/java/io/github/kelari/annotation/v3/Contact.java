package io.github.kelari.annotation.v3;

import io.github.kelari.annotation.v3.extensions.Extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Contact information for the exposed API.
 *
 * <p>This annotation is used to define metadata about the contact responsible for the API.
 * The information includes the name, URL, and email of the person or organization. It is
 * commonly used in the OpenAPI `Info` object to provide human-readable contact details.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#contact-object">OpenAPI Specification v3.1.0 – Contact Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Contact(
 *     name = "Antonio Neto",
 *     url = "https://kelari.io/support",
 *     email = "support@kelari.io"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#contact-object">OpenAPI 3.1.0 – Contact Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Contact {

    /**
     * The email address of the contact person/organization.
     * */
    String email() default "";
    /**
     * The list of optional extensions.
     * */
    Extension[] extensions() default {};
    /**
     * The identifying name of the contact person/organization.
     * */
    String name() default "";
    /**
     * The URL pointing to the contact information.
     * */
    String url() default "";
}