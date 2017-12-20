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

package com.dsi.intranet.eprocurement.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for EprocurementLocation. This utility wraps
 * {@link com.dsi.intranet.eprocurement.service.impl.EprocurementLocationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author CIGNEX Technologies
 * @see EprocurementLocationLocalService
 * @see com.dsi.intranet.eprocurement.service.base.EprocurementLocationLocalServiceBaseImpl
 * @see com.dsi.intranet.eprocurement.service.impl.EprocurementLocationLocalServiceImpl
 * @generated
 */
@ProviderType
public class EprocurementLocationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dsi.intranet.eprocurement.service.impl.EprocurementLocationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the eprocurement location to the database. Also notifies the appropriate model listeners.
	*
	* @param eprocurementLocation the eprocurement location
	* @return the eprocurement location that was added
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation addEprocurementLocation(
		com.dsi.intranet.eprocurement.model.EprocurementLocation eprocurementLocation) {
		return getService().addEprocurementLocation(eprocurementLocation);
	}

	/**
	* Creates a new eprocurement location with the primary key. Does not add the eprocurement location to the database.
	*
	* @param locationId the primary key for the new eprocurement location
	* @return the new eprocurement location
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation createEprocurementLocation(
		java.lang.String locationId) {
		return getService().createEprocurementLocation(locationId);
	}

	/**
	* Deletes the eprocurement location from the database. Also notifies the appropriate model listeners.
	*
	* @param eprocurementLocation the eprocurement location
	* @return the eprocurement location that was removed
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation deleteEprocurementLocation(
		com.dsi.intranet.eprocurement.model.EprocurementLocation eprocurementLocation) {
		return getService().deleteEprocurementLocation(eprocurementLocation);
	}

	/**
	* Deletes the eprocurement location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location that was removed
	* @throws PortalException if a eprocurement location with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation deleteEprocurementLocation(
		java.lang.String locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEprocurementLocation(locationId);
	}

	public static com.dsi.intranet.eprocurement.model.EprocurementLocation fetchEprocurementLocation(
		java.lang.String locationId) {
		return getService().fetchEprocurementLocation(locationId);
	}

	/**
	* Returns the eprocurement location with the primary key.
	*
	* @param locationId the primary key of the eprocurement location
	* @return the eprocurement location
	* @throws PortalException if a eprocurement location with the primary key could not be found
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation getEprocurementLocation(
		java.lang.String locationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEprocurementLocation(locationId);
	}

	/**
	* Updates the eprocurement location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eprocurementLocation the eprocurement location
	* @return the eprocurement location that was updated
	*/
	public static com.dsi.intranet.eprocurement.model.EprocurementLocation updateEprocurementLocation(
		com.dsi.intranet.eprocurement.model.EprocurementLocation eprocurementLocation) {
		return getService().updateEprocurementLocation(eprocurementLocation);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of eprocurement locations.
	*
	* @return the number of eprocurement locations
	*/
	public static int getEprocurementLocationsCount() {
		return getService().getEprocurementLocationsCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the eprocurement locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dsi.intranet.eprocurement.model.impl.EprocurementLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eprocurement locations
	* @param end the upper bound of the range of eprocurement locations (not inclusive)
	* @return the range of eprocurement locations
	*/
	public static java.util.List<com.dsi.intranet.eprocurement.model.EprocurementLocation> getEprocurementLocations(
		int start, int end) {
		return getService().getEprocurementLocations(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void clearService() {
		_service = null;
	}

	public static EprocurementLocationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EprocurementLocationLocalService.class.getName());

			if (invokableLocalService instanceof EprocurementLocationLocalService) {
				_service = (EprocurementLocationLocalService)invokableLocalService;
			}
			else {
				_service = new EprocurementLocationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EprocurementLocationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static EprocurementLocationLocalService _service;
}