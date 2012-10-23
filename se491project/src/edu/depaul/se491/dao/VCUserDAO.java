package edu.depaul.se491.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import edu.depaul.se491.entities.VCClass;
import edu.depaul.se491.entities.VCUser;

public class VCUserDAO {

	
	public void addUser(String fname, String lname, String email, String openId,
			 boolean teacher, boolean student, boolean admin) {
		
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			VCUser vcUser = new VCUser(fname, lname, email, openId,
					                   teacher, student,  admin);
			em.persist(vcUser);
			em.close();
		}	
	}
	
	public VCUser getVCUser(String openId) {
		
		VCUser vcUser = null;
		
		synchronized (this) {
			try{
				EntityManager em = EMFService.get().createEntityManager();
				Query query = em.createNamedQuery("findUserbyOpenId"); 
			
				query.setParameter("openId", openId);
				query.setMaxResults(1);
		
				vcUser = (VCUser) query.getSingleResult();	
			}catch (NoResultException nre){
				vcUser = null;
			}
		}
		
		return vcUser;
	}
	
	public void update(VCUser vcUser) {
		
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();			
			
			em.persist(vcUser);
			em.flush();
			em.close();
		}	
	}
	

}
