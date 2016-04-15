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
 * The value of the attributes in {@link ComponentContext#getProperties()} have this type in case of
 * password attributes. The programmer should not set an instance of this class as an OSGi service
 * property but a String with a dummy value should be used instead (e.g.: with five stars in it).
 * The parameter setter method of such attribute may have this type or a String type.
 */
public class PasswordHolder implements Comparable<PasswordHolder> {

  public static PasswordHolder valueOf(final String password) {
    return new PasswordHolder(password);
  }

  private final String password;

  public PasswordHolder(final String value) {
    this.password = value;
  }

  @Override
  public int compareTo(final PasswordHolder o) {
    if (o.password != null && this.password != null) {
      return password.compareTo(o.password);
    }
    if (this.password == null && o.password != null) {
      return -1;
    }
    if (this.password != null && o.password == null) {
      return 1;
    }
    return 0;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PasswordHolder other = (PasswordHolder) obj;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "*****";
  }
}
