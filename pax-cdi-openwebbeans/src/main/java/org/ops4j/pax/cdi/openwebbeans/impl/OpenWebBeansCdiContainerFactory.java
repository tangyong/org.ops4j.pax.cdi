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
package org.ops4j.pax.cdi.openwebbeans.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.webbeans.context.WebBeansContext;
import org.ops4j.pax.cdi.spi.CdiContainer;
import org.ops4j.pax.cdi.spi.CdiContainerFactory;
import org.osgi.framework.Bundle;

/**
 * {@link CdiContainerFactory} implementation based on Apache OpenWebBeans.
 * 
 * @author Harald Wellmann
 * 
 */
public class OpenWebBeansCdiContainerFactory implements CdiContainerFactory {

    private Bundle ownBundle;
    private Map<Long, CdiContainer> containers = new HashMap<Long, CdiContainer>();
    private Collection<Bundle> extensionBundles;

    public OpenWebBeansCdiContainerFactory(Bundle ownBundle) {
        this.ownBundle = ownBundle;
    }

    @Override
    public String getProviderName() {
        return WebBeansContext.class.getName();
    }

    @Override
    public CdiContainer createContainer(Bundle bundle) {
        OpenWebBeansCdiContainer container = new OpenWebBeansCdiContainer(ownBundle, bundle,
            extensionBundles);
        containers.put(bundle.getBundleId(), container);
        return container;
    }

    @Override
    public CdiContainer getContainer(Bundle bundle) {
        return containers.get(bundle.getBundleId());
    }

    @Override
    public Collection<CdiContainer> getContainers() {
        return Collections.unmodifiableCollection(containers.values());
    }

    @Override
    public void removeContainer(Bundle bundle) {
        containers.remove(bundle.getBundleId());
    }

    @Override
    public void setExtensionBundles(Collection<Bundle> extensionBundles) {
        this.extensionBundles = extensionBundles;
    }

}
