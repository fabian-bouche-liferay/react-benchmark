package com.liferay.samples.fbo.react.benchmark.omicron.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "react-benchmark", scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
	)
@Meta.OCD(
	    id = "com.liferay.samples.fbo.react.benchmark.omicron.configuration.OmicronPortletInstanceConfiguration",
	    localization = "content/Language",
	    name = "redirect-filter-configuration-name"
	)
public interface OmicronPortletInstanceConfiguration {

    @Meta.AD(
    		required = false,
    		name = "foo", 
    		deflt = "bar"
    		)
    public String foo();
	
}
