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
   * throws a runtime exception. Deactivate method will not be called if the component fails during
   * calling setters, activate or update method.
   */
  FAILED,

  /**
   * The component will be permanently failed if implementation change is necessary to make it work.
   */
  FAILED_PERMANENT,

  /**
   * The activate method of the component is currently processing.
   */
  STARTING,

  /**
   * The component is stopped. This state cannot really be coughed as the component instance is
   * deleted as soon as it is in the STOPPED state.
   */
  STOPPED,

  /**
   * The deactivate function of the component is currently running.
   */
  STOPPING,

  /**
   * The component has unsatisfied references.
   */
  UNSATISFIED,

  /**
   * The component gets the UPDATE_CONFIGURATION state if the component has not been ACTIVE and new
   * configuration arrived, or the component was active but it had to be stopped to apply
   * non-dynamic changes.
   */
  UPDATING_CONFIGURATION
}
