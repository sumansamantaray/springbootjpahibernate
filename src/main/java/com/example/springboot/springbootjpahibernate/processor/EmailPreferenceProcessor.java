/**
 * 
 */
package com.example.springboot.springbootjpahibernate.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.springboot.springbootjpahibernate.db.EmailPrefHibernateDao;
import com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity;
import com.example.springboot.springbootjpahibernate.util.EmailPreferenceUtil;

/**
 * @author samasu5
 *
 */
@Component
public class EmailPreferenceProcessor {
	
	@Autowired
	EmailPreferenceUtil emailPrefUtil;
	
	@Autowired
	EmailPrefHibernateDao emailPrefHibernateDaoImpl;

	public void processEmailPreference() {
		
//		List<EmailPreferences> emailPrefObjList = emailPrefUtil.readEmailPreferenceFile();
		List<EmailPreferenceEntity> emailPrefObjList = emailPrefUtil.readFromXlsxFile();
		for (EmailPreferenceEntity emailPrefObj : emailPrefObjList) {
//			System.out.println("Account number: "+emailPrefObj.getAccountNumber());
			if ("D".equals(emailPrefObj.getStatus())) {
				// Delete email preference will be called.....
				emailPrefHibernateDaoImpl.deleteEmailPreference(emailPrefObj);
			}
			else if ("A".equals(emailPrefObj.getStatus())) {
				System.out.println("Account number "+emailPrefObj.getAccountNumber());
				System.out.println("Status "+emailPrefObj.getStatus());
				emailPrefHibernateDaoImpl.insertEmailPreference(emailPrefObj);
			}
			else {
				// Update Email preference will be called....
				emailPrefHibernateDaoImpl.updateEmailPreference(emailPrefObj);
			}
		}
	}

}
