package io.github.kelari.core.scanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interface for scanning the classpath and class structures to retrieve annotation metadata.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public interface AnnotationScanner {

    /**
     * Scans the classpath within the provided base package for classes annotated with the specified annotation.
     *
     * @param basePackage     the package to scan
     * @param annotationClass the annotation class to look for
     * @return a set of matching classes
     */
    Set<Class<?>> scan(String basePackage, Class<? extends Annotation> annotationClass);

    /**
     * Retrieves all declared methods of the specified class.
     *
     * @param clazz the class to inspect
     * @return a list of methods
     */
    List<Method> getMethods(Class<?> clazz);

    /**
     * Retrieves all annotations of a given method.
     *
     * @param method the method to inspect
     * @return a list of annotations on the method
     */
    List<Annotation> getAnnotations(Method method);

    /**
     * Retrieves a specific annotation from the given method, if present.
     *
     * @param method          the method to inspect
     * @param annotationClass the annotation class to retrieve
     * @param <A>             the type of the annotation
     * @return the annotation instance, or null if not present
     */
    <A extends Annotation> A getAnnotation(Method method, Class<A> annotationClass);

    /**
     * Retrieves a map of method to specific annotation, if present.
     *
     * @param clazz           the class to inspect
     * @param annotationClass the annotation class to look for on methods
     * @return a map where keys are methods and values are the corresponding annotation (or null if absent)
     */
    <A extends Annotation> Map<Method, A> getAnnotatedMethods(Class<?> clazz, Class<A> annotationClass);
}
