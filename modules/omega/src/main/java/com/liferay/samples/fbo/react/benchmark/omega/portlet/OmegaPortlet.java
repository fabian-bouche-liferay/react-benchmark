package com.liferay.samples.fbo.react.benchmark.omega.portlet;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.react.benchmark.omega.configuration.OmegaPortletInstanceConfiguration;
import com.liferay.samples.fbo.react.benchmark.omega.constants.OmegaPortletKeys;

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
	configurationPid = "com.liferay.samples.fbo.react.benchmark.omega.configuration.OmegaPortletInstanceConfiguration",
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Omega",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmegaPortletKeys.OMEGA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmegaPortlet extends MVCPortlet {
	
	private final static Logger LOG = LoggerFactory.getLogger(OmegaPortlet.class);

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		OmegaPortletInstanceConfiguration omegaPortletInstanceConfiguration;
		
		try {
			omegaPortletInstanceConfiguration =
					portletDisplay.getPortletInstanceConfiguration(
							OmegaPortletInstanceConfiguration.class);
			
			renderRequest.setAttribute(
					"configuration",
					omegaPortletInstanceConfiguration);
			
		} catch (ConfigurationException e) {
			LOG.error("Failed to get configuration", e);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
}