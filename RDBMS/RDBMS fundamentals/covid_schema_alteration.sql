-- Task 5: Alter Table to Add Vaccination Information
-- Objective: Extend the database schema to accommodate new requirements

USE covid_db;

-- View current schema before alteration
DESCRIBE covid_cases;

-- Add vaccination_rate column to covid_cases table
ALTER TABLE covid_cases
ADD COLUMN vaccination_rate DECIMAL(5, 2) DEFAULT 0.00
AFTER population;

-- Verify column was added
DESCRIBE covid_cases;

-- Update vaccination_rate for India records using data from covid_vaccines
UPDATE covid_cases cc
JOIN covid_vaccines cv ON cc.country = cv.country AND cc.report_date = cv.report_date
SET cc.vaccination_rate = cv.vaccination_rate
WHERE cc.country = 'India';

-- Update vaccination_rate for USA records
UPDATE covid_cases cc
JOIN covid_vaccines cv ON cc.country = cv.country AND cc.report_date = cv.report_date
SET cc.vaccination_rate = cv.vaccination_rate
WHERE cc.country = 'USA';

-- Update vaccination_rate for UK records
UPDATE covid_cases cc
JOIN covid_vaccines cv ON cc.country = cv.country AND cc.report_date = cv.report_date
SET cc.vaccination_rate = cv.vaccination_rate
WHERE cc.country = 'UK';

-- Add additional columns for extended tracking
ALTER TABLE covid_cases
ADD COLUMN icu_patients INT DEFAULT 0 AFTER recoveries,
ADD COLUMN hospitalizations INT DEFAULT 0 AFTER icu_patients,
ADD COLUMN positivity_rate DECIMAL(5, 2) DEFAULT 0.00 AFTER hospitalizations;

-- Verify final schema
DESCRIBE covid_cases;

-- View final data with all columns
SELECT country, report_date, confirmed_cases, deaths, recoveries,
       icu_patients, hospitalizations, positivity_rate,
       population, vaccination_rate
FROM covid_cases
ORDER BY country, report_date;
