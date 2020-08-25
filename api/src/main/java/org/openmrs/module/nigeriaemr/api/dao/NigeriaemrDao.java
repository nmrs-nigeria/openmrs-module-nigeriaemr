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
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.nigeriaemr.Item;
import org.openmrs.module.nigeriaemr.model.DatimMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public class NigeriaemrDao {
	
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Item getItemByUuid(String uuid) {
		return (Item) getSession().createCriteria(Item.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public Item saveItem(Item item) {
		getSession().saveOrUpdate(item);
		return item;
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
