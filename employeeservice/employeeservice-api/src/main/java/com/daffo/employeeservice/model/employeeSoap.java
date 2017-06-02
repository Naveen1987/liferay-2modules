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

package com.daffo.employeeservice.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class employeeSoap implements Serializable {
	public static employeeSoap toSoapModel(employee model) {
		employeeSoap soapModel = new employeeSoap();

		soapModel.setEid(model.getEid());
		soapModel.setEname(model.getEname());

		return soapModel;
	}

	public static employeeSoap[] toSoapModels(employee[] models) {
		employeeSoap[] soapModels = new employeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static employeeSoap[][] toSoapModels(employee[][] models) {
		employeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new employeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new employeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static employeeSoap[] toSoapModels(List<employee> models) {
		List<employeeSoap> soapModels = new ArrayList<employeeSoap>(models.size());

		for (employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new employeeSoap[soapModels.size()]);
	}

	public employeeSoap() {
	}

	public int getPrimaryKey() {
		return _eid;
	}

	public void setPrimaryKey(int pk) {
		setEid(pk);
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

	private int _eid;
	private String _ename;
}