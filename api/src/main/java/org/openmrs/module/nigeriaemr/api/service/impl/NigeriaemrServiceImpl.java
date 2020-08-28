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
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.openmrs.module.nigeriaemr.model.NDRExportBatch;

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
	public NDRExport saveNdrExportItem(NDRExport ndrExport) throws APIException {
		if (ndrExport.getOwner() == null) {
			ndrExport.setOwner(userService.getUser(1));
		}
		return dao.saveNdrExport(ndrExport);
	}
	
	@Override
	public void updateNdrExportItemProcessedCount(int id, int count) throws APIException {
		NDRExport ndrExport = getNDRExportById(id);
		if (ndrExport != null) {
			ndrExport.setDateEnded(new Date());
			ndrExport.setPatientsProcessed(count);
			dao.saveNdrExport(ndrExport);
		}
	}
	
	@Override
	public void updateStatus(int id, String status) throws APIException {
		NDRExport ndrExport = getNDRExportById(id);
		if (ndrExport != null) {
			ndrExport.setDateEnded(new Date());
			ndrExport.setStatus(status);
			dao.saveNdrExport(ndrExport);
		}
	}
	
	@Override
	public List<NDRExport> getExports(Map<String, Object> conditions, boolean includeVoided) throws APIException {
		return dao.getExports(conditions, includeVoided);
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
	public List<NDRExportBatch> getExportBatchByStatus(String status) throws APIException {
		return dao.getExportBatchByStatus(status);
	}
	
	@Override
	public NDRExportBatch updateExportBatch(int id, String status) throws APIException {
		NDRExportBatch ndrExportBatch = dao.getExportBatch(id);
		ndrExportBatch.setStatus(status);
		return dao.save(ndrExportBatch);
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
	
}
