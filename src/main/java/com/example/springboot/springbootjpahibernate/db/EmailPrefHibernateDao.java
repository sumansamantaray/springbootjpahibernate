/**
 * 
 */
package com.example.springboot.springbootjpahibernate.db;

import com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity;

/**
 * @author samasu5
 *
 */
public interface EmailPrefHibernateDao {

	public int insertEmailPreference(EmailPreferenceEntity emailPrefObj);
	
	public int updateEmailPreference(EmailPreferenceEntity emailPrefObj);
	
	public int deleteEmailPreference(EmailPreferenceEntity emailPrefObj);
}
