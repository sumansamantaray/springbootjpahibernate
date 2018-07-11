CREATE TABLE "MY_EMAIL_PREFERENCES"
(
	email_Preference_Id INT PRIMARY KEY AUTO_INCREMENT,
    account_number varchar(100) NOT NULL,
    email_address varchar(100) DEFAULT NULL,
    domesticInb varchar(1),
    domesticOut varchar(1),
    internationalInb varchar(1),
    internationalOut varchar(1),
    bookInb varchar(1),
    bookOut varchar(1),
    email_format varchar(10)
);