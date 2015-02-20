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
package org.everit.osgi.ecm.component.resource;

import java.util.Map;

import org.everit.osgi.linkage.ConfigurableResource;

public interface ComponentRevision<C> extends ConfigurableResource {

    /**
     * The cause of the failure of the component.
     *
     * @return The cause of the failure or {@code null} if the component is not in {@link ComponentState#FAILED} state.
     */
    Throwable getCause();

    ComponentContainer<C> getComponentContainer();

    /**
     * In case of {@link ComponentState#STARTING} or {@link ComponentState#STOPPING} state the method returns the thread
     * that initiatied the state change on the component. This information can be useful if there is a long-running task
     * or a deadlock during the state change.
     *
     * @return The thread that initiated {@link ComponentState#STARTING} or {@link ComponentState#STOPPING} or
     *         {@code null} if the component has a different state.
     */
    Thread getProcessingThread();

    @Override
    Map<String, Object> getProperties();

    ComponentState getState();
}
