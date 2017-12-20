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

import com.dsi.intranet.eprocurement.model.EprocurementLocationClp;
import com.dsi.intranet.eprocurement.model.EprocurementRequestClp;
import com.dsi.intranet.eprocurement.model.ItemClp;
import com.dsi.intranet.eprocurement.model.RequestAttachmentClp;
import com.dsi.intranet.eprocurement.model.WorkflowDefinitionClp;
import com.dsi.intranet.eprocurement.model.WorkflowRequestClp;
import com.dsi.intranet.eprocurement.model.WorkflowReviewClp;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CIGNEX Technologies
 */
@ProviderType
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"e-procurement-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"e-procurement-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "e-procurement-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EprocurementLocationClp.class.getName())) {
			return translateInputEprocurementLocation(oldModel);
		}

		if (oldModelClassName.equals(EprocurementRequestClp.class.getName())) {
			return translateInputEprocurementRequest(oldModel);
		}

		if (oldModelClassName.equals(ItemClp.class.getName())) {
			return translateInputItem(oldModel);
		}

		if (oldModelClassName.equals(RequestAttachmentClp.class.getName())) {
			return translateInputRequestAttachment(oldModel);
		}

		if (oldModelClassName.equals(WorkflowDefinitionClp.class.getName())) {
			return translateInputWorkflowDefinition(oldModel);
		}

		if (oldModelClassName.equals(WorkflowRequestClp.class.getName())) {
			return translateInputWorkflowRequest(oldModel);
		}

		if (oldModelClassName.equals(WorkflowReviewClp.class.getName())) {
			return translateInputWorkflowReview(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputEprocurementLocation(
		BaseModel<?> oldModel) {
		EprocurementLocationClp oldClpModel = (EprocurementLocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprocurementLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEprocurementRequest(
		BaseModel<?> oldModel) {
		EprocurementRequestClp oldClpModel = (EprocurementRequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEprocurementRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputItem(BaseModel<?> oldModel) {
		ItemClp oldClpModel = (ItemClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getItemRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRequestAttachment(BaseModel<?> oldModel) {
		RequestAttachmentClp oldClpModel = (RequestAttachmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRequestAttachmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkflowDefinition(BaseModel<?> oldModel) {
		WorkflowDefinitionClp oldClpModel = (WorkflowDefinitionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkflowDefinitionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkflowRequest(BaseModel<?> oldModel) {
		WorkflowRequestClp oldClpModel = (WorkflowRequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkflowRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkflowReview(BaseModel<?> oldModel) {
		WorkflowReviewClp oldClpModel = (WorkflowReviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkflowReviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.EprocurementLocationImpl")) {
			return translateOutputEprocurementLocation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.EprocurementRequestImpl")) {
			return translateOutputEprocurementRequest(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.ItemImpl")) {
			return translateOutputItem(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.RequestAttachmentImpl")) {
			return translateOutputRequestAttachment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.WorkflowDefinitionImpl")) {
			return translateOutputWorkflowDefinition(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.WorkflowRequestImpl")) {
			return translateOutputWorkflowRequest(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.dsi.intranet.eprocurement.model.impl.WorkflowReviewImpl")) {
			return translateOutputWorkflowReview(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			ObjectInputStream objectInputStream = null;
			ObjectOutputStream objectOutputStream = null;

			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				return throwable;
			}
			catch (ClassNotFoundException cnfe) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
			finally {
				if (objectOutputStream != null) {
					try {
						objectOutputStream.close();
					}
					catch (Throwable throwable2) {
						_log.error(throwable2, throwable2);

						return throwable2;
					}
				}

				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					}
					catch (Throwable throwable2) {
						_log.error(throwable2, throwable2);

						return throwable2;
					}
				}
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchLocationException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchLocationException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchRequestException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchRequestException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchItemException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchItemException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchRequestAttachmentException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchWorkflowDefinitionException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchWorkflowRequestException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException")) {
			return new com.dsi.intranet.eprocurement.exception.NoSuchWorkflowReviewException(throwable.getMessage(),
				throwable.getCause());
		}

		return throwable;
	}

	public static Object translateOutputEprocurementLocation(
		BaseModel<?> oldModel) {
		EprocurementLocationClp newModel = new EprocurementLocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprocurementLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEprocurementRequest(
		BaseModel<?> oldModel) {
		EprocurementRequestClp newModel = new EprocurementRequestClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEprocurementRequestRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputItem(BaseModel<?> oldModel) {
		ItemClp newModel = new ItemClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setItemRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRequestAttachment(BaseModel<?> oldModel) {
		RequestAttachmentClp newModel = new RequestAttachmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRequestAttachmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkflowDefinition(
		BaseModel<?> oldModel) {
		WorkflowDefinitionClp newModel = new WorkflowDefinitionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkflowDefinitionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkflowRequest(BaseModel<?> oldModel) {
		WorkflowRequestClp newModel = new WorkflowRequestClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkflowRequestRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkflowReview(BaseModel<?> oldModel) {
		WorkflowReviewClp newModel = new WorkflowReviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkflowReviewRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}