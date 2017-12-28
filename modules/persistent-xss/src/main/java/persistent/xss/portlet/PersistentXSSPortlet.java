package persistent.xss.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import persistent.xss.constants.PersistentXSSPortletKeys;

/**
 * @author peter
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=persistent-xss Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PersistentXSSPortletKeys.PersistentXSS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PersistentXSSPortlet extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse response) {
		storePreferences(setMessage(request, ParamUtil.getString(request, "message")));
	}

	private PortletPreferences setMessage(ActionRequest request, String entry){
		PortletPreferences prefs = request.getPreferences();

		String message = ParamUtil.getString(request, "message");

		try {
			prefs.setValue("message", message);
		} catch (ReadOnlyException e) {
			_log.error(e);
		}

		return prefs;
	}

	private void storePreferences(PortletPreferences prefs) {
		try {
			prefs.store();
		} catch (ValidatorException | IOException e) {
			_log.error(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(PersistentXSSPortlet.class.getName());
}