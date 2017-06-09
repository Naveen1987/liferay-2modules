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

package com.daffo.wiki_node_tableservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.daffo.wiki_node_tableservice.model.wiki_node_table;
import com.daffo.wiki_node_tableservice.model.wiki_node_tableModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the wiki_node_table service. Represents a row in the &quot;wiki_node_table&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link wiki_node_tableModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link wiki_node_tableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see wiki_node_tableImpl
 * @see wiki_node_table
 * @see wiki_node_tableModel
 * @generated
 */
@ProviderType
public class wiki_node_tableModelImpl extends BaseModelImpl<wiki_node_table>
	implements wiki_node_tableModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wiki_node_table model instance should use the {@link wiki_node_table} interface instead.
	 */
	public static final String TABLE_NAME = "wiki_node_table";
	public static final Object[][] TABLE_COLUMNS = {
			{ "NodeID", Types.BIGINT },
			{ "NodeName", Types.VARCHAR },
			{ "NodeDescription", Types.VARCHAR },
			{ "NodeCreationDate", Types.VARCHAR },
			{ "NodeCreator", Types.VARCHAR },
			{ "NodeModificationDate", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("NodeID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("NodeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NodeDescription", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NodeCreationDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NodeCreator", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NodeModificationDate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table wiki_node_table (NodeID LONG not null primary key,NodeName VARCHAR(75) null,NodeDescription VARCHAR(75) null,NodeCreationDate VARCHAR(75) null,NodeCreator VARCHAR(75) null,NodeModificationDate VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table wiki_node_table";
	public static final String ORDER_BY_JPQL = " ORDER BY wiki_node_table.NodeID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY wiki_node_table.NodeID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.daffo.wiki_node_tableservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.daffo.wiki_node_tableservice.model.wiki_node_table"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.daffo.wiki_node_tableservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.daffo.wiki_node_tableservice.model.wiki_node_table"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.daffo.wiki_node_tableservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.daffo.wiki_node_tableservice.model.wiki_node_table"));

	public wiki_node_tableModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _NodeID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNodeID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _NodeID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return wiki_node_table.class;
	}

	@Override
	public String getModelClassName() {
		return wiki_node_table.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("NodeID", getNodeID());
		attributes.put("NodeName", getNodeName());
		attributes.put("NodeDescription", getNodeDescription());
		attributes.put("NodeCreationDate", getNodeCreationDate());
		attributes.put("NodeCreator", getNodeCreator());
		attributes.put("NodeModificationDate", getNodeModificationDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long NodeID = (Long)attributes.get("NodeID");

		if (NodeID != null) {
			setNodeID(NodeID);
		}

		String NodeName = (String)attributes.get("NodeName");

		if (NodeName != null) {
			setNodeName(NodeName);
		}

		String NodeDescription = (String)attributes.get("NodeDescription");

		if (NodeDescription != null) {
			setNodeDescription(NodeDescription);
		}

		String NodeCreationDate = (String)attributes.get("NodeCreationDate");

		if (NodeCreationDate != null) {
			setNodeCreationDate(NodeCreationDate);
		}

		String NodeCreator = (String)attributes.get("NodeCreator");

		if (NodeCreator != null) {
			setNodeCreator(NodeCreator);
		}

		String NodeModificationDate = (String)attributes.get(
				"NodeModificationDate");

		if (NodeModificationDate != null) {
			setNodeModificationDate(NodeModificationDate);
		}
	}

	@Override
	public long getNodeID() {
		return _NodeID;
	}

	@Override
	public void setNodeID(long NodeID) {
		_NodeID = NodeID;
	}

	@Override
	public String getNodeName() {
		if (_NodeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _NodeName;
		}
	}

	@Override
	public void setNodeName(String NodeName) {
		_NodeName = NodeName;
	}

	@Override
	public String getNodeDescription() {
		if (_NodeDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _NodeDescription;
		}
	}

	@Override
	public void setNodeDescription(String NodeDescription) {
		_NodeDescription = NodeDescription;
	}

	@Override
	public String getNodeCreationDate() {
		if (_NodeCreationDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _NodeCreationDate;
		}
	}

	@Override
	public void setNodeCreationDate(String NodeCreationDate) {
		_NodeCreationDate = NodeCreationDate;
	}

	@Override
	public String getNodeCreator() {
		if (_NodeCreator == null) {
			return StringPool.BLANK;
		}
		else {
			return _NodeCreator;
		}
	}

	@Override
	public void setNodeCreator(String NodeCreator) {
		_NodeCreator = NodeCreator;
	}

	@Override
	public String getNodeModificationDate() {
		if (_NodeModificationDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _NodeModificationDate;
		}
	}

	@Override
	public void setNodeModificationDate(String NodeModificationDate) {
		_NodeModificationDate = NodeModificationDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			wiki_node_table.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public wiki_node_table toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (wiki_node_table)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		wiki_node_tableImpl wiki_node_tableImpl = new wiki_node_tableImpl();

		wiki_node_tableImpl.setNodeID(getNodeID());
		wiki_node_tableImpl.setNodeName(getNodeName());
		wiki_node_tableImpl.setNodeDescription(getNodeDescription());
		wiki_node_tableImpl.setNodeCreationDate(getNodeCreationDate());
		wiki_node_tableImpl.setNodeCreator(getNodeCreator());
		wiki_node_tableImpl.setNodeModificationDate(getNodeModificationDate());

		wiki_node_tableImpl.resetOriginalValues();

		return wiki_node_tableImpl;
	}

	@Override
	public int compareTo(wiki_node_table wiki_node_table) {
		long primaryKey = wiki_node_table.getPrimaryKey();

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

		if (!(obj instanceof wiki_node_table)) {
			return false;
		}

		wiki_node_table wiki_node_table = (wiki_node_table)obj;

		long primaryKey = wiki_node_table.getPrimaryKey();

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
	public CacheModel<wiki_node_table> toCacheModel() {
		wiki_node_tableCacheModel wiki_node_tableCacheModel = new wiki_node_tableCacheModel();

		wiki_node_tableCacheModel.NodeID = getNodeID();

		wiki_node_tableCacheModel.NodeName = getNodeName();

		String NodeName = wiki_node_tableCacheModel.NodeName;

		if ((NodeName != null) && (NodeName.length() == 0)) {
			wiki_node_tableCacheModel.NodeName = null;
		}

		wiki_node_tableCacheModel.NodeDescription = getNodeDescription();

		String NodeDescription = wiki_node_tableCacheModel.NodeDescription;

		if ((NodeDescription != null) && (NodeDescription.length() == 0)) {
			wiki_node_tableCacheModel.NodeDescription = null;
		}

		wiki_node_tableCacheModel.NodeCreationDate = getNodeCreationDate();

		String NodeCreationDate = wiki_node_tableCacheModel.NodeCreationDate;

		if ((NodeCreationDate != null) && (NodeCreationDate.length() == 0)) {
			wiki_node_tableCacheModel.NodeCreationDate = null;
		}

		wiki_node_tableCacheModel.NodeCreator = getNodeCreator();

		String NodeCreator = wiki_node_tableCacheModel.NodeCreator;

		if ((NodeCreator != null) && (NodeCreator.length() == 0)) {
			wiki_node_tableCacheModel.NodeCreator = null;
		}

		wiki_node_tableCacheModel.NodeModificationDate = getNodeModificationDate();

		String NodeModificationDate = wiki_node_tableCacheModel.NodeModificationDate;

		if ((NodeModificationDate != null) &&
				(NodeModificationDate.length() == 0)) {
			wiki_node_tableCacheModel.NodeModificationDate = null;
		}

		return wiki_node_tableCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{NodeID=");
		sb.append(getNodeID());
		sb.append(", NodeName=");
		sb.append(getNodeName());
		sb.append(", NodeDescription=");
		sb.append(getNodeDescription());
		sb.append(", NodeCreationDate=");
		sb.append(getNodeCreationDate());
		sb.append(", NodeCreator=");
		sb.append(getNodeCreator());
		sb.append(", NodeModificationDate=");
		sb.append(getNodeModificationDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.daffo.wiki_node_tableservice.model.wiki_node_table");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>NodeID</column-name><column-value><![CDATA[");
		sb.append(getNodeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NodeName</column-name><column-value><![CDATA[");
		sb.append(getNodeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NodeDescription</column-name><column-value><![CDATA[");
		sb.append(getNodeDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NodeCreationDate</column-name><column-value><![CDATA[");
		sb.append(getNodeCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NodeCreator</column-name><column-value><![CDATA[");
		sb.append(getNodeCreator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NodeModificationDate</column-name><column-value><![CDATA[");
		sb.append(getNodeModificationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = wiki_node_table.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			wiki_node_table.class
		};
	private long _NodeID;
	private String _NodeName;
	private String _NodeDescription;
	private String _NodeCreationDate;
	private String _NodeCreator;
	private String _NodeModificationDate;
	private wiki_node_table _escapedModel;
}