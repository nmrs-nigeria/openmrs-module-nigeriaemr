/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr.api.service.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.nigeriaemr.Item;
import org.openmrs.module.nigeriaemr.api.service.NigeriaemrService;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaemrDao;
import org.openmrs.module.nigeriaemr.model.*;

import javax.naming.directory.SchemaViolationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class NigeriaemrServiceImpl extends BaseOpenmrsService implements NigeriaemrService {
	
	NigeriaemrDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(NigeriaemrDao dao) {
		this.dao = dao;
	}
	
	@Override
	public NDRExport getNDRExportById(int id) throws APIException {
		NDRExport ndrExport = null;
		try {
			ndrExport = dao.getNDRExportById(id);
		}
		catch (Exception e) {
			//log error
		}
		return ndrExport;
	}
	
	@Override
	public NDRExportBatch getNDRExportBatchById(int id) throws APIException {
		NDRExportBatch ndrExportBatch = null;
		try {
			ndrExportBatch = dao.getNDRExportBatchById(id);
		}
		catch (Exception e) {
			//log error
		}
		return ndrExportBatch;
	}
	
	@Override
	public List<NDRExport> getNDRExportByBatchIdByStatus(int batchId, String status) throws APIException {
		return dao.getNDRExportByBatchIdByStatus(batchId, status);
	}
	
	@Override
	public NDRExport saveNdrExportItem(NDRExport ndrExport) throws APIException {
		if (ndrExport.getOwner() == null) {
			ndrExport.setOwner(Context.getUserService().getUser(1));
		}
		return dao.saveNdrExport(ndrExport);
	}
	
	@Override
	public synchronized NDRExportBatch saveNdrExportBatchItem(NDRExportBatch ndrExportBatch, boolean override)
	        throws APIException {
		NDRExportBatch old = null;
		if (ndrExportBatch.getId() != null)
			old = dao.getNDRExportBatchById(ndrExportBatch.getId());
		if (old == null
		        || !("Restarted".equalsIgnoreCase(old.getStatus()) && "Done".equalsIgnoreCase(ndrExportBatch.getStatus()))) {
			return dao.save(ndrExportBatch);
		} else if (override) {
			return dao.save(ndrExportBatch);
		}
		return ndrExportBatch;
	}
	
	@Override
	public void updateNdrExportItemProcessedCount(int id, int count) throws APIException {
		NDRExportBatch ndrExportBatch = getNDRExportBatchById(id);
		if (ndrExportBatch != null) {
			if (ndrExportBatch.getPatientsProcessed() != null) {
				int oldCount = ndrExportBatch.getPatientsProcessed();
				ndrExportBatch.setPatientsProcessed(oldCount + count);
			} else {
				ndrExportBatch.setPatientsProcessed(count);
			}
			dao.save(ndrExportBatch);
		}
	}
	
	@Override
	public void updateStatus(int exportId, int batchId, String status, boolean done) throws APIException {
		dao.updateStatus(exportId, batchId, status, done);
	}
	
	@Override
	public void updateAllStatus(String status) throws APIException {
		dao.updateAllStatus(status);
	}
	
	@Override
	public List<NDRExport> getExports(Map<String, Object> conditions, Integer size, boolean includeVoided)
	        throws APIException {
		return dao.getExports(conditions, size, includeVoided);
	}
	
	@Override
	public Integer getFinishedExportCount(int batchId) throws APIException {
		return dao.getFinishedExportCount(batchId, false);
	}
	
	@Override
	public List<NDRExport> getDelayedProcessingExports(Map<String, Object> conditions) throws APIException {
		return dao.getDelayedProcessingExports(conditions);
	}
	
	@Override
	public NDRExportBatch createExportBatch(Date lastExportDate, int totalPatients) throws APIException {
		NDRExportBatch ndrExportBatch = new NDRExportBatch();
		ndrExportBatch.setDateCreated(new Date());
		ndrExportBatch.setDateUpdated(new Date());
		ndrExportBatch.setLastExportDate(lastExportDate);
		ndrExportBatch.setStatus("Created");
		ndrExportBatch.setPatients(totalPatients);
		ndrExportBatch.setOwner(Context.getAuthenticatedUser());
		return dao.save(ndrExportBatch);
	}
	
	@Override
	public List<NDRExportBatch> getExportBatchByStatus(String status, boolean includeVoided) throws APIException {
		return dao.getExportBatchByStatus(status, includeVoided);
	}
	
	@Override
	public List<NDRExportBatch> getExportBatchByStartMode(boolean startMode, boolean includeVoided) throws APIException {
		return dao.getExportBatchByStartMode(startMode, includeVoided);
	}
	
	public void saveNdrApiErrorLog(ndrMessageLog messageLog) throws APIException {
		dao.saveNdrApiErrorLog(messageLog);
	}
	
	public List<ndrMessageLog> getNdrMessageLogs(Integer exportId) throws APIException {
		return dao.getNdrMessageLogs(exportId);
	}
	
	public NDRExportBatch getNDRExportBatch(Integer exportId) throws APIException {
		return dao.getNDRExportBatch(exportId);
	}
	
	public NDRExportBatch getNDRExportByZipFileName(String path) throws APIException {
		return dao.getNDRExportByZipFileName(path);
	}
	
	public void setBatchIdsFromNdr(Integer exportId, String batches) throws APIException {
		dao.setBatchIdsFromNdr(exportId, batches);
	}
	
	public List<NDRExportBatch> getBatchExports() throws APIException {
		return dao.getBatchExports();
	}
	
	public void updateBatchExport(Integer exportId, String ndrErrorLogStatus) throws APIException {
		dao.updateBatchExport(exportId, ndrErrorLogStatus);
	}
	
	@Override
	public NDRExportBatch updateExportBatch(int id, String status, boolean end) throws APIException {
		NDRExportBatch ndrExportBatch = dao.getExportBatch(id);
		ndrExportBatch.setStatus(status);
		ndrExportBatch.setDateUpdated(new Date());
		if (end)
			ndrExportBatch.setDateEnded(new Date());
		return dao.save(ndrExportBatch);
	}
	
	@Override
	public void resetExportBatch(int id) throws APIException {
		NDRExportBatch ndrExportBatch = dao.getExportBatch(id);
		ndrExportBatch.setStatus("Processing");
		ndrExportBatch.setDateUpdated(new Date());
		ndrExportBatch.setDateCreated(new Date());
		ndrExportBatch.setPatientsProcessed(0);
		dao.save(ndrExportBatch);
	}
	
	@Override
	public List<BiometricInfo> getBiometricInfoByPatientId(Integer patientId) throws APIException {
		return dao.getBiometricInfoByPatientId(patientId);
	}
	
	@Override
	public List<NDRExport> getExports(boolean includeVoided) throws APIException {
		return dao.getExports(includeVoided);
	}
	
	@Override
	public void voidExportEntry(int id) throws APIException {
		NDRExport ndrExport = getNDRExportById(id);
		ndrExport.setVoided(true);
		dao.saveNdrExport(ndrExport);
	}
	
	@Override
	public void voidExportBatchEntry(int id) throws APIException {
		NDRExportBatch ndrExportBatch = getNDRExportBatchById(id);
		ndrExportBatch.setVoided(true);
		dao.save(ndrExportBatch);
	}
	
	@Override
	public DatimMap getDatatimMapByDataimId(String datimId) throws APIException {
		return dao.getDatatimMapByDataimId(datimId);
	}
	
	@Override
	public void deleteExports(int batchId) throws APIException {
		dao.deleteExports(batchId);
	}
	
	@Override
	public String getSqlVersion() throws APIException {
		return dao.getSqlVersion();
	}
	
	@Override
	public void saveBiometricInfo(BiometricInfo biometricInfo) {
		dao.saveBiometricInfo(biometricInfo);
	}
	
	@Override
	public void deleteBiometricInfoByPatientId(Integer patientId) throws APIException {
		dao.deleteBiometricInfo(patientId);
	}
}
