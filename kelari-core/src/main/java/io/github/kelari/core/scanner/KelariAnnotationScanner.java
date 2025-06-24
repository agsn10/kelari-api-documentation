package io.github.kelari.core.scanner;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Implementation of {@link AnnotationScanner} that uses the Reflections library
 * to scan the classpath for annotated classes and methods.
 *
 * <p>This scanner is useful for reading annotations from classes and methods
 * without directly depending on specific frameworks like Spring.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class KelariAnnotationScanner implements AnnotationScanner {

    /**
     * Scans the classpath within the provided base package and finds all classes
     * annotated with the specified annotation.
     *
     * @param basePackage     the base package to scan
     * @param annotationClass the annotation type to look for
     * @return a set of classes annotated with {@code annotationClass}
     */
    @Override
    public Set<Class<?>> scan(String basePackage, Class<? extends Annotation> annotationClass) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(basePackage)
                .addScanners(Scanners.TypesAnnotated));
        return reflections.getTypesAnnotatedWith(annotationClass);
    }

    /**
     * Returns all declared methods of the given class.
     *
     * @param clazz the class to inspect
     * @return a list of declared methods
     */
    @Override
    public List<Method> getMethods(Class<?> clazz) {
        return Arrays.asList(clazz.getDeclaredMethods());
    }

    /**
     * Returns all annotations present on the given method.
     *
     * @param method the method to inspect
     * @return a list of annotations found on the method
     */
    @Override
    public List<Annotation> getAnnotations(Method method) {
        return Arrays.asList(method.getAnnotations());
    }

    /**
     * Returns the annotation of the specified type present on the method, or {@code null} if not found.
     *
     * @param method          the method to inspect
     * @param annotationClass the annotation class to look for
     * @param <A>             the annotation type
     * @return the annotation instance if present; {@code null} otherwise
     */
    @Override
    public <A extends Annotation> A getAnnotation(Method method, Class<A> annotationClass) {
        return method.getAnnotation(annotationClass);
    }

    /**
     * Returns a map of methods from the given class that are annotated with the specified annotation.
     * The map keys are the methods and the values are their corresponding annotations.
     *
     * @param clazz           the class to inspect
     * @param annotationClass the annotation type to look for
     * @param <A>             the annotation type
     * @return a map of annotated methods and their annotations
     */
    @Override
    public <A extends Annotation> Map<Method, A> getAnnotatedMethods(Class<?> clazz, Class<A> annotationClass) {
        Map<Method, A> result = new LinkedHashMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            A annotation = method.getAnnotation(annotationClass);
            if (annotation != null)
                result.put(method, annotation);
        }
        return result;
    }
}
