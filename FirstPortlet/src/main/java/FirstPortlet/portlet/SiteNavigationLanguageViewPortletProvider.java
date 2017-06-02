package FirstPortlet.portlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.portal.kernel.servlet.taglib.ui.BreadcrumbEntry"
	},
	service = ViewPortletProvider.class
)
public class SiteNavigationLanguageViewPortletProvider
	extends BasePortletProvider implements ViewPortletProvider {

	@Override
	public String getPortletName() {
		return "First Portlet";
	}

	@Override
	public PortletURL getPortletURL(HttpServletRequest request, Group group)
		throws PortalException {

		return PortletURLFactoryUtil.create(
			request, getPortletName(),null, PortletRequest.RENDER_PHASE);
	}

	/**
	 * @deprecated As of 2.1.0
	 */
	@Deprecated
	@Override
	protected long getPlid(ThemeDisplay themeDisplay) throws PortalException {
		return themeDisplay.getPlid();
	}

}