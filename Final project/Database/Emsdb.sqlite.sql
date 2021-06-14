BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Car" (
	"RegitrationNo"	INTEGER,
	"CarType"	VARCHAR(45) NOT NULL,
	"Status"	VARCHAR(45) NOT NULL,
	PRIMARY KEY("RegitrationNo")
);
CREATE TABLE IF NOT EXISTS "User" (
	"id"	INTEGER,
	"FName"	VARCHAR(45) NOT NULL,
	"LName"	VARCHAR(45) NOT NULL,
	"UserName"	VARCHAR(45) NOT NULL,
	"Password"	VARCHAR(45) NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Emt" (
	"id"	INTEGER,
	"FName"	VARCHAR(45) NOT NULL,
	"LName"	VARCHAR(45) NOT NULL,
	"Status"	VARCHAR(45) NOT NULL,
	"Expertise"	VARCHAR(45),
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Admin" (
	"id"	INTEGER,
	"AdminFName"	VARCHAR(45) NOT NULL,
	"AdminLName"	VARCHAR(45) NOT NULL,
	"UserName"	VARCHAR(45) NOT NULL,
	"Password"	VARCHAR(45) NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Task" (
	"Id"	INTEGER,
	"Status"	VARCHAR(30),
	"StarTime"	varchar(30),
	"EndTime"	varchar(30),
	"car"	int,
	"Emt1"	int,
	"Emt2"	int,
	"Task details"	TEXT,
	PRIMARY KEY("Id" AUTOINCREMENT)
);
COMMIT;
