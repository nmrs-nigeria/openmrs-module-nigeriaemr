package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernatePatientDAO;
import org.openmrs.api.db.hibernate.PatientSearchCriteria;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaPatientDAO;
import org.springframework.expression.spel.ast.Identifier;

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
	public String getPatientIdentifier(Integer patientId, Integer identifierType) throws DAOException {
		
		String query = "SELECT distinct(patient_identifier.identifier) FROM patient_identifier patient_identifier "
		        + " WHERE patient_identifier.identifier_type = :identifierType AND patient_identifier.patient_id = :patientId ";
		SQLQuery sql = getSession().createSQLQuery(query);
		sql.setInteger("identifierType", identifierType);
		sql.setInteger("patientId", patientId);
		return sql.uniqueResult().toString();
	}
	
}
