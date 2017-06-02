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

package com.daffo.Form_di_segnalService.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Form_di_segnalazione_serviceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Form_di_segnalazione_serviceLocalService
 * @generated
 */
@ProviderType
public class Form_di_segnalazione_serviceLocalServiceWrapper
	implements Form_di_segnalazione_serviceLocalService,
		ServiceWrapper<Form_di_segnalazione_serviceLocalService> {
	public Form_di_segnalazione_serviceLocalServiceWrapper(
		Form_di_segnalazione_serviceLocalService form_di_segnalazione_serviceLocalService) {
		_form_di_segnalazione_serviceLocalService = form_di_segnalazione_serviceLocalService;
	}

	/**
	* Adds the form_di_segnalazione_service to the database. Also notifies the appropriate model listeners.
	*
	* @param form_di_segnalazione_service the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was added
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service addForm_di_segnalazione_service(
		com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service form_di_segnalazione_service) {
		return _form_di_segnalazione_serviceLocalService.addForm_di_segnalazione_service(form_di_segnalazione_service);
	}

	/**
	* Creates a new form_di_segnalazione_service with the primary key. Does not add the form_di_segnalazione_service to the database.
	*
	* @param Form_di_segnalazione_id the primary key for the new form_di_segnalazione_service
	* @return the new form_di_segnalazione_service
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service createForm_di_segnalazione_service(
		long Form_di_segnalazione_id) {
		return _form_di_segnalazione_serviceLocalService.createForm_di_segnalazione_service(Form_di_segnalazione_id);
	}

	/**
	* Deletes the form_di_segnalazione_service from the database. Also notifies the appropriate model listeners.
	*
	* @param form_di_segnalazione_service the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was removed
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service deleteForm_di_segnalazione_service(
		com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service form_di_segnalazione_service) {
		return _form_di_segnalazione_serviceLocalService.deleteForm_di_segnalazione_service(form_di_segnalazione_service);
	}

	/**
	* Deletes the form_di_segnalazione_service with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was removed
	* @throws PortalException if a form_di_segnalazione_service with the primary key could not be found
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service deleteForm_di_segnalazione_service(
		long Form_di_segnalazione_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _form_di_segnalazione_serviceLocalService.deleteForm_di_segnalazione_service(Form_di_segnalazione_id);
	}

	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service fetchForm_di_segnalazione_service(
		long Form_di_segnalazione_id) {
		return _form_di_segnalazione_serviceLocalService.fetchForm_di_segnalazione_service(Form_di_segnalazione_id);
	}

	/**
	* Returns the form_di_segnalazione_service with the primary key.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service
	* @throws PortalException if a form_di_segnalazione_service with the primary key could not be found
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service getForm_di_segnalazione_service(
		long Form_di_segnalazione_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _form_di_segnalazione_serviceLocalService.getForm_di_segnalazione_service(Form_di_segnalazione_id);
	}

	/**
	* Updates the form_di_segnalazione_service in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param form_di_segnalazione_service the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was updated
	*/
	@Override
	public com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service updateForm_di_segnalazione_service(
		com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service form_di_segnalazione_service) {
		return _form_di_segnalazione_serviceLocalService.updateForm_di_segnalazione_service(form_di_segnalazione_service);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _form_di_segnalazione_serviceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _form_di_segnalazione_serviceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _form_di_segnalazione_serviceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _form_di_segnalazione_serviceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _form_di_segnalazione_serviceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of form_di_segnalazione_services.
	*
	* @return the number of form_di_segnalazione_services
	*/
	@Override
	public int getForm_di_segnalazione_servicesCount() {
		return _form_di_segnalazione_serviceLocalService.getForm_di_segnalazione_servicesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _form_di_segnalazione_serviceLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _form_di_segnalazione_serviceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _form_di_segnalazione_serviceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _form_di_segnalazione_serviceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the form_di_segnalazione_services.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @return the range of form_di_segnalazione_services
	*/
	@Override
	public java.util.List<com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service> getForm_di_segnalazione_services(
		int start, int end) {
		return _form_di_segnalazione_serviceLocalService.getForm_di_segnalazione_services(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _form_di_segnalazione_serviceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _form_di_segnalazione_serviceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Form_di_segnalazione_serviceLocalService getWrappedService() {
		return _form_di_segnalazione_serviceLocalService;
	}

	@Override
	public void setWrappedService(
		Form_di_segnalazione_serviceLocalService form_di_segnalazione_serviceLocalService) {
		_form_di_segnalazione_serviceLocalService = form_di_segnalazione_serviceLocalService;
	}

	private Form_di_segnalazione_serviceLocalService _form_di_segnalazione_serviceLocalService;
}