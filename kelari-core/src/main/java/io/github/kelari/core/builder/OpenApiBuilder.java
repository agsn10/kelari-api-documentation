package io.github.kelari.core.builder;

import io.github.kelari.model.v3.Components;
import io.github.kelari.model.v3.ExternalDocumentation;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.info.Info;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.servers.Server;
import io.github.kelari.model.v3.security.SecurityRequirement;
import io.github.kelari.model.v3.tags.Tag;

import java.util.*;

/**
 * Builder for constructing OpenAPI root object (OpenAPI spec).
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class OpenApiBuilder {

    private final OpenAPI openApi;

    private final Map<String, PathItem> paths = new LinkedHashMap<>();
    private final List<Server> servers = new ArrayList<>();
    private final List<SecurityRequirement> securityRequirements = new ArrayList<>();
    private final List<Tag> tags = new ArrayList<>();

    public OpenApiBuilder() {
        this.openApi = new OpenAPI();
    }

    public static OpenApiBuilder create() {
        return new OpenApiBuilder();
    }

    public OpenApiBuilder openapiVersion(String version) {
        openApi.setOpenapi(version);
        return this;
    }

    public OpenApiBuilder info(Info info) {
        openApi.setInfo(info);
        return this;
    }

    public OpenApiBuilder server(Server server) {
        this.servers.add(server);
        return this;
    }

    public OpenApiBuilder servers(List<Server> servers) {
        this.servers.addAll(servers);
        return this;
    }

    public OpenApiBuilder path(String path, PathItem item) {
        this.paths.put(path, item);
        return this;
    }

    public OpenApiBuilder paths(Map<String, PathItem> pathMap) {
        this.paths.putAll(pathMap);
        return this;
    }

    public OpenApiBuilder components(Components components) {
        openApi.setComponents(components);
        return this;
    }

    public OpenApiBuilder security(SecurityRequirement securityRequirement) {
        this.securityRequirements.add(securityRequirement);
        return this;
    }

    public OpenApiBuilder tag(Tag tag) {
        this.tags.add(tag);
        return this;
    }

    public OpenApiBuilder externalDocs(ExternalDocumentation docs) {
        openApi.setExternalDocs(docs);
        return this;
    }

    public OpenAPI build() {
        if (!servers.isEmpty()) openApi.setServers(servers);
        if (!paths.isEmpty()) {
            paths.forEach((key, value) ->{
                openApi.getPaths().addPathItem(key, value);
            });
        }
        if (!securityRequirements.isEmpty()) openApi.setSecurity(securityRequirements);
        if (!tags.isEmpty()) openApi.setTags(tags);
        return openApi;
    }
}