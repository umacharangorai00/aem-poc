package com.micron.web.core.eventhandler.slinglevel;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.observation.ResourceChange;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.micron.web.core.solr.util.PocUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(service = ResourceChangeListener.class, immediate = true,
           property = {
             ResourceChangeListener.CHANGES+"=ADDED",
             ResourceChangeListener.CHANGES+"=REMOVED",
             ResourceChangeListener.CHANGES+"=CHANGED",
             ResourceChangeListener.PATHS+"=/content/micron-web/in/fr/content-page"
           }
)
public class SlingEventHandler implements ResourceChangeListener {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void onChange(final List<ResourceChange> list) {

        list.stream().forEach(resourceChange -> {

            log.info("SlingEventHandler :: Path {} and Type {}", resourceChange.getPath(),resourceChange.getType());

            try (ResourceResolver resourceResolver = PocUtil.newResolver(this.resourceResolverFactory)){

                // Update,add,get properties of a Node -- approach 1
                Session session = resourceResolver.adaptTo(Session.class);
                Node node = session.getNode(resourceChange.getPath());
                node.setProperty("Property is added by", "Uma C Gorai");
                session.save();

                // Update,add,get properties of a Node -- approach 2
                Resource resource = resourceResolver.getResource(resourceChange.getPath());
                String title = resource.getValueMap().get("jcr:title", String.class);
                log.info("Resource title is {}", title);
                ModifiableValueMap modifiableValueMap = resource.adaptTo(ModifiableValueMap.class);
                modifiableValueMap.put("ResourceChangeListener tested by", "Uma");
                resourceResolver.commit();

            } catch (LoginException e) {
                e.printStackTrace();
            } catch (PersistenceException e) {
                e.printStackTrace();
            } catch (ValueFormatException e) {
                e.printStackTrace();
            } catch (VersionException e) {
                e.printStackTrace();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
            } catch (LockException e) {
                e.printStackTrace();
            } catch (RepositoryException e) {
                e.printStackTrace();
            }

        });

    }

}
