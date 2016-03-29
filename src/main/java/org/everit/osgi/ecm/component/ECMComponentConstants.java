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
  public static final String SERVICE_PROP_COMPONENT_CLASS = "org.everit.osgi.ecm.component.class";

  /**
   * Key for the component ID service property. The property stores the ID of the component that
   * registered the service.
   */
  public static final String SERVICE_PROP_COMPONENT_ID =
      "org.everit.osgi.ecm.component.id";

  private ECMComponentConstants() {
  }
}
