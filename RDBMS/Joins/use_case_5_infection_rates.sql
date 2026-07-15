-- Use Case 5: Find Countries with Highest Infection Rates
-- Objective: Rank countries by infection rate (confirmed_cases / population * 100)

USE covid_db_joins;

-- Query 1: Infection rate for each country on latest date
SELECT c.country_name,
       ck.confirmed_cases,
       c.population,
       ROUND((ck.confirmed_cases * 100.0 / c.population), 2) AS infection_rate_percent
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
WHERE ck.report_date = '2021-06-01'
ORDER BY infection_rate_percent DESC;

-- Query 2: Infection rate across all dates, ranked
SELECT c.country_name,
       ck.report_date,
       ck.confirmed_cases,
       c.population,
       ROUND((ck.confirmed_cases * 100.0 / c.population), 2) AS infection_rate_percent
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
ORDER BY infection_rate_percent DESC;

-- Query 3: Highest infection rate per country (max across all dates)
SELECT c.country_name,
       MAX(ck.confirmed_cases) AS max_confirmed,
       c.population,
       ROUND((MAX(ck.confirmed_cases) * 100.0 / c.population), 2) AS max_infection_rate
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
GROUP BY c.country_name, c.population
ORDER BY max_infection_rate DESC;

-- Query 4: Death rate alongside infection rate
SELECT c.country_name,
       ck.confirmed_cases,
       cd.deaths,
       c.population,
       ROUND((ck.confirmed_cases * 100.0 / c.population), 2) AS infection_rate,
       ROUND((cd.deaths * 100.0 / ck.confirmed_cases), 2) AS death_rate
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
INNER JOIN covid_deaths cd ON ck.country_id = cd.country_id AND ck.report_date = cd.report_date
WHERE ck.report_date = '2021-06-01'
ORDER BY infection_rate DESC;

-- Query 5: Countries with infection rate above 1%
SELECT c.country_name,
       ck.confirmed_cases,
       c.population,
       ROUND((ck.confirmed_cases * 100.0 / c.population), 2) AS infection_rate_percent
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
WHERE ck.report_date = '2021-06-01'
  AND (ck.confirmed_cases * 100.0 / c.population) > 1
ORDER BY infection_rate_percent DESC;
