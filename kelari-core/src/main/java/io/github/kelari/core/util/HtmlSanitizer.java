package io.github.kelari.core.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

/**
 * Utility class to sanitize HTML input and prevent XSS vulnerabilities.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class HtmlSanitizer {

    /**
     * Sanitizes HTML content using a relaxed safelist (Markdown-safe).
     *
     * @param unsafeHtml raw HTML string (possibly unsafe)
     * @return cleaned and safe HTML string
     */
    public String sanitize(String unsafeHtml) {
        if (unsafeHtml == null || unsafeHtml.isBlank()) return "";

        return Jsoup.clean(unsafeHtml, "", Safelist.relaxed()
                        .addTags("span", "div") // Add extra tags if needed
                        .addAttributes(":all", "class", "style"),
                new Document.OutputSettings().prettyPrint(false));
    }
}
