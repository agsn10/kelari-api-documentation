package io.github.kelari.annotation.v3.info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides metadata about the API.
 *
 * <p>This annotation is used to define general information about the API, such as the title, version,
 * description, contact information, and licensing. It corresponds to the Info Object in the OpenAPI Specification.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#info-object">OpenAPI Specification v3.1.0 – Info Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Info(
 *     title = "Sample API",
 *     version = "1.0.0",
 *     description = "This is a sample API.",
 *     termsOfService = "https://example.com/terms",
 *     contact = @Contact(
 *         name = "API Support",
 *         email = "support@example.com",
 *         url = "https://example.com/contact"
 *     ),
 *     license = @License(
 *         name = "Apache 2.0",
 *         url = "https://www.apache.org/licenses/LICENSE-2.0.html"
 *     )
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#info-object">OpenAPI 3.1.0 – Info Object</a>
 * @see Contact
 * @see License
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Info {

    /**
     * The application's title.
     * @return The application's title.
     * */
    String title() default "";
    /**
     * The version of the API definition.
     * @return The application's version.
     * */
    String version()default "";
    /**
     * A short description of the application. CommonMark syntax can be used for rich text representation.
     * @return The application's description.
     * */
    String description() default "";
    /**
     * A URL to the Terms of Service for the API. Must be in the format of a URL.
     * @return The application's terms of service.
     * */
    String termsOfService() default "";
    /**
     * The license information for the exposed API.
     * @return The license of the application.
     * */
    License license() default @License;
    /**
     * The contact information for the exposed API.
     * @return A contact for the applicatio.
     * */
    Contact contact() default @Contact;
}
