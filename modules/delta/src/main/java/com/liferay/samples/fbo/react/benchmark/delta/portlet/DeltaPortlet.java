package com.liferay.samples.fbo.react.benchmark.delta.portlet;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.react.benchmark.delta.configuration.DeltaPortletInstanceConfiguration;
import com.liferay.samples.fbo.react.benchmark.delta.constants.DeltaPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Fabian-Liferay
 */
@Component(
	immediate = true,
	configurationPid = "com.liferay.samples.fbo.react.benchmark.delta.configuration.DeltaPortletInstanceConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Delta",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DeltaPortletKeys.DELTA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DeltaPortlet extends MVCPortlet {
	
	private final static Logger LOG = LoggerFactory.getLogger(DeltaPortlet.class);

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		DeltaPortletInstanceConfiguration deltaPortletInstanceConfiguration;
		
		try {
			deltaPortletInstanceConfiguration =
					portletDisplay.getPortletInstanceConfiguration(
							DeltaPortletInstanceConfiguration.class);
			
			renderRequest.setAttribute(
					"configuration",
					deltaPortletInstanceConfiguration);
			
		} catch (ConfigurationException e) {
			LOG.error("Failed to get configuration", e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
}