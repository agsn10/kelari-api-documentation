package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.Components;
import io.github.kelari.model.v3.ExternalDocumentation;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;

/**
 * Represents a schema definition in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Schema} object defines the structure of input and output data types
 * used by the API. It includes information such as the data type, format,
 * constraints (e.g., minimum, maximum, length), examples, enumerations, and whether
 * a property is required or nullable.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 * schema:
 *   type: object
 *   properties:
 *     id:
 *       type: integer
 *       format: int64
 *     name:
 *       type: string
 *   required:
 *     - id
 *     - name
 * </pre>
 *
 * @param <T> the type represented by the schema.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#reference-object">OpenAPI 3.0.1 – Reference Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Schema<T> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Schema.class.getName());

    public static final String BIND_TYPE_AND_TYPES = "bind-type"; //?? module core
    public static final String BINARY_STRING_CONVERSION_PROPERTY = "binary-string-conversion"; //?? module core
    public static final String SCHEMA_RESOLUTION_PROPERTY = "schema-resolution"; //?? module core
    public static final String APPLY_SCHEMA_RESOLUTION_PROPERTY = "apply-schema-resolution"; //?? module core
    public static final String EXPLICIT_OBJECT_SCHEMA_PROPERTY = "explicit-object-schema"; //?? module core
    public static final String USE_ARBITRARY_SCHEMA_PROPERTY = "use-arbitrary-schema"; //?? module core

    protected T _default;

    private String name;
    private String title = null;
    private BigDecimal multipleOf = null;
    private BigDecimal maximum = null;
    private Boolean exclusiveMaximum = null;
    private BigDecimal minimum = null;
    private Boolean exclusiveMinimum = null;
    private Integer maxLength = null;
    private Integer minLength = null;
    private String pattern = null;
    private Integer maxItems = null;
    private Integer minItems = null;
    private Boolean uniqueItems = null;
    private Integer maxProperties = null;
    private Integer minProperties = null;
    private List<String> required = null;
    private String type = null;
    private Schema not = null;
    private Map<String, Schema> properties = null;
    private Schema additionalProperties;
    private String description = null;
    private String format = null;
    private String $ref = null;
    private Boolean nullable = null;
    private Boolean readOnly = null;
    private Boolean writeOnly = null;
    protected T example = null;
    private ExternalDocumentation externalDocs = null;
    private Boolean deprecated = null;
    private XML xml = null;
    private Map<String, Object> extensions = null;
    protected List<T> _enum = null;
    private Discriminator discriminator = null;
    private Set<String> types;
    private Map<String, Schema> patternProperties = null;
    private BigDecimal exclusiveMaximumValue = null;
    private BigDecimal exclusiveMinimumValue = null;
    private Schema contains = null;
    private String contentEncoding;
    private String contentMediaType;
    private Schema contentSchema;
    private Schema propertyNames;
    private Schema unevaluatedProperties;
    private Integer maxContains;
    private Integer minContains;
    private Schema additionalItems;
    private Schema unevaluatedItems;
    private Schema _if;
    private Schema _else;
    private Schema then;
    private Map<String, Schema> dependentSchemas;
    private Map<String, List<String>> dependentRequired;
    private String $comment;
    private List<T> examples;
    private Schema<?> items = null;

    public Schema() {
    }

    protected Schema(String type, String format) {
        this.type = type;
        this.addType(type);
        this.format = format;
    }

    /**
     * Adds a single type to the {@code types} set.
     * <p>
     * Initializes the set if it is {@code null}.
     * </p>
     *
     * @param type the type to add.
     * @return {@code true} if the type was added, {@code false} if it was already present.
     */
    public boolean addType(String type) {
        if (types == null)
            types = new LinkedHashSet<>();
        return types.add(type);
    }

    /**
     * Fluent method to add a type to the {@code types} set.
     *
     * @param type the type to add.
     * @return this {@code Schema} instance.
     */
    public Schema typesItem(String type) {
        addType(type);
        return this;
    }

    /**
     * Returns the set of types associated with this schema.
     *
     * @return a set of strings representing the schema types.
     */
    public Set<String> getTypes() {
        return types;
    }

    /**
     * Sets the types for this schema.
     *
     * @param types a set of types to assign to the schema.
     */
    public void setTypes(Set<String> types) {
        this.types = types;
    }

    /**
     * Fluent setter for the schema types.
     *
     * @param types the set of types to assign.
     * @return this {@code Schema} instance.
     */
    public Schema types(Set<String> types) {
        this.types = types;
        return this;
    }

    /**
     * Returns the schema item definition (typically used for array item types).
     *
     * @return a {@code Schema} object representing the items schema.
     */
    public Schema<?> getItems() {
        return items;
    }

    /**
     * Sets the schema for items (used in array definitions).
     *
     * @param items the schema to assign for items.
     */
    public void setItems(Schema<?> items) {
        this.items = items;
    }

    /**
     * Fluent setter for the {@code items} schema.
     *
     * @param items the schema to assign for items.
     * @return this {@code Schema} instance.
     */
    public Schema items(Schema<?> items) {
        this.items = items;
        return this;
    }

    /**
     * Returns the default value of the schema.
     * <p>
     * This value is used when the client does not supply a value for the associated property.
     * The default SHOULD be valid against the associated schema constraints (e.g., type, format).
     * </p>
     */
    public T getDefault() {
        return _default;
    }
    /**
     * Sets the default value of the schema.
     * <p>
     * This value is used when the client does not provide one. It SHOULD conform to
     * the constraints of the schema (such as {@code type}, {@code format}, {@code enum}, etc.).
     * </p>
     */
    public void setDefault(Object _default) {
        this._default = cast(_default);
    }

    @SuppressWarnings("unchecked")
    protected T cast(Object value) {
        return (T) value;
    }

    /**
     * Returns the name of the schema property.
     * <p>
     * This is typically used in contexts where the schema is a property of an object,
     * and the name corresponds to the key under which this schema is defined.
     * </p>
     *
     * @return the name of the schema property.
     */
    @JsonIgnore
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name of the schema property.
     * <p>
     * This name should be a valid identifier for a field when the schema is part
     * of an object definition. It has no effect when used standalone or in array context.
     * </p>
     *
     * @param name the name of the schema property.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fluent-style setter for the schema name.
     * <p>
     * Sets the name of the schema property and returns the schema instance
     * for method chaining.
     * </p>
     *
     * @param name the name of the schema property.
     * @return the updated schema instance.
     */
    public Schema name(String name) {
        this.setName(name);
        return this;
    }

    /**
     * Returns the title of the schema.
     * <p>
     * The title provides a short summary or label for the schema, and is primarily used
     * for documentation purposes. It does not affect validation or processing.
     * </p>
     *
     * @return the title of the schema, or {@code null} if not defined.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of the schema.
     * <p>
     * The title is a short, human-readable description of the schema,
     * often used in generated documentation tools like Swagger UI.
     * </p>
     *
     * @param title the title to assign to the schema.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Fluent-style setter for the schema title.
     * <p>
     * Sets the title of the schema and returns the schema instance for method chaining.
     * Useful when configuring the schema in a builder-like fashion.
     * </p>
     *
     * @param title the title to assign to the schema.
     * @return the updated schema instance.
     */
    public Schema title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Returns the value of the {@code multipleOf} constraint for this schema.
     * <p>
     * This constraint indicates that the value of the instance must be a multiple
     * of the specified number. It is typically used with numeric types.
     * </p>
     *
     * @return the {@code multipleOf} value, or {@code null} if not defined.
     */
    public BigDecimal getMultipleOf() {
        return multipleOf;
    }
    /**
     * Sets the {@code multipleOf} constraint for this schema.
     * <p>
     * Indicates that the instance value must be a multiple of this number.
     * The value must be strictly greater than 0.
     * </p>
     *
     * @param multipleOf the {@code multipleOf} value to set.
     */
    public void setMultipleOf(BigDecimal multipleOf) {
        this.multipleOf = multipleOf;
    }
    /**
     * Fluent-style setter for the {@code multipleOf} constraint.
     * <p>
     * Sets the {@code multipleOf} value and returns the updated schema instance.
     * Useful when building the schema using a fluent interface.
     * </p>
     *
     * @param multipleOf the {@code multipleOf} value to set.
     * @return the updated schema instance.
     */
    public Schema multipleOf(BigDecimal multipleOf) {
        this.multipleOf = multipleOf;
        return this;
    }

    /**
     * Returns the maximum value allowed for a numeric instance.
     * <p>
     * This defines an inclusive upper limit for a numeric value,
     * unless {@code exclusiveMaximum} is set to {@code true}.
     * </p>
     *
     * @return the maximum value allowed, or {@code null} if not defined.
     * @see #setExclusiveMaximum(Boolean)
     */
    public BigDecimal getMaximum() {
        return maximum;
    }
    /**
     * Sets the maximum value allowed for a numeric instance.
     * <p>
     * By default, this value is inclusive. To make it exclusive, set {@code exclusiveMaximum} to {@code true}.
     * </p>
     *
     * @param maximum the maximum allowed value.
     */
    public void setMaximum(BigDecimal maximum) {
        this.maximum = maximum;
    }
    /**
     * Fluent-style setter for the maximum value constraint.
     * <p>
     * Sets the maximum allowed value for a numeric instance and returns the schema
     * instance for method chaining.
     * </p>
     *
     * @param maximum the maximum value to set.
     * @return the updated schema instance.
     */
    public Schema maximum(BigDecimal maximum) {
        this.maximum = maximum;
        return this;
    }

    /**
     * Returns whether the maximum value is exclusive.
     * <p>
     * When set to {@code true}, the instance value must be strictly less than the value specified by {@code maximum}.
     * When {@code false} or {@code null}, the instance value may be equal to {@code maximum}.
     * </p>
     *
     * @return {@code true} if the maximum is exclusive; {@code false} or {@code null} otherwise.
     * @see #getMaximum()
     */
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }
    /**
     * Sets whether the maximum value is exclusive.
     * <p>
     * If {@code true}, the instance value must be strictly less than {@code maximum}.
     * If {@code false} or {@code null}, the instance value may be equal to {@code maximum}.
     * </p>
     *
     * @param exclusiveMaximum {@code true} if the maximum value is exclusive, {@code false} otherwise.
     */
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }
    /**
     * Fluent-style setter for the {@code exclusiveMaximum} property.
     * <p>
     * Specifies whether the maximum value is exclusive and returns the schema instance
     * for method chaining.
     * </p>
     *
     * @param exclusiveMaximum {@code true} if the maximum is exclusive.
     * @return the updated schema instance.
     */
    public Schema exclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
        return this;
    }

    /**
     * Returns the minimum value allowed for a numeric instance.
     * <p>
     * This defines an inclusive lower limit for a numeric value,
     * unless {@code exclusiveMinimum} is set to {@code true}.
     * </p>
     *
     * @return the minimum value allowed, or {@code null} if not defined.
     * @see #setExclusiveMinimum(Boolean)
     */
    public BigDecimal getMinimum() {
        return minimum;
    }
    /**
     * Sets the minimum value allowed for a numeric instance.
     * <p>
     * By default, this value is inclusive. To make it exclusive, set {@code exclusiveMinimum} to {@code true}.
     * </p>
     *
     * @param minimum the minimum allowed value.
     */
    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }
    /**
     * Fluent-style setter for the minimum value constraint.
     * <p>
     * Sets the minimum allowed value for a numeric instance and returns the schema
     * instance for method chaining.
     * </p>
     *
     * @param minimum the minimum value to set.
     * @return the updated schema instance.
     */
    public Schema minimum(BigDecimal minimum) {
        this.minimum = minimum;
        return this;
    }

    /**
     * Returns whether the minimum value is exclusive.
     * <p>
     * When set to {@code true}, the instance value must be strictly greater than the value specified by {@code minimum}.
     * When {@code false} or {@code null}, the instance value may be equal to {@code minimum}.
     * </p>
     *
     * @return {@code true} if the minimum is exclusive; {@code false} or {@code null} otherwise.
     * @see #getMinimum()
     */
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }
    /**
     * Sets whether the minimum value is exclusive.
     * <p>
     * If {@code true}, the instance value must be strictly greater than {@code minimum}.
     * If {@code false} or {@code null}, the instance value may be equal to {@code minimum}.
     * </p>
     *
     * @param exclusiveMinimum {@code true} if the minimum value is exclusive; {@code false} otherwise.
     * @see #setMinimum(BigDecimal)
     */
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }
    /**
     * Fluent-style setter for the {@code exclusiveMinimum} property.
     * <p>
     * Specifies whether the minimum value is exclusive and returns the schema instance
     * for method chaining.
     * </p>
     *
     * @param exclusiveMinimum {@code true} if the minimum is exclusive.
     * @return the updated schema instance.
     */
    public Schema exclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
        return this;
    }

    /**
     * Returns the maximum length allowed for a string value.
     * <p>
     * This constraint applies only to string-typed schema definitions. It defines the
     * maximum number of characters a string instance can contain.
     * </p>
     *
     * @return the maximum string length allowed, or {@code null} if not specified.
     * @see #setMinLength(Integer)
     * @see #setPattern(String)
     */
    public Integer getMaxLength() {
        return maxLength;
    }
    /**
     * Sets the maximum length allowed for a string value.
     * <p>
     * The maximum length must be a non-negative integer. It defines the upper limit
     * on the number of characters permitted in a string instance.
     * </p>
     *
     * @param maxLength the maximum string length allowed.
     * @throws IllegalArgumentException if {@code maxLength} is negative.
     */
    public void setMaxLength(Integer maxLength) {
        if (maxLength != null && maxLength < 0) {
            throw new IllegalArgumentException("maxLength must be a non-negative integer.");
        }
        this.maxLength = maxLength;
    }
    /**
     * Fluent-style setter for the {@code maxLength} property.
     * <p>
     * Defines the maximum number of characters a string instance can contain
     * and returns the schema instance for method chaining.
     * </p>
     *
     * @param maxLength the maximum allowed string length.
     */
    public Schema maxLength(Integer maxLength) {
        this.setMaxLength(maxLength);
        return this;
    }

    /**
     * Returns the minimum length allowed for a string value.
     * <p>
     * This constraint applies only to schema definitions of type {@code string}.
     * It defines the minimum number of characters that a string instance must contain.
     * </p>
     *
     * @return the minimum string length allowed, or {@code null} if not defined.
     * @see #setMaxLength(Integer)
     * @see #setPattern(String)
     */
    public Integer getMinLength() {
        return minLength;
    }
    /**
     * Sets the minimum length allowed for a string value.
     * <p>
     * The value must be a non-negative integer. It specifies the lower bound on the number of characters
     * that a string instance must contain.
     * </p>
     *
     * @param minLength the minimum number of characters required.
     * @throws IllegalArgumentException if {@code minLength} is negative.
     */
    public void setMinLength(Integer minLength) {
        if (minLength != null && minLength < 0) {
            throw new IllegalArgumentException("minLength must be a non-negative integer.");
        }
        this.minLength = minLength;
    }
    /**
     * Fluent-style setter for the {@code minLength} property.
     * <p>
     * Sets the minimum number of characters a string must contain and returns the schema
     * instance for method chaining.
     * </p>
     *
     * @param minLength the minimum string length to set.
     */
    public Schema minLength(Integer minLength) {
        this.setMinLength(minLength);
        return this;
    }

    /**
     * Returns the regular expression pattern that a string value must match.
     * <p>
     * This constraint is applicable only to schema definitions of type {@code string}.
     * The pattern must be a valid regular expression, and instances of the string must match this pattern.
     * </p>
     *
     * @return the regular expression pattern, or {@code null} if not defined.
     * @see #setMinLength(Integer)
     * @see #setMaxLength(Integer)
     */
    public String getPattern() {
        return pattern;
    }
    /**
     * Sets the regular expression pattern that a string value must match.
     * <p>
     * This defines a constraint on string values to ensure they conform to a specified
     * regular expression. The expression should follow the ECMA 262/Perl 5 regular expression syntax.
     * </p>
     *
     * @param pattern the regular expression pattern to apply.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    /**
     * Fluent-style setter for the {@code pattern} property.
     * <p>
     * Sets the regular expression pattern that a string instance must match and
     * returns the schema instance for method chaining.
     * </p>
     *
     * @param pattern the pattern to set.
     * @return the updated schema instance.
     */
    public Schema pattern(String pattern) {
        this.setPattern(pattern);
        return this;
    }

    /**
     * Returns the maximum number of items allowed in an array.
     * <p>
     * This constraint applies only to schema definitions of type {@code array}.
     * It specifies the upper limit on the number of items that an array instance can contain.
     * </p>
     *
     * @return the maximum number of items allowed, or {@code null} if not defined.
     * @see #setMinItems(Integer)
     * @see #setUniqueItems(Boolean)
     */
    public Integer getMaxItems() {
        return maxItems;
    }
    /**
     * Sets the maximum number of items allowed in an array.
     * <p>
     * This defines the maximum length constraint for arrays. The value must be a non-negative integer.
     * </p>
     *
     * @param maxItems the maximum number of items allowed.
     * @throws IllegalArgumentException if {@code maxItems} is negative.
     */
    public void setMaxItems(Integer maxItems) {
        if (maxItems != null && maxItems < 0) {
            throw new IllegalArgumentException("maxItems must be a non-negative integer.");
        }
        this.maxItems = maxItems;
    }
    /**
     * Fluent-style setter for the {@code maxItems} property.
     * <p>
     * Sets the maximum number of items allowed in an array and returns the schema instance for method chaining.
     * </p>
     *
     * @param maxItems the maximum array size to set.
     * @return the updated schema instance.
     */
    public Schema maxItems(Integer maxItems) {
        this.setMaxItems(maxItems);
        return this;
    }

    /**
     * Returns the minimum number of items required in an array.
     * <p>
     * This constraint applies only to schema definitions of type {@code array}.
     * It specifies the lower bound on the number of items that an array instance must contain.
     * </p>
     *
     * @return the minimum number of items required, or {@code null} if not defined.
     * @since 1.0
     * @see #getMaxItems()
     * @see #getUniqueItems()
     */
    public Integer getMinItems() {
        return minItems;
    }
    /**
     * Sets the minimum number of items required in an array.
     * <p>
     * This defines the minimum length constraint for arrays. The value must be a non-negative integer.
     * </p>
     *
     * @param minItems the minimum number of items required.
     * @throws IllegalArgumentException if {@code minItems} is negative.
     */
    public void setMinItems(Integer minItems) {
        if (minItems != null && minItems < 0) {
            throw new IllegalArgumentException("minItems must be a non-negative integer.");
        }
        this.minItems = minItems;
    }
    /**
     * Fluent-style setter for the {@code minItems} property.
     * <p>
     * Sets the minimum number of items required in an array and returns the schema instance for method chaining.
     * </p>
     *
     * @param minItems the minimum number of array items to require.
     * @return the updated schema instance.
     */
    public Schema minItems(Integer minItems) {
        this.setMinItems(minItems);
        return this;
    }

    /**
     * Indicates whether all items in the array must be unique.
     * <p>
     * This constraint applies only to schema definitions of type {@code array}.
     * When set to {@code true}, the array instance must not contain duplicate values.
     * </p>
     *
     * @return {@code true} if items in the array must be unique, {@code false} otherwise, or {@code null} if not defined.
     * @since 1.0
     * @see #getMaxItems()
     * @see #getMinItems()
     */
    public Boolean getUniqueItems() {
        return uniqueItems;
    }
    /**
     * Sets whether all items in the array must be unique.
     * <p>
     * This defines the {@code uniqueItems} constraint. If set to {@code true}, duplicate items in the array are not allowed.
     * </p>
     *
     * @param uniqueItems {@code true} if items must be unique, {@code false} otherwise.
     */
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }
    /**
     * Fluent-style setter for the {@code uniqueItems} property.
     * <p>
     * Specifies whether all items in the array must be unique and returns the schema instance for method chaining.
     * </p>
     *
     * @param uniqueItems {@code true} if items must be unique.
     * @return the updated schema instance.
     */
    public Schema uniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
        return this;
    }

    /**
     * Returns the maximum number of properties allowed in an object.
     * <p>
     * This constraint is applicable only to schemas of type {@code object}.
     * It specifies the upper bound for the number of properties an object instance may contain.
     * </p>
     *
     * @return the maximum number of properties allowed, or {@code null} if not defined.
     * @see #getMinProperties()
     */
    public Integer getMaxProperties() {
        return maxProperties;
    }
    /**
     * Sets the maximum number of properties allowed in an object.
     * <p>
     * This defines a constraint to limit the number of fields (properties) within an object instance.
     * The value must be a non-negative integer.
     * </p>
     *
     * @param maxProperties the maximum number of properties allowed.
     * @throws IllegalArgumentException if {@code maxProperties} is negative.
     */
    public void setMaxProperties(Integer maxProperties) {
        if (maxProperties != null && maxProperties < 0)
            throw new IllegalArgumentException("maxProperties must be a non-negative integer.");
        this.maxProperties = maxProperties;
    }
    /**
     * Fluent-style setter for the {@code maxProperties} property.
     * <p>
     * Sets the maximum number of properties and returns the schema instance for method chaining.
     * </p>
     *
     * @param maxProperties the maximum number of properties allowed.
     * @return the updated schema instance.
     */
    public Schema maxProperties(Integer maxProperties) {
        this.setMaxProperties(maxProperties);
        return this;
    }

    /**
     * Returns the minimum number of properties required in an object.
     * <p>
     * This constraint is applicable only to schemas of type {@code object}.
     * It specifies the lower bound for the number of properties an object instance must contain.
     * </p>
     *
     * @return the minimum number of properties required, or {@code null} if not defined.
     * @see #getMaxProperties()
     */
    public Integer getMinProperties() {
        return minProperties;
    }
    /**
     * Sets the minimum number of properties required in an object.
     * <p>
     * This defines a constraint to ensure that an object instance has at least a certain number of properties.
     * The value must be a non-negative integer.
     * </p>
     *
     * @param minProperties the minimum number of properties required.
     * @throws IllegalArgumentException if {@code minProperties} is negative.
     */
    public void setMinProperties(Integer minProperties) {
        if (minProperties != null && minProperties < 0)
            throw new IllegalArgumentException("minProperties must be a non-negative integer.");
        this.minProperties = minProperties;
    }
    /**
     * Fluent-style setter for the {@code minProperties} property.
     * <p>
     * Sets the minimum number of properties and returns the schema instance for method chaining.
     * </p>
     *
     * @param minProperties the minimum number of properties required.
     * @return the updated schema instance.
     */
    public Schema minProperties(Integer minProperties) {
        this.setMinProperties(minProperties);
        return this;
    }

    /**
     * Returns the list of required property names for the object schema.
     * <p>
     * This list defines which properties must be present when an instance of the schema is validated.
     * It only applies to schemas of type {@code object}.
     * </p>
     *
     * @return a list of required property names, or {@code null} if no properties are required.
     * @see #setRequired(List)
     */
    public List<String> getRequired() {
        return required;
    }
    /**
     * Sets the list of required property names for the object schema.
     * <p>
     * If the provided list is {@code null} or empty, or if the current {@code properties} map is {@code null}
     * or empty, the required list is cleared. Only properties that exist in the current {@code properties}
     * map are considered valid and will be retained in the required list.
     * </p>
     *
     * @param required a list of property names that are required.
     */
    public void setRequired(List<String> required) {
        if (required == null || required.isEmpty()) {
            this.required = null;
            return;
        }
        if (this.properties == null || this.properties.isEmpty()) {
            this.required = null;
            return;
        }
        List<String> filtered = required.stream()
                .filter(req -> this.properties.containsKey(req))
                .sorted()
                .toList();
        this.required = filtered.isEmpty() ? null : filtered;
    }
    /**
     * Fluent-style setter for the {@code required} property.
     * <p>
     * Sets the list of required properties without filtering based on existing properties.
     * For consistency, prefer using {@link #setRequired(List)} if filtering is needed.
     * </p>
     *
     * @param required a list of required property names.
     * @return the updated schema instance.
     */
    public Schema required(List<String> required) {
        this.required = required;
        return this;
    }

    /**
     * Returns the type of the schema.
     * <p>
     * This defines the basic data type of the schema, such as {@code string}, {@code number},
     * {@code integer}, {@code boolean}, {@code array}, or {@code object}, as specified by
     * the OpenAPI 3.0.1 specification.
     * </p>
     * <p>
     * If the system property {@code BIND_TYPE_AND_TYPES} is set to {@code true}, and the {@code types}
     * set contains exactly one value while {@code type} is {@code null}, this method will return
     * that single value from {@code types}.
     * </p>
     *
     * @return the schema type, or a single value from {@code types} if binding is enabled.
     */
    public String getType() {
        boolean shouldBindTypes = Boolean.parseBoolean(System.getProperty(BIND_TYPE_AND_TYPES, "false"));
        boolean hasSingleType = types != null && types.size() == 1;
        if (shouldBindTypes && type == null && hasSingleType)
            return types.iterator().next();
        return type;
    }
    /**
     * Sets the type of the schema.
     * <p>
     * This should match one of the standard OpenAPI data types: {@code string}, {@code number},
     * {@code integer}, {@code boolean}, {@code array}, or {@code object}.
     * </p>
     *
     * @param type the data type to be set for this schema.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Fluent-style setter for the {@code type} field.
     *
     * @param type the data type to be set for this schema.
     * @return the updated schema instance.
     */
    public Schema type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Returns the schema that must not be valid for the instance.
     * <p>
     * The {@code not} keyword in a schema is used to declare that the data must not match
     * the specified schema. It is useful for defining constraints and validation logic.
     * </p>
     *
     * @return the schema that should not be matched.
     */
    public Schema getNot() {
        return not;
    }
    /**
     * Sets the schema that must not be valid for the instance.
     * <p>
     * This can be used to restrict input by specifying disallowed schema definitions.
     * </p>
     *
     * @param not the schema to be excluded.
     */
    public void setNot(Schema not) {
        this.not = not;
    }
    /**
     * Fluent-style setter for the {@code not} schema.
     *
     * @param not the schema to be excluded.
     * @return the updated schema instance.
     */
    public Schema not(Schema not) {
        this.not = not;
        return this;
    }

    public Map<String, Schema> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Schema> properties) {
        this.properties = properties;
    }

    /**
     * Returns the definition of additional properties allowed by the schema.
     * <p>
     * In OpenAPI 3.0.1, the {@code additionalProperties} keyword controls whether
     * an object can have properties not listed in the {@code properties} section.
     * This field can be either:
     * <ul>
     *   <li>{@code Boolean} – {@code true} allows any additional properties; {@code false} disallows them.</li>
     *   <li>{@link Schema} – specifies the schema that additional properties must conform to.</li>
     * </ul>
     * </p>
     *
     * @return an {@code Object} representing additional properties, either {@code Boolean} or {@link Schema}.
     */
    public Schema getAdditionalProperties() {
        return additionalProperties;
    }
    /**
     * Sets the definition for additional properties allowed by the schema.
     * <p>
     * The argument must be either a {@code Boolean} or a {@link Schema} instance.
     * </p>
     *
     * @param additionalProperties the value indicating allowed additional properties
     * @throws IllegalArgumentException if the argument is neither a {@code Boolean} nor a {@link Schema}
     */
    public void setAdditionalProperties(Schema additionalProperties) {
        if (OpenApiPredicates.SCHEMA_INVALID_ADDITIONAL_PROPERTIES.test(additionalProperties))
            throw new IllegalArgumentException("additionalProperties must be either a Boolean or a Schema instance");
        this.additionalProperties = additionalProperties;
    }
    /**
     * Fluent-style method for setting {@code additionalProperties}.
     * <p>
     * This is a convenience method for chaining. Internally delegates to {@link #setAdditionalProperties(Schema)}.
     * </p>
     *
     * @param additionalProperties the value indicating allowed additional properties
     * @return this {@link Schema} instance
     * @throws IllegalArgumentException if the argument is invalid
     */
    public Schema additionalProperties(Schema additionalProperties) {
        setAdditionalProperties(additionalProperties);
        return this;
    }

    /**
     * Returns the description of the schema.
     * <p>
     * The {@code description} provides a short explanation about the purpose or details
     * of the schema. It supports rich text representation using CommonMark syntax.
     * </p>
     *
     * @return the schema description, or {@code null} if not set.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the schema.
     * <p>
     * This field is used to document the purpose, usage, or constraints of the schema.
     * Supports CommonMark syntax for rich text formatting.
     * </p>
     *
     * @param description the new description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent-style method for setting the schema description.
     * <p>
     * Supports method chaining and is equivalent to calling {@link #setDescription(String)}.
     * </p>
     *
     * @param description the new description to set.
     * @return this {@link Schema} instance.
     */
    public Schema description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the format of the schema.
     * <p>
     * The {@code format} keyword provides additional information about the data type.
     * It is used to specify the format of the data for types like {@code string}, {@code integer},
     * {@code number}, and others. Common formats include {@code date-time}, {@code email}, {@code uri}, and more.
     * </p>
     *
     * @return the schema format, or {@code null} if not set.
     */
    public String getFormat() {
        return format;
    }
    /**
     * Sets the format of the schema.
     * <p>
     * This field specifies the format for data types such as {@code string}, {@code integer},
     * and {@code number}. Common formats might include {@code date-time}, {@code email}, {@code uri}, and others.
     * </p>
     *
     * @param format the format string to set.
     */
    public void setFormat(String format) {
        this.format = format;
    }
    /**
     * Fluent-style method for setting the schema format.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #setFormat(String)}.
     * </p>
     *
     * @param format the format string to set.
     * @return this {@link Schema} instance.
     */
    public Schema format(String format) {
        this.format = format;
        return this;
    }

    /**
     * Returns the reference to the schema.
     * <p>
     * The {@code $ref} keyword is used to reference a schema defined elsewhere in the
     * OpenAPI specification. It allows you to reuse existing definitions and avoid duplication.
     * The value of this field is a URI or a reference to another schema component.
     * </p>
     *
     * @return the schema reference, or {@code null} if not set.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference to the schema.
     * <p>
     * The {@code $ref} field allows referencing schemas defined elsewhere in the OpenAPI specification.
     * If the reference does not contain the necessary prefix, it will be automatically adjusted
     * to point to the correct location in the schema components section.
     * </p>
     *
     * @param $ref the reference string to set.
     * @throws IllegalArgumentException if the reference is invalid.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.SCHEMA_PLAIN_REFERENCE.test($ref))
            $ref = Components.COMPONENTS_SCHEMAS_REF + $ref;
        this.$ref = $ref;
    }
    /**
     * Fluent-style method for setting the schema reference.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #set$ref(String)}.
     * </p>
     *
     * @param $ref the reference string to set.
     * @return this {@link Schema} instance.
     */
    public Schema $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Returns whether the schema allows {@code null} values.
     * <p>
     * The {@code nullable} field specifies whether the value of the schema can be {@code null}.
     * If {@code nullable} is {@code true}, the value can be {@code null}; otherwise, it cannot.
     * This is particularly useful for defining optional values in an API response.
     * </p>
     *
     * @return {@code true} if the schema allows {@code null} values, {@code false} otherwise, or {@code null} if not set.
     */
    public Boolean getNullable() {
        return nullable;
    }
    /**
     * Sets whether the schema allows {@code null} values.
     * <p>
     * This method defines whether the schema permits the value to be {@code null}.
     * If set to {@code true}, the schema will allow a {@code null} value for the corresponding field.
     * </p>
     *
     * @param nullable {@code true} if the schema should allow {@code null} values, {@code false} otherwise.
     */
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }
    /**
     * Fluent-style method for setting whether the schema allows {@code null} values.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #setNullable(Boolean)}.
     * </p>
     *
     * @param nullable {@code true} if the schema should allow {@code null} values, {@code false} otherwise.
     * @return this {@link Schema} instance.
     */
    public Schema nullable(Boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    /**
     * Returns whether the schema is marked as read-only.
     * <p>
     * The {@code readOnly} field indicates whether the property described by the schema is read-only.
     * If {@code readOnly} is {@code true}, the property cannot be modified by the user and is typically used
     * in API responses where the value is computed or generated by the server and cannot be updated by the client.
     * </p>
     *
     * @return {@code true} if the schema is read-only, {@code false} otherwise, or {@code null} if not set.
     */
    public Boolean getReadOnly() {
        return readOnly;
    }
    /**
     * Sets whether the schema is marked as read-only.
     * <p>
     * This method defines whether the property described by the schema is read-only.
     * If set to {@code true}, the property cannot be modified by the user.
     * </p>
     *
     * @param readOnly {@code true} if the schema should be read-only, {@code false} otherwise.
     */
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }
    /**
     * Fluent-style method for setting whether the schema is marked as read-only.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #setReadOnly(Boolean)}.
     * </p>
     *
     * @param readOnly {@code true} if the schema should be read-only, {@code false} otherwise.
     * @return this {@link Schema} instance.
     */
    public Schema readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    /**
     * Returns whether the schema is marked as write-only.
     * <p>
     * The {@code writeOnly} field indicates whether the property described by the schema is write-only.
     * If {@code writeOnly} is {@code true}, the property can only be set by the user and cannot be retrieved
     * from the response. This is typically used for input fields where the value is provided by the client
     * but is not expected to be included in the response from the server.
     * </p>
     *
     * @return {@code true} if the schema is write-only, {@code false} otherwise, or {@code null} if not set.
     */
    public Boolean getWriteOnly() {
        return writeOnly;
    }
    /**
     * Sets whether the schema is marked as write-only.
     * <p>
     * This method defines whether the property described by the schema is write-only.
     * If set to {@code true}, the property can only be set by the user and will not be included in the response.
     * </p>
     *
     * @param writeOnly {@code true} if the schema should be write-only, {@code false} otherwise.
     */
    public void setWriteOnly(Boolean writeOnly) {
        this.writeOnly = writeOnly;
    }
    /**
     * Fluent-style method for setting whether the schema is marked as write-only.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #setWriteOnly(Boolean)}.
     * </p>
     *
     * @param writeOnly {@code true} if the schema should be write-only, {@code false} otherwise.
     * @return this {@link Schema} instance.
     */
    public Schema writeOnly(Boolean writeOnly) {
        this.writeOnly = writeOnly;
        return this;
    }

    /**
     * Returns the example value associated with the schema.
     * <p>
     * The {@code example} field provides a sample value that illustrates the expected format or content
     * of the property described by the schema. This example value can be used in documentation or
     * for testing purposes to demonstrate what a valid value might look like.
     * </p>
     *
     * @return the example value for the schema, or {@code null} if not set.
     */
    public Object getExample() {
        return example;
    }
    /**
     * Sets the example value for the schema.
     * <p>
     * This method sets an example value to illustrate what the value of the property described by the schema
     * might look like. This is often used in API documentation and helps developers understand the expected
     * format of a property.
     * </p>
     *
     * @param example the example value to be set, can be any type that represents a valid example for the property.
     */
    public void setExample(Object example) {
        this.example = cast(example);
    }
    /**
     * Fluent-style method for setting the example value for the schema.
     * <p>
     * This method allows for method chaining and is equivalent to calling {@link #setExample(Object)}.
     * </p>
     *
     * @param example the example value to be set.
     * @return this {@link Schema} instance.
     */
    public Schema example(Object example) {
        setExample(example);
        return this;
    }

    /**
     * Returns the external documentation associated with the schema.
     * <p>
     * The external documentation provides additional information about the schema that can be found
     * outside the current API definition. This is useful for linking to extended documentation, specifications,
     * or tutorials relevant to this schema.
     * </p>
     *
     * @return the {@link ExternalDocumentation} instance, or {@code null} if not set.
     */
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }
    /**
     * Sets the external documentation associated with the schema.
     * <p>
     * Use this to attach an {@link ExternalDocumentation} object that provides additional context,
     * references, or supporting documentation for the schema.
     * </p>
     *
     * @param externalDocs the {@link ExternalDocumentation} object to associate with the schema.
     */
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }
    /**
     * Fluent-style method for setting the external documentation for the schema.
     * <p>
     * This method is functionally equivalent to {@link #setExternalDocs(ExternalDocumentation)}
     * and is useful for method chaining.
     * </p>
     *
     * @param externalDocs the {@link ExternalDocumentation} to set.
     * @return this {@link Schema} instance.
     */
    public Schema externalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
        return this;
    }

    /**
     * Indicates whether the schema property is deprecated.
     * <p>
     * When set to {@code true}, it signals that the property or schema is deprecated and should
     * no longer be used. Consumers of the API should avoid relying on deprecated properties,
     * as they may be removed in future versions.
     * </p>
     *
     * @return {@code true} if the schema is deprecated, {@code false} or {@code null} otherwise.
     */
    public Boolean getDeprecated() {
        return deprecated;
    }
    /**
     * Sets whether the schema is deprecated.
     * <p>
     * This method marks the schema (or a property within a schema) as deprecated.
     * A value of {@code true} indicates that the property should be avoided by consumers.
     * </p>
     *
     * @param deprecated {@code true} to mark the schema as deprecated; {@code false} otherwise.
     */
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }
    /**
     * Fluent-style method to configure the {@code deprecated} property of the schema.
     * <p>
     * Allows method chaining when building a schema.
     * </p>
     *
     * @param deprecated {@code true} to mark as deprecated.
     * @return the current {@link Schema} instance.
     */
    public Schema deprecated(Boolean deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    /**
     * Returns the XML object representing XML model definitions for this schema.
     * <p>
     * This is used to customize the XML representation of the schema when the media type is {@code application/xml}.
     * </p>
     *
     * @return the {@link XML} configuration object, or {@code null} if not set.
     */
    public XML getXml() {
        return xml;
    }
    /**
     * Sets the XML object that defines how this schema should be represented in XML.
     * <p>
     * This allows you to define properties such as name, namespace, prefix, attribute or wrapped, which determine
     * how the property appears in an XML document.
     * </p>
     *
     * @param xml the {@link XML} configuration object.
     */
    public void setXml(XML xml) {
        this.xml = xml;
    }
    /**
     * Fluent-style method to configure the {@code xml} property of the schema.
     * <p>
     * Allows method chaining when building a schema.
     * </p>
     *
     * @param xml the {@link XML} object representing XML configuration.
     * @return the current {@link Schema} instance.
     */
    public Schema xml(XML xml) {
        this.xml = xml;
        return this;
    }

    /**
     * Returns the map of vendor-specific extensions associated with this schema.
     * <p>
     * Extensions allow adding custom metadata to the schema that is not part of the OpenAPI Specification.
     * Keys must start with {@code "x-"} to be considered valid.
     * </p>
     *
     * @return a {@link Map} of extension names to values, or {@code null} if no extensions are set.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets the full map of vendor-specific extensions for this schema.
     * <p>
     * This will replace any existing extensions.
     * </p>
     *
     * @param extensions a {@link Map} of extension names to values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent-style method to set the map of vendor-specific extensions.
     * <p>
     * Allows chaining when building the schema.
     * </p>
     *
     * @param extensions a {@link Map} of extension names to values.
     * @return the current {@link Schema} instance.
     */
    public Schema extensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }
    /**
     * Adds a single vendor-specific extension to this schema.
     * <p>
     * The extension name must start with {@code "x-"} to be valid.
     * If the name is invalid, the extension is ignored and a warning is logged.
     * </p>
     *
     * @param name the name of the extension (must start with {@code "x-"}).
     * @param value the value associated with the extension.
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (this.extensions == null)
            this.extensions = new java.util.LinkedHashMap<>();
        this.extensions.put(name, value);
    }

    /**
     * Fluent-style method to set the list of allowed enum values for this schema.
     * <p>
     * The values must be of the type compatible with the schema's type.
     * </p>
     *
     * @param _enum a list of allowed values.
     * @return the current {@link Schema} instance.
     */
    public Schema _enum(List<T> _enum) {
        this._enum = _enum;
        return this;
    }
    /**
     * Returns the list of allowed enum values for this schema.
     *
     * @return a list of allowed values, or {@code null} if not defined.
     */
    public List<T> getEnum() {
        return _enum;
    }
    /**
     * Sets the list of allowed enum values for this schema.
     *
     * @param _enum a list of allowed values.
     */
    public void setEnum(List<T> _enum) {
        this._enum = _enum;
    }
    /**
     * Adds a single item to the list of allowed enum values.
     * <p>
     * If the list is not yet initialized, it will be created.
     * The item will be cast using the internal {@code cast} method.
     * </p>
     *
     * @param _enumItem the value to add to the enum list.
     */
    public void addEnumItemObject(T _enumItem) {
        if (this._enum == null)
            this._enum = new ArrayList<>();
        this._enum.add(cast(_enumItem));
    }

    /**
     * Returns the {@link Discriminator} object associated with this schema.
     * <p>
     * A discriminator is used to aid in serialization, deserialization, and validation
     * when using polymorphism with {@code oneOf}, {@code anyOf}, or {@code allOf}.
     * </p>
     *
     * @return the discriminator object, or {@code null} if not defined.
     */
    public Discriminator getDiscriminator() {
        return discriminator;
    }
    /**
     * Sets the {@link Discriminator} object for this schema.
     * <p>
     * A discriminator is used in schemas with polymorphic behavior to determine
     * which subschema an object should be deserialized to.
     * </p>
     *
     * @param discriminator the {@link Discriminator} to set.
     */
    public void setDiscriminator(Discriminator discriminator) {
        this.discriminator = discriminator;
    }
    /**
     * Fluent-style method to set the {@link Discriminator} object for this schema.
     *
     * @param discriminator the {@link Discriminator} to set.
     * @return the current {@link Schema} instance.
     */
    public Schema discriminator(Discriminator discriminator) {
        this.discriminator = discriminator;
        return this;
    }

    /**
     * Returns the map of pattern properties defined for this schema.
     * <p>
     * Pattern properties are used to define schemas that apply to properties matching
     * certain regular expression patterns.
     * </p>
     *
     * @return a map where keys are regular expressions and values are schemas applied to
     *         properties matching the corresponding pattern; or {@code null} if none are defined.
     */
    public Map<String, Schema> getPatternProperties() {
        return patternProperties;
    }
    /**
     * Sets the map of pattern properties for this schema.
     * <p>
     * Each entry in the map consists of a regular expression and the corresponding schema
     * that applies to properties matching the pattern.
     * </p>
     *
     * @param patternProperties the pattern properties to set.
     */
    public void setPatternProperties(Map<String, Schema> patternProperties) {
        this.patternProperties = patternProperties;
    }
    /**
     * Fluent-style method for setting pattern properties.
     *
     * @param patternProperties the map of regular expression patterns and corresponding schemas.
     * @return the current {@link Schema} instance.
     */
    public Schema patternProperties(Map<String, Schema> patternProperties) {
        this.patternProperties = patternProperties;
        return this;
    }
    /**
     * Adds a single pattern property to the schema.
     * <p>
     * If the pattern properties map is {@code null}, it will be initialized.
     * </p>
     *
     * @param key   the regular expression pattern.
     * @param patternPropertiesItem the schema to apply for properties matching the pattern.
     * @return the current {@link Schema} instance.
     */
    public Schema addPatternProperty(String key, Schema patternPropertiesItem) {
        if (this.patternProperties == null)
            this.patternProperties = new LinkedHashMap<>();
        this.patternProperties.put(key, patternPropertiesItem);
        return this;
    }

    /**
     * Gets the exclusive maximum value for numeric instance validation.
     * <p>
     * This value is used to indicate that the instance value must be
     * strictly less than the specified number (i.e., exclusive maximum).
     * </p>
     *
     * @return the exclusive maximum value, or {@code null} if not set.
     */
    public BigDecimal getExclusiveMaximumValue() {
        return exclusiveMaximumValue;
    }
    /**
     * Sets the exclusive maximum value for numeric instance validation.
     * <p>
     * When specified, instance values must be strictly less than this value.
     * </p>
     *
     * @param exclusiveMaximumValue the exclusive maximum value to set.
     */
    public void setExclusiveMaximumValue(BigDecimal exclusiveMaximumValue) {
        this.exclusiveMaximumValue = exclusiveMaximumValue;
    }
    /**
     * Fluent-style method for setting the exclusive maximum value.
     *
     * @param exclusiveMaximumValue the exclusive maximum value to set.
     * @return the current {@link Schema} instance.
     */
    public Schema exclusiveMaximumValue(BigDecimal exclusiveMaximumValue) {
        this.exclusiveMaximumValue = exclusiveMaximumValue;
        return this;
    }

    /**
     * Gets the exclusive minimum value for numeric instance validation.
     * <p>
     * This value is used to indicate that the instance value must be
     * strictly greater than the specified number (i.e., exclusive minimum).
     * </p>
     *
     * @return the exclusive minimum value, or {@code null} if not set.
     */
    public BigDecimal getExclusiveMinimumValue() {
        return exclusiveMinimumValue;
    }
    /**
     * Sets the exclusive minimum value for numeric instance validation.
     * <p>
     * When specified, instance values must be strictly greater than this value.
     * </p>
     *
     * @param exclusiveMinimumValue the exclusive minimum value to set.
     */
    public void setExclusiveMinimumValue(BigDecimal exclusiveMinimumValue) {
        this.exclusiveMinimumValue = exclusiveMinimumValue;
    }
    /**
     * Fluent-style method for setting the exclusive minimum value.
     *
     * @param exclusiveMinimumValue the exclusive minimum value to set.
     * @return the current {@link Schema} instance.
     */
    public Schema exclusiveMinimumValue(BigDecimal exclusiveMinimumValue) {
        this.exclusiveMinimumValue = exclusiveMinimumValue;
        return this;
    }

    /**
     * Sets the schema that each item in an array must contain at least once.
     * <p>
     * This corresponds to the JSON Schema `contains` keyword, which requires
     * that an array has at least one item that is valid against the given schema.
     * </p>
     *
     * @param contains the schema that should be matched by at least one item in the array.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema contains(Schema contains) {
        this.contains = contains;
        return this;
    }

    /**
     * Gets the content encoding of the schema.
     * <p>
     * This corresponds to the `contentEncoding` keyword, which specifies the
     * encoding of the content in the schema. It may be useful for APIs where
     * the encoding of the content type must be specified explicitly.
     * </p>
     *
     * @return the content encoding for the schema.
     */
    public String getContentEncoding() {
        return contentEncoding;
    }
    /**
     * Sets the content encoding for the schema.
     * <p>
     * This sets the `contentEncoding` keyword, which specifies the encoding of the
     * content in the schema. It is used to define how the content is represented,
     * such as whether it is base64-encoded or otherwise encoded.
     * </p>
     *
     * @param contentEncoding the content encoding to set for the schema.
     */
    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }
    /**
     * Sets the content encoding for the schema and returns the updated schema instance.
     * <p>
     * This method allows you to chain method calls by setting the `contentEncoding` keyword.
     * </p>
     *
     * @param contentEncoding the content encoding to set for the schema.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema contentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /**
     * Gets the content media type of the schema.
     * <p>
     * This corresponds to the `contentMediaType` keyword, which specifies the media type
     * (MIME type) of the content in the schema. For example, it could be `application/json`
     * or `text/plain`, depending on the type of content expected.
     * </p>
     *
     * @return the content media type for the schema.
     */
    public String getContentMediaType() {
        return contentMediaType;
    }
    /**
     * Sets the content media type for the schema.
     * <p>
     * This sets the `contentMediaType` keyword, which specifies the media type
     * (MIME type) of the content in the schema. It is used to define how the content
     * should be interpreted, for example, whether it's a JSON object or a plain text string.
     * </p>
     *
     * @param contentMediaType the content media type to set for the schema.
     */
    public void setContentMediaType(String contentMediaType) {
        this.contentMediaType = contentMediaType;
    }
    /**
     * Sets the content media type for the schema and returns the updated schema instance.
     * <p>
     * This method allows you to chain method calls by setting the `contentMediaType` keyword.
     * </p>
     *
     * @param contentMediaType the content media type to set for the schema.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema contentMediaType(String contentMediaType) {
        this.contentMediaType = contentMediaType;
        return this;
    }

    /**
     * Gets the content schema associated with this schema.
     * <p>
     * This method returns the schema that describes the content model, which may include
     * further details or constraints for the content defined by this schema.
     * </p>
     *
     * @return the content schema associated with this schema.
     */
    public Schema getContentSchema() {
        return contentSchema;
    }
    /**
     * Sets the content schema associated with this schema.
     * <p>
     * This method allows setting the schema that defines the content model, including
     * constraints and properties related to the content of this schema.
     * </p>
     *
     * @param contentSchema the content schema to set.
     */
    public void setContentSchema(Schema contentSchema) {
        this.contentSchema = contentSchema;
    }
    /**
     * Sets the content schema and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema that describes the content model and allows method chaining
     * to streamline setting multiple properties in a single call.
     * </p>
     *
     * @param contentSchema the content schema to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema contentSchema(Schema contentSchema) {
        this.contentSchema = contentSchema;
        return this;
    }

    /**
     * Gets the schema that defines the property names of this schema.
     * <p>
     * This method returns a schema that describes the names of the properties for this schema,
     * potentially including constraints or rules related to property names.
     * </p>
     *
     * @return the schema that defines the property names.
     */
    public Schema getPropertyNames() {
        return propertyNames;
    }
    /**
     * Sets the schema that defines the property names of this schema.
     * <p>
     * This method allows setting the schema that governs the names of the properties
     * for this schema, which could include constraints on naming rules or patterns.
     * </p>
     *
     * @param propertyNames the schema to set for the property names.
     */
    public void setPropertyNames(Schema propertyNames) {
        this.propertyNames = propertyNames;
    }
    /**
     * Sets the schema that defines the property names of this schema and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for property names and supports method chaining, enabling
     * the configuration of multiple properties in a single call.
     * </p>
     *
     * @param propertyNames the schema to set for the property names.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema propertyNames(Schema propertyNames) {
        this.propertyNames = propertyNames;
        return this;
    }

    /**
     * Gets the schema that defines the unevaluated properties of this schema.
     * <p>
     * This method returns the schema that governs the unevaluated properties of this schema.
     * Unevaluated properties are those properties which do not fit within the constraints
     * or rules of the current schema.
     * </p>
     *
     * @return the schema that defines the unevaluated properties.
     */
    public Schema getUnevaluatedProperties() {
        return unevaluatedProperties;
    }
    /**
     * Sets the schema that defines the unevaluated properties of this schema.
     * <p>
     * This method allows setting the schema that governs the unevaluated properties of
     * the current schema. Unevaluated properties may represent additional properties
     * that are not yet validated by the schema's constraints.
     * </p>
     *
     * @param unevaluatedProperties the schema to set for the unevaluated properties.
     */
    public void setUnevaluatedProperties(Schema unevaluatedProperties) {
        this.unevaluatedProperties = unevaluatedProperties;
    }
    /**
     * Sets the schema that defines the unevaluated properties of this schema and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for unevaluated properties and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param unevaluatedProperties the schema to set for the unevaluated properties.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema unevaluatedProperties(Schema unevaluatedProperties) {
        this.unevaluatedProperties = unevaluatedProperties;
        return this;
    }

    /**
     * Gets the maximum number of elements that can be contained in the array or object defined by this schema.
     * <p>
     * This method returns the maximum number of elements allowed in an array or object
     * based on the current schema's definition.
     * </p>
     *
     * @return the maximum number of elements that can be contained.
     */
    public Integer getMaxContains() {
        return maxContains;
    }
    /**
     * Sets the maximum number of elements that can be contained in the array or object defined by this schema.
     * <p>
     * This method allows setting the maximum number of elements that are allowed in the array or object
     * based on the constraints of the current schema.
     * </p>
     *
     * @param maxContains the maximum number of elements to set.
     */
    public void setMaxContains(Integer maxContains) {
        this.maxContains = maxContains;
    }
    /**
     * Sets the maximum number of elements that can be contained in the array or object defined by this schema and
     * returns the current schema instance for method chaining.
     * <p>
     * This method sets the maximum number of elements for the array or object and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param maxContains the maximum number of elements to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema maxContains(Integer maxContains) {
        this.maxContains = maxContains;
        return this;
    }

    /**
     * Gets the minimum number of elements that must be contained in the array or object defined by this schema.
     * <p>
     * This method returns the minimum number of elements required in an array or object
     * based on the current schema's definition.
     * </p>
     *
     * @return the minimum number of elements that must be contained.
     */
    public Integer getMinContains() {
        return minContains;
    }
    /**
     * Sets the minimum number of elements that must be contained in the array or object defined by this schema.
     * <p>
     * This method allows setting the minimum number of elements that are required in the array or object
     * based on the constraints of the current schema.
     * </p>
     *
     * @param minContains the minimum number of elements to set.
     */
    public void setMinContains(Integer minContains) {
        this.minContains = minContains;
    }
    /**
     * Sets the minimum number of elements that must be contained in the array or object defined by this schema and
     * returns the current schema instance for method chaining.
     * <p>
     * This method sets the minimum number of elements for the array or object and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param minContains the minimum number of elements to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema minContains(Integer minContains) {
        this.minContains = minContains;
        return this;
    }

    /**
     * Gets the schema that defines additional items that can be present in the array defined by this schema.
     * <p>
     * This method returns the schema for any additional items allowed in the array.
     * If no additional items are specified, this will return {@code null}.
     * </p>
     *
     * @return the schema for additional items, or {@code null} if none are defined.
     */
    public Schema getAdditionalItems() {
        return additionalItems;
    }
    /**
     * Sets the schema that defines additional items that can be present in the array defined by this schema.
     * <p>
     * This method allows specifying the schema for any additional items allowed in the array.
     * If no additional items are required, this method can be used to set it as {@code null}.
     * </p>
     *
     * @param additionalItems the schema for additional items.
     */
    public void setAdditionalItems(Schema additionalItems) {
        this.additionalItems = additionalItems;
    }
    /**
     * Sets the schema for additional items in the array and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for additional items and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param additionalItems the schema for additional items to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema additionalItems(Schema additionalItems) {
        this.additionalItems = additionalItems;
        return this;
    }

    /**
     * Gets the schema that defines unevaluated items that can be present in the array defined by this schema.
     * <p>
     * This method returns the schema for any unevaluated items allowed in the array.
     * If no unevaluated items are specified, this will return {@code null}.
     * </p>
     *
     * @return the schema for unevaluated items, or {@code null} if none are defined.
     */
    public Schema getUnevaluatedItems() {
        return unevaluatedItems;
    }
    /**
     * Sets the schema that defines unevaluated items that can be present in the array defined by this schema.
     * <p>
     * This method allows specifying the schema for any unevaluated items allowed in the array.
     * If no unevaluated items are required, this method can be used to set it as {@code null}.
     * </p>
     *
     * @param unevaluatedItems the schema for unevaluated items.
     * @since 1.0
     */
    public void setUnevaluatedItems(Schema unevaluatedItems) {
        this.unevaluatedItems = unevaluatedItems;
    }
    /**
     * Sets the schema for unevaluated items in the array and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for unevaluated items and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param unevaluatedItems the schema for unevaluated items to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema unevaluatedItems(Schema unevaluatedItems) {
        this.unevaluatedItems = unevaluatedItems;
        return this;
    }

    /**
     * Gets the schema that defines the condition for the "if" clause in the schema validation.
     * <p>
     * This method returns the schema representing the condition that must be satisfied for the "if" clause.
     * If no "if" condition is defined, this will return {@code null}.
     * </p>
     *
     * @return the schema for the "if" clause condition, or {@code null} if none is defined.
     */
    public Schema getIf() {
        return _if;
    }
    /**
     * Sets the schema that defines the condition for the "if" clause in the schema validation.
     * <p>
     * This method allows specifying the schema for the condition that must be satisfied for the "if" clause.
     * If no condition is required, this method can be used to set it as {@code null}.
     * </p>
     *
     * @param _if the schema for the "if" clause condition.
     */
    public void setIf(Schema _if) {
        this._if = _if;
    }
    /**
     * Sets the schema for the "if" clause condition and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for the "if" clause condition and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param _if the schema for the "if" clause condition to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema _if(Schema _if) {
        this._if = _if;
        return this;
    }

    /**
     * Gets the schema that defines the condition for the "else" clause in the schema validation.
     * <p>
     * This method returns the schema representing the condition that must be satisfied for the "else" clause.
     * If no "else" condition is defined, this will return {@code null}.
     * </p>
     *
     * @return the schema for the "else" clause condition, or {@code null} if none is defined.
     */
    public Schema getElse() {
        return _else;
    }
    /**
     * Sets the schema that defines the condition for the "else" clause in the schema validation.
     * <p>
     * This method allows specifying the schema for the condition that must be satisfied for the "else" clause.
     * If no condition is required, this method can be used to set it as {@code null}.
     * </p>
     *
     * @param _else the schema for the "else" clause condition.
     */
    public void setElse(Schema _else) {
        this._else = _else;
    }
    /**
     * Sets the schema for the "else" clause condition and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for the "else" clause condition and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param _else the schema for the "else" clause condition to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema _else(Schema _else) {
        this._else = _else;
        return this;
    }

    /**
     * Gets the schema that defines the condition for the "then" clause in the schema validation.
     * <p>
     * This method returns the schema representing the condition that must be satisfied for the "then" clause.
     * If no "then" condition is defined, this will return {@code null}.
     * </p>
     *
     * @return the schema for the "then" clause condition, or {@code null} if none is defined.
     */
    public Schema getThen() {
        return then;
    }
    /**
     * Sets the schema that defines the condition for the "then" clause in the schema validation.
     * <p>
     * This method allows specifying the schema for the condition that must be satisfied for the "then" clause.
     * If no condition is required, this method can be used to set it as {@code null}.
     * </p>
     *
     * @param then the schema for the "then" clause condition.
     */
    public void setThen(Schema then) {
        this.then = then;
    }
    /**
     * Sets the schema for the "then" clause condition and returns the current schema instance for method chaining.
     * <p>
     * This method sets the schema for the "then" clause condition and supports method chaining,
     * enabling a more fluent configuration of the schema.
     * </p>
     *
     * @param then the schema for the "then" clause condition to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema then(Schema then) {
        this.then = then;
        return this;
    }

    /**
     * Gets the map of dependent schemas for this schema.
     * <p>
     * This method returns a map where the key is the name of the dependent schema, and the value is the {@link Schema}
     * object that defines the dependent schema for this schema.
     * </p>
     *
     * @return a map of dependent schemas, or {@code null} if no dependent schemas are defined.
     */
    public Map<String, Schema> getDependentSchemas() {
        return dependentSchemas;
    }
    /**
     * Sets the map of dependent schemas for this schema.
     * <p>
     * This method allows setting a map of dependent schemas where the key is the name of the dependent schema, and
     * the value is the {@link Schema} object representing the dependent schema.
     * </p>
     *
     * @param dependentSchemas a map of dependent schemas to set.
     */
    public void setDependentSchemas(Map<String, Schema> dependentSchemas) {
        this.dependentSchemas = dependentSchemas;
    }
    /**
     * Sets the map of dependent schemas and returns the current schema instance for method chaining.
     * <p>
     * This method sets the dependent schemas and supports method chaining, allowing for more fluent configuration of the schema.
     * </p>
     *
     * @param dependentSchemas a map of dependent schemas to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema dependentSchemas(Map<String, Schema> dependentSchemas) {
        this.dependentSchemas = dependentSchemas;
        return this;
    }

    /**
     * Gets the map of required properties for the dependent schemas.
     * <p>
     * This method returns a map where the key is the name of the dependent schema, and the value is a list of required
     * properties for that schema. Each entry represents a dependent schema's required properties.
     * </p>
     *
     * @return a map of required properties for dependent schemas, or {@code null} if no dependent required properties are defined.
     */
    public Map<String, List<String>> getDependentRequired() {
        return dependentRequired;
    }
    /**
     * Sets the map of required properties for the dependent schemas.
     * <p>
     * This method allows setting a map of required properties for dependent schemas, where the key is the name of the
     * dependent schema, and the value is a list of required properties for that schema.
     * </p>
     *
     * @param dependentRequired a map of required properties for dependent schemas to set.
     */
    public void setDependentRequired(Map<String, List<String>> dependentRequired) {
        this.dependentRequired = dependentRequired;
    }
    /**
     * Sets the map of required properties for the dependent schemas and returns the current schema instance for method chaining.
     * <p>
     * This method sets the dependent required properties and supports method chaining, allowing for more fluent configuration of the schema.
     * </p>
     *
     * @param dependentRequired a map of required properties for dependent schemas to set.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema dependentRequired(Map<String, List<String>> dependentRequired) {
        this.dependentRequired = dependentRequired;
        return this;
    }

    /**
     * Gets the comment associated with the schema.
     * <p>
     * This method returns the comment for the schema, which can provide additional information about the schema's use
     * or context.
     * </p>
     *
     * @return the comment for the schema, or {@code null} if no comment is set.
     */
    public String get$comment() {
        return $comment;
    }
    /**
     * Sets the comment for the schema.
     * <p>
     * This method allows setting a comment for the schema, which can be used to provide additional information
     * or documentation about the schema.
     * </p>
     *
     * @param $comment the comment to set for the schema.
     */
    public void set$comment(String $comment) {
        this.$comment = $comment;
    }
    /**
     * Sets the comment for the schema and returns the current schema instance for method chaining.
     * <p>
     * This method sets the comment and supports method chaining, allowing for a more fluent configuration of the schema.
     * </p>
     *
     * @param $comment the comment to set for the schema.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema $comment(String $comment) {
        this.$comment = $comment;
        return this;
    }

    /**
     * Gets the list of examples for the schema.
     * <p>
     * This method returns the examples associated with the schema, which can be used to provide sample data or
     * illustrate how values conforming to the schema should look.
     * </p>
     *
     * @return a list of examples for the schema, or {@code null} if no examples are set.
     */
    public List<T> getExamples() {
        return examples;
    }
    /**
     * Sets the list of examples for the schema.
     * <p>
     * This method allows setting the list of examples associated with the schema. Examples can help demonstrate
     * how values that conform to the schema would appear.
     * </p>
     *
     * @param examples the list of examples to set for the schema.
     */
    public void setExamples(List<T> examples) {
        this.examples = examples;
    }
    /**
     * Sets the list of examples for the schema and returns the current schema instance for method chaining.
     * <p>
     * This method sets the list of examples and supports method chaining, enabling a more fluent configuration
     * of the schema with examples.
     * </p>
     *
     * @param examples the list of examples to set for the schema.
     * @return the current {@link Schema} instance for method chaining.
     */
    public Schema<T> examples(List<T> examples) {
        this.examples = examples;
        return this;
    }
    /**
     * Adds a single example to the list of examples for the schema.
     * <p>
     * This method adds a single example to the existing list of examples. If no examples are set yet, it will
     * initialize the list.
     * </p>
     *
     * @param example the example to add to the list of examples for the schema.
     */
    public void addExample(T example) {
        if (this.examples == null)
            this.examples = new ArrayList<>();
        this.examples.add(example);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Schema<?> schema = (Schema<?>) object;
        return Objects.equals(_default, schema._default) &&
               Objects.equals(name, schema.name) &&
               Objects.equals(title, schema.title) &&
               Objects.equals(multipleOf, schema.multipleOf) &&
               Objects.equals(maximum, schema.maximum) &&
               Objects.equals(exclusiveMaximum, schema.exclusiveMaximum) &&
               Objects.equals(minimum, schema.minimum) &&
               Objects.equals(exclusiveMinimum, schema.exclusiveMinimum) &&
               Objects.equals(maxLength, schema.maxLength) &&
               Objects.equals(minLength, schema.minLength) &&
               Objects.equals(pattern, schema.pattern) &&
               Objects.equals(maxItems, schema.maxItems) &&
               Objects.equals(minItems, schema.minItems) &&
               Objects.equals(uniqueItems, schema.uniqueItems) &&
               Objects.equals(maxProperties, schema.maxProperties) &&
               Objects.equals(minProperties, schema.minProperties) &&
               Objects.equals(required, schema.required) &&
               Objects.equals(type, schema.type) &&
               Objects.equals(not, schema.not) &&
               Objects.equals(properties, schema.properties) &&
               Objects.equals(additionalProperties, schema.additionalProperties) &&
               Objects.equals(description, schema.description) &&
               Objects.equals(format, schema.format) &&
               Objects.equals($ref, schema.$ref) &&
               Objects.equals(nullable, schema.nullable) &&
               Objects.equals(readOnly, schema.readOnly) &&
               Objects.equals(writeOnly, schema.writeOnly) &&
               Objects.equals(example, schema.example) &&
               Objects.equals(externalDocs, schema.externalDocs) &&
               Objects.equals(deprecated, schema.deprecated) &&
               Objects.equals(xml, schema.xml) &&
               Objects.equals(extensions, schema.extensions) &&
               Objects.equals(_enum, schema._enum) &&
               Objects.equals(discriminator, schema.discriminator) &&
               Objects.equals(types, schema.types) &&
               Objects.equals(patternProperties, schema.patternProperties) &&
               Objects.equals(exclusiveMaximumValue, schema.exclusiveMaximumValue) &&
               Objects.equals(exclusiveMinimumValue, schema.exclusiveMinimumValue) &&
               Objects.equals(contains, schema.contains) &&
               Objects.equals(contentEncoding, schema.contentEncoding) &&
               Objects.equals(contentMediaType, schema.contentMediaType) &&
               Objects.equals(contentSchema, schema.contentSchema) &&
               Objects.equals(propertyNames, schema.propertyNames) &&
               Objects.equals(unevaluatedProperties, schema.unevaluatedProperties) &&
               Objects.equals(maxContains, schema.maxContains) &&
               Objects.equals(minContains, schema.minContains) &&
               Objects.equals(additionalItems, schema.additionalItems) &&
               Objects.equals(unevaluatedItems, schema.unevaluatedItems) &&
               Objects.equals(_if, schema._if) && Objects.equals(_else, schema._else) &&
               Objects.equals(then, schema.then) &&
               Objects.equals(dependentSchemas, schema.dependentSchemas) &&
               Objects.equals(dependentRequired, schema.dependentRequired) &&
               Objects.equals($comment, schema.$comment) &&
               Objects.equals(examples, schema.examples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_default, name, title, multipleOf,
                            maximum, exclusiveMaximum, minimum,
                            exclusiveMinimum, maxLength, minLength,
                            pattern, maxItems, minItems, uniqueItems,
                            maxProperties, minProperties, required, type,
                            not, properties, additionalProperties, description,
                            format, $ref, nullable, readOnly, writeOnly, example,
                            externalDocs, deprecated, xml, extensions, _enum,
                            discriminator, types, patternProperties, exclusiveMaximumValue,
                            exclusiveMinimumValue, contains, contentEncoding, contentMediaType,
                            contentSchema, propertyNames, unevaluatedProperties, maxContains,
                            minContains, additionalItems, unevaluatedItems, _if, _else, then,
                            dependentSchemas, dependentRequired, $comment, examples);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Schema {\n");
        //Object typeStr = specVersion == SpecVersion.V30 ? type : types;
        //sb.append("    type: ").append(toIndentedString(typeStr)).append("\n");
        sb.append("    format: ").append(toIndentedString(format)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    multipleOf: ").append(toIndentedString(multipleOf)).append("\n");
        sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
        //Object exclusiveMaximumStr = specVersion == SpecVersion.V30 ? exclusiveMaximum : exclusiveMaximumValue;
        sb.append("    exclusiveMaximum: ").append(toIndentedString(exclusiveMaximumValue)).append("\n");
        sb.append("    minimum: ").append(toIndentedString(minimum)).append("\n");
        //Object exclusiveMinimumStr = specVersion == SpecVersion.V30 ? exclusiveMinimum : exclusiveMinimumValue;
        sb.append("    exclusiveMinimum: ").append(toIndentedString(exclusiveMinimumValue)).append("\n");
        sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
        sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
        sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
        sb.append("    maxItems: ").append(toIndentedString(maxItems)).append("\n");
        sb.append("    minItems: ").append(toIndentedString(minItems)).append("\n");
        sb.append("    uniqueItems: ").append(toIndentedString(uniqueItems)).append("\n");
        sb.append("    maxProperties: ").append(toIndentedString(maxProperties)).append("\n");
        sb.append("    minProperties: ").append(toIndentedString(minProperties)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    not: ").append(toIndentedString(not)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
        sb.append("    nullable: ").append(toIndentedString(nullable)).append("\n");
        sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
        sb.append("    writeOnly: ").append(toIndentedString(writeOnly)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    externalDocs: ").append(toIndentedString(externalDocs)).append("\n");
        sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
        sb.append("    discriminator: ").append(toIndentedString(discriminator)).append("\n");
        sb.append("    xml: ").append(toIndentedString(xml)).append("\n");
        //if (specVersion == SpecVersion.V31)
        sb.append("    patternProperties: ").append(toIndentedString(patternProperties)).append("\n");
        sb.append("    contains: ").append(toIndentedString(contains)).append("\n");
        //sb.append("    $id: ").append(toIndentedString($id)).append("\n");
        //sb.append("    $anchor: ").append(toIndentedString($anchor)).append("\n");
        //sb.append("    $schema: ").append(toIndentedString($schema)).append("\n");
        //sb.append("    $vocabulary: ").append(toIndentedString($vocabulary)).append("\n");
        //sb.append("    $dynamicAnchor: ").append(toIndentedString($dynamicAnchor)).append("\n");
        //sb.append("    $dynamicRef: ").append(toIndentedString($dynamicRef)).append("\n");
        //sb.append("    const: ").append(toIndentedString(_const)).append("\n");
        sb.append("    contentEncoding: ").append(toIndentedString(contentEncoding)).append("\n");
        sb.append("    contentMediaType: ").append(toIndentedString(contentMediaType)).append("\n");
        sb.append("    contentSchema: ").append(toIndentedString(contentSchema)).append("\n");
        sb.append("    propertyNames: ").append(toIndentedString(propertyNames)).append("\n");
        sb.append("    unevaluatedProperties: ").append(toIndentedString(unevaluatedProperties)).append("\n");
        sb.append("    maxContains: ").append(toIndentedString(maxContains)).append("\n");
        sb.append("    minContains: ").append(toIndentedString(minContains)).append("\n");
        sb.append("    additionalItems: ").append(toIndentedString(additionalItems)).append("\n");
        sb.append("    unevaluatedItems: ").append(toIndentedString(unevaluatedItems)).append("\n");
        sb.append("    _if: ").append(toIndentedString(_if)).append("\n");
        sb.append("    _else: ").append(toIndentedString(_else)).append("\n");
        sb.append("    then: ").append(toIndentedString(then)).append("\n");
        sb.append("    dependentRequired: ").append(toIndentedString(dependentRequired)).append("\n");
        sb.append("    dependentSchemas: ").append(toIndentedString(dependentSchemas)).append("\n");
        sb.append("    $comment: ").append(toIndentedString($comment)).append("\n");
        //sb.append("    prefixItems: ").append(toIndentedString(prefixItems)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}