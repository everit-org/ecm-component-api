/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.ecm.component.resource;

import org.everit.osgi.ecm.metadata.ComponentMetadata;
import org.everit.osgi.linkage.ResourceContainer;
import org.everit.osgi.linkage.WireContainer;
import org.osgi.framework.BundleContext;

/**
 * The component container that holds zero or more active components and manages their lifecycles.
 * The container is accessible as an OSGi service.
 *
 * @param <C>
 *          The type of the components that is managed by this container.
 */
public interface ComponentContainer<C> extends ResourceContainer, WireContainer {

  /**
   * The context of the bundle that started the component container.
   */
  BundleContext getBundleContext();

  /**
   * The metadata of the component that was used during creation. All information about the
   * attributes and the component itself are available in the metadata objects.
   */
  ComponentMetadata getComponentMetadata();

  /**
   * Snapshot about the component states that are managed by this container.
   */
  @Override
  ComponentRevision<C>[] getResources();

}
