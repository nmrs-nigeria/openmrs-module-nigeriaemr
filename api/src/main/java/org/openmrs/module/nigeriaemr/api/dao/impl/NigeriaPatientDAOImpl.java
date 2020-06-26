package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernatePatientDAO;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaPatientDAO;

import java.util.Date;
import java.util.List;

public class NigeriaPatientDAOImpl extends HibernatePatientDAO implements NigeriaPatientDAO {
	
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
	public List<Patient> getPatients(Integer startId, Integer endId, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(Patient.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		criteria.add(Restrictions.ge("patientId", startId));
		criteria.add(Restrictions.le("patientId", endId));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Patient> getPatients(List<Integer> patientIds, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(Patient.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		criteria.add(Restrictions.in("patientId", patientIds));
		return criteria.list();
	}

	@Override
	public List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException {
		return null;
	}

	SELECT * FROM nigeriamrs.patient WHERE patient_id in (SELECT distinct(patient_id) FROM nigeriamrs.encounter where date_created > '2019-10-11 00:00:00');
}
