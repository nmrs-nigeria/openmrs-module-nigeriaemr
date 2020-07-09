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
import org.openmrs.module.nigeriaemr.model.BiometricInfo;
import org.openmrs.module.nigeriaemr.model.NDRExport;
import org.springframework.transaction.annotation.Transactional;

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
	@Authorized()
	@Transactional(readOnly = true)
	NDRExport getNDRExportById(int id) throws APIException;
	
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
	
	//	@Authorized()
	@Transactional
	void updateNdrExportItemProcessedCount(int id, int count) throws APIException;
	
	@Transactional
	void updateStatus(int id, String status) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	List<NDRExport> getExports(boolean includeVoided) throws APIException;
	
	@Authorized(NigeriaemrConfig.MODULE_PRIVILEGE)
	@Transactional
	void voidExportEntry(int id) throws APIException;
	
	//	@Authorized()
	@Transactional
	List<NDRExport> getExports(Map<String, Object> conditions, boolean includeVoided) throws APIException;
	
	@Authorized
	@Transactional
	public List<BiometricInfo> getBiometricInfoByPatientId(Integer patientId) throws APIException;
	
}
