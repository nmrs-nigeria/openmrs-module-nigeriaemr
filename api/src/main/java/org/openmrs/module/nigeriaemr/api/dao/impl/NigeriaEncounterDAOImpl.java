package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernateEncounterDAO;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaEncounterDAO;
import org.openmrs.module.nigeriaemr.model.ndr.EncountersType;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NigeriaEncounterDAOImpl extends HibernateEncounterDAO implements NigeriaEncounterDAO {
	
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Encounter> getEncountersByPatient(Patient patient, Date fromDate, Date toDate) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		
		if (patient != null && patient.getPatientId() != null) {
			criteria.add(Restrictions.eq("patient", patient));
		}
		if (fromDate != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", fromDate), Restrictions.ge("dateChanged", fromDate)));
		}
		
		if (toDate != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", toDate), Restrictions.le("dateChanged", toDate)));
		}
		criteria.add(Restrictions.eq("voided", false));
		
		criteria.addOrder(Order.asc("encounterDatetime"));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Encounter> getEncountersByEncounterDate(Date fromDate, Date toDate) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		
		if (fromDate != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", fromDate), Restrictions.ge("dateChanged", fromDate)));
		}
		
		if (toDate != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", toDate), Restrictions.le("dateChanged", toDate)));
		}
		criteria.add(Restrictions.eq("voided", false));
		return criteria.list();
	}
	
	@Override
	public Encounter getLastEncounterByPatient(Patient patient, Date fromDate, Date toDate) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		criteria.add(Restrictions.ge("patient", patient));
		if (fromDate != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", fromDate), Restrictions.ge("dateChanged", fromDate)));
		}
		
		if (toDate != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", toDate), Restrictions.le("dateChanged", toDate)));
		}
		criteria.add(Restrictions.eq("voided", false));
		criteria.addOrder(Order.desc("encounterDatetime"));
		criteria.setFetchSize(1);
		if (criteria.list().size() > 0)
			return (Encounter) criteria.list().get(0);
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Encounter> getEncountersByEncounterTypeIds(Patient patient, Date fromDate, Date toDate,
	        List<Integer> encounterTypeIds, boolean asc, int size) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		criteria.add(Restrictions.eq("voided", false));
		if (patient != null && patient.getPatientId() != null) {
			criteria.add(Restrictions.eq("patient", patient));
		}
		
		if (fromDate != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", fromDate), Restrictions.ge("dateChanged", fromDate)));
		}
		
		if (toDate != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", toDate), Restrictions.le("dateChanged", toDate)));
		}
		
		if (encounterTypeIds.size() > 0) {
			criteria.add(Restrictions.in("encounterType.encounterTypeId", encounterTypeIds));
		}
		
		if (asc) {
			criteria.addOrder(Order.asc("encounterDatetime"));
		} else {
			criteria.addOrder(Order.desc("encounterDatetime"));
		}
		if (size > 0) {
			criteria.setFetchSize(size);
		}
		return criteria.list();
	}
	
	@Override
	public List<Encounter> getEncountersByEncounterIds(List<Integer> encounterIds) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		criteria.add(Restrictions.in("encounterId", encounterIds));
		return criteria.list();
	}
	
	@Override
	public Encounter getEncounterByEncounterType(Patient patient, int encounterTypeId) throws DAOException {
		try {
			Criteria criteria = getSession().createCriteria(Encounter.class);
			criteria.add(Restrictions.ge("patient.", patient));
			criteria.add(Restrictions.eq("encounterType.encounterTypeId", encounterTypeId));
			criteria.setFetchSize(1);
			if (criteria.list() != null) {
				if (criteria.list().size() > 0)
					return (Encounter) criteria.list().get(0);
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
