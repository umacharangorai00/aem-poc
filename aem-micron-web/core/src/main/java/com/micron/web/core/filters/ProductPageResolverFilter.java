package com.micron.web.core.filters;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.servlets.annotations.SlingServletFilter;
import org.apache.sling.servlets.annotations.SlingServletFilterScope;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Filter.class)
@SlingServletFilter(scope = SlingServletFilterScope.COMPONENT,
  extensions = { "html" },
  pattern = "(/.*)*/products/.+",
  methods = { HttpConstants.METHOD_GET },
  resourceTypes = { Resource.RESOURCE_TYPE_NON_EXISTING })
public class ProductPageResolverFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String PRODUCTS = "/products/";
    private static final String CATEGORY_SEPARATOR = "/";
    private static final String PROXY_PAGE_PATH = "/content/micron-web/us/en/products";

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {

        boolean preventDefaultSlingResolution = false;

        try {
            logger.info("Inside ProductPageFilter =======================================");
            final SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;
            final String requestedPath = StringUtils.removeEnd(slingRequest.getResource().getPath(), "/jcr:content");

            if (!StringUtils.contains(requestedPath, PRODUCTS)) {
                return;
            }
            final String pagePathAfterProducts = StringUtils.substringAfter(requestedPath, PRODUCTS);
            final String[] pathArray = pagePathAfterProducts.split(Pattern.quote(CATEGORY_SEPARATOR));
            final String category = pathArray[0];
            final String subCategory = pathArray[1];
            final String product = pathArray[pathArray.length-1];

            request.setAttribute("category", category);
            request.setAttribute("subCategory", subCategory);
            request.setAttribute("product", product);
            final RequestDispatcher requestDispatcher = request.getRequestDispatcher(PROXY_PAGE_PATH);
            if (requestDispatcher != null) {
                requestDispatcher.include(request, response);
                return;
            }

        } catch (final RuntimeException e) {
            logger.error("Error during dispatching the request {}",e.getMessage());
        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
