-- Active: 1702275006268@@127.0.0.1@3306@djongo
create  DATABASE  repertoire_contacts;
CREATE table Etudiant ( id INT PRIMARY  KEY  AUTO_INCREMENT, 
nom xVARCHAR(255), date_naissance  DATE, adresse VARCHAR(255), email VARCHAR(255), telnumber VARCHAR(20), cycle VARCHAR (50), niveau varchar (50));
CREATE TABLE Enseignant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    date_naissance DATE,
    adresse VARCHAR(255),
    email VARCHAR(255),
    telNumber VARCHAR(20),
    statut VARCHAR(50)
);
CREATE TABLE Agent (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    date_naissance DATE,
    adresse VARCHAR(255),
    email VARCHAR(255),
    telNumber VARCHAR(20),
    salaire DECIMAL(10, 2),
    statut VARCHAR(50),
    categorie VARCHAR(50),
    indice_salaire INT,
    occupation VARCHAR(50)
);
USE repertoire_contacts;
SHOW TABLES;
SELECT * FROM Agent;
