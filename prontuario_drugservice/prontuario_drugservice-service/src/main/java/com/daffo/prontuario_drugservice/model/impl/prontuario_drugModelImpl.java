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

package com.daffo.prontuario_drugservice.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.daffo.prontuario_drugservice.model.prontuario_drug;
import com.daffo.prontuario_drugservice.model.prontuario_drugModel;

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
 * The base model implementation for the prontuario_drug service. Represents a row in the &quot;prontuario_drug&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link prontuario_drugModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link prontuario_drugImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see prontuario_drugImpl
 * @see prontuario_drug
 * @see prontuario_drugModel
 * @generated
 */
@ProviderType
public class prontuario_drugModelImpl extends BaseModelImpl<prontuario_drug>
	implements prontuario_drugModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a prontuario_drug model instance should use the {@link prontuario_drug} interface instead.
	 */
	public static final String TABLE_NAME = "prontuario_drug";
	public static final Object[][] TABLE_COLUMNS = {
			{ "drug_id", Types.BIGINT },
			{ "Gruppo", Types.VARCHAR },
			{ "SottoGruppo", Types.VARCHAR },
			{ "Codice", Types.VARCHAR },
			{ "Principio_Attivo", Types.VARCHAR },
			{ "Nome_Commerciale", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("drug_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Gruppo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("SottoGruppo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Codice", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Principio_Attivo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("Nome_Commerciale", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table prontuario_drug (drug_id LONG not null primary key,Gruppo VARCHAR(75) null,SottoGruppo VARCHAR(75) null,Codice VARCHAR(75) null,Principio_Attivo VARCHAR(75) null,Nome_Commerciale VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table prontuario_drug";
	public static final String ORDER_BY_JPQL = " ORDER BY prontuario_drug.drug_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY prontuario_drug.drug_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.daffo.prontuario_drugservice.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.daffo.prontuario_drugservice.model.prontuario_drug"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.daffo.prontuario_drugservice.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.daffo.prontuario_drugservice.model.prontuario_drug"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.daffo.prontuario_drugservice.service.util.ServiceProps.get(
				"lock.expiration.time.com.daffo.prontuario_drugservice.model.prontuario_drug"));

	public prontuario_drugModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _drug_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDrug_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _drug_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return prontuario_drug.class;
	}

	@Override
	public String getModelClassName() {
		return prontuario_drug.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("drug_id", getDrug_id());
		attributes.put("Gruppo", getGruppo());
		attributes.put("SottoGruppo", getSottoGruppo());
		attributes.put("Codice", getCodice());
		attributes.put("Principio_Attivo", getPrincipio_Attivo());
		attributes.put("Nome_Commerciale", getNome_Commerciale());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long drug_id = (Long)attributes.get("drug_id");

		if (drug_id != null) {
			setDrug_id(drug_id);
		}

		String Gruppo = (String)attributes.get("Gruppo");

		if (Gruppo != null) {
			setGruppo(Gruppo);
		}

		String SottoGruppo = (String)attributes.get("SottoGruppo");

		if (SottoGruppo != null) {
			setSottoGruppo(SottoGruppo);
		}

		String Codice = (String)attributes.get("Codice");

		if (Codice != null) {
			setCodice(Codice);
		}

		String Principio_Attivo = (String)attributes.get("Principio_Attivo");

		if (Principio_Attivo != null) {
			setPrincipio_Attivo(Principio_Attivo);
		}

		String Nome_Commerciale = (String)attributes.get("Nome_Commerciale");

		if (Nome_Commerciale != null) {
			setNome_Commerciale(Nome_Commerciale);
		}
	}

	@Override
	public long getDrug_id() {
		return _drug_id;
	}

	@Override
	public void setDrug_id(long drug_id) {
		_drug_id = drug_id;
	}

	@Override
	public String getGruppo() {
		if (_Gruppo == null) {
			return StringPool.BLANK;
		}
		else {
			return _Gruppo;
		}
	}

	@Override
	public void setGruppo(String Gruppo) {
		_Gruppo = Gruppo;
	}

	@Override
	public String getSottoGruppo() {
		if (_SottoGruppo == null) {
			return StringPool.BLANK;
		}
		else {
			return _SottoGruppo;
		}
	}

	@Override
	public void setSottoGruppo(String SottoGruppo) {
		_SottoGruppo = SottoGruppo;
	}

	@Override
	public String getCodice() {
		if (_Codice == null) {
			return StringPool.BLANK;
		}
		else {
			return _Codice;
		}
	}

	@Override
	public void setCodice(String Codice) {
		_Codice = Codice;
	}

	@Override
	public String getPrincipio_Attivo() {
		if (_Principio_Attivo == null) {
			return StringPool.BLANK;
		}
		else {
			return _Principio_Attivo;
		}
	}

	@Override
	public void setPrincipio_Attivo(String Principio_Attivo) {
		_Principio_Attivo = Principio_Attivo;
	}

	@Override
	public String getNome_Commerciale() {
		if (_Nome_Commerciale == null) {
			return StringPool.BLANK;
		}
		else {
			return _Nome_Commerciale;
		}
	}

	@Override
	public void setNome_Commerciale(String Nome_Commerciale) {
		_Nome_Commerciale = Nome_Commerciale;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			prontuario_drug.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public prontuario_drug toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (prontuario_drug)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		prontuario_drugImpl prontuario_drugImpl = new prontuario_drugImpl();

		prontuario_drugImpl.setDrug_id(getDrug_id());
		prontuario_drugImpl.setGruppo(getGruppo());
		prontuario_drugImpl.setSottoGruppo(getSottoGruppo());
		prontuario_drugImpl.setCodice(getCodice());
		prontuario_drugImpl.setPrincipio_Attivo(getPrincipio_Attivo());
		prontuario_drugImpl.setNome_Commerciale(getNome_Commerciale());

		prontuario_drugImpl.resetOriginalValues();

		return prontuario_drugImpl;
	}

	@Override
	public int compareTo(prontuario_drug prontuario_drug) {
		long primaryKey = prontuario_drug.getPrimaryKey();

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

		if (!(obj instanceof prontuario_drug)) {
			return false;
		}

		prontuario_drug prontuario_drug = (prontuario_drug)obj;

		long primaryKey = prontuario_drug.getPrimaryKey();

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
	public CacheModel<prontuario_drug> toCacheModel() {
		prontuario_drugCacheModel prontuario_drugCacheModel = new prontuario_drugCacheModel();

		prontuario_drugCacheModel.drug_id = getDrug_id();

		prontuario_drugCacheModel.Gruppo = getGruppo();

		String Gruppo = prontuario_drugCacheModel.Gruppo;

		if ((Gruppo != null) && (Gruppo.length() == 0)) {
			prontuario_drugCacheModel.Gruppo = null;
		}

		prontuario_drugCacheModel.SottoGruppo = getSottoGruppo();

		String SottoGruppo = prontuario_drugCacheModel.SottoGruppo;

		if ((SottoGruppo != null) && (SottoGruppo.length() == 0)) {
			prontuario_drugCacheModel.SottoGruppo = null;
		}

		prontuario_drugCacheModel.Codice = getCodice();

		String Codice = prontuario_drugCacheModel.Codice;

		if ((Codice != null) && (Codice.length() == 0)) {
			prontuario_drugCacheModel.Codice = null;
		}

		prontuario_drugCacheModel.Principio_Attivo = getPrincipio_Attivo();

		String Principio_Attivo = prontuario_drugCacheModel.Principio_Attivo;

		if ((Principio_Attivo != null) && (Principio_Attivo.length() == 0)) {
			prontuario_drugCacheModel.Principio_Attivo = null;
		}

		prontuario_drugCacheModel.Nome_Commerciale = getNome_Commerciale();

		String Nome_Commerciale = prontuario_drugCacheModel.Nome_Commerciale;

		if ((Nome_Commerciale != null) && (Nome_Commerciale.length() == 0)) {
			prontuario_drugCacheModel.Nome_Commerciale = null;
		}

		return prontuario_drugCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{drug_id=");
		sb.append(getDrug_id());
		sb.append(", Gruppo=");
		sb.append(getGruppo());
		sb.append(", SottoGruppo=");
		sb.append(getSottoGruppo());
		sb.append(", Codice=");
		sb.append(getCodice());
		sb.append(", Principio_Attivo=");
		sb.append(getPrincipio_Attivo());
		sb.append(", Nome_Commerciale=");
		sb.append(getNome_Commerciale());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.daffo.prontuario_drugservice.model.prontuario_drug");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>drug_id</column-name><column-value><![CDATA[");
		sb.append(getDrug_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Gruppo</column-name><column-value><![CDATA[");
		sb.append(getGruppo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SottoGruppo</column-name><column-value><![CDATA[");
		sb.append(getSottoGruppo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Codice</column-name><column-value><![CDATA[");
		sb.append(getCodice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Principio_Attivo</column-name><column-value><![CDATA[");
		sb.append(getPrincipio_Attivo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Nome_Commerciale</column-name><column-value><![CDATA[");
		sb.append(getNome_Commerciale());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = prontuario_drug.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			prontuario_drug.class
		};
	private long _drug_id;
	private String _Gruppo;
	private String _SottoGruppo;
	private String _Codice;
	private String _Principio_Attivo;
	private String _Nome_Commerciale;
	private prontuario_drug _escapedModel;
}