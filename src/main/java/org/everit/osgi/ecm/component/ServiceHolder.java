/**
 * This file is part of Everit - ECM Component API.
 *
 * Everit - ECM Component API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - ECM Component API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - ECM Component API.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.component;

import java.util.Map;

import org.osgi.framework.ServiceReference;

public class ServiceHolder<S> extends AbstractReferenceHolder<ServiceReference<S>> {

    private final S service;

    public ServiceHolder(String referenceId, ServiceReference<S> reference, S service,
            Map<String, Object> attributes) {
        super(referenceId, reference, attributes);
        this.service = service;
    }

    public S getService() {
        return service;
    }

}