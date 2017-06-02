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

import com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException;
import com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the form_di_segnalazione_service service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.daffo.Form_di_segnalService.service.persistence.impl.Form_di_segnalazione_servicePersistenceImpl
 * @see Form_di_segnalazione_serviceUtil
 * @generated
 */
@ProviderType
public interface Form_di_segnalazione_servicePersistence extends BasePersistence<Form_di_segnalazione_service> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Form_di_segnalazione_serviceUtil} to access the form_di_segnalazione_service persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the form_di_segnalazione_services where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching form_di_segnalazione_services
	*/
	public java.util.List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator);

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
	public java.util.List<Form_di_segnalazione_service> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	*/
	public Form_di_segnalazione_service findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException;

	/**
	* Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	*/
	public Form_di_segnalazione_service fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator);

	/**
	* Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	*/
	public Form_di_segnalazione_service findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException;

	/**
	* Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	*/
	public Form_di_segnalazione_service fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator);

	/**
	* Returns the form_di_segnalazione_services before and after the current form_di_segnalazione_service in the ordered set where uuid = &#63;.
	*
	* @param Form_di_segnalazione_id the primary key of the current form_di_segnalazione_service
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public Form_di_segnalazione_service[] findByUuid_PrevAndNext(
		long Form_di_segnalazione_id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException;

	/**
	* Removes all the form_di_segnalazione_services where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of form_di_segnalazione_services where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching form_di_segnalazione_services
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the form_di_segnalazione_service in the entity cache if it is enabled.
	*
	* @param form_di_segnalazione_service the form_di_segnalazione_service
	*/
	public void cacheResult(
		Form_di_segnalazione_service form_di_segnalazione_service);

	/**
	* Caches the form_di_segnalazione_services in the entity cache if it is enabled.
	*
	* @param form_di_segnalazione_services the form_di_segnalazione_services
	*/
	public void cacheResult(
		java.util.List<Form_di_segnalazione_service> form_di_segnalazione_services);

	/**
	* Creates a new form_di_segnalazione_service with the primary key. Does not add the form_di_segnalazione_service to the database.
	*
	* @param Form_di_segnalazione_id the primary key for the new form_di_segnalazione_service
	* @return the new form_di_segnalazione_service
	*/
	public Form_di_segnalazione_service create(long Form_di_segnalazione_id);

	/**
	* Removes the form_di_segnalazione_service with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service that was removed
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public Form_di_segnalazione_service remove(long Form_di_segnalazione_id)
		throws NoSuchForm_di_segnalazione_serviceException;

	public Form_di_segnalazione_service updateImpl(
		Form_di_segnalazione_service form_di_segnalazione_service);

	/**
	* Returns the form_di_segnalazione_service with the primary key or throws a {@link NoSuchForm_di_segnalazione_serviceException} if it could not be found.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service
	* @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	*/
	public Form_di_segnalazione_service findByPrimaryKey(
		long Form_di_segnalazione_id)
		throws NoSuchForm_di_segnalazione_serviceException;

	/**
	* Returns the form_di_segnalazione_service with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	* @return the form_di_segnalazione_service, or <code>null</code> if a form_di_segnalazione_service with the primary key could not be found
	*/
	public Form_di_segnalazione_service fetchByPrimaryKey(
		long Form_di_segnalazione_id);

	@Override
	public java.util.Map<java.io.Serializable, Form_di_segnalazione_service> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the form_di_segnalazione_services.
	*
	* @return the form_di_segnalazione_services
	*/
	public java.util.List<Form_di_segnalazione_service> findAll();

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
	public java.util.List<Form_di_segnalazione_service> findAll(int start,
		int end);

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
	public java.util.List<Form_di_segnalazione_service> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator);

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
	public java.util.List<Form_di_segnalazione_service> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the form_di_segnalazione_services from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of form_di_segnalazione_services.
	*
	* @return the number of form_di_segnalazione_services
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}