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

package com.demo.empservice.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.demo.empservice.service.http.EmployeeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.demo.empservice.service.http.EmployeeServiceSoap
 * @generated
 */
@ProviderType
public class EmployeeSoap implements Serializable {
	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEid(model.getEid());
		soapModel.setEname(model.getEname());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public int getPrimaryKey() {
		return _eid;
	}

	public void setPrimaryKey(int pk) {
		setEid(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public int getEid() {
		return _eid;
	}

	public void setEid(int eid) {
		_eid = eid;
	}

	public String getEname() {
		return _ename;
	}

	public void setEname(String ename) {
		_ename = ename;
	}

	private String _uuid;
	private int _eid;
	private String _ename;
}