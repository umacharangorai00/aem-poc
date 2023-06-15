package com.micron.web.core.solr.services;

import java.util.List;

import com.micron.web.core.solr.helper.PageDetails;

public interface PageService {

    List<PageDetails> getPageDetail(String sitePath);


}
