package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernateEncounterDAO;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaEncounterDAO;

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
		criteria.add(Restrictions.ge("dateCreated", fromDate));
		//		criteria.add(Restrictions.ge("dateChanged", fromDate));
		if (toDate != null) {
			criteria.add(Restrictions.le("dateCreated", toDate));
		}
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Encounter> getEncountersByEncounterDate(Date fromDate, Date toDate) throws DAOException {
		Criteria criteria = getSession().createCriteria(Encounter.class);
		
		if (fromDate != null) {
			criteria.add(Restrictions.ge("dateCreated", fromDate));
		}
		
		if (toDate != null) {
			criteria.add(Restrictions.le("dateCreated", toDate));
		}
		return criteria.list();
	}
	
}
