-- Task 1: Create COVID Database Schema
-- Objective: Design a database to store COVID-19-related information

CREATE DATABASE IF NOT EXISTS covid_db;
USE covid_db;

-- Table: covid_cases
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT DEFAULT 0,
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Table: covid_deaths
CREATE TABLE covid_deaths (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    deaths INT DEFAULT 0,
    recovery_rate DECIMAL(5, 2) DEFAULT 0.00,
    mortality_rate DECIMAL(5, 2) DEFAULT 0.00,
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Table: covid_vaccines
CREATE TABLE covid_vaccines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    total_vaccinated BIGINT DEFAULT 0,
    first_dose BIGINT DEFAULT 0,
    second_dose BIGINT DEFAULT 0,
    booster_dose BIGINT DEFAULT 0,
    vaccination_rate DECIMAL(5, 2) DEFAULT 0.00,
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Verify table creation
SHOW TABLES;
DESCRIBE covid_cases;
DESCRIBE covid_deaths;
DESCRIBE covid_vaccines;
