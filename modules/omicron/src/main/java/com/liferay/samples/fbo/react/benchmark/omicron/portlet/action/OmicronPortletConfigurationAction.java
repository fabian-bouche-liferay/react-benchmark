package com.liferay.samples.fbo.react.benchmark.omicron.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.samples.fbo.react.benchmark.omicron.configuration.OmicronPortletInstanceConfiguration;
import com.liferay.samples.fbo.react.benchmark.omicron.constants.OmicronPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		property = "javax.portlet.name=" + OmicronPortletKeys.OMICRON,
		service = ConfigurationAction.class
	)
public class OmicronPortletConfigurationAction extends DefaultConfigurationAction {
	
	private final static Logger LOG = LoggerFactory.getLogger(OmicronPortletConfigurationAction.class);
	
	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/configuration.jsp";
	}
	
	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		_themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();
		
		_omicronPortletInstanceConfiguration =
				portletDisplay.getPortletInstanceConfiguration(
						OmicronPortletInstanceConfiguration.class);
		
		httpServletRequest.setAttribute(
				"configuration",
				_omicronPortletInstanceConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String foo = ParamUtil.getString(actionRequest, "foo");
		LOG.debug("Setting foo: {}", foo);
		setPreference(actionRequest, "foo", foo);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	@Reference(
			target = "(osgi.web.symbolicname=com.liferay.samples.fbo.react.benchmark.omicron)",
			unbind = "-"
			)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}
	
	private ThemeDisplay _themeDisplay;
	
	private OmicronPortletInstanceConfiguration _omicronPortletInstanceConfiguration;
}