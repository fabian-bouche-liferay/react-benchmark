package com.liferay.samples.fbo.react.benchmark.omicron.portlet;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.react.benchmark.omicron.configuration.OmicronPortletInstanceConfiguration;
import com.liferay.samples.fbo.react.benchmark.omicron.constants.OmicronPortletKeys;

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
	configurationPid = "com.liferay.samples.fbo.react.benchmark.omicron.configuration.OmicronPortletInstanceConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Omicron",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmicronPortletKeys.OMICRON,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmicronPortlet extends MVCPortlet {
	
	private final static Logger LOG = LoggerFactory.getLogger(OmicronPortlet.class);

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		OmicronPortletInstanceConfiguration omicronPortletInstanceConfiguration;
		
		try {
			omicronPortletInstanceConfiguration =
					portletDisplay.getPortletInstanceConfiguration(
							OmicronPortletInstanceConfiguration.class);
			
			renderRequest.setAttribute(
					"configuration",
					omicronPortletInstanceConfiguration);
			
		} catch (ConfigurationException e) {
			LOG.error("Failed to get configuration", e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
}