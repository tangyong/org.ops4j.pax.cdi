/*
 * Copyright 2012 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.cdi.api;

import org.osgi.framework.BundleContext;

/**
 * Interface for CDI beans representing a CDI-enabled OSGi bundle.
 * 
 * @author Harald Wellmann
 * 
 */
public interface BeanBundle {

    /**
     * Gets the bundle context of this bean bundle.
     * 
     * @return
     */
    BundleContext getBundleContext();

    /**
     * Sets the bundle context of this bean bundle.
     * <p>
     * DO NOT USE IN APPLICATION CODE.
     * 
     * @param bundleContext
     *            bundle context
     */
    void setBundleContext(BundleContext bundle);
}
