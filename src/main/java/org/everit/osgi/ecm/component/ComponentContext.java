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

import java.util.Dictionary;
import java.util.Map;

import org.everit.osgi.ecm.component.resource.ComponentContainer;
import org.everit.osgi.ecm.component.resource.ComponentRevision;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

/**
 * The context of the component that should be accessible only from within a component.
 *
 * @param <C>
 *          The type of the component class.
 */
public interface ComponentContext<C> {

  /**
   * The bundle context of the bundle that registered the component (normally it is the bundle that
   * contains the component implementation).
   */
  BundleContext getBundleContext();

  /**
   * The container of the component that is registered as an OSGi service and manages the lifecycle
   * of the component instance.
   */
  ComponentContainer<C> getComponentContainer();

  /**
   * A snapshot about the state of the component.
   */
  ComponentRevision<C> getComponentRevision();

  /**
   * Get the service that was registered when the component was opened. The service reference can be
   * used to log messages via {@link LogService}.
   *
   * @return The {@link ServiceReference} that offers the {@link ComponentContainer} and optionally
   *         interfaces.
   */
  ServiceReference<?> getComponentServiceReference();

  /**
   * The type of the component implementation.
   */
  Class<C> getComponentType();

  /**
   * Returns the service instance that was instantiated by this component.
   *
   * @return The instance of the component or <code>null</code> if the component is not in
   *         {@link org.everit.osgi.ecm.component.resource.ComponentState#ACTIVE}.
   */
  C getInstance();

  Map<String, Object> getProperties();

  /**
   * Registers the specified service object with the specified properties under the name of the
   * specified class with the Framework.
   *
   * <p>
   * This method is otherwise identical to {@link #registerService(String, Object, Dictionary)} and
   * is provided to return a type safe {@code ServiceRegistration}.
   *
   * @param <S>
   *          Type of Service.
   * @param clazz
   *          The class under whose name the service can be located.
   * @param service
   *          The service object or a {@code ServiceFactory} object.
   * @param properties
   *          The properties for this service.
   * @return A {@code ServiceRegistration} object for use by the bundle registering the service to
   *         update the service's properties or to unregister the service.
   * @throws IllegalStateException
   *           If this BundleContext is no longer valid.
   * @see #registerService(String, Object, Dictionary)
   * @since 1.6
   */
  <S> ServiceRegistration<S> registerService(Class<S> clazz, S service,
      Dictionary<String, ?> properties);

  /**
   * Registers the specified service object with the specified properties under the specified class
   * name with the Framework.
   *
   * <p>
   * This method is otherwise identical to {@link #registerService(String[], Object, Dictionary)}
   * and is provided as a convenience when {@code service} will only be registered under a single
   * class name. Note that even in this case the value of the service's
   * {@link org.osgi.framework.Constants#OBJECTCLASS} property will be an array of string, rather
   * than just a single string.
   *
   * @param clazz
   *          The class name under which the service can be located.
   * @param service
   *          The service object or a {@code ServiceFactory} object.
   * @param properties
   *          The properties for this service.
   * @return A {@code ServiceRegistration} object for use by the bundle registering the service to
   *         update the service's properties or to unregister the service.
   * @throws IllegalStateException
   *           If this BundleContext is no longer valid.
   * @see #registerService(String[], Object, Dictionary)
   */
  ServiceRegistration<?> registerService(String clazz, Object service,
      Dictionary<String, ?> properties);

  /**
   * Registers the specified service object with the specified properties under the specified class
   * names into the Framework. A {@code ServiceRegistration} object is returned. The
   * {@code ServiceRegistration} object is for the private use of the bundle registering the service
   * and should not be shared with other bundles. The registering bundle is defined to be the
   * context bundle. Other bundles can locate the service by using one of the
   * {@link #getServiceReferences(Class, String)}, {@link #getServiceReferences(String, String)},
   * {@link #getServiceReference(Class)} or {@link #getServiceReference(String)} methods.
   *
   * <p>
   * A bundle can register a service object that implements the
   * {@link org.osgi.framework.ServiceFactory} interface to have more flexibility in providing
   * service objects to other bundles.
   *
   * <p>
   * The following steps are required to register a service:
   * <ol>
   * <li>If {@code service} is not a {@code ServiceFactory}, an {@code IllegalArgumentException} is
   * thrown if {@code service} is not an {@code instanceof} all the specified class names.
   * <li>The Framework adds the following service properties to the service properties from the
   * specified {@code Dictionary} (which may be {@code null}): <br/>
   * A property named {@link org.osgi.framework.Constants#SERVICE_ID} identifying the registration
   * number of the service <br/>
   * A property named {@link org.osgi.framework.Constants#OBJECTCLASS} containing all the specified
   * classes. <br/>
   * Properties with these names in the specified {@code Dictionary} will be ignored.
   * <li>The service is added to the Framework service registry and may now be used by other
   * bundles.
   * <li>A service event of type {@link org.osgi.framework.ServiceEvent#REGISTERED} is fired.
   * <li>A {@code ServiceRegistration} object for this registration is returned.
   * </ol>
   *
   * @param clazzes
   *          The class names under which the service can be located. The class names in this array
   *          will be stored in the service's properties under the key
   *          {@link org.osgi.framework.Constants#OBJECTCLASS} .
   * @param service
   *          The service object or a {@code ServiceFactory} object.
   * @param properties
   *          The properties for this service. The keys in the properties object must all be
   *          {@code String} objects. See {@link org.osgi.framework.Constants} for a list of
   *          standard service property keys. Changes should not be made to this object after
   *          calling this method. To update the service's properties the
   *          {@link ServiceRegistration#setProperties(Dictionary)} method must be called. The set
   *          of properties may be {@code null} if the service has no properties.
   * @return A {@code ServiceRegistration} object for use by the bundle registering the service to
   *         update the service's properties or to unregister the service.
   * @throws IllegalArgumentException
   *           If one of the following is true:
   *           <ul>
   *           <li>{@code service} is {@code null}. <li>{@code service} is not a
   *           {@code ServiceFactory} object and is not an instance of all the named classes in
   *           {@code clazzes}. <li> {@code properties} contains case variants of the same key name.
   *           </ul>
   * @throws SecurityException
   *           If the caller does not have the {@code ServicePermission} to register the service for
   *           all the named classes and the Java Runtime Environment supports permissions.
   * @throws IllegalStateException
   *           If this BundleContext is no longer valid.
   * @see ServiceRegistration
   * @see org.osgi.framework.ServiceFactory
   */
  ServiceRegistration<?> registerService(String[] clazzes, Object service,
      Dictionary<String, ?> properties);

}
