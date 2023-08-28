package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Obs;
import org.openmrs.Person;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernateObsDAO;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaObsDAO;
import org.openmrs.module.nigeriaemr.api.service.impl.NigeriaEncounterServiceImpl;
import org.openmrs.module.nigeriaemr.util.LoggerUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NigeriaObsDAOImpl extends HibernateObsDAO implements NigeriaObsDAO {
	
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
	public List<Obs> getObs(List<Integer> obsIds, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		criteria.add(Restrictions.in("obsId", obsIds));
		criteria.addOrder(Order.desc("obsDatetime"));
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	         {
		try {
			List<Obs> obs = new ArrayList<>();
			List<Integer> obsIds;

			String query = "SELECT distinct(obs.obs_id) FROM obs WHERE TRUE";
			if (personId != null)
				query += " AND obs.person_id = :personId";
			if (conceptId != null)
				query += " AND obs.concept_id = :conceptId";
			if (encounterIds != null && encounterIds.size() > 0)
				query += " AND obs.encounter_id in :encounterIds";

			query += " AND obs.voided = false";

			SQLQuery sql = getSession().createSQLQuery(query);
			if (personId != null)
				sql.setInteger("personId", personId);
			if (conceptId != null)
				sql.setInteger("conceptId", conceptId);
			if (encounterIds != null && encounterIds.size() > 0)
				sql.setParameterList("encounterIds", encounterIds);

			obsIds = sql.list();

			if (obsIds.size() >= 1) {
				obs = this.getObs(obsIds, includeVoided);
			}

			return obs;
		}catch (HibernateException ex){
			LoggerUtils.write(NigeriaEncounterServiceImpl.class.getName(), ex.getMessage(), LoggerUtils.LogFormat.FATAL,
					LoggerUtils.LogLevel.live);
		}
		return null;
	}
	
	@Override
	public Obs getLastObsByConceptId(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (!includeVoided)
			criteria.add(Restrictions.eq("voided", false));
		if (from != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", from), Restrictions.ge("dateChanged", from)));
		}
		if (to != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", to), Restrictions.le("dateChanged", to)));
		}
		if (person != null) {
			criteria.add(Restrictions.eq("person", person));
		}
		if (concept != null) {
			criteria.add(Restrictions.eq("concept", concept));
		}
		if (asc) {
			criteria.addOrder(Order.asc("obsDatetime"));
		} else {
			criteria.addOrder(Order.desc("obsDatetime"));
		}
		
		criteria.setFetchSize(1);
		if (criteria.list().size() > 0)
			return (Obs) criteria.list().get(0);
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Obs> getObsByEncounterType(List<Integer> obsIds, List<Integer> encounterTypeIds, boolean includeVoided)
	        throws DAOException {
		List<Obs> obs = new ArrayList<Obs>();
		
		String query = "SELECT distinct(o.obs_id) FROM obs o LEFT JOIN encounter e ON e.encounter_id = o.encounter_id WHERE TRUE";
		
		if (obsIds != null && obsIds.size() > 0)
			query += " AND o.obs_id in :obsIds";
		if (encounterTypeIds != null && encounterTypeIds.size() > 0)
			query += " AND e.encounter_type in :encounterTypeIds";
		
		query += " AND e.voided = false AND o.voided = false";
		
		SQLQuery sql = getSession().createSQLQuery(query);
		if (obsIds != null && obsIds.size() > 0)
			sql.setParameterList("obsIds", obsIds);
		if (encounterTypeIds != null && encounterTypeIds.size() > 0)
			sql.setParameterList("encounterTypeIds", encounterTypeIds);
		
		List<Integer> ret_obsIds = sql.list();
		
		if (ret_obsIds.size() >= 1) {
			obs = this.getObs(ret_obsIds, includeVoided);
		}
		
		return obs;
	}
	
	@Override
	public Obs getHighestObsByConcept(Person person, Concept concept, Date from, Date to, boolean includeVoided, boolean asc)
	        throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (!includeVoided)
			criteria.add(Restrictions.eq("voided", false));
		if (from != null) {
			criteria.add(Restrictions.or(Restrictions.ge("dateCreated", from), Restrictions.ge("dateChanged", from)));
		}
		if (to != null) {
			criteria.add(Restrictions.or(Restrictions.le("dateCreated", to), Restrictions.le("dateChanged", to)));
		}
		if (person != null) {
			criteria.add(Restrictions.eq("person", person));
		}
		if (concept != null) {
			criteria.add(Restrictions.eq("concept", concept));
		}
		if (asc) {
			criteria.addOrder(Order.asc("valueNumeric"));
		} else {
			criteria.addOrder(Order.desc("valueNumeric"));
		}
		
		criteria.setFetchSize(1);
		if (criteria.list().size() > 0)
			return (Obs) criteria.list().get(0);
		return null;
	}
	
	@Override
	public List<Obs> getObsByVisitDate(Date visitDate, List<Integer> obsIds, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (!includeVoided)
			criteria.add(Restrictions.eq("voided", false));
		criteria.add(Restrictions.eq("obsDatetime", visitDate));
		if (obsIds != null && obsIds.size() > 0) {
			criteria.add(Restrictions.in("obsId", obsIds));
		}
		return criteria.list();
	}
	
	@Override
	public Obs getObsbyValueCoded(Concept concept, Concept valueCoded, List<Integer> obsList) throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (valueCoded != null) {
			criteria.add(Restrictions.eq("valueCoded", valueCoded));
		}
		if (obsList != null && obsList.size() > 0) {
			criteria.add(Restrictions.in("obsId", obsList));
		}
		if (concept != null) {
			criteria.add(Restrictions.eq("concept", concept));
		}
		criteria.addOrder(Order.desc("obsDatetime"));
		criteria.add(Restrictions.eq("voided", false));
		criteria.setFetchSize(1);
		
		criteria.setFetchSize(1);
		if (criteria.list().size() > 0)
			return (Obs) criteria.list().get(0);
		return null;
	}
	
	@Override
	public List<Obs> getObsByConcept(Concept concept, List<Integer> obsList) throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (obsList != null && obsList.size() > 0) {
			criteria.add(Restrictions.in("obsId", obsList));
		}
		if (concept != null) {
			criteria.add(Restrictions.eq("concept", concept));
		}
		criteria.addOrder(Order.desc("obsDatetime"));
		criteria.add(Restrictions.eq("voided", false));
		return criteria.list();
	}
	
	@Override
	public List<Obs> getObsByConcept(List<Concept> concepts, List<Integer> obsList) throws DAOException {
		Criteria criteria = getSession().createCriteria(Obs.class);
		if (obsList != null && obsList.size() > 0) {
			criteria.add(Restrictions.in("obsId", obsList));
		}
		if (concepts != null && concepts.size() > 0) {
			criteria.add(Restrictions.in("concept", concepts));
		}
		criteria.addOrder(Order.desc("obsDatetime"));
		criteria.add(Restrictions.eq("voided", false));
		return criteria.list();
	}
	
	@Override
	public List<Concept> getConcepts(List<Integer> conceptIds, boolean includeVoided) throws DAOException {
		Criteria criteria = getSession().createCriteria(Concept.class);
		criteria.add(Restrictions.eq("voided", includeVoided));
		criteria.add(Restrictions.in("conceptId", conceptIds));
		return criteria.list();
	}
	
	@Override
	public List<Integer> getPatientsByObsDate(Date from, Date to, List<String> patientIds, boolean includeVoided)
	        throws DAOException {
		
		String query = getQueryString(from, to, patientIds, includeVoided, "patient", "patient_id", false) + " UNION ALL "
		        + getQueryString(from, to, patientIds, includeVoided, "person", "person_id", false) + "  UNION ALL "
		        + getQueryString(from, to, patientIds, includeVoided, "person_address", "person_id", false) + "  UNION ALL "
		        + getQueryString(from, to, patientIds, includeVoided, "patient_identifier", "patient_id", false)
		        + "  UNION ALL "
		        + getQueryString(from, to, patientIds, includeVoided, "patient_program", "patient_id", false)
		        + "  UNION ALL "
		        + getQueryString(from, to, patientIds, includeVoided, "person_attribute", "person_id", false)
		        + "  UNION ALL " + getQueryString(from, to, patientIds, includeVoided, "person_name", "person_id", false)
		        + "  UNION ALL " + getQueryString(from, to, patientIds, includeVoided, "obs", "person_id", true)
		        + "  UNION ALL " + getQueryString(from, to, patientIds, includeVoided, "encounter", "patient_id", false)
		        + "  UNION ALL " + getQueryString(from, to, patientIds, includeVoided, "visit", "patient_id", false);
		
		SQLQuery sql = getSession().createSQLQuery(query);
		if (from != null) {
			sql.setTimestamp("from", from);
		}
		if (to != null) {
			sql.setTimestamp("to", to);
		}
		if (patientIds != null && patientIds.size() > 0)
			sql.setParameterList("patientIds", patientIds);
		
		List<Integer> ret = sql.list();
		
		return ret.stream().distinct().collect(Collectors.toList());
	}
	
	private String getQueryString(Date from, Date to, List<String> patientIds, boolean includeVoided, String tableName,
	        String fieldName, boolean noDateChanged) {
		StringBuilder query = new StringBuilder();
		if (noDateChanged) {
			query.append("  SELECT ").append(tableName).append(".").append(fieldName).append(" AS patient_id FROM ")
			        .append(tableName).append(" WHERE TRUE");
			if (from != null)
				query.append(" AND ").append(tableName).append(".date_created >= :from ");
			if (to != null)
				query.append(" AND ").append(tableName).append(".date_created <= :to  ");
		} else {
			query.append("  SELECT ").append(tableName).append(".").append(fieldName).append(" AS patient_id FROM ")
			        .append(tableName).append(" WHERE TRUE");
			if (from != null)
				query.append(" AND (").append(tableName).append(".date_created >= :from OR ").append(tableName)
				        .append(".date_changed >= :from) ");
			if (to != null)
				query.append(" AND (").append(tableName).append(".date_created <= :to OR ").append(tableName)
				        .append(".date_changed <= :to ) ");
		}
		if (!includeVoided)
			query.append(" AND ").append(tableName).append(".voided = FALSE ");
		if (patientIds != null && patientIds.size() > 0)
			query.append(" AND ").append(tableName).append(".").append(fieldName).append(" IN (:patientIds)  ");
		return query.toString();
	}
	
	@Override
	public List<Integer> getPatientEncounterIdsByDate(Integer id, Date fromDate, Date toDate) throws DAOException {
		try {
			
			String query = "SELECT DISTINCT encounter_id as enc FROM obs WHERE voided = false ";
			if (id != null)
				query += " AND person_id = :person_id ";
			if (fromDate != null)
				query += " AND date_created >= :fromDate ";
			if (toDate != null)
				query += " AND date_created <= :toDate ";
			
			query += " UNION ALL ";
			
			query += "SELECT DISTINCT encounter_id as enc FROM encounter WHERE voided = false ";
			if (id != null)
				query += " AND patient_id = :person_id ";
			if (fromDate != null)
				query += " AND (date_created >= :fromDate or date_changed >= :toDate)";
			if (toDate != null)
				query += " AND (date_created <= :fromDate or date_changed >= :toDate)";
			
			query += " UNION ALL ";
			
			query += "SELECT DISTINCT encounter.encounter_id as enc from encounter, visit WHERE visit.visit_id = encounter.visit_id  AND visit.voided = FALSE AND encounter.voided = FALSE ";
			if (id != null)
				query += " AND encounter.patient_id = :person_id ";
			if (fromDate != null)
				query += " AND (visit.date_created >= :fromDate OR visit.date_changed >= :toDate)";
			if (toDate != null)
				query += " AND (visit.date_created <= :fromDate OR visit.date_changed >= :toDate)";
			
			sessionFactory.getCurrentSession().clear();
			SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery(query);
			
			if (fromDate != null) {
				sql.setParameter("fromDate", fromDate);
			}
			if (toDate != null) {
				sql.setParameter("toDate", toDate);
			}
			if (id != null)
				sql.setParameter("person_id", id);
			List<Integer> encounterIds = null;
			try {
				encounterIds = sql.list();
				return encounterIds.stream().distinct().collect(Collectors.toList());
			}
			catch (Exception e) {
				e.getCause().getLocalizedMessage();
			}
			sessionFactory.getCurrentSession().getTransaction().commit();
			return encounterIds;
		}
		catch (HibernateException ex) {
			Throwable cause = ex.getCause();
			if (cause instanceof SQLException) {
				System.out.println(cause.getMessage());
			}
		}
		return null;
	}
}
