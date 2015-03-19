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

import java.util.Map;

import org.osgi.framework.wiring.BundleCapability;

/**
 * Holder class for bundle capability references. This type can be used in setters when programmers
 * want to get information about the configured CLAUSE of the references (id, attributes).
 */
public class BundleCapabilityHolder extends AbstractReferenceHolder<BundleCapability> {

  public BundleCapabilityHolder(final String referenceId, final BundleCapability reference,
      final Map<String, Object> attributes) {
    super(referenceId, reference, attributes);
  }

}
