package io.github.kelari.annotation.v3.media;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Provides a mapping between a property value and a schema definition.
 *
 * <p>
 * Used within a {@code Discriminator} to define how values in the discriminator property
 * correspond to specific schemas. This is typically used in polymorphic schema definitions
 * where multiple subtypes share a base type.
 * </p>
 *
 * <p>
 * Corresponds to the {@code mapping} field of the <strong>Discriminator Object</strong> in the
 * <a href="https://spec.openapis.org/oas/v3.0.1#discriminator-object">OpenAPI 3.0.1 Specification</a>.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @DiscriminatorMapping(value = "cat", schema = Cat.class)
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Discriminator
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {})
@Retention(value = RUNTIME)
@Inherited
public @interface DiscriminatorMapping {

    /**
     * The schema class that is mapped to the given discriminator value.
     *
     * @return The schema class. Defaults to {@code Void.class} if unspecified.
     */
    Class<?> schema() default java.lang.Void.class;

    /**
     * The property value used in the discriminator that maps to the specified schema.
     *
     * @return The discriminator value as a string.
     */
    String value() default "";
}
