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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.roomservice.model.BookedEquipment;
import com.roomservice.model.BookedEquipmentModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BookedEquipment service. Represents a row in the &quot;bookedequipment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link BookedEquipmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BookedEquipmentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookedEquipmentImpl
 * @see BookedEquipment
 * @see BookedEquipmentModel
 * @generated
 */
@ProviderType
public class BookedEquipmentModelImpl extends BaseModelImpl<BookedEquipment>
	implements BookedEquipmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a booked equipment model instance should use the {@link BookedEquipment} interface instead.
	 */
	public static final String TABLE_NAME = "bookedequipment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "booked_equip_id", Types.BIGINT },
			{ "equip_id", Types.BIGINT },
			{ "course_id", Types.BIGINT },
			{ "equip_quantity", Types.INTEGER },
			{ "booked_equip_status", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("booked_equip_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("equip_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("course_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("equip_quantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("booked_equip_status", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table bookedequipment (booked_equip_id LONG not null primary key,equip_id LONG,course_id LONG,equip_quantity INTEGER,booked_equip_status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table bookedequipment";
	public static final String ORDER_BY_JPQL = " ORDER BY bookedEquipment.booked_equip_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY bookedequipment.booked_equip_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.roomservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.roomservice.model.BookedEquipment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.roomservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.roomservice.model.BookedEquipment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.roomservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.roomservice.model.BookedEquipment"));

	public BookedEquipmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _booked_equip_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBooked_equip_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _booked_equip_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("course_id", getCourse_id());
		attributes.put("equip_quantity", getEquip_quantity());
		attributes.put("booked_equip_status", getBooked_equip_status());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		Long course_id = (Long)attributes.get("course_id");

		if (course_id != null) {
			setCourse_id(course_id);
		}

		Integer equip_quantity = (Integer)attributes.get("equip_quantity");

		if (equip_quantity != null) {
			setEquip_quantity(equip_quantity);
		}

		Boolean booked_equip_status = (Boolean)attributes.get(
				"booked_equip_status");

		if (booked_equip_status != null) {
			setBooked_equip_status(booked_equip_status);
		}
	}

	@Override
	public long getBooked_equip_id() {
		return _booked_equip_id;
	}

	@Override
	public void setBooked_equip_id(long booked_equip_id) {
		_booked_equip_id = booked_equip_id;
	}

	@Override
	public long getEquip_id() {
		return _equip_id;
	}

	@Override
	public void setEquip_id(long equip_id) {
		_equip_id = equip_id;
	}

	@Override
	public long getCourse_id() {
		return _course_id;
	}

	@Override
	public void setCourse_id(long course_id) {
		_course_id = course_id;
	}

	@Override
	public int getEquip_quantity() {
		return _equip_quantity;
	}

	@Override
	public void setEquip_quantity(int equip_quantity) {
		_equip_quantity = equip_quantity;
	}

	@Override
	public boolean getBooked_equip_status() {
		return _booked_equip_status;
	}

	@Override
	public boolean isBooked_equip_status() {
		return _booked_equip_status;
	}

	@Override
	public void setBooked_equip_status(boolean booked_equip_status) {
		_booked_equip_status = booked_equip_status;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BookedEquipment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BookedEquipment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BookedEquipment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BookedEquipmentImpl bookedEquipmentImpl = new BookedEquipmentImpl();

		bookedEquipmentImpl.setBooked_equip_id(getBooked_equip_id());
		bookedEquipmentImpl.setEquip_id(getEquip_id());
		bookedEquipmentImpl.setCourse_id(getCourse_id());
		bookedEquipmentImpl.setEquip_quantity(getEquip_quantity());
		bookedEquipmentImpl.setBooked_equip_status(getBooked_equip_status());

		bookedEquipmentImpl.resetOriginalValues();

		return bookedEquipmentImpl;
	}

	@Override
	public int compareTo(BookedEquipment bookedEquipment) {
		long primaryKey = bookedEquipment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookedEquipment)) {
			return false;
		}

		BookedEquipment bookedEquipment = (BookedEquipment)obj;

		long primaryKey = bookedEquipment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<BookedEquipment> toCacheModel() {
		BookedEquipmentCacheModel bookedEquipmentCacheModel = new BookedEquipmentCacheModel();

		bookedEquipmentCacheModel.booked_equip_id = getBooked_equip_id();

		bookedEquipmentCacheModel.equip_id = getEquip_id();

		bookedEquipmentCacheModel.course_id = getCourse_id();

		bookedEquipmentCacheModel.equip_quantity = getEquip_quantity();

		bookedEquipmentCacheModel.booked_equip_status = getBooked_equip_status();

		return bookedEquipmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{booked_equip_id=");
		sb.append(getBooked_equip_id());
		sb.append(", equip_id=");
		sb.append(getEquip_id());
		sb.append(", course_id=");
		sb.append(getCourse_id());
		sb.append(", equip_quantity=");
		sb.append(getEquip_quantity());
		sb.append(", booked_equip_status=");
		sb.append(getBooked_equip_status());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.roomservice.model.BookedEquipment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>booked_equip_id</column-name><column-value><![CDATA[");
		sb.append(getBooked_equip_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equip_id</column-name><column-value><![CDATA[");
		sb.append(getEquip_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>course_id</column-name><column-value><![CDATA[");
		sb.append(getCourse_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equip_quantity</column-name><column-value><![CDATA[");
		sb.append(getEquip_quantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>booked_equip_status</column-name><column-value><![CDATA[");
		sb.append(getBooked_equip_status());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = BookedEquipment.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			BookedEquipment.class
		};
	private long _booked_equip_id;
	private long _equip_id;
	private long _course_id;
	private int _equip_quantity;
	private boolean _booked_equip_status;
	private BookedEquipment _escapedModel;
}