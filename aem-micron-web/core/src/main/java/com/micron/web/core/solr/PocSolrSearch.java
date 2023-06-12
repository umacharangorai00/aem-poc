package com.micron.web.core.solr;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class)
@SlingServletPaths({ PocSolrSearch.SERVLET_PATH })
public class PocSolrSearch  extends SlingAllMethodsServlet {

    public static final String SERVLET_PATH = "/poc/solr-search";

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        final Resource resource = request.getResource();
        response.setContentType("text/plain");
        response.getWriter().write("Title = Test servlet");
    }

    @Override
    protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
