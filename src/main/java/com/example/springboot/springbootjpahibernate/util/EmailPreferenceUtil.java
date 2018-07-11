package com.example.springboot.springbootjpahibernate.util;
/**
 * 
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.springboot.springbootjpahibernate.db.model.EmailPreferenceEntity;


/**
 * @author Suman
 *
 */
@Component
public class EmailPreferenceUtil {

	// 1234567890|suman.samantaray@email.com|N|N|N|N|N|N|HTML
	
	@Bean
	public List<EmailPreferenceEntity> readEmailPreferenceFile() {
		
		List<EmailPreferenceEntity> emailPreferenceList = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("./src/main/resources/emailpreference.txt")));
			
			while (sc.hasNext()) {
				String emailPreferenceRecord = sc.nextLine();
				String[] splitRecord = emailPreferenceRecord.split("\\|");
				EmailPreferenceEntity emailPrefObj = new EmailPreferenceEntity();
				emailPrefObj.setAccountNumber(splitRecord[0]);
				emailPrefObj.setEmailAddress(splitRecord[1]);
				emailPrefObj.setDomesticInb(splitRecord[2]);
				emailPrefObj.setDomesticOut(splitRecord[3]);
				emailPrefObj.setInternationalInb(splitRecord[4]);
				emailPrefObj.setInternationalOut(splitRecord[5]);
				emailPrefObj.setBookInb(splitRecord[6]);
				emailPrefObj.setBookOut(splitRecord[7]);
				emailPrefObj.setEmailFormat(splitRecord[8]);
				emailPrefObj.setStatus(splitRecord[9]);
				emailPreferenceList.add(emailPrefObj);
			}
			
			sc.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		
		return emailPreferenceList;
	}
	
	public List<EmailPreferenceEntity> readFromXlsxFile() {
		
		List<EmailPreferenceEntity> emailPreferenceList = new ArrayList<>();
		try {
			
			// Creating a Workbook from an Excel file (.xls or .xlsx)
	        Workbook workbook = WorkbookFactory.create(new File("./src/main/resources/email_preferences.xlsx"));

	        // Retrieving the number of sheets in the Workbook
	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        
	        Sheet dataSheet = workbook.getSheetAt(0);
	        
	        // Create a DataFormatter to format and get each cell's value as String
	        DataFormatter dataFormatter = new DataFormatter();
	        System.out.println("Sheet Header :"+dataSheet.getHeader());
	        
	        dataSheet.forEach(row -> {
	        	if (row.getRowNum() == 0) return;
	        	EmailPreferenceEntity emailPrefObj = new EmailPreferenceEntity();
	            row.forEach(cell -> {
	                String cellValue = dataFormatter.formatCellValue(cell);
	                switch (cell.getColumnIndex()) {
	                
	                	case 0:
	                		emailPrefObj.setAccountNumber(cellValue);
	                		
	                	case 1:
	                		emailPrefObj.setEmailAddress(cellValue);
	        				
	                	case 2:
	                		emailPrefObj.setDomesticInb(cellValue);
	                		
	                	case 3:
	                		emailPrefObj.setDomesticOut(cellValue);
	                		
	                	case 4:
	                		emailPrefObj.setInternationalInb(cellValue);
	        				
	                	case 5:
	                		emailPrefObj.setInternationalOut(cellValue);
	        				
	                	case 6:
	                		emailPrefObj.setBookInb(cellValue);
	        				
	                	case 7:
	                		emailPrefObj.setBookOut(cellValue);
	        				
	                	case 8:
	                		emailPrefObj.setEmailFormat(cellValue);
	        				
	                	case 9:
	                		emailPrefObj.setStatus(cellValue);
	        				
	                }
	                
	                System.out.print(cellValue + cell.getColumnIndex()+ "\t");
	            });
	            System.out.println();
	            emailPreferenceList.add(emailPrefObj);
	        });
			
		} catch (InvalidFormatException invalidFormatexp) {
			
			invalidFormatexp.printStackTrace();
		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		
		
		return emailPreferenceList;
	}
	
}
