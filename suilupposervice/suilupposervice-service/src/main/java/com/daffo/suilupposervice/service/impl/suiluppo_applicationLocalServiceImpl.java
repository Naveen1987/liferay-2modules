/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.daffo.suilupposervice.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.daffo.suilupposervice.model.suiluppo_application;
import com.daffo.suilupposervice.model.suiluppo_equip_allocation;
import com.daffo.suilupposervice.service.base.suiluppo_applicationLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;

/**
 * The implementation of the suiluppo_application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.daffo.suilupposervice.service.suiluppo_applicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see suiluppo_applicationLocalServiceBaseImpl
 * @see com.daffo.suilupposervice.service.suiluppo_applicationLocalServiceUtil
 */
@ProviderType
public class suiluppo_applicationLocalServiceImpl
	extends suiluppo_applicationLocalServiceBaseImpl {
	@Override
	public List<suiluppo_application> findBycourse_id(long course_id) {
		return this.suiluppo_applicationPersistence.findBycourse_id(course_id);
	}
}