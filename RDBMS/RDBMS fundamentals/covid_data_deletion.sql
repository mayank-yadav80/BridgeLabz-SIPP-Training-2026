-- Task 4: Delete Incorrect Records
-- Objective: Clean and maintain data quality

USE covid_db;

-- First, insert some incorrect records for demonstration
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('IN', '2021-05-01', 19500000, 215000, 17500000, 1380004385),
('India', '2021-05-01', 19500000, 215000, 17500000, 1380004385),
('USA', '2021-05-01', 32300000, 575000, 25000000, 331002651);

-- View current data with potential issues
SELECT * FROM covid_cases ORDER BY country, report_date;

-- 1. Delete records with incorrect country name (e.g., 'IN' instead of 'India')
DELETE FROM covid_cases
WHERE country = 'IN';

-- Verify removal of incorrect country
SELECT * FROM covid_cases WHERE country = 'IN';

-- 2. Remove duplicate records for the same country and date
-- Keep the row with the lowest id (first inserted)
DELETE c1 FROM covid_cases c1
INNER JOIN covid_cases c2
WHERE c1.id > c2.id
  AND c1.country = c2.country
  AND c1.report_date = c2.report_date;

-- Verify duplicates are removed
SELECT country, report_date, COUNT(*)
FROM covid_cases
GROUP BY country, report_date
HAVING COUNT(*) > 1;

-- 3. Delete old records (before a specific date) if needed
DELETE FROM covid_cases
WHERE report_date < '2021-01-01';

-- 4. Delete records with zero or invalid data
DELETE FROM covid_cases
WHERE confirmed_cases <= 0
   OR country = '';

-- Final verification of clean data
SELECT * FROM covid_cases ORDER BY country, report_date;

-- Show total records remaining
SELECT COUNT(*) AS total_records FROM covid_cases;
