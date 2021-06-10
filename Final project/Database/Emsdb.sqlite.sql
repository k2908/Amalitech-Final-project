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
	PRIMARY KEY("Id" AUTOINCREMENT)
);
INSERT INTO "Car" ("RegitrationNo","CarType","Status") VALUES (4444,'fkkkg','available');
INSERT INTO "Car" ("RegitrationNo","CarType","Status") VALUES (12365,'gfhjjh','available');
INSERT INTO "Car" ("RegitrationNo","CarType","Status") VALUES (12366,'','available');
INSERT INTO "User" ("id","FName","LName","UserName","Password") VALUES (1,'nkjl;jml','jlljjll','llklklkl','lllllj');
INSERT INTO "Emt" ("id","FName","LName","Status","Expertise") VALUES (1,'jjhhjhjkh','hhjhhkkj','available','hhkhkjkjk');
INSERT INTO "Emt" ("id","FName","LName","Status","Expertise") VALUES (2,'n,,m,n,','hjhjhj','available',',,.kmm
');
INSERT INTO "Emt" ("id","FName","LName","Status","Expertise") VALUES (3,'khjnjnj','jknjnnkjn','available','ljllml');
INSERT INTO "Emt" ("id","FName","LName","Status","Expertise") VALUES (4,'hkbnkjnjll','kbknkljn','available','hjbkj,nk');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (1,'kofi','jjjj','kofi36@gmail.com','Amen52');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (2,'hkffjk','gjhkjjkj','hsjhks@ghhh.com','Amen54');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (3,'jhhjjj','jbbjbkjjh','1','2');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (4,'ds','sddfd','ddfg','dggfgfrrf');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (5,'hjhjhkhk','gfghhjkhj','gfghggj','gfghjjk');
INSERT INTO "Admin" ("id","AdminFName","AdminLName","UserName","Password") VALUES (6,'hgvj vk','ghfcjvgh','ghjgkb','fdhgl');
INSERT INTO "Task" ("Id","Status","StarTime","EndTime","car","Emt1","Emt2") VALUES (1,'in progress','Wed Jun 09 21:09:05 GMT 2021',NULL,4444,1,1);
COMMIT;
