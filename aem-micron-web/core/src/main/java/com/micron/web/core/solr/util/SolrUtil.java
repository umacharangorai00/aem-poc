package com.micron.web.core.solr.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrUtil {

    private static int socketTimeOut = 6000;

    private static int connectionTimeOut = 5000;

    public static SolrClient getSolrClient(String solrUrl) {

        try{
            return new HttpSolrClient.Builder(solrUrl)
                       .withConnectionTimeout(connectionTimeOut)
                       .withSocketTimeout(socketTimeOut)
                       .build();


        }catch (Exception exception) {

        }

        return null;

    }

    public static String getPageName(String Id) {

        return StringUtils.replace(Id, "/", "_");
    }



}
