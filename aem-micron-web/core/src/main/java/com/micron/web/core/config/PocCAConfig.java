package com.micron.web.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "POC Context aware configuration", description = "POC Context aware configuration")
public @interface PocCAConfig {

    @Property(label = "POC Country Site", description = "POC Site Name")
    String siteCountry() default "us";

    @Property(label = "POC Site Locale", description = "POC Site for for different languages")
    String siteLocale() default "en";

    @Property(label = "POC Site Admin", description = "Admin for updating country site.")
    String siteAdmin() default "aem-poc";

    @Property(label = "Site Section", description = "Site section for poc site.")
    String siteSection() default "aem";

}
