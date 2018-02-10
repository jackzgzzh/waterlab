create database lab;

create table Header(
	id int primary key auto_increment,
	waterFrom varchar(50) not null,	
	checkTime datetime not null,
	weather varchar(20) not null,
	temperature int not null
);

create table SourceWater(
	id int primary key auto_increment,
	srcHeader int not null,
	srcTemperature float(5,2) not null,
	srcPh float(4,2) not null,
	srcChroma int not null, /*色度*/
	srcLookable tinyint(1) not null, /*肉眼可见物，tinyint(1)对应Boolean类型*/
	srcSmell tinyint(1) not null,
	srcNtu float(5,2) not null,
	srcCfu int not null,	/*菌落总数*/
	srcTotalColiforms int not null, /*总大肠菌群数*/
	srcHeatResistant int not null, /*耐热大肠菌*/
	srcCod float(4,2) not null, /*耗氧量*/
	srcAmmonia float(3,2) not null, /*氨氮*/	
	constraint srcHeader foreign key (srcHeader) references Header(id)
);

create table FinishedWater(
	id int primary key auto_increment,
	fihTemperature float(5,2) not null,
	fihPh float(4,2) not null,
	fihChroma int not null, /*色度*/
	fihLookable tinyint(1) not null, /*肉眼可见物，tinyint(1)对应Boolean类型*/
	fihSmell tinyint(1) not null,
	fihNtu float(5,2) not null,
	fihChlorineDioxide float(3,2) not null, /*二氧化氯*/
	fihHico float(3,2) not null, /*余氯*/
	fihUhr float(3,2) not null,	/*总氯*/
	fihCfu int not null,	/*菌落总数*/
	fihTotalColiforms int not null, /*总大肠菌群数*/
	fihHeatResistant int not null, /*耐热大肠菌*/
	fihCod float(4,2) not null, /*耗氧量*/
	fihAmmonia float(3,2) not null /*氨氮*/
);

create table Footer(
	id int primary key auto_increment,
	checker varchar(50) not null,
	verifier varchar(50) not null
);

create table ProcessWater(
	id int primary key auto_increment,
	checkTimeProcess datetime not null,
	sourceWaterNfu float(5,2) not null,
	precipitableWaterNfu float(5,2) not null,/*沉淀水*/
	savedWaterNfu float(5,2) not null,/*清水池*/
	filteredWaterNfu float(5,2) not null,/*滤后水*/
	finishedWaterNfu float(5,2) not null,
	finishedWaterHico float(3,2) not null
);

create table User(
	id int primary key auto_increment,
	userRole int not null,
	userName varchar(30) not null,
	password varchar(20) not null
);

/*测试数据*/
insert into Header values(1,'XX水厂',now(),'雨',10);

insert into SourceWater values(1,1,10.4,7.96,3,1,0,35.1,90,25,12,2.40,0.10);
insert into SourceWater values(null,1,10.8,7.96,3,1,0,32.9,190,25,12,2.40,0.10);
insert into SourceWater values(null,1,10.4,7.99,3,0,0,35.5,90,25,12,2.44,0.11);
insert into SourceWater values(null,1,10.5,7.98,3,1,0,37.4,90,20,10,2.40,0.10);
insert into SourceWater values(null,1,10.9,7.96,3,0,0,35.1,95,15,9,2.41,0.11);
insert into SourceWater values(null,1,10.0,7.98,3,1,0,36.1,90,35,12,2.32,0.08);
insert into SourceWater values(null,1,10.1,7.99,3,1,0,38.1,80,45,11,2.36,0.11);
insert into SourceWater values(null,1,10.2,7.97,3,0,0,35.3,90,25,10,2.40,0.08);
insert into SourceWater values(null,1,11.8,7.96,3,1,0,32.9,190,25,12,2.40,0.10);
insert into SourceWater values(null,1,11.4,7.99,3,0,0,35.5,90,25,12,2.44,0.11);
insert into SourceWater values(null,1,11.5,7.98,3,1,0,37.4,90,20,10,2.40,0.10);
insert into SourceWater values(null,1,11.9,7.96,3,0,0,35.1,95,15,9,2.41,0.11);
insert into SourceWater values(null,1,11.0,7.98,3,1,0,36.1,90,35,12,2.32,0.08);
insert into SourceWater values(null,1,11.1,7.99,3,1,0,38.1,80,45,11,2.36,0.11);
insert into SourceWater values(null,1,11.2,7.97,3,0,0,35.3,90,25,10,2.40,0.08);
insert into SourceWater values(null,1,12.8,7.96,3,1,0,32.9,190,25,12,2.40,0.10);
insert into SourceWater values(null,1,12.4,7.99,3,0,0,35.5,90,25,12,2.44,0.11);
insert into SourceWater values(null,1,12.5,7.98,3,1,0,37.4,90,20,10,2.40,0.10);
insert into SourceWater values(null,1,12.9,7.96,3,0,0,35.1,95,15,9,2.41,0.11);
insert into SourceWater values(null,1,12.0,7.98,3,1,0,36.1,90,35,12,2.32,0.08);
insert into SourceWater values(null,1,12.1,7.99,3,1,0,38.1,80,45,11,2.36,0.11);
insert into SourceWater values(null,1,12.2,7.97,3,0,0,35.3,90,25,10,2.40,0.08);

insert into FinishedWater values(1,10.5,7.89,3,0,0,0.41,0,0.50,0.70,3,0,0,1.44,0.02);
insert into FinishedWater values(null,10.9,7.89,3,0,0,0.41,0,0.50,0.70,3,0,0,1.44,0.03);
insert into FinishedWater values(null,10.8,7.82,3,0,0,0.36,0,0.55,0.75,2,0,0,1.40,0.04);
insert into FinishedWater values(null,10.0,7.89,3,1,0,0.45,0,0.50,0.70,3,0,0,1.28,0.02);
insert into FinishedWater values(null,10.1,7.83,3,0,0,0.41,0,0.56,0.76,4,0,0,1.44,0.02);
insert into FinishedWater values(null,10.4,7.91,3,0,1,0.32,0,0.45,0.65,3,0,0,1.49,0.03);
insert into FinishedWater values(null,11.9,7.89,3,0,0,0.41,0,0.50,0.70,3,0,0,1.44,0.03);
insert into FinishedWater values(null,11.8,7.82,3,0,0,0.36,0,0.55,0.75,2,0,0,1.40,0.04);
insert into FinishedWater values(null,11.0,7.89,3,1,0,0.45,0,0.50,0.70,3,0,0,1.28,0.02);
insert into FinishedWater values(null,11.1,7.83,3,0,0,0.41,0,0.56,0.76,4,0,0,1.44,0.02);
insert into FinishedWater values(null,11.4,7.91,3,0,1,0.32,0,0.45,0.65,3,0,0,1.49,0.03);
insert into FinishedWater values(null,12.9,7.89,3,0,0,0.41,0,0.50,0.70,3,0,0,1.44,0.03);
insert into FinishedWater values(null,12.8,7.82,3,0,0,0.36,0,0.55,0.75,2,0,0,1.40,0.04);
insert into FinishedWater values(null,12.0,7.89,3,1,0,0.45,0,0.50,0.70,3,0,0,1.28,0.02);
insert into FinishedWater values(null,12.1,7.83,3,0,0,0.41,0,0.56,0.76,4,0,0,1.44,0.02);
insert into FinishedWater values(null,12.4,7.91,3,0,1,0.32,0,0.45,0.65,3,0,0,1.49,0.03);

insert into ProcessWater values(1,now(),36.9,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),46.9,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),46.9,2.53,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),46.9,2.63,0.39,0.45,0.36,0.40);
insert into ProcessWater values(null,now(),46.9,2.69,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),46.9,2.63,0.39,0.35,0.30,0.40);	
insert into ProcessWater values(null,now(),56.9,2.63,0.32,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),56.5,2.63,0.39,0.35,0.36,0.50);
insert into ProcessWater values(null,now(),56.9,2.83,0.39,0.31,0.36,0.40);
insert into ProcessWater values(null,now(),56.3,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),56.9,2.63,0.36,0.35,0.36,0.45);	
insert into ProcessWater values(null,now(),66.2,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),66.9,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),66.1,2.63,0.35,0.30,0.38,0.41);
insert into ProcessWater values(null,now(),66.9,2.63,0.39,0.35,0.36,0.40);
insert into ProcessWater values(null,now(),66.9,2.63,0.39,0.32,0.36,0.42);	


insert into User values(null,1,'jackzg1','123');
insert into User values(null,1,'jackzg2','123');
insert into User values(null,2,'jackzg3','123');
insert into User values(null,2,'jackzg4','123');
insert into User values(null,2,'jackzg5','123');
insert into User values(null,1,'jackzg6','123');
insert into User values(null,2,'jackzg7','123');
insert into User values(null,1,'jackzg8','123');
insert into User values(null,2,'jackzg9','123');
insert into User values(null,1,'jackzg10','123');
insert into User values(null,2,'jackzg10','123');
insert into User values(null,1,'jackzg12','123');