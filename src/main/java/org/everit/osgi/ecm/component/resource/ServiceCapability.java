package org.everit.osgi.ecm.component.resource;

import org.osgi.framework.ServiceReference;
import org.osgi.resource.Capability;

public interface ServiceCapability extends Capability {

    ServiceReference<?> getServiceReference();
}
