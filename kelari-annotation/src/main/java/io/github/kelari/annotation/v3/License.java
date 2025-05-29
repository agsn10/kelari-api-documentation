package io.github.kelari.annotation.v3;

import io.github.kelari.annotation.v3.extensions.Extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provides licensing information for the API.
 *
 * <p>This annotation is used to specify the license under which the API is made available. It corresponds to the
 * License Object in the OpenAPI Specification.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#license-object">OpenAPI Specification v3.1.0 – License Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @License(
 *     name = "Apache 2.0",
 *     url = "https://www.apache.org/licenses/LICENSE-2.0.html"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#license-object">OpenAPI 3.1.0 – License Object</a>
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface License {
    /**
     * The list of optional extensions.
     * */
    Extension[] extensions() default {};
    /**
     * he license name used for the API.
     * */
    String name() default "";
    /**
     * A URL to the license used for the API.
     * */
    String url() default "";
}
