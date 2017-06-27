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

package com.roomservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.roomservice.model.BookedEquipment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BookedEquipment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BookedEquipment
 * @generated
 */
@ProviderType
public class BookedEquipmentCacheModel implements CacheModel<BookedEquipment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookedEquipmentCacheModel)) {
			return false;
		}

		BookedEquipmentCacheModel bookedEquipmentCacheModel = (BookedEquipmentCacheModel)obj;

		if (booked_equip_id == bookedEquipmentCacheModel.booked_equip_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, booked_equip_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{booked_equip_id=");
		sb.append(booked_equip_id);
		sb.append(", equip_id=");
		sb.append(equip_id);
		sb.append(", room_id=");
		sb.append(room_id);
		sb.append(", booked_equip_status=");
		sb.append(booked_equip_status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookedEquipment toEntityModel() {
		BookedEquipmentImpl bookedEquipmentImpl = new BookedEquipmentImpl();

		bookedEquipmentImpl.setBooked_equip_id(booked_equip_id);
		bookedEquipmentImpl.setEquip_id(equip_id);
		bookedEquipmentImpl.setRoom_id(room_id);
		bookedEquipmentImpl.setBooked_equip_status(booked_equip_status);

		bookedEquipmentImpl.resetOriginalValues();

		return bookedEquipmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		booked_equip_id = objectInput.readLong();

		equip_id = objectInput.readLong();

		room_id = objectInput.readLong();

		booked_equip_status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(booked_equip_id);

		objectOutput.writeLong(equip_id);

		objectOutput.writeLong(room_id);

		objectOutput.writeBoolean(booked_equip_status);
	}

	public long booked_equip_id;
	public long equip_id;
	public long room_id;
	public boolean booked_equip_status;
}