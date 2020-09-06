/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaemrDao;
import org.openmrs.module.nigeriaemr.api.service.impl.NigeriaemrServiceImpl;
import org.openmrs.module.nigeriaemr.model.NDRExport;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * This is a unit test, which verifies logic in NigeriaemrService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class NigeriaemrServiceTest {
	
	@InjectMocks
	NigeriaemrServiceImpl basicModuleService;
	
	@Mock
	NigeriaemrDao dao;
	
	@Mock
	UserService userService;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Ignore
	public void saveItem_shouldSetOwnerIfNotSet() {
		//Given
		NDRExport item = new NDRExport();
		item.setPath("some description");
		
		when(dao.saveNdrExport(item)).thenReturn(item);
		
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		
		//When
		basicModuleService.saveNdrExportItem(item);
		
		//Then
		assertThat(item, hasProperty("owner", is(user)));
	}
}
