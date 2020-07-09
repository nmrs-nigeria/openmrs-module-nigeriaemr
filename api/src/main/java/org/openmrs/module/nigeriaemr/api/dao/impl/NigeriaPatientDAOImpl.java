package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernatePatientDAO;
import org.openmrs.api.db.hibernate.PatientSearchCriteria;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaPatientDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientsByEncounterDate(Date fromDate, Date toDate, boolean includeVoided) throws DAOException {
		List<Patient> patients = new ArrayList<Patient>();
		List<Integer> patientIds;
		
		String query = "SELECT distinct(encounter.patient_id) FROM encounter encounter WHERE (encounter.date_created >= :fromDate OR encounter.date_changed >= :fromDate)";
		if (toDate != null)
			query += " AND (encounter.date_created <= :toDate OR encounter.date_changed <= :toDate)";
		
		SQLQuery sql = getSession().createSQLQuery(query);
		
		sql.setDate("fromDate", fromDate);
		if (toDate != null)
			sql.setDate("toDate", toDate);
		
		patientIds = sql.list();
		
		if (patientIds.size() >= 1) {
			patients = this.getPatients(patientIds, includeVoided);
		}
		
		return patients;
	}
	
}
