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

import org.omg.PortableInterceptor.ACTIVE;

/**
 * States of the lifecycle of a component instance.
 */
public enum ComponentState {

  /**
   * A component is active when all of the properties of the component are set and the activate
   * method was processed (if there is any) successfully.
   */
  ACTIVE,

  /**
   * A component is in the failed state if any of the setter the activate or the update method
   * throws a runtime exception or a configuration cannot be applyed due to multiplicity or type
   * issues.
   */
  FAILED,

  /**
   * The component will be permanently failed if implementation (or metadata) change is necessary to
   * make it work.
   */
  FAILED_PERMANENT,

  /**
   * The component is not yet initialized or it was removed. It is hard to catch this state as
   * <ul>
   * <li>As soon as the component context is created, initialization starts.</li>
   * <li>As soon as the component context is inactivated, it is removed from the system completely
   * (as this happens when the container is closed).</li>
   * </ul>
   */
  INACTIVE,

  /**
   * The component is instantiated and the setters or the activate method of the component is
   * currently processing.
   */
  STARTING,

  /**
   * The deactivate function of the component is currently running. {@link STOPPING} can be caused
   * due to several reasons:
   * <ul>
   * <li>The component is destroyed as the configuration behind the component is deleted</li>
   * <li>Due to a non-dynamic configuration update, the component has to be restarted. In this case
   * the first step is stopping the component.</li>
   * <li>The component was in {@link STARTING} or {@link ACTIVE} state and there was a failure. In
   * the end of STOPPING, the component will get the {@link #FAILED} or {@linkg #FAILED_PERMANENT}
   * state.</li>
   * <li>The component was {@link ACTIVE} and one of the references became unsatisfied.</li>
   * </ul>
   */
  STOPPING,

  /**
   * The component has unsatisfied references.
   */
  UNSATISFIED,

  /**
   * The component instance is just created and new configuration is applied on it. This component
   * can get this state due to the following reasons:
   * <ul>
   * <li>the component was {@link FAILED} and new configuration arrived</li>
   * <li>the component was {@link UNSATISFIED} and new configuration arrived</li>
   * <li>the component was {@link ACTIVE} but it had to be stopped to apply non-dynamic changes. In
   * this case the component class is re-instantiated.</li>
   * </ul>
   */
  UPDATING_CONFIGURATION
}
