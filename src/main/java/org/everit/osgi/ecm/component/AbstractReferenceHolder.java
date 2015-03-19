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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Abstract class for reference holder implementations. A reference holder is useful normally if the
 * configuration type is the reference is CLAUSE as the holder contains the requirement id and the
 * attributes.
 *
 * @param <R>
 *          The type of the reference.
 */
public abstract class AbstractReferenceHolder<R> {

  private final Map<String, Object> attributes;

  private final R reference;

  private final String referenceId;

  /**
   * Constructor of the abstract reference holder.
   */
  public AbstractReferenceHolder(final String referenceId, final R reference,
      final Map<String, Object> attributes) {
    this.referenceId = referenceId;
    this.reference = reference;
    this.attributes = Collections.unmodifiableMap(new LinkedHashMap<String, Object>(attributes));
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public R getReference() {
    return reference;
  }

  public String getReferenceId() {
    return referenceId;
  }

  @Override
  public String toString() {
    return "AbstractReferenceHolder [referenceId=" + referenceId + ", reference=" + reference
        + ", attributes="
        + attributes + "]";
  }

}
