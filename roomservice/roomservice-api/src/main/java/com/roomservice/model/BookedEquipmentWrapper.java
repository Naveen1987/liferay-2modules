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

package com.roomservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BookedEquipment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookedEquipment
 * @generated
 */
@ProviderType
public class BookedEquipmentWrapper implements BookedEquipment,
	ModelWrapper<BookedEquipment> {
	public BookedEquipmentWrapper(BookedEquipment bookedEquipment) {
		_bookedEquipment = bookedEquipment;
	}

	@Override
	public Class<?> getModelClass() {
		return BookedEquipment.class;
	}

	@Override
	public String getModelClassName() {
		return BookedEquipment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("booked_equip_id", getBooked_equip_id());
		attributes.put("equip_id", getEquip_id());
		attributes.put("room_id", getRoom_id());
		attributes.put("booked_equip_status", getBooked_equip_status());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long booked_equip_id = (Long)attributes.get("booked_equip_id");

		if (booked_equip_id != null) {
			setBooked_equip_id(booked_equip_id);
		}

		Long equip_id = (Long)attributes.get("equip_id");

		if (equip_id != null) {
			setEquip_id(equip_id);
		}

		Long room_id = (Long)attributes.get("room_id");

		if (room_id != null) {
			setRoom_id(room_id);
		}

		Boolean booked_equip_status = (Boolean)attributes.get(
				"booked_equip_status");

		if (booked_equip_status != null) {
			setBooked_equip_status(booked_equip_status);
		}
	}

	@Override
	public BookedEquipment toEscapedModel() {
		return new BookedEquipmentWrapper(_bookedEquipment.toEscapedModel());
	}

	@Override
	public BookedEquipment toUnescapedModel() {
		return new BookedEquipmentWrapper(_bookedEquipment.toUnescapedModel());
	}

	/**
	* Returns the booked_equip_status of this booked equipment.
	*
	* @return the booked_equip_status of this booked equipment
	*/
	@Override
	public boolean getBooked_equip_status() {
		return _bookedEquipment.getBooked_equip_status();
	}

	/**
	* Returns <code>true</code> if this booked equipment is booked_equip_status.
	*
	* @return <code>true</code> if this booked equipment is booked_equip_status; <code>false</code> otherwise
	*/
	@Override
	public boolean isBooked_equip_status() {
		return _bookedEquipment.isBooked_equip_status();
	}

	@Override
	public boolean isCachedModel() {
		return _bookedEquipment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bookedEquipment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bookedEquipment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bookedEquipment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BookedEquipment> toCacheModel() {
		return _bookedEquipment.toCacheModel();
	}

	@Override
	public int compareTo(BookedEquipment bookedEquipment) {
		return _bookedEquipment.compareTo(bookedEquipment);
	}

	@Override
	public int hashCode() {
		return _bookedEquipment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookedEquipment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BookedEquipmentWrapper((BookedEquipment)_bookedEquipment.clone());
	}

	@Override
	public java.lang.String toString() {
		return _bookedEquipment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bookedEquipment.toXmlString();
	}

	/**
	* Returns the booked_equip_id of this booked equipment.
	*
	* @return the booked_equip_id of this booked equipment
	*/
	@Override
	public long getBooked_equip_id() {
		return _bookedEquipment.getBooked_equip_id();
	}

	/**
	* Returns the equip_id of this booked equipment.
	*
	* @return the equip_id of this booked equipment
	*/
	@Override
	public long getEquip_id() {
		return _bookedEquipment.getEquip_id();
	}

	/**
	* Returns the primary key of this booked equipment.
	*
	* @return the primary key of this booked equipment
	*/
	@Override
	public long getPrimaryKey() {
		return _bookedEquipment.getPrimaryKey();
	}

	/**
	* Returns the room_id of this booked equipment.
	*
	* @return the room_id of this booked equipment
	*/
	@Override
	public long getRoom_id() {
		return _bookedEquipment.getRoom_id();
	}

	@Override
	public void persist() {
		_bookedEquipment.persist();
	}

	/**
	* Sets the booked_equip_id of this booked equipment.
	*
	* @param booked_equip_id the booked_equip_id of this booked equipment
	*/
	@Override
	public void setBooked_equip_id(long booked_equip_id) {
		_bookedEquipment.setBooked_equip_id(booked_equip_id);
	}

	/**
	* Sets whether this booked equipment is booked_equip_status.
	*
	* @param booked_equip_status the booked_equip_status of this booked equipment
	*/
	@Override
	public void setBooked_equip_status(boolean booked_equip_status) {
		_bookedEquipment.setBooked_equip_status(booked_equip_status);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bookedEquipment.setCachedModel(cachedModel);
	}

	/**
	* Sets the equip_id of this booked equipment.
	*
	* @param equip_id the equip_id of this booked equipment
	*/
	@Override
	public void setEquip_id(long equip_id) {
		_bookedEquipment.setEquip_id(equip_id);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bookedEquipment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_bookedEquipment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bookedEquipment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_bookedEquipment.setNew(n);
	}

	/**
	* Sets the primary key of this booked equipment.
	*
	* @param primaryKey the primary key of this booked equipment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bookedEquipment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bookedEquipment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the room_id of this booked equipment.
	*
	* @param room_id the room_id of this booked equipment
	*/
	@Override
	public void setRoom_id(long room_id) {
		_bookedEquipment.setRoom_id(room_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookedEquipmentWrapper)) {
			return false;
		}

		BookedEquipmentWrapper bookedEquipmentWrapper = (BookedEquipmentWrapper)obj;

		if (Objects.equals(_bookedEquipment,
					bookedEquipmentWrapper._bookedEquipment)) {
			return true;
		}

		return false;
	}

	@Override
	public BookedEquipment getWrappedModel() {
		return _bookedEquipment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bookedEquipment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bookedEquipment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bookedEquipment.resetOriginalValues();
	}

	private final BookedEquipment _bookedEquipment;
}