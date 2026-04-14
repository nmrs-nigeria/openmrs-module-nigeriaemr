/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr.api.service;

import org.openmrs.Patient;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.nigeriaemr.NigeriaemrConfig;
import org.openmrs.module.nigeriaemr.Item;
import org.openmrs.module.nigeriaemr.model.*;
import org.openmrs.module.nigeriaemr.util.FileUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.directory.SchemaViolationException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface NigeriaemrService extends OpenmrsService {
	
	/**
	 * Returns an item by uuid. It can be called by any authenticated user. It is fetched in read
	 * only transaction.
	 * 
	 * @param id
	 * @return
	 * @throws APIException
	 */
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional(readOnly = true)
	NDRExport getNDRExportById(int id) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional(readOnly = true)
	NDRExportBatch getNDRExportBatchById(int id) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	List<NDRExport> getNDRExportByBatchIdByStatus(int batchId, String status) throws APIException;
	
	/**
	 * Saves an item. Sets the owner to superuser, if it is not set. It can be called by users with
	 * this module's privilege. It is executed in a transaction.
	 * 
	 * @param ndrExport
	 * @return
	 * @throws APIException
	 */
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	NDRExport saveNdrExportItem(NDRExport ndrExport) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	NDRExportBatch saveNdrExportBatchItem(NDRExportBatch ndrExportBatch, boolean override) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void updateNdrExportItemProcessedCount(int id, int count) throws APIException;
	
	@Transactional
	void updateStatus(int exportId, int batchId, String status, boolean done) throws APIException;
	
	@Transactional
	void updateAllStatus(String status) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExport> getExports(boolean includeVoided) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void voidExportEntry(int id) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void voidExportBatchEntry(int id) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExport> getExports(Map<String, Object> conditions, Integer size, boolean includeVoided) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	Integer getFinishedExportCount(int batchId) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExport> getDelayedProcessingExports(Map<String, Object> conditions) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	NDRExportBatch createExportBatch(Date lastExportDate, int totalPatients) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExportBatch> getExportBatchByStatus(String status, boolean includeVoided) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExportBatch> getExportBatchByStartMode(boolean startMode, boolean includeVoided) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<ndrMessageLog> getNdrMessageLogs(Integer exportId) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	NDRExportBatch updateExportBatch(int id, String status, boolean end) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void setBatchIdsFromNdr(Integer exportId, String batches) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void saveNdrApiErrorLog(ndrMessageLog messageLog) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExportBatch> getBatchExports() throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void updateBatchExport(Integer exportId, String ndrErrorLogStatus) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	public NDRExportBatch getNDRExportByZipFileName(String path) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void resetExportBatch(int id) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	public List<BiometricInfo> getBiometricInfoByPatientId(Integer patientId) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	DatimMap getDatatimMapByDataimId(String datimId) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void deleteExports(int idInt) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	String getSqlVersion() throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void saveBiometricInfo(BiometricInfo biometricInfo);
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	public void deleteBiometricInfoByPatientId(Integer patientId) throws APIException;
}
