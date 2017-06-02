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

package com.daffo.Form_di_segnalService.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the form_di_segnalazione_service service. This utility wraps {@link com.daffo.Form_di_segnalService.service.persistence.impl.Form_di_segnalazione_servicePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Form_di_segnalazione_servicePersistence
 * @see com.daffo.Form_di_segnalService.service.persistence.impl.Form_di_segnalazione_servicePersistenceImpl
 * @generated
 */
@ProviderType
public class Form_di_segnalazione_serviceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		getPersistence().clearCache(form_di_segnalazione_service);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Form_di_segnalazione_service> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Form_di_segnalazione_service> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Form_di_segnalazione_service> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Form_di_segnalazione_service update(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		return getPersistence().update(form_di_segnalazione_service);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Form_di_segnalazione_service update(
		Form_di_segnalazione_service form_di_segnalazione_service,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(form_di_segnalazione_service, serviceContext);
	}

	/**
	* Returns all the form_di_segnalazione_services where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the form_di_segnalazione_services where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @return the range of matching form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the form_di_segnalazione_services where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the form_di_segnalazione_services where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	*/
	public static Form_di_segnalazione_service findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	*/
	public static Form_di_segnalazione_service fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	*/
	public static Form_di_segnalazione_service findByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	*/
	public static Form_di_segnalazione_service fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the form_di_segnalazione_services before and after the current form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param Form_di_segnalazione_id the primary key of the current form_di_segnalazione_service
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public static Form_di_segnalazione_service[] findByUuid_PrevAndNext(
		long Form_di_segnalazione_id, java.lang.String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(Form_di_segnalazione_id, uuid,
			orderByComparator);
	}

	/**
	* Removes all the form_di_segnalazione_services where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of form_di_segnalazione_services where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching form_di_segnalazione_services
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the form_di_segnalazione_service in the entity cache if it is enabled.
	*
	* @param form_di_segnalazione_service the form_di_segnalazione_service
	*/
	public static void cacheResult(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		getPersistence().cacheResult(form_di_segnalazione_service);
	}

	/**
	* Caches the form_di_segnalazione_services in the entity cache if it is enabled.
	*
	* @param form_di_segnalazione_services the form_di_segnalazione_services
	*/
	public static void cacheResult(
		List<Form_di_segnalazione_service> form_di_segnalazione_services) {
		getPersistence().cacheResult(form_di_segnalazione_services);
	}

	/**
	* Creates a new form_di_segnalazione_service with the primary key. Does not add the form_di_segnalazione_service to the database.
	*
	* @param Form_di_segnalazione_id the primary key for the new form_di_segnalazione_service
	* @return the new form_di_segnalazione_service
	*/
	public static Form_di_segnalazione_service create(
		long Form_di_segnalazione_id) {
		return getPersistence().create(Form_di_segnalazione_id);
	}

	/**
	* Removes the form_di_segnalazione_service with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was removed
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public static Form_di_segnalazione_service remove(
		long Form_di_segnalazione_id)
		throws com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException {
		return getPersistence().remove(Form_di_segnalazione_id);
	}

	public static Form_di_segnalazione_service updateImpl(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		return getPersistence().updateImpl(form_di_segnalazione_service);
	}

	/**
	* Returns the form_di_segnalazione_service with the primary key or throws a {@link NoSuchForm_di_segnalazione_serviceException} if it could not be found.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public static Form_di_segnalazione_service findByPrimaryKey(
		long Form_di_segnalazione_id)
		throws com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException {
		return getPersistence().findByPrimaryKey(Form_di_segnalazione_id);
	}

	/**
	* Returns the form_di_segnalazione_service with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service, or <code>null</code> if a form_di_segnalazione_service with the primary key could not be found
	*/
	public static Form_di_segnalazione_service fetchByPrimaryKey(
		long Form_di_segnalazione_id) {
		return getPersistence().fetchByPrimaryKey(Form_di_segnalazione_id);
	}

	public static java.util.Map<java.io.Serializable, Form_di_segnalazione_service> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the form_di_segnalazione_services.
	*
	* @return the form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the form_di_segnalazione_services.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @return the range of form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the form_di_segnalazione_services.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findAll(int start,
		int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the form_di_segnalazione_services.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of form_di_segnalazione_services
	* @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of form_di_segnalazione_services
	*/
	public static List<Form_di_segnalazione_service> findAll(int start,
		int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the form_di_segnalazione_services from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of form_di_segnalazione_services.
	*
	* @return the number of form_di_segnalazione_services
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Form_di_segnalazione_servicePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Form_di_segnalazione_servicePersistence, Form_di_segnalazione_servicePersistence> _serviceTracker =
		ServiceTrackerFactory.open(Form_di_segnalazione_servicePersistence.class);
}