package com.micron.web.core.solr.helper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.json.JSONArray;

import com.micron.web.core.solr.config.SolrCAConfig;
import com.micron.web.core.solr.services.PageService;
import com.micron.web.core.solr.services.SolrConfigurationService;
import com.micron.web.core.solr.services.SolrService;
import com.micron.web.core.solr.services.SolrServiceManager;
import com.micron.web.core.solr.util.PocUtil;

import lombok.Getter;

public class SolrSearchHelper {

    @Getter
    private SolrCAConfig solrCAConfig;

    @Getter
    private SolrConfigurationService solrConfigurationService;

    @Getter
    private SolrServiceManager solrServiceManager;

    @Getter
    private SlingHttpServletRequest request;

    @Getter
    private SlingHttpServletResponse response;

    @Getter
    private String sitePath;

    public SolrSearchHelper(SlingHttpServletRequest request,
                            SlingHttpServletResponse response,
                            SolrServiceManager solrServiceManager) {
        this.request = request;
        this.response = response;
        this.solrServiceManager = solrServiceManager;
        this.sitePath = this.request.getParameter("sitePath");
        this.solrCAConfig = PocUtil.getContextAwareConfig(this.sitePath, this.request.getResourceResolver(), SolrCAConfig.class);

    }

    public SolrSearchHelper(String sitePath, SolrServiceManager solrServiceManager, ResourceResolver resourceResolver) {

        this.solrServiceManager = solrServiceManager;
        this.sitePath = sitePath;
        this.solrCAConfig = PocUtil.getContextAwareConfig(sitePath, resourceResolver, SolrCAConfig.class);
    }

    public SolrSearchHelper(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        this.request = request;
        this.response = response;

    }

    public void searchSolr(PageService pageService, SolrService solrService) {

        JSONArray parseArray = new JSONArray();
        try{

            final ResourceResolver resourceResolver = this.request.getResourceResolver();
            this.solrConfigurationService = this.solrServiceManager.getServiceConfiguration(this.solrCAConfig.siteId());
            String searchOperation = this.request.getParameter("searchOperation");
            if (StringUtils.equalsIgnoreCase(searchOperation, "index")) {
                List<PageDetails> pageDetail = pageService.getPageDetail(this.sitePath);
                String documentAdded = solrService.addDocuments(pageDetail, this);
                response.getWriter().write(documentAdded);

            } else if (StringUtils.equalsIgnoreCase(searchOperation, "delete")) {

            } else {

            }

        } catch (Exception exception) {

        }

    }


    // Added for test the solr api
    public void indexData(final PageService pageService, final SolrService solrService) {

        try{
            List<PageDetails> pageDetail = pageService.getPageDetail("/content/micron-web/in/en");
            String documentAdded = solrService.testAddDocuments(pageDetail);
            response.getWriter().write(documentAdded);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}