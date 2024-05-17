### Use Case: USER Details and User Account Info Upload

#### Description
Write a Spring Boot application that manages user details. Use H2 as the database and create a single-page application (SPA) to create, update, and delete user records. The database should have two tables: `USER_DETAILS` and `USER_ACCOUNT_DETAILS`.

#### Database Tables

**USER_DETAILS**:
| Field            | Description                        |
|------------------|------------------------------------|
| USER_ID          | User ID                            |
| USER_FNAME       | User First Name                    |
| USER_LNAME       | User Last Name                     |
| USER_MOBILE_NUMBER | User Mobile Number (Max Length: 10) |
| USER_EMAIL_ID    | User Email ID                      |
| USER_CREATED_DATE| User Created Date                  |

**USER_ACCOUNT_DETAILS**:
| Field                | Description                                      |
|----------------------|--------------------------------------------------|
| USER_ID              | User ID                                          |
| USER_ACCOUNT_NO      | User Account Number (Only numericals, length 15) |
| USER_ACCOUNT_TYPE    | User Account Type                                |
| ACCOUNT_CREATION_DATE| Account Creation Date                            |
| OPERATION_TYPE       | Operation Type                                   |
| SECOND_OPERATOR_NAME | Second Operator Name                             |

#### Operations
1. Add user details to the `USER_DETAILS` table.
2. Allow the user to upload an Excel file with `USER_ACCOUNT_DETAILS` through the UI.
3. Validate if the user exists in the `USER_DETAILS` table when an Excel file is uploaded.
4. If the user exists, insert the user account information into `USER_ACCOUNT_DETAILS`.
5. After processing all rows, return a message to the UI indicating the number of successful and failed records.

#### Sample Data

**USER_DETAILS**:
| USER_ID | USER_FNAME  | USER_LNAME    | USER_MOBILE_NUMBER | USER_EMAIL_ID      | USER_CREATED_DATE |
|---------|-------------|---------------|--------------------|--------------------|-------------------|
| 1001    | Virendra    | Shewag        | 1111111111         | Viru@gmail.com     | 2022-07-27        |
| 1002    | Anil        | Kumble        | 1111111112         | Anil@gmail.com     | 2022-07-27        |
| 1003    | Sachin      | Tendulkar     | 1111111113         | SRT@gmail.com      | 2022-07-25        |
| 1002    | MS          | Dhoni         | 1111111114         | MS@gmail.com       | 2022-07-27        |
| 1004    | Yuvraj      | Singh         | 1111111115         | YUVI@gmail.com     | 2022-07-27        |

**USER_ACCOUNT_DETAILS**:
| USER_ID | USER_ACCOUNT_NO | USER_ACCOUNT_TYPE | ACCOUNT_CREATION_DATE | OPERATION_TYPE | SECOND_OPERATOR_NAME |
|---------|-----------------|-------------------|-----------------------|----------------|----------------------|
| 1001    | 123456789012341 | SAVINGS           | 2022-07-27            | INDIVIDUAL     |                      |
| 1002    | 123456789012342 | CURRENT           | 2022-07-27            | JOINT          | Chethana             |
| 1003    | 123456789012343 | SAVINGS           | 2022-07-25            | INDIVIDUAL     |                      |
| 1002    | 123456789012344 | SAVINGS           | 2022-07-27            | JOINT          | Sakshi               |
| 1004    | 123456789012345 | CURRENT           | 2022-07-27            | INDIVIDUAL     |                      |

#### Technologies
- **Java 8**
- **Spring Boot**
- **Spring JPA**
- **Angular**

#### Notes
Ensure the application adheres to best practices and guidelines for both backend and frontend development. Use appropriate error handling, logging, and code documentation.
