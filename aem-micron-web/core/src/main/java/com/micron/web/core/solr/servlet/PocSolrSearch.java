package com.micron.web.core.solr.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.micron.web.core.solr.helper.SolrSearchHelper;
import com.micron.web.core.solr.services.PageService;
import com.micron.web.core.solr.services.SolrService;
import com.micron.web.core.solr.services.SolrServiceManager;

@Component(service = Servlet.class)
@SlingServletPaths({ PocSolrSearch.SERVLET_PATH })
public class PocSolrSearch  extends SlingAllMethodsServlet {

    public static final String SERVLET_PATH = "/poc/solr-search";

    @Reference
    private SolrService solrService;

    @Reference
    private PageService pageService;

    @Reference
    private SolrServiceManager solrServiceManager;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {



        SolrSearchHelper solrSearchHelper = new SolrSearchHelper(request, response, solrServiceManager);

        solrSearchHelper.searchSolr(pageService, solrService);


    }

}
