/**
 * 
 */
package com.example.springboot.springbootjpahibernate.db;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity;

/**
 * @author samasu5
 *
 */
@Component
@Repository
@Transactional
public class EmailPrefHibernateDaoImpl implements EmailPrefHibernateDao {

	@Autowired
	EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.example.springboot.springbootjpahibernate.db.EmailPrefHibernateDao#insertEmailPreference(com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity)
	 */
	@Override
	public int insertEmailPreference(EmailPreferenceEntity emailPrefObj) {
		em.getTransaction().begin();
		em.persist(emailPrefObj);
		em.getTransaction().commit();
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.springboot.springbootjpahibernate.db.EmailPrefHibernateDao#updateEmailPreference(com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity)
	 */
	@Override
	public int updateEmailPreference(EmailPreferenceEntity emailPrefObj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.example.springboot.springbootjpahibernate.db.EmailPrefHibernateDao#deleteEmailPreference(com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity)
	 */
	@Override
	public int deleteEmailPreference(EmailPreferenceEntity emailPrefObj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
