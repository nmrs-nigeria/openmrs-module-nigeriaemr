package org.openmrs.module.nigeriaemr.api.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Obs;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.api.db.hibernate.HibernateObsDAO;
import org.openmrs.module.nigeriaemr.api.dao.NigeriaObsDAO;

import java.util.ArrayList;
import java.util.List;

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
		return criteria.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Obs> getObsByConceptId(Integer personId, Integer conceptId, List<Integer> encounterIds, boolean includeVoided)
	        throws DAOException {
		List<Obs> obs = new ArrayList<Obs>();
		List<Integer> obsIds;
		
		String query = "SELECT distinct(obs.obs_id) FROM obs WHERE TRUE";
		if (personId != null)
			query += " AND obs.person_id = :personId";
		if (conceptId != null)
			query += " AND obs.concept_id = :conceptId";
		if (encounterIds != null && encounterIds.size() > 0)
			query += " AND obs.encounter_id in :encounterIds";
		
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
}
