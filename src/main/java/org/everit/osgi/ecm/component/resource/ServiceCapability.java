package org.everit.osgi.ecm.component.resource;

import org.osgi.framework.ServiceReference;
import org.osgi.resource.Capability;

public interface ServiceCapability extends Capability {

    /**
     * Namespace that is returned if the {@link Capability} is a {@link ServiceCapability}.
     */
    String SERVICE_CAPABILITY_NAMESPACE = "osgi.service";

    /**
     * Two {@link ServiceCapability}s are the same if they hold the same {@link ServiceReference} instance.
     */
    @Override
    boolean equals(Object obj);

    ServiceReference<?> getServiceReference();

    /**
     * Two {@link ServiceCapability}s have the same hashcode if they hold the same {@link ServiceReference} instance.
     */
    @Override
    int hashCode();
}
