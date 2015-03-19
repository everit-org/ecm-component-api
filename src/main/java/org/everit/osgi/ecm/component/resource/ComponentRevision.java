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

import java.util.Map;

import org.everit.osgi.linkage.ConfigurableResource;
import org.everit.osgi.linkage.EmbeddedResource;
import org.osgi.framework.wiring.BundleRevision;

/**
 * A snapshot of the state of a component instance.
 *
 * @param <C>
 *          The type of the component instance.
 */
public interface ComponentRevision<C> extends ConfigurableResource, EmbeddedResource {

  /**
   * The cause of the failure of the component.
   *
   * @return The cause of the failure or {@code null} if the component is not in
   *         {@link ComponentState#FAILED} state.
   */
  Throwable getCause();

  /**
   * The container that this component revision belongs to.
   *
   * @return the container that this component revision belongs to.
   */
  ComponentContainer<C> getComponentContainer();

  @Override
  BundleRevision getDeclaringResource();

  /**
   * In case of {@link ComponentState#STARTING} or {@link ComponentState#STOPPING} state the method
   * returns the thread that initiatied the state change on the component. This information can be
   * useful if there is a long-running task or a deadlock during the state change.
   *
   * @return The thread that initiated {@link ComponentState#STARTING} or
   *         {@link ComponentState#STOPPING} or {@code null} if the component has a different state.
   */
  Thread getProcessingThread();

  /**
   * The configuration properties of the component.
   */
  @Override
  Map<String, Object> getProperties();

  /**
   * The state of the component.
   */
  ComponentState getState();
}
