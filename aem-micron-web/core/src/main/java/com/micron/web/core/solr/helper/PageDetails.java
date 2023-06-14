package com.micron.web.core.solr.helper;

import lombok.Data;

@Data
public class PageDetails {

    private String title;

    private String name;

    private String description;

    private String path;

    public PageDetails(String title, String name, String description, String path) {

        this.title = title;
        this.name = name;
        this.description = description;
        this.path = path;

    }
}
