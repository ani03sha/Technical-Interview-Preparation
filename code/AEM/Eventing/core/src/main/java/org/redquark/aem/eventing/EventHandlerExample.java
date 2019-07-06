package org.redquark.aem.eventing;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.observation.ResourceChangeListener;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(
		immediate = true, 
		service = EventHandler.class, 
		property = {
				Constants.SERVICE_DESCRIPTION + "= This event handler listens the events on page activation",
				EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",
				EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/CHANGED",
				EventConstants.EVENT_FILTER + "(&" + "(path=/content/we-retail/us/en/*/jcr:content) (|("
						+ SlingConstants.PROPERTY_CHANGED_ATTRIBUTES + "=*jcr:title) " + "(" + ResourceChangeListener.CHANGES
						+ "=*jcr:title)))" 
		})
public class EventHandlerExample implements EventHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handleEvent(Event event) {
		log.info("Event is: {}", event.getTopic());
	}

}
