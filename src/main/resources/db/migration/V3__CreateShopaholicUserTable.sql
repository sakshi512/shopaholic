CREATE TABLE SHOPAHOLIC_USER(
 su_id serial PRIMARY KEY,
su_firstname Varchar(50) NOT null,
su_lastname Varchar(50) NOT null,
su_addressline1 Varchar(100) NOT null,
su_addressline2 Varchar(100),
su_city Varchar(100) NOT null,
su_pin INTEGER NOT null,
su_phone varchar(15) NOT null,
su_email Varchar(250) NOT null,
su_password VARCHAR(300) NOT NULL,
su_DOB DATE NOT null,
su_role INTEGER REFERENCES User_Roles(ur_Id),
su_creationdate DATE NOT NULL);