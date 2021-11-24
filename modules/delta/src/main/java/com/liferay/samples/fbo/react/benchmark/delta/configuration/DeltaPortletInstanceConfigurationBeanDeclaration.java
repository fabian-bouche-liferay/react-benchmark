package com.liferay.samples.fbo.react.benchmark.delta.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationBeanDeclaration.class)
public class DeltaPortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
    
	@Override
	public Class<?> getConfigurationBeanClass() {
		return DeltaPortletInstanceConfiguration.class;
	}
	
}
