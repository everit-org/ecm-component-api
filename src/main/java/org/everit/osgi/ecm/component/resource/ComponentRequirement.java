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

import org.osgi.resource.Capability;
import org.osgi.resource.Requirement;

public interface ComponentRequirement<C extends Capability> extends Requirement {

    Class<C> getAcceptedCapabilityType();

    String getRequirementId();

    @Override
    ComponentRevision getResource();
}
