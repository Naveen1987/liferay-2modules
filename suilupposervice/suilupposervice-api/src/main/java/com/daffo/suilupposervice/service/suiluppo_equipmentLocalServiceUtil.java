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

package com.daffo.suilupposervice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for suiluppo_equipment. This utility wraps
 * {@link com.daffo.suilupposervice.service.impl.suiluppo_equipmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Naveen
 * @see suiluppo_equipmentLocalService
 * @see com.daffo.suilupposervice.service.base.suiluppo_equipmentLocalServiceBaseImpl
 * @see com.daffo.suilupposervice.service.impl.suiluppo_equipmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class suiluppo_equipmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.daffo.suilupposervice.service.impl.suiluppo_equipmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the suiluppo_equipment to the database. Also notifies the appropriate model listeners.
	*
	* @param suiluppo_equipment the suiluppo_equipment
	* @return the suiluppo_equipment that was added
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment addsuiluppo_equipment(
		com.daffo.suilupposervice.model.suiluppo_equipment suiluppo_equipment) {
		return getService().addsuiluppo_equipment(suiluppo_equipment);
	}

	/**
	* Creates a new suiluppo_equipment with the primary key. Does not add the suiluppo_equipment to the database.
	*
	* @param equip_id the primary key for the new suiluppo_equipment
	* @return the new suiluppo_equipment
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment createsuiluppo_equipment(
		long equip_id) {
		return getService().createsuiluppo_equipment(equip_id);
	}

	/**
	* Deletes the suiluppo_equipment from the database. Also notifies the appropriate model listeners.
	*
	* @param suiluppo_equipment the suiluppo_equipment
	* @return the suiluppo_equipment that was removed
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment deletesuiluppo_equipment(
		com.daffo.suilupposervice.model.suiluppo_equipment suiluppo_equipment) {
		return getService().deletesuiluppo_equipment(suiluppo_equipment);
	}

	/**
	* Deletes the suiluppo_equipment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param equip_id the primary key of the suiluppo_equipment
	* @return the suiluppo_equipment that was removed
	* @throws PortalException if a suiluppo_equipment with the primary key could not be found
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment deletesuiluppo_equipment(
		long equip_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletesuiluppo_equipment(equip_id);
	}

	public static com.daffo.suilupposervice.model.suiluppo_equipment fetchsuiluppo_equipment(
		long equip_id) {
		return getService().fetchsuiluppo_equipment(equip_id);
	}

	/**
	* Returns the suiluppo_equipment with the primary key.
	*
	* @param equip_id the primary key of the suiluppo_equipment
	* @return the suiluppo_equipment
	* @throws PortalException if a suiluppo_equipment with the primary key could not be found
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment getsuiluppo_equipment(
		long equip_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getsuiluppo_equipment(equip_id);
	}

	/**
	* Updates the suiluppo_equipment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param suiluppo_equipment the suiluppo_equipment
	* @return the suiluppo_equipment that was updated
	*/
	public static com.daffo.suilupposervice.model.suiluppo_equipment updatesuiluppo_equipment(
		com.daffo.suilupposervice.model.suiluppo_equipment suiluppo_equipment) {
		return getService().updatesuiluppo_equipment(suiluppo_equipment);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of suiluppo_equipments.
	*
	* @return the number of suiluppo_equipments
	*/
	public static int getsuiluppo_equipmentsCount() {
		return getService().getsuiluppo_equipmentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.suilupposervice.model.impl.suiluppo_equipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.suilupposervice.model.impl.suiluppo_equipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the suiluppo_equipments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.daffo.suilupposervice.model.impl.suiluppo_equipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of suiluppo_equipments
	* @param end the upper bound of the range of suiluppo_equipments (not inclusive)
	* @return the range of suiluppo_equipments
	*/
	public static java.util.List<com.daffo.suilupposervice.model.suiluppo_equipment> getsuiluppo_equipments(
		int start, int end) {
		return getService().getsuiluppo_equipments(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static suiluppo_equipmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<suiluppo_equipmentLocalService, suiluppo_equipmentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(suiluppo_equipmentLocalService.class);
}