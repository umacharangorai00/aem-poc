package com.micron.web.core.solr.services.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.osgi.service.component.annotations.Component;

import com.micron.web.core.solr.helper.PageDetails;
import com.micron.web.core.solr.helper.SolrSearchHelper;
import com.micron.web.core.solr.services.SolrService;
import com.micron.web.core.solr.constants.SolrConstants;
import com.micron.web.core.solr.util.SolrUtil;

@Component(service = SolrService.class, immediate = true)
public class SolrServiceImpl implements SolrService {

    @Override
    public String addDocuments(final List<PageDetails> pageDetail, final SolrSearchHelper solrSearchHelper) {

        try {

            final String solrServer = solrSearchHelper.getSolrConfigurationService().getSolrServerEndPoint();
            final SolrClient solrClient = SolrUtil.getSolrClient(solrServer);
            final String coreName = solrSearchHelper.getSolrCAConfig().collectionName();
            for(PageDetails page : pageDetail) {

                final SolrInputDocument doc = new SolrInputDocument();
                doc.addField(SolrConstants.PAGE_ID, SolrUtil.getPageName(page.getPath()));
                doc.addField(SolrConstants.PAGE_NAME, page.getName());
                doc.addField(SolrConstants.PAGE_TITLE, page.getTitle());
                doc.addField(SolrConstants.PAGE_DESCRIPTION, page.getDescription());
                final UpdateResponse updateResponse = solrClient.add(coreName, doc);

            }
            solrClient.commit(coreName);
            return "Total "+pageDetail.size()+" document added";

        } catch (Exception exception) {

        }
        return "documents could not added to solr";
    }

    /**
     *  Added for test the solr Api
     * @param pageDetail
     * @return
     */
    @Override
    public String testAddDocuments(final List<PageDetails> pageDetail) {
        try {

            final String solrServer = "http://localhost:8983/solr";
            final String coreName = "poc-core";
            final SolrClient solrClient = SolrUtil.getSolrClient(solrServer);

            for(PageDetails page : pageDetail) {

                final SolrInputDocument doc = new SolrInputDocument();
                doc.addField(SolrConstants.PAGE_ID, SolrUtil.getPageName(page.getPath()));
                doc.addField(SolrConstants.PAGE_NAME, page.getName());
                doc.addField(SolrConstants.PAGE_TITLE, page.getTitle());
                doc.addField(SolrConstants.PAGE_DESCRIPTION, page.getDescription());
                final UpdateResponse updateResponse = solrClient.add(coreName, doc);

            }
            solrClient.commit(coreName);
            return "Total "+pageDetail.size()+" document added";

        } catch (Exception exception) {

            exception.printStackTrace();
        }
        return "documents could not added to solr";
    }

}
