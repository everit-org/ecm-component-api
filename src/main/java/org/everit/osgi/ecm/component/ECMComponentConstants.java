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
   * Service property of OSGi services registered by ECM Component instances. The value holds the
   * service id of the Component Container that instantiated the Component instance.
   */
  public static final String SERVICE_PROP_COMPONENT_CONTAINER_SERVICE_ID =
      "org.everit.osgi.ecm.component.container.service.id";

  /**
   * Property that is set for the registered ComponentContainer / ManagedService /
   * ManagedServiceFactory OSGi service and for the OSGi services that are registered by components.
   * The type of the service property is String.
   */
  public static final String SERVICE_PROP_COMPONENT_ID = "org.everit.osgi.ecm.component.id";

  /**
   * Property that is set for the registered ComponentContainer / ManagedService /
   * ManagedServiceFactory OSGi service and for the OSGi services that are registered by components.
   * The type of the service property is Version.
   */
  public static final String SERVICE_PROP_COMPONENT_VERSION =
      "org.everit.osgi.ecm.component.version";

  private ECMComponentConstants() {
  }
}
