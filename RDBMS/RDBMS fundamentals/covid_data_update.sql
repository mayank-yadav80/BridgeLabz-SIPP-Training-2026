-- Task 3: Update Case Information
-- Objective: Maintain accurate COVID statistics

USE covid_db;

-- Before update: Check current data for India on 2021-06-01
SELECT * FROM covid_cases WHERE country = 'India' AND report_date = '2021-06-01';

-- Update confirmed cases for India on a specific date
UPDATE covid_cases
SET confirmed_cases = 28500000,
    deaths = 342000,
    recoveries = 26000000
WHERE country = 'India' AND report_date = '2021-06-01';

-- Verify the update
SELECT * FROM covid_cases WHERE country = 'India' AND report_date = '2021-06-01';

-- Update multiple records: Add recoveries for all USA records
UPDATE covid_cases
SET recoveries = recoveries + 500000
WHERE country = 'USA';

-- Verify bulk update
SELECT * FROM covid_cases WHERE country = 'USA';

-- Update using arithmetic: Increment deaths by 5% for UK
UPDATE covid_cases
SET deaths = ROUND(deaths * 1.05)
WHERE country = 'UK';

-- Verify
SELECT * FROM covid_cases WHERE country = 'UK';

-- Update recovery rate in covid_deaths table
UPDATE covid_deaths
SET recovery_rate = ROUND((SELECT recoveries FROM covid_cases c
                          WHERE c.country = covid_deaths.country
                          AND c.report_date = covid_deaths.report_date)
                          * 100.0 / NULLIF((SELECT confirmed_cases FROM covid_cases c
                                            WHERE c.country = covid_deaths.country
                                            AND c.report_date = covid_deaths.report_date), 0), 2)
WHERE country = 'India' AND report_date = '2021-06-01';

-- Final verification
SELECT country, report_date, confirmed_cases, deaths, recoveries
FROM covid_cases
ORDER BY country, report_date;
