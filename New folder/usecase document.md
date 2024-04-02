# Use Case (USER Details and User Account Info Upload)
1.	Write a Spring Boot application that contains the spring components for User Details. Use H2 as DB. Have a single page screen which can create/update/delete an User record. DB tables can have USER_DETAILS, USER_ACCOUNT_DETAILS tables.
USER_DETAILS can have fields like USER_ID, USER_FNAME, USER_LNAME, USER _MOBILE_NUMBER (MAX Length should be 10 ), USER_EMAIL_ID, USER_CREATED_DATE
USER_ADDRESS can have fields like USER_ID, USER_ACCOUNT_NO(only Numericals with length 15 ), USER_ACCOUNT_TYPE, ACCOUNT_CREATION_DATE, OPERATION_TYPE, SECOND_OPERATOR_NAME

# Operations.
a.	ADD few User details into USER_DETAILS table.

b.	From UI user should be able to upload an excel file with USER_ACCOUNT_DETAILS, each row in the sheet is user account information

c.	Once user has uploaded an excel sheet, check if the user exists already using USER_DETAILS table.

d.	If user exists, insert that user account information into USER_ACCOUNT_DETAILS.

e.	After processing all the rows, return to UI with a message like how many records where successful and how many are failure.

Note : Please use Java 8, Spring Boot , Spring JPA, Angular for developing User details.

# Sample Data In User Details Table.

# USER_ID	USER_FNAME	USER_LNAME	USER_MOBILE NUMBER	USER_EMAIL_ID	USER_CREATED_DATE
1001	Virendra 	Shewag	1111111111	Viru@gmail.com	2022-07-27

1002	Anil	Kumble	1111111112	Anil@gmail.com	2022-07-27

1003	Sachin	Tendulkar	1111111113	SRT@gmail.com	2022-07-25

1002	MS	Dhoni	1111111114	MS@gmail.com	2022-07-27

1004	Yuvraj	Singh	1111111115	YUVI@gmail.com	2022-07-27

# Sample Data In User Account Table

# USER_ID	USER_ACCOUNT_NO	USER_ACCOUNT_TYPE	ACCOUNT_CREATION_DATE	OPERATION_TYPE	SECOND_OPERATOR_NAME
1001	123456789012341 	SAVINGS	2022-07-27	INDIVIDUAL	

1002	123456789012342	CURRENT	2022-07-27	JOINT	Chethana

1003	123456789012343	SAVINGS	2022-07-25	INDIVIDUAL	

1002	123456789012344	SAVINGS	2022-07-27	JOINT	Sakshi

1004	123456789012345	CURRENT	2022-07-27	INDIVIDUAL	

