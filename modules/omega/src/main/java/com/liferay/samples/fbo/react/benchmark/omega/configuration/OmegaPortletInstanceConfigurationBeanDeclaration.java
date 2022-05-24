package com.liferay.samples.fbo.react.benchmark.omega.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationBeanDeclaration.class)
public class OmegaPortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    
	@Override
	public Class<?> getConfigurationBeanClass() {
		return OmegaPortletInstanceConfiguration.class;
	}
	
}
