package io.github.kelari.core.loader;

import io.github.kelari.core.util.HtmlSanitizer;
import io.github.kelari.core.util.MarkdownConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for testing Markdown to HTML conversion and sanitization.
 */
class MarkdownConverterTest {

    private final MarkdownConverter converter = new MarkdownConverter();
    private final HtmlSanitizer sanitizer = new HtmlSanitizer();

    @Test
    void testMarkdownToHtmlConversion() {
        String markdown = "**Hello, World!**";
        String html = converter.toHtml(markdown);

        // Verifica se o conteúdo HTML gerado corresponde ao esperado
        assertTrue(html.contains("<strong>Hello, World!</strong>"));
    }

    @Test
    void testXSSProtectionWithHtmlSanitizer() {
        String unsafeMarkdown = "**<script>alert('XSS')</script>Hello, World!**";
        String unsafeHtml = converter.toHtml(unsafeMarkdown);

        // Sanitiza o HTML para garantir que qualquer tag maliciosa seja removida
        String safeHtml = sanitizer.sanitize(unsafeHtml);

        // Verifica se o código JavaScript foi removido
        assertFalse(safeHtml.contains("<script>"));
        assertTrue(safeHtml.contains("Hello, World!"));
    }

    @Test
    void testEmptyMarkdown() {
        String markdown = "";
        String html = converter.toHtml(markdown);

        // Verifica se a conversão de Markdown vazio retorna uma string vazia
        assertEquals("", html);
    }

    @Test
    void testSanitizeEmptyHtml() {
        String html = "";
        String sanitizedHtml = sanitizer.sanitize(html);

        // Verifica se a sanitização de HTML vazio retorna uma string vazia
        assertEquals("", sanitizedHtml);
    }
}
