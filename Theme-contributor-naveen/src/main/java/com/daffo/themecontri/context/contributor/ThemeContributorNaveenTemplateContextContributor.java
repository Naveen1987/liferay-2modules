package com.daffo.themecontri.context.contributor;

import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;
import com.liferay.portal.kernel.servlet.taglib.ui.URLMenuItem;
import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Administrator
 */
@Component(
	immediate = true,
	property = {"type=" + TemplateContextContributor.TYPE_THEME},
	service = TemplateContextContributor.class
)
public class ThemeContributorNaveenTemplateContextContributor
	implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {
		Menu me=new Menu();
		me.setLabel("Me");;
		URLMenuItem m=new URLMenuItem();
		m.setLabel("Go");
		m.setURL("#");
		me.setMenuItems(new ArrayList<MenuItem>(){{add(m);}});
		contextObjects.put("sample_text", "This is some sample text.");
		contextObjects.put("menume",me);
	}

}