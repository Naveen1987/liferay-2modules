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

package com.daffo.Form_di_segnalService.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.daffo.Form_di_segnalService.exception.NoSuchForm_di_segnalazione_serviceException;
import com.daffo.Form_di_segnalService.model.Form_di_segnalazione_service;
import com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceImpl;
import com.daffo.Form_di_segnalService.model.impl.Form_di_segnalazione_serviceModelImpl;
import com.daffo.Form_di_segnalService.service.persistence.Form_di_segnalazione_servicePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the form_di_segnalazione_service service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Form_di_segnalazione_servicePersistence
 * @see com.daffo.Form_di_segnalService.service.persistence.Form_di_segnalazione_serviceUtil
 * @generated
 */
@ProviderType
public class Form_di_segnalazione_servicePersistenceImpl
	extends BasePersistenceImpl<Form_di_segnalazione_service>
	implements Form_di_segnalazione_servicePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Form_di_segnalazione_serviceUtil} to access the form_di_segnalazione_service persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Form_di_segnalazione_serviceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			Form_di_segnalazione_serviceModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the form_di_segnalazione_services where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form_di_segnalazione_services where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @return the range of matching form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findByUuid(String uuid,
		int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form_di_segnalazione_services where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form_di_segnalazione_services where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Form_di_segnalazione_service> list = null;

		if (retrieveFromCache) {
			list = (List<Form_di_segnalazione_service>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Form_di_segnalazione_service form_di_segnalazione_service : list) {
					if (!Objects.equals(uuid,
								form_di_segnalazione_service.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Form_di_segnalazione_serviceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Form_di_segnalazione_service>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Form_di_segnalazione_service>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form_di_segnalazione_service
	 * @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	 */
	@Override
	public Form_di_segnalazione_service findByUuid_First(String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException {
		Form_di_segnalazione_service form_di_segnalazione_service = fetchByUuid_First(uuid,
				orderByComparator);

		if (form_di_segnalazione_service != null) {
			return form_di_segnalazione_service;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForm_di_segnalazione_serviceException(msg.toString());
	}

	/**
	 * Returns the first form_di_segnalazione_service in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	 */
	@Override
	public Form_di_segnalazione_service fetchByUuid_First(String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		List<Form_di_segnalazione_service> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form_di_segnalazione_service
	 * @throws NoSuchForm_di_segnalazione_serviceException if a matching form_di_segnalazione_service could not be found
	 */
	@Override
	public Form_di_segnalazione_service findByUuid_Last(String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException {
		Form_di_segnalazione_service form_di_segnalazione_service = fetchByUuid_Last(uuid,
				orderByComparator);

		if (form_di_segnalazione_service != null) {
			return form_di_segnalazione_service;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchForm_di_segnalazione_serviceException(msg.toString());
	}

	/**
	 * Returns the last form_di_segnalazione_service in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form_di_segnalazione_service, or <code>null</code> if a matching form_di_segnalazione_service could not be found
	 */
	@Override
	public Form_di_segnalazione_service fetchByUuid_Last(String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Form_di_segnalazione_service> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form_di_segnalazione_services before and after the current form_di_segnalazione_service in the ordered set where uuid = &#63;.
	 *
	 * @param Form_di_segnalazione_id the primary key of the current form_di_segnalazione_service
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form_di_segnalazione_service
	 * @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service[] findByUuid_PrevAndNext(
		long Form_di_segnalazione_id, String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator)
		throws NoSuchForm_di_segnalazione_serviceException {
		Form_di_segnalazione_service form_di_segnalazione_service = findByPrimaryKey(Form_di_segnalazione_id);

		Session session = null;

		try {
			session = openSession();

			Form_di_segnalazione_service[] array = new Form_di_segnalazione_serviceImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					form_di_segnalazione_service, uuid, orderByComparator, true);

			array[1] = form_di_segnalazione_service;

			array[2] = getByUuid_PrevAndNext(session,
					form_di_segnalazione_service, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Form_di_segnalazione_service getByUuid_PrevAndNext(
		Session session,
		Form_di_segnalazione_service form_di_segnalazione_service, String uuid,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Form_di_segnalazione_serviceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(form_di_segnalazione_service);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Form_di_segnalazione_service> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form_di_segnalazione_services where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Form_di_segnalazione_service form_di_segnalazione_service : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(form_di_segnalazione_service);
		}
	}

	/**
	 * Returns the number of form_di_segnalazione_services where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form_di_segnalazione_services
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "form_di_segnalazione_service.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "form_di_segnalazione_service.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(form_di_segnalazione_service.uuid IS NULL OR form_di_segnalazione_service.uuid = '')";

	public Form_di_segnalazione_servicePersistenceImpl() {
		setModelClass(Form_di_segnalazione_service.class);
	}

	/**
	 * Caches the form_di_segnalazione_service in the entity cache if it is enabled.
	 *
	 * @param form_di_segnalazione_service the form_di_segnalazione_service
	 */
	@Override
	public void cacheResult(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		entityCache.putResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			form_di_segnalazione_service.getPrimaryKey(),
			form_di_segnalazione_service);

		form_di_segnalazione_service.resetOriginalValues();
	}

	/**
	 * Caches the form_di_segnalazione_services in the entity cache if it is enabled.
	 *
	 * @param form_di_segnalazione_services the form_di_segnalazione_services
	 */
	@Override
	public void cacheResult(
		List<Form_di_segnalazione_service> form_di_segnalazione_services) {
		for (Form_di_segnalazione_service form_di_segnalazione_service : form_di_segnalazione_services) {
			if (entityCache.getResult(
						Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
						Form_di_segnalazione_serviceImpl.class,
						form_di_segnalazione_service.getPrimaryKey()) == null) {
				cacheResult(form_di_segnalazione_service);
			}
			else {
				form_di_segnalazione_service.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all form_di_segnalazione_services.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Form_di_segnalazione_serviceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form_di_segnalazione_service.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		entityCache.removeResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			form_di_segnalazione_service.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Form_di_segnalazione_service> form_di_segnalazione_services) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Form_di_segnalazione_service form_di_segnalazione_service : form_di_segnalazione_services) {
			entityCache.removeResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
				Form_di_segnalazione_serviceImpl.class,
				form_di_segnalazione_service.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form_di_segnalazione_service with the primary key. Does not add the form_di_segnalazione_service to the database.
	 *
	 * @param Form_di_segnalazione_id the primary key for the new form_di_segnalazione_service
	 * @return the new form_di_segnalazione_service
	 */
	@Override
	public Form_di_segnalazione_service create(long Form_di_segnalazione_id) {
		Form_di_segnalazione_service form_di_segnalazione_service = new Form_di_segnalazione_serviceImpl();

		form_di_segnalazione_service.setNew(true);
		form_di_segnalazione_service.setPrimaryKey(Form_di_segnalazione_id);

		String uuid = PortalUUIDUtil.generate();

		form_di_segnalazione_service.setUuid(uuid);

		return form_di_segnalazione_service;
	}

	/**
	 * Removes the form_di_segnalazione_service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service that was removed
	 * @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service remove(long Form_di_segnalazione_id)
		throws NoSuchForm_di_segnalazione_serviceException {
		return remove((Serializable)Form_di_segnalazione_id);
	}

	/**
	 * Removes the form_di_segnalazione_service with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service that was removed
	 * @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service remove(Serializable primaryKey)
		throws NoSuchForm_di_segnalazione_serviceException {
		Session session = null;

		try {
			session = openSession();

			Form_di_segnalazione_service form_di_segnalazione_service = (Form_di_segnalazione_service)session.get(Form_di_segnalazione_serviceImpl.class,
					primaryKey);

			if (form_di_segnalazione_service == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchForm_di_segnalazione_serviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(form_di_segnalazione_service);
		}
		catch (NoSuchForm_di_segnalazione_serviceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Form_di_segnalazione_service removeImpl(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		form_di_segnalazione_service = toUnwrappedModel(form_di_segnalazione_service);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(form_di_segnalazione_service)) {
				form_di_segnalazione_service = (Form_di_segnalazione_service)session.get(Form_di_segnalazione_serviceImpl.class,
						form_di_segnalazione_service.getPrimaryKeyObj());
			}

			if (form_di_segnalazione_service != null) {
				session.delete(form_di_segnalazione_service);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (form_di_segnalazione_service != null) {
			clearCache(form_di_segnalazione_service);
		}

		return form_di_segnalazione_service;
	}

	@Override
	public Form_di_segnalazione_service updateImpl(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		form_di_segnalazione_service = toUnwrappedModel(form_di_segnalazione_service);

		boolean isNew = form_di_segnalazione_service.isNew();

		Form_di_segnalazione_serviceModelImpl form_di_segnalazione_serviceModelImpl =
			(Form_di_segnalazione_serviceModelImpl)form_di_segnalazione_service;

		if (Validator.isNull(form_di_segnalazione_service.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			form_di_segnalazione_service.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (form_di_segnalazione_service.isNew()) {
				session.save(form_di_segnalazione_service);

				form_di_segnalazione_service.setNew(false);
			}
			else {
				form_di_segnalazione_service = (Form_di_segnalazione_service)session.merge(form_di_segnalazione_service);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!Form_di_segnalazione_serviceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((form_di_segnalazione_serviceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						form_di_segnalazione_serviceModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						form_di_segnalazione_serviceModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
			Form_di_segnalazione_serviceImpl.class,
			form_di_segnalazione_service.getPrimaryKey(),
			form_di_segnalazione_service, false);

		form_di_segnalazione_service.resetOriginalValues();

		return form_di_segnalazione_service;
	}

	protected Form_di_segnalazione_service toUnwrappedModel(
		Form_di_segnalazione_service form_di_segnalazione_service) {
		if (form_di_segnalazione_service instanceof Form_di_segnalazione_serviceImpl) {
			return form_di_segnalazione_service;
		}

		Form_di_segnalazione_serviceImpl form_di_segnalazione_serviceImpl = new Form_di_segnalazione_serviceImpl();

		form_di_segnalazione_serviceImpl.setNew(form_di_segnalazione_service.isNew());
		form_di_segnalazione_serviceImpl.setPrimaryKey(form_di_segnalazione_service.getPrimaryKey());

		form_di_segnalazione_serviceImpl.setUuid(form_di_segnalazione_service.getUuid());
		form_di_segnalazione_serviceImpl.setForm_di_segnalazione_id(form_di_segnalazione_service.getForm_di_segnalazione_id());
		form_di_segnalazione_serviceImpl.setCODICE(form_di_segnalazione_service.getCODICE());
		form_di_segnalazione_serviceImpl.setINIZIALI_1(form_di_segnalazione_service.getINIZIALI_1());
		form_di_segnalazione_serviceImpl.setINIZIALI_1_a(form_di_segnalazione_service.getINIZIALI_1_a());
		form_di_segnalazione_serviceImpl.setINIZIALI_1_b(form_di_segnalazione_service.getINIZIALI_1_b());
		form_di_segnalazione_serviceImpl.setINIZIALI_1_c(form_di_segnalazione_service.getINIZIALI_1_c());
		form_di_segnalazione_serviceImpl.setINIZIALI_1_d(form_di_segnalazione_service.getINIZIALI_1_d());
		form_di_segnalazione_serviceImpl.setINIZIALI_1_e(form_di_segnalazione_service.getINIZIALI_1_e());
		form_di_segnalazione_serviceImpl.setDATA_2(form_di_segnalazione_service.getDATA_2());
		form_di_segnalazione_serviceImpl.setSESSO_3(form_di_segnalazione_service.getSESSO_3());
		form_di_segnalazione_serviceImpl.setDATA_4(form_di_segnalazione_service.getDATA_4());
		form_di_segnalazione_serviceImpl.setORIGINE_5(form_di_segnalazione_service.getORIGINE_5());
		form_di_segnalazione_serviceImpl.setDESCRIZIONE_6(form_di_segnalazione_service.getDESCRIZIONE_6());
		form_di_segnalazione_serviceImpl.setINDICARE_7_1(form_di_segnalazione_service.getINDICARE_7_1());
		form_di_segnalazione_serviceImpl.setINDICARE_7_2(form_di_segnalazione_service.getINDICARE_7_2());
		form_di_segnalazione_serviceImpl.setINDICARE_7_3(form_di_segnalazione_service.getINDICARE_7_3());
		form_di_segnalazione_serviceImpl.setINDICARE_7_4(form_di_segnalazione_service.getINDICARE_7_4());
		form_di_segnalazione_serviceImpl.setINDICARE_7_5(form_di_segnalazione_service.getINDICARE_7_5());
		form_di_segnalazione_serviceImpl.setINDICARE_7_6(form_di_segnalazione_service.getINDICARE_7_6());
		form_di_segnalazione_serviceImpl.setINDICARE_7_7(form_di_segnalazione_service.getINDICARE_7_7());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_1(form_di_segnalazione_service.getGRAVITA_8_1());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_2(form_di_segnalazione_service.getGRAVITA_8_2());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_3(form_di_segnalazione_service.getGRAVITA_8_3());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_4(form_di_segnalazione_service.getGRAVITA_8_4());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_5(form_di_segnalazione_service.getGRAVITA_8_5());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_6(form_di_segnalazione_service.getGRAVITA_8_6());
		form_di_segnalazione_serviceImpl.setGRAVITA_8_7(form_di_segnalazione_service.getGRAVITA_8_7());
		form_di_segnalazione_serviceImpl.setEVENTUALI_9(form_di_segnalazione_service.getEVENTUALI_9());
		form_di_segnalazione_serviceImpl.setESITO_10(form_di_segnalazione_service.getESITO_10());
		form_di_segnalazione_serviceImpl.setESITO_10_1(form_di_segnalazione_service.getESITO_10_1());
		form_di_segnalazione_serviceImpl.setESITO_10_2(form_di_segnalazione_service.getESITO_10_2());
		form_di_segnalazione_serviceImpl.setESITO_10_3(form_di_segnalazione_service.getESITO_10_3());
		form_di_segnalazione_serviceImpl.setESITO_10_4(form_di_segnalazione_service.getESITO_10_4());
		form_di_segnalazione_serviceImpl.setESITO_10_5(form_di_segnalazione_service.getESITO_10_5());
		form_di_segnalazione_serviceImpl.setESITO_10_6(form_di_segnalazione_service.getESITO_10_6());
		form_di_segnalazione_serviceImpl.setESITO_10_7(form_di_segnalazione_service.getESITO_10_7());
		form_di_segnalazione_serviceImpl.setESITO_10_8(form_di_segnalazione_service.getESITO_10_8());
		form_di_segnalazione_serviceImpl.setESITO_10_9(form_di_segnalazione_service.getESITO_10_9());
		form_di_segnalazione_serviceImpl.setESITO_10_10(form_di_segnalazione_service.getESITO_10_10());
		form_di_segnalazione_serviceImpl.setAZIONI_11(form_di_segnalazione_service.getAZIONI_11());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a(form_di_segnalazione_service.getFARMACO_12_a());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_13(form_di_segnalazione_service.getFARMACO_12_a_13());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_14(form_di_segnalazione_service.getFARMACO_12_a_14());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_15(form_di_segnalazione_service.getFARMACO_12_a_15());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_16_1(form_di_segnalazione_service.getFARMACO_12_a_16_1());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_16_2(form_di_segnalazione_service.getFARMACO_12_a_16_2());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_17(form_di_segnalazione_service.getFARMACO_12_a_17());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_18(form_di_segnalazione_service.getFARMACO_12_a_18());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_19(form_di_segnalazione_service.getFARMACO_12_a_19());
		form_di_segnalazione_serviceImpl.setFARMACO_12_a_20(form_di_segnalazione_service.getFARMACO_12_a_20());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b(form_di_segnalazione_service.getFARMACO_12_b());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_13(form_di_segnalazione_service.getFARMACO_12_b_13());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_14(form_di_segnalazione_service.getFARMACO_12_b_14());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_15(form_di_segnalazione_service.getFARMACO_12_b_15());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_16_1(form_di_segnalazione_service.getFARMACO_12_b_16_1());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_16_2(form_di_segnalazione_service.getFARMACO_12_b_16_2());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_17(form_di_segnalazione_service.getFARMACO_12_b_17());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_18(form_di_segnalazione_service.getFARMACO_12_b_18());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_19(form_di_segnalazione_service.getFARMACO_12_b_19());
		form_di_segnalazione_serviceImpl.setFARMACO_12_b_20(form_di_segnalazione_service.getFARMACO_12_b_20());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c(form_di_segnalazione_service.getFARMACO_12_c());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_13(form_di_segnalazione_service.getFARMACO_12_c_13());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_14(form_di_segnalazione_service.getFARMACO_12_c_14());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_15(form_di_segnalazione_service.getFARMACO_12_c_15());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_16_1(form_di_segnalazione_service.getFARMACO_12_c_16_1());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_16_2(form_di_segnalazione_service.getFARMACO_12_c_16_2());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_17(form_di_segnalazione_service.getFARMACO_12_c_17());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_18(form_di_segnalazione_service.getFARMACO_12_c_18());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_19(form_di_segnalazione_service.getFARMACO_12_c_19());
		form_di_segnalazione_serviceImpl.setFARMACO_12_c_20(form_di_segnalazione_service.getFARMACO_12_c_20());
		form_di_segnalazione_serviceImpl.setINDICAZIONI_21_a(form_di_segnalazione_service.getINDICAZIONI_21_a());
		form_di_segnalazione_serviceImpl.setINDICAZIONI_21_b(form_di_segnalazione_service.getINDICAZIONI_21_b());
		form_di_segnalazione_serviceImpl.setINDICAZIONI_21_c(form_di_segnalazione_service.getINDICAZIONI_21_c());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a(form_di_segnalazione_service.getFARMACO_22_a());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_23(form_di_segnalazione_service.getFARMACO_22_a_23());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_24(form_di_segnalazione_service.getFARMACO_22_a_24());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_25(form_di_segnalazione_service.getFARMACO_22_a_25());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_26_1(form_di_segnalazione_service.getFARMACO_22_a_26_1());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_26_2(form_di_segnalazione_service.getFARMACO_22_a_26_2());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_27(form_di_segnalazione_service.getFARMACO_22_a_27());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_28(form_di_segnalazione_service.getFARMACO_22_a_28());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_29(form_di_segnalazione_service.getFARMACO_22_a_29());
		form_di_segnalazione_serviceImpl.setFARMACO_22_a_30(form_di_segnalazione_service.getFARMACO_22_a_30());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b(form_di_segnalazione_service.getFARMACO_22_b());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_23(form_di_segnalazione_service.getFARMACO_22_b_23());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_24(form_di_segnalazione_service.getFARMACO_22_b_24());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_25(form_di_segnalazione_service.getFARMACO_22_b_25());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_26_1(form_di_segnalazione_service.getFARMACO_22_b_26_1());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_26_2(form_di_segnalazione_service.getFARMACO_22_b_26_2());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_27(form_di_segnalazione_service.getFARMACO_22_b_27());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_28(form_di_segnalazione_service.getFARMACO_22_b_28());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_29(form_di_segnalazione_service.getFARMACO_22_b_29());
		form_di_segnalazione_serviceImpl.setFARMACO_22_b_30(form_di_segnalazione_service.getFARMACO_22_b_30());
		form_di_segnalazione_serviceImpl.setINDICAZIONI_31_a(form_di_segnalazione_service.getINDICAZIONI_31_a());
		form_di_segnalazione_serviceImpl.setINDICAZIONI_31_b(form_di_segnalazione_service.getINDICAZIONI_31_b());
		form_di_segnalazione_serviceImpl.setUSO_32(form_di_segnalazione_service.getUSO_32());
		form_di_segnalazione_serviceImpl.setCONDIZIONI_33(form_di_segnalazione_service.getCONDIZIONI_33());
		form_di_segnalazione_serviceImpl.setALTRE_34(form_di_segnalazione_service.getALTRE_34());
		form_di_segnalazione_serviceImpl.setINDICARE_35_1(form_di_segnalazione_service.getINDICARE_35_1());
		form_di_segnalazione_serviceImpl.setINDICARE_35_2(form_di_segnalazione_service.getINDICARE_35_2());
		form_di_segnalazione_serviceImpl.setINDICARE_35_3(form_di_segnalazione_service.getINDICARE_35_3());
		form_di_segnalazione_serviceImpl.setINDICARE_35_4(form_di_segnalazione_service.getINDICARE_35_4());
		form_di_segnalazione_serviceImpl.setINDICARE_35_5(form_di_segnalazione_service.getINDICARE_35_5());
		form_di_segnalazione_serviceImpl.setINDICARE_35_6(form_di_segnalazione_service.getINDICARE_35_6());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_1(form_di_segnalazione_service.getQUALIFICA_36_1());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_2(form_di_segnalazione_service.getQUALIFICA_36_2());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_3(form_di_segnalazione_service.getQUALIFICA_36_3());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_4(form_di_segnalazione_service.getQUALIFICA_36_4());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_5(form_di_segnalazione_service.getQUALIFICA_36_5());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_6(form_di_segnalazione_service.getQUALIFICA_36_6());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_7(form_di_segnalazione_service.getQUALIFICA_36_7());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_8(form_di_segnalazione_service.getQUALIFICA_36_8());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_9(form_di_segnalazione_service.getQUALIFICA_36_9());
		form_di_segnalazione_serviceImpl.setQUALIFICA_36_10(form_di_segnalazione_service.getQUALIFICA_36_10());
		form_di_segnalazione_serviceImpl.setDATI_37_1(form_di_segnalazione_service.getDATI_37_1());
		form_di_segnalazione_serviceImpl.setDATI_37_2(form_di_segnalazione_service.getDATI_37_2());
		form_di_segnalazione_serviceImpl.setDATI_37_3(form_di_segnalazione_service.getDATI_37_3());
		form_di_segnalazione_serviceImpl.setDATI_37_4(form_di_segnalazione_service.getDATI_37_4());
		form_di_segnalazione_serviceImpl.setASL_38(form_di_segnalazione_service.getASL_38());
		form_di_segnalazione_serviceImpl.setREGIONE_39(form_di_segnalazione_service.getREGIONE_39());
		form_di_segnalazione_serviceImpl.setDATA_40(form_di_segnalazione_service.getDATA_40());
		form_di_segnalazione_serviceImpl.setFIRMA_41(form_di_segnalazione_service.getFIRMA_41());

		return form_di_segnalazione_serviceImpl;
	}

	/**
	 * Returns the form_di_segnalazione_service with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service
	 * @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchForm_di_segnalazione_serviceException {
		Form_di_segnalazione_service form_di_segnalazione_service = fetchByPrimaryKey(primaryKey);

		if (form_di_segnalazione_service == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchForm_di_segnalazione_serviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return form_di_segnalazione_service;
	}

	/**
	 * Returns the form_di_segnalazione_service with the primary key or throws a {@link NoSuchForm_di_segnalazione_serviceException} if it could not be found.
	 *
	 * @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service
	 * @throws NoSuchForm_di_segnalazione_serviceException if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service findByPrimaryKey(
		long Form_di_segnalazione_id)
		throws NoSuchForm_di_segnalazione_serviceException {
		return findByPrimaryKey((Serializable)Form_di_segnalazione_id);
	}

	/**
	 * Returns the form_di_segnalazione_service with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service, or <code>null</code> if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
				Form_di_segnalazione_serviceImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Form_di_segnalazione_service form_di_segnalazione_service = (Form_di_segnalazione_service)serializable;

		if (form_di_segnalazione_service == null) {
			Session session = null;

			try {
				session = openSession();

				form_di_segnalazione_service = (Form_di_segnalazione_service)session.get(Form_di_segnalazione_serviceImpl.class,
						primaryKey);

				if (form_di_segnalazione_service != null) {
					cacheResult(form_di_segnalazione_service);
				}
				else {
					entityCache.putResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
						Form_di_segnalazione_serviceImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
					Form_di_segnalazione_serviceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return form_di_segnalazione_service;
	}

	/**
	 * Returns the form_di_segnalazione_service with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Form_di_segnalazione_id the primary key of the form_di_segnalazione_service
	 * @return the form_di_segnalazione_service, or <code>null</code> if a form_di_segnalazione_service with the primary key could not be found
	 */
	@Override
	public Form_di_segnalazione_service fetchByPrimaryKey(
		long Form_di_segnalazione_id) {
		return fetchByPrimaryKey((Serializable)Form_di_segnalazione_id);
	}

	@Override
	public Map<Serializable, Form_di_segnalazione_service> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Form_di_segnalazione_service> map = new HashMap<Serializable, Form_di_segnalazione_service>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Form_di_segnalazione_service form_di_segnalazione_service = fetchByPrimaryKey(primaryKey);

			if (form_di_segnalazione_service != null) {
				map.put(primaryKey, form_di_segnalazione_service);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
					Form_di_segnalazione_serviceImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(Form_di_segnalazione_service)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Form_di_segnalazione_service form_di_segnalazione_service : (List<Form_di_segnalazione_service>)q.list()) {
				map.put(form_di_segnalazione_service.getPrimaryKeyObj(),
					form_di_segnalazione_service);

				cacheResult(form_di_segnalazione_service);

				uncachedPrimaryKeys.remove(form_di_segnalazione_service.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Form_di_segnalazione_serviceModelImpl.ENTITY_CACHE_ENABLED,
					Form_di_segnalazione_serviceImpl.class, primaryKey,
					nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the form_di_segnalazione_services.
	 *
	 * @return the form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form_di_segnalazione_services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @return the range of form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form_di_segnalazione_services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findAll(int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form_di_segnalazione_services.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Form_di_segnalazione_serviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of form_di_segnalazione_services
	 * @param end the upper bound of the range of form_di_segnalazione_services (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of form_di_segnalazione_services
	 */
	@Override
	public List<Form_di_segnalazione_service> findAll(int start, int end,
		OrderByComparator<Form_di_segnalazione_service> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Form_di_segnalazione_service> list = null;

		if (retrieveFromCache) {
			list = (List<Form_di_segnalazione_service>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE;

				if (pagination) {
					sql = sql.concat(Form_di_segnalazione_serviceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Form_di_segnalazione_service>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Form_di_segnalazione_service>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the form_di_segnalazione_services from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Form_di_segnalazione_service form_di_segnalazione_service : findAll()) {
			remove(form_di_segnalazione_service);
		}
	}

	/**
	 * Returns the number of form_di_segnalazione_services.
	 *
	 * @return the number of form_di_segnalazione_services
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORM_DI_SEGNALAZIONE_SERVICE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Form_di_segnalazione_serviceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form_di_segnalazione_service persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Form_di_segnalazione_serviceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE = "SELECT form_di_segnalazione_service FROM Form_di_segnalazione_service form_di_segnalazione_service";
	private static final String _SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE_PKS_IN =
		"SELECT form_di_segnalazione_service FROM Form_di_segnalazione_service form_di_segnalazione_service WHERE Form_di_segnalazione_id IN (";
	private static final String _SQL_SELECT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE = "SELECT form_di_segnalazione_service FROM Form_di_segnalazione_service form_di_segnalazione_service WHERE ";
	private static final String _SQL_COUNT_FORM_DI_SEGNALAZIONE_SERVICE = "SELECT COUNT(form_di_segnalazione_service) FROM Form_di_segnalazione_service form_di_segnalazione_service";
	private static final String _SQL_COUNT_FORM_DI_SEGNALAZIONE_SERVICE_WHERE = "SELECT COUNT(form_di_segnalazione_service) FROM Form_di_segnalazione_service form_di_segnalazione_service WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "form_di_segnalazione_service.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Form_di_segnalazione_service exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Form_di_segnalazione_service exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Form_di_segnalazione_servicePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}