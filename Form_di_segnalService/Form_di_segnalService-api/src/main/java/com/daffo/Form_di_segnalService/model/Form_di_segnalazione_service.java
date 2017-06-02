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

package com.daffo.Form_di_segnalService.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Form_di_segnalazione_service service. Represents a row in the &quot;form_di_segnalazione&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Form_di_segnalazione_serviceModel
 * @see com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceImpl
 * @see com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceModelImpl
 * @generated
 */
@ImplementationClassName("com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceImpl")
@ProviderType
public interface Form_di_segnalazione_service
	extends Form_di_segnalazione_serviceModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Form_di_segnalazione_service, Long> FORM_DI_SEGNALAZIONE_ID_ACCESSOR =
		new Accessor<Form_di_segnalazione_service, Long>() {
			@Override
			public Long get(
				Form_di_segnalazione_service form_di_segnalazione_service) {
				return form_di_segnalazione_service.getForm_di_segnalazione_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Form_di_segnalazione_service> getTypeClass() {
				return Form_di_segnalazione_service.class;
			}
		};
}