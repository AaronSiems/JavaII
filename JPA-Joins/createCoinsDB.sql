create database coins;
use coins;

create table coins(
ID int NOT NULL AUTO_INCREMENT, 
COIN varchar(20) NOT NULL, 
YEAR int NOT NULL, 
MINT varchar(1) NOT NULL, --coins can have no mint mark but we will assume all the coins in here do
PRIMARY KEY(ID));

insert into coins values(null, "Quarter", 2018, "P");
insert into coins values(null, "Dime", 1964, "D");
insert into coins values(null, "Nickel", 1942, "P");
insert into coins values(null, "Penny", 1918, "S");