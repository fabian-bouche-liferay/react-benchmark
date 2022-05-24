package com.liferay.samples.fbo.react.benchmark.omicron.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationBeanDeclaration.class)
public class OmicronPortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    
	@Override
	public Class<?> getConfigurationBeanClass() {
		return OmicronPortletInstanceConfiguration.class;
	}
	
}
