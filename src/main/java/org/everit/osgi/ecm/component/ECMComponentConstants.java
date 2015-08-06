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
package org.everit.osgi.ecm.component;

/**
 * Constants of ECM Component API.
 */
public final class ECMComponentConstants {

  /**
   * Key for the service property that tells the implementation class of the component when the
   * {@link org.everit.osgi.ecm.component.resource.ComponentContainer} is registered as an OSGi
   * service.
   */
  public static final String SERVICE_PROP_COMPONENT_CLASS = "ecm.component.class";

  /**
   * Service property key for the name of the component (in the Metadata it is the componentId) that
   * is provided as service property of
   * {@link org.everit.osgi.ecm.component.resource.ComponentContainer} OSGi service.
   */
  public static final String SERVICE_PROP_COMPONENT_NAME = "ecm.component.name";

  /**
   * Key for the component ID service property. The property stores the ID of the component that
   * registered the service.
   */
  public static final String SERVICE_PROP_COMPONENT_ID = "ecm.component.id";

  /**
   * Key for the component service PID service property. This property stores the registered service
   * PID.
   */
  public static final String SERVICE_PROP_COMPONENT_SERVICE_PID = "ecm.component.service.pid";

  /**
   * Key for those service property that stores the ID of the component container service that
   * registered the service.
   */
  public static final String SERVICE_PROP_COMPONENT_CONTAINER_SERVICE_ID =
      "ecm.component.container.service.id";

  private ECMComponentConstants() {
  }
}
