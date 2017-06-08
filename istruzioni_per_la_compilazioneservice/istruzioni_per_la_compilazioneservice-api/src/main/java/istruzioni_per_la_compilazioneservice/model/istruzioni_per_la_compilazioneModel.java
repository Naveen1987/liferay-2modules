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

package istruzioni_per_la_compilazioneservice.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the istruzioni_per_la_compilazione service. Represents a row in the &quot;istruzioni_per_la_compilazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazioneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see istruzioni_per_la_compilazione
 * @see istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazioneImpl
 * @see istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazioneModelImpl
 * @generated
 */
@ProviderType
public interface istruzioni_per_la_compilazioneModel extends BaseModel<istruzioni_per_la_compilazione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a istruzioni_per_la_compilazione model instance should use the {@link istruzioni_per_la_compilazione} interface instead.
	 */

	/**
	 * Returns the primary key of this istruzioni_per_la_compilazione.
	 *
	 * @return the primary key of this istruzioni_per_la_compilazione
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this istruzioni_per_la_compilazione.
	 *
	 * @param primaryKey the primary key of this istruzioni_per_la_compilazione
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the istruzioni_per_id of this istruzioni_per_la_compilazione.
	 *
	 * @return the istruzioni_per_id of this istruzioni_per_la_compilazione
	 */
	public long getIstruzioni_per_id();

	/**
	 * Sets the istruzioni_per_id of this istruzioni_per_la_compilazione.
	 *
	 * @param Istruzioni_per_id the istruzioni_per_id of this istruzioni_per_la_compilazione
	 */
	public void setIstruzioni_per_id(long Istruzioni_per_id);

	/**
	 * Returns the purpose of this istruzioni_per_la_compilazione.
	 *
	 * @return the purpose of this istruzioni_per_la_compilazione
	 */
	@AutoEscape
	public String getPurpose();

	/**
	 * Sets the purpose of this istruzioni_per_la_compilazione.
	 *
	 * @param purpose the purpose of this istruzioni_per_la_compilazione
	 */
	public void setPurpose(String purpose);

	/**
	 * Returns the main title of this istruzioni_per_la_compilazione.
	 *
	 * @return the main title of this istruzioni_per_la_compilazione
	 */
	@AutoEscape
	public String getMainTitle();

	/**
	 * Sets the main title of this istruzioni_per_la_compilazione.
	 *
	 * @param MainTitle the main title of this istruzioni_per_la_compilazione
	 */
	public void setMainTitle(String MainTitle);

	/**
	 * Returns the tilte of this istruzioni_per_la_compilazione.
	 *
	 * @return the tilte of this istruzioni_per_la_compilazione
	 */
	@AutoEscape
	public String getTilte();

	/**
	 * Sets the tilte of this istruzioni_per_la_compilazione.
	 *
	 * @param Tilte the tilte of this istruzioni_per_la_compilazione
	 */
	public void setTilte(String Tilte);

	/**
	 * Returns the sub title of this istruzioni_per_la_compilazione.
	 *
	 * @return the sub title of this istruzioni_per_la_compilazione
	 */
	@AutoEscape
	public String getSubTitle();

	/**
	 * Sets the sub title of this istruzioni_per_la_compilazione.
	 *
	 * @param SubTitle the sub title of this istruzioni_per_la_compilazione
	 */
	public void setSubTitle(String SubTitle);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione istruzioni_per_la_compilazione);

	@Override
	public int hashCode();

	@Override
	public CacheModel<istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione> toCacheModel();

	@Override
	public istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione toEscapedModel();

	@Override
	public istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}