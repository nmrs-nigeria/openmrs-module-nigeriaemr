/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr.api.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.APIException;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;

import java.util.List;
import java.util.Map;
import org.openmrs.module.nigeriaemr.model.DatimMap;

public class NigeriaemrDao {
	
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public NDRExport getNDRExportById(int id) {
		return (NDRExport) getSession().createCriteria(NDRExport.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public NDRExport saveNdrExport(NDRExport ndrExport) {
		getSession().saveOrUpdate(ndrExport);
		return ndrExport;
	}
	
	@SuppressWarnings("unchecked")
	public List<NDRExport> getExports(boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(NDRExport.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		criteria.addOrder(Order.desc("dateStarted"));
		return criteria.list();
	}
	
	public List<NDRExport> getExports(Map<String, Object> conditions, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(NDRExport.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		for (String key : conditions.keySet()) {
			criteria.add(Restrictions.eq(key, conditions.get(key)));
		}
		criteria.addOrder(Order.desc("dateStarted"));
		return criteria.list();
	}
	
	public List<BiometricInfo> getBiometricInfoByPatientId(Integer patientId) throws DAOException {
		Criteria criteria = getSession().createCriteria(BiometricInfo.class);
		criteria.add(Restrictions.eq("patientId", patientId));
		return criteria.list();
	}
	
	public NDRExportBatch save(NDRExportBatch ndrExportBatch) throws APIException {
		getSession().saveOrUpdate(ndrExportBatch);
		return ndrExportBatch;
	}
	
	public List<NDRExportBatch> getExportBatchByStatus(String status) throws APIException {
		Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
		criteria.add(Restrictions.eq("status", status));
		criteria.addOrder(Order.desc("dateCreated"));
		return criteria.list();
	}
	
	public NDRExportBatch getExportBatch(int id) throws APIException {
		Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.addOrder(Order.desc("dateCreated"));
		return (NDRExportBatch) criteria.uniqueResult();
	}
	
	public DatimMap getDatatimMapByDataimId(String datimId) {
		Criteria criteria = getSession().createCriteria(DatimMap.class);
		criteria.add(Restrictions.eq("datimCode", datimId));
		criteria.setFetchSize(1);
		List<DatimMap> datimMapList = (List<DatimMap>) criteria.list();
		if (datimMapList.size() > 0)
			return datimMapList.get(0);
		return null;
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
