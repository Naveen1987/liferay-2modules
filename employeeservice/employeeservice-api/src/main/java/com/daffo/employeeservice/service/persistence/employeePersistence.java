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

package com.daffo.employeeservice.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.daffo.employeeservice.exception.NoSuchemployeeException;
import com.daffo.employeeservice.model.employee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.daffo.employeeservice.service.persistence.impl.employeePersistenceImpl
 * @see employeeUtil
 * @generated
 */
@ProviderType
public interface employeePersistence extends BasePersistence<employee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link employeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee
	*/
	public void cacheResult(employee employee);

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees
	*/
	public void cacheResult(java.util.List<employee> employees);

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param eid the primary key for the new employee
	* @return the new employee
	*/
	public employee create(int eid);

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eid the primary key of the employee
	* @return the employee that was removed
	* @throws NoSuchemployeeException if a employee with the primary key could not be found
	*/
	public employee remove(int eid) throws NoSuchemployeeException;

	public employee updateImpl(employee employee);

	/**
	* Returns the employee with the primary key or throws a {@link NoSuchemployeeException} if it could not be found.
	*
	* @param eid the primary key of the employee
	* @return the employee
	* @throws NoSuchemployeeException if a employee with the primary key could not be found
	*/
	public employee findByPrimaryKey(int eid) throws NoSuchemployeeException;

	/**
	* Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eid the primary key of the employee
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	*/
	public employee fetchByPrimaryKey(int eid);

	@Override
	public java.util.Map<java.io.Serializable, employee> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the employees.
	*
	* @return the employees
	*/
	public java.util.List<employee> findAll();

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link employeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	*/
	public java.util.List<employee> findAll(int start, int end);

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link employeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employees
	*/
	public java.util.List<employee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<employee> orderByComparator);

	/**
	* Returns an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link employeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employees
	*/
	public java.util.List<employee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<employee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the employees from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	*/
	public int countAll();
}