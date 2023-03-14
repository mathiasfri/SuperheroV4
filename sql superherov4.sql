DROP TABLE if exists superheroes;
DROP TABLE if exists city;
DROP TABLE if exists superpower;
DROP TABLE if exists Superhero_Superpower;
DROP TABLE if exists City_Superhero;

-- Table creation

CREATE TABLE Superheroes(
superheroID INT NOT NULL auto_increment,
heroName varchar(50),
realName varchar(30),
creationYear int,
PRIMARY KEY(superheroID)
);

CREATE TABLE Superpower(
superpowerID INT NOT NULL AUTO_INCREMENT,
name varchar(50),
PRIMARY KEY(superpowerID)
);

CREATE TABLE City(
cityID INT NOT NULL AUTO_INCREMENT,
name varchar(30),
PRIMARY KEY(cityID)
);

CREATE TABLE Superhero_Superpower(
superheroID int not null,
superpowerID int not null,
PRIMARY KEY(superheroID, superpowerID),
foreign key (superheroID) references superheroes(superheroID),
foreign key (superpowerID) references superpower(superpowerID)
);

CREATE TABLE City_Superhero(
cityID int not null,
superheroID int not null,
PRIMARY KEY(cityID, superheroID),
foreign key (superheroID) references superheroes(superheroID),
foreign key (cityID) references city(cityID)
);

-- Data input

INSERT INTO superheroes(superheroID, heroName, realName, creationYear) VALUES (1, "The Flash", "Berry Allen", 1999);
INSERT INTO superheroes(superheroID, heroName, realName, creationYear) VALUES (2, "Spiderman", "Peter Parker", 1992);
INSERT INTO superheroes(superheroID, heroName, realName, creationYear) VALUES (3, "Superman", "Clark Kent", 1938);

INSERT INTO city(cityID, name) VALUES (1, "Central City");
INSERT INTO city(cityID, name) VALUES (2, "New York");
INSERT INTO city(cityID, name) VALUES (3, "Gotham");

INSERT INTO superpower(superpowerID, name) VALUES(1, "Speed");
INSERT INTO superpower(superpowerID, name) VALUES(2, "Spider-sense");
INSERT INTO superpower(superpowerID, name) VALUES(3, "Fly, Strength, Laser-eyes");

INSERT INTO Superhero_Superpower (superheroID, superpowerID) VALUES (1, 1);
INSERT INTO Superhero_Superpower (superheroID, superpowerID) VALUES (2, 2);
INSERT INTO Superhero_Superpower (superheroID, superpowerID) VALUES (3, 3);

INSERT INTO City_Superhero (superheroID, cityID) VALUES (1, 1);
INSERT INTO City_Superhero (superheroID, cityID) VALUES (2, 2);
INSERT INTO City_Superhero (superheroID, cityID) VALUES (3, 3);


-- SQL commands for the code

SELECT * FROM superheroes;

SELECT heroName, realName, count(*) as NumberOfSuperpowers FROM superhero_superpower join superheroes
on superheroes.superheroID = superhero_superpower.superheroID
GROUP BY superheroes.superheroID;

SELECT heroName, realName, superpower.name AS Superpower FROM superpower join superheroes join superhero_superpower
on superpower.superpowerID = superhero_superpower.superpowerID
and superheroes.superheroID = superhero_superpower.superheroID
WHERE superheroes.heroName = "Spiderman";

SELECT heroName, city.name AS City FROM city JOIN superheroes JOIN city_superhero
on city.cityID = city_superhero.cityID
and superheroes.superheroID = city_superhero.superheroID
WHERE superheroes.heroName = "Spiderman";
