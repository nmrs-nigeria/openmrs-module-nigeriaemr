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
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.APIException;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.nigeriaemr.model.*;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NigeriaemrDao {
	
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public NDRExport getNDRExportById(int id) {
		return (NDRExport) getSession().createCriteria(NDRExport.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public NDRExportBatch getNDRExportBatchById(int id) {
		return (NDRExportBatch) getSession().createCriteria(NDRExportBatch.class).add(Restrictions.eq("id", id))
		        .uniqueResult();
	}
	
	public NDRExport saveNdrExport(NDRExport ndrExport) {
		getSession().evict(ndrExport);
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
	
	public List<NDRExport> getExports(Map<String, Object> conditions, Integer size, boolean includeVoided)
	        throws DAOException {
		Criteria criteria = getSession().createCriteria(NDRExport.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		for (String key : conditions.keySet()) {
			criteria.add(Restrictions.eq(key, conditions.get(key)));
		}
		criteria.addOrder(Order.desc("dateStarted"));
		//		criteria.setFetchSize(size);
		if (size != null && size > 0)
			criteria.setMaxResults(size);
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
	
	public List<NDRExportBatch> getExportBatchByStatus(String status, boolean includeVoided) throws APIException {
		Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}
		if (!includeVoided)
			criteria.add(Restrictions.eq("voided", false));
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
	
	public void updateStatus(int exportId, int batchId, String status, boolean done) {
		StringBuilder sb = new StringBuilder(
		        "update nigeriaemr_ndr_export set status = :status, date_updated = :dateUpdated");
		
		if (done)
			sb.append(", date_ended = :dateEnded");
		
		sb.append(" where batch_id = :batchId");
		if (exportId > 0)
			sb.append(" and nigeriaemr_ndr_export_id = :exportId");
		
		SQLQuery sql = getSession().createSQLQuery(sb.toString());
		
		sql.setString("status", status);
		if (exportId > 0)
			sql.setInteger("exportId", exportId);
		sql.setInteger("batchId", batchId);
		sql.setTimestamp("dateUpdated", new Date());
		if (done)
			sql.setTimestamp("dateEnded", new Date());
		sql.executeUpdate();
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<NDRExport> getDelayedProcessingExports(Map<String, Object> conditions) {
		
		StringBuilder query = new StringBuilder("SELECT distinct(N.nigeriaemr_ndr_export_id) FROM nigeriaemr_ndr_export N "
		        + " WHERE TIMESTAMPDIFF(MINUTE,N.date_updated,NOW()) > 15 ");
		for (String key : conditions.keySet()) {
			query.append(" AND N.").append(key).append(" = ").append(conditions.get(key));
		}
		
		SQLQuery sql = getSession().createSQLQuery(query.toString());
		
		List<Integer> exportId = sql.list();

		if(exportId.size()>0) {
			Criteria criteria = getSession().createCriteria(NDRExport.class);
			criteria.add(Restrictions.in("id", exportId));

			return criteria.list();
		}
		return new ArrayList<>();
	}
	
	public void deleteExports(int batchId) {
		SQLQuery sql = getSession().createSQLQuery("delete from nigeriaemr_ndr_export where batch_id = :batchId ");
		sql.setInteger("batchId", batchId);
		sql.executeUpdate();
	}
	
	public Integer getFinishedExportCount(Integer batchId, boolean includeVoided) {
		SQLQuery sql = getSession().createSQLQuery(
		    "select count(*) from nigeriaemr_ndr_export where batch_id = :batchId and status in ('Failed', 'Done') ");
		sql.setInteger("batchId", batchId);
		return ((BigInteger) sql.uniqueResult()).intValue();
	}
	
	public void updateAllStatus(String status) {
		SQLQuery sql = getSession().createSQLQuery(
		    "update nigeriaemr_ndr_batch_export set status = :status where status = 'Processing'");
		sql.setString("status", status);
		sql.executeUpdate();
	}
	
	public void setBatchIdsFromNdr(Integer exportId, String batches) {
		SQLQuery sql = getSession()
		        .createSQLQuery(
		            "update nigeriaemr_ndr_batch_export set ndr_batch_ids = :ndrBatchIds, errorLogsPulled = :errorLogsPulled where nigeriaemr_ndr_batch_export_id = :exportId");
		sql.setString("ndrBatchIds", batches);
		sql.setInteger("exportId", exportId);
		sql.setString("errorLogsPulled", "no");
		sql.executeUpdate();
	}
	
	public void updateBatchExport(Integer exportId, String ndrErrorLogStatus) {
		SQLQuery sql = getSession()
		        .createSQLQuery(
		            "update nigeriaemr_ndr_batch_export set errorLogsPulled = :errorLogsPulled where nigeriaemr_ndr_batch_export_id = :exportId");
		sql.setInteger("exportId", exportId);
		sql.setString("errorLogsPulled", ndrErrorLogStatus);
		sql.executeUpdate();
	}
	
	public List<NDRExportBatch> getBatchExports()
	{
		try{
			Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
			criteria.add(Restrictions.isNotNull("ndrBatchIds"));
//			criteria.add(Restrictions.isNotEmpty("ndrBatchIds"));
//			criteria.add(Restrictions.sizeGt("ndrBatchIds", 0));
			criteria.add(Restrictions.eq("errorLogsPulled", "no"));
			criteria.addOrder(Order.desc("dateCreated"));
			return criteria.list();
		}
		catch (Exception e)
		{
			LoggerUtils.write(NigeriaemrDao.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
					LoggerUtils.LogLevel.live);
			return new ArrayList<>();
		}
	}
	
	public List<NDRExport> getNDRExportByBatchIdByStatus(int batchId, String status)
	{
		Criteria criteria = getSession().createCriteria(NDRExport.class);
		criteria.add(Restrictions.eq("batchId", batchId));
		criteria.add(Restrictions.eq("status", status));
		List<NDRExport> ndrExports = criteria.list();
		if(ndrExports != null && ndrExports.size() > 0) return ndrExports;
		return new ArrayList<>();
	}
	
	public NDRExportBatch getNDRExportByZipFileName(String path) {
		try {
			Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
			criteria.add(Restrictions.eq("path", path));
			List<NDRExportBatch> ndrBatchExports = criteria.list();
			if (ndrBatchExports != null && ndrBatchExports.size() > 0)
				return ndrBatchExports.get(0);
			return new NDRExportBatch();
		}
		catch (APIException e) {
			LoggerUtils.write(NigeriaemrDao.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
			    LoggerUtils.LogLevel.live);
			return new NDRExportBatch();
		}
	}
	
	public NDRExportBatch getNDRExportBatch(int exportId) {
		Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
		criteria.add(Restrictions.eq("id", exportId));
		List<NDRExportBatch> ndrExports = criteria.list();
		if (ndrExports != null && ndrExports.size() > 0)
			return ndrExports.get(0);
		return new NDRExportBatch();
	}
	
	public List<ndrMessageLog> getNdrMessageLogs(int exportId)
	{
		System.out.println("\ngetNdrMessageLogs exportId: " + exportId);

		Criteria criteria = getSession().createCriteria(ndrMessageLog.class);
		criteria.add(Restrictions.eq("exportId", exportId));
		List<ndrMessageLog> ndrMessageLogs = criteria.list();
		if(ndrMessageLogs != null && ndrMessageLogs.size() > 0)
		{
			return ndrMessageLogs;
		}

		return new ArrayList<>();
	}
	
	public List<NDRExportBatch> getExportBatchByStartMode(boolean startMode, boolean includeVoided)
	{
		try
		{
			Criteria criteria = getSession().createCriteria(NDRExportBatch.class);
			criteria.add(Restrictions.eq("automatic", startMode));
			if (!includeVoided)
				criteria.add(Restrictions.eq("voided", false));
			criteria.addOrder(Order.desc("dateCreated"));

			List<NDRExportBatch> lst = criteria.list();

			return lst;
		}
		catch (Exception e)
		{
			LoggerUtils.write(NigeriaemrDao.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
					LoggerUtils.LogLevel.live);

			return new ArrayList<>();
		}
	}
	
	public String getSqlVersion() {
		try {
			SQLQuery sql = getSession().createSQLQuery("Select version() as version");
			if (sql.uniqueResult() != null) {
				return (String) sql.uniqueResult();
			}
		}
		catch (Exception e) {
			LoggerUtils.write(NigeriaemrDao.class.getName(), e.getMessage(), LoggerUtils.LogFormat.INFO,
			    LoggerUtils.LogLevel.live);
		}
		return "5.7.21-log";
	}
	
	public void saveBiometricInfo(BiometricInfo biometricInfo) throws APIException {
		Criteria criteria = getSession().createCriteria(BiometricInfo.class);
		criteria.add(Restrictions.eq("patientId", biometricInfo.getPatientId()));
		criteria.add(Restrictions.eq("fingerPosition", biometricInfo.getFingerPosition()));
		
		List<BiometricInfo> biometricInfos = criteria.list();
		String sqlString = "insert into  biometricinfo (patient_Id, imageWidth, imageHeight, imageDPI,  "
		        + "imageQuality, fingerPosition, serialNumber, model, manufacturer, creator, date_created, new_template, template)"
		        + "Values(:patientId,:imageWidth,:imageHeight,:imageDPI,:imageQuality,:fingerPosition,:serialNumber,:model,:manufacturer,:creator,:dateCreated,:newTemplate,:template)";
		if (biometricInfos.size() > 0) {
			sqlString = "UPDATE biometricinfo SET " + "patient_Id = :patientId, " + "imageWidth = :imageWidth, "
			        + "imageHeight = :imageHeight, " + "imageDPI = :imageDPI, " + "imageQuality = :imageQuality, "
			        + "fingerPosition = :fingerPosition, " + "serialNumber = :serialNumber, " + "model = :model, "
			        + "manufacturer = :manufacturer, " + "creator = :creator, " + "date_created = :dateCreated, "
			        + "new_template = :newTemplate, "
			        + "template = :template WHERE patient_id = :patientId AND fingerPosition = :fingerPosition ";
		}
		SQLQuery sql = getSession().createSQLQuery(sqlString);
		sql.setInteger("patientId", biometricInfo.getPatientId());
		sql.setInteger("imageWidth", biometricInfo.getImageWidth());
		sql.setInteger("imageHeight", biometricInfo.getImageHeight());
		sql.setInteger("imageDPI", biometricInfo.getImageDPI());
		sql.setInteger("imageQuality", biometricInfo.getImageQuality());
		sql.setString("fingerPosition", biometricInfo.getFingerPosition());
		sql.setString("serialNumber", biometricInfo.getSerialNumber());
		sql.setString("manufacturer", biometricInfo.getManufacturer());
		sql.setTimestamp("dateCreated", biometricInfo.getDateCreated());
		sql.setBinary("newTemplate", biometricInfo.getTemplate().getBytes());
		sql.setString("template", null);
		sql.setString("model", biometricInfo.getModel());
		sql.setInteger("creator", 1);
		sql.executeUpdate();
	}
	
	public void deleteBiometricInfo(Integer patientId) {
		SQLQuery sql = getSession().createSQLQuery("delete from biometricinfo where patient_id = :patientId ");
		sql.setInteger("patientId", patientId);
		sql.executeUpdate();
	}
	
	public void saveNdrApiErrorLog(ndrMessageLog messageLog) throws APIException {
		String sqlString = "insert into ndr_message_logs (exportId, message, patientIdentifier, fileName, dateCreated,batchNumber)"
		        + "Values(:exportId,:message,:patientIdentifier,:fileName,:dateCreated,:batchNumber)";
		
		SQLQuery sql = getSession().createSQLQuery(sqlString);
		sql.setInteger("exportId", messageLog.getExportId());
		sql.setString("message", messageLog.getMessage());
		sql.setString("patientIdentifier", messageLog.getPatientIdentifier());
		sql.setString("fileName", messageLog.getFileName());
		sql.setDate("dateCreated", messageLog.getDateCreated());
		sql.setString("batchNumber", messageLog.getBatchNumber());
		sql.executeUpdate();
	}
}
