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
 * The base model interface for the istruzioni_per_la_compilazione_child service. Represents a row in the &quot;istruzioni_per_la_compilazione_child&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazione_childModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazione_childImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see istruzioni_per_la_compilazione_child
 * @see istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazione_childImpl
 * @see istruzioni_per_la_compilazioneservice.model.impl.istruzioni_per_la_compilazione_childModelImpl
 * @generated
 */
@ProviderType
public interface istruzioni_per_la_compilazione_childModel extends BaseModel<istruzioni_per_la_compilazione_child> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a istruzioni_per_la_compilazione_child model instance should use the {@link istruzioni_per_la_compilazione_child} interface instead.
	 */

	/**
	 * Returns the primary key of this istruzioni_per_la_compilazione_child.
	 *
	 * @return the primary key of this istruzioni_per_la_compilazione_child
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this istruzioni_per_la_compilazione_child.
	 *
	 * @param primaryKey the primary key of this istruzioni_per_la_compilazione_child
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ins_id of this istruzioni_per_la_compilazione_child.
	 *
	 * @return the ins_id of this istruzioni_per_la_compilazione_child
	 */
	public long getIns_id();

	/**
	 * Sets the ins_id of this istruzioni_per_la_compilazione_child.
	 *
	 * @param Ins_id the ins_id of this istruzioni_per_la_compilazione_child
	 */
	public void setIns_id(long Ins_id);

	/**
	 * Returns the instruction of this istruzioni_per_la_compilazione_child.
	 *
	 * @return the instruction of this istruzioni_per_la_compilazione_child
	 */
	@AutoEscape
	public String getInstruction();

	/**
	 * Sets the instruction of this istruzioni_per_la_compilazione_child.
	 *
	 * @param Instruction the instruction of this istruzioni_per_la_compilazione_child
	 */
	public void setInstruction(String Instruction);

	/**
	 * Returns the istruzioni_per_id of this istruzioni_per_la_compilazione_child.
	 *
	 * @return the istruzioni_per_id of this istruzioni_per_la_compilazione_child
	 */
	public long getIstruzioni_per_id();

	/**
	 * Sets the istruzioni_per_id of this istruzioni_per_la_compilazione_child.
	 *
	 * @param Istruzioni_per_id the istruzioni_per_id of this istruzioni_per_la_compilazione_child
	 */
	public void setIstruzioni_per_id(long Istruzioni_per_id);

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
		istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child istruzioni_per_la_compilazione_child);

	@Override
	public int hashCode();

	@Override
	public CacheModel<istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child> toCacheModel();

	@Override
	public istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child toEscapedModel();

	@Override
	public istruzioni_per_la_compilazioneservice.model.istruzioni_per_la_compilazione_child toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}