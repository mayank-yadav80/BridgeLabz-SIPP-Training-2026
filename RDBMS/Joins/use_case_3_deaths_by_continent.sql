-- Use Case 3: Analyze Deaths by Continent
-- Objective: Determine total COVID deaths aggregated by continent

USE covid_db_joins;

-- Using existing countries and covid_deaths tables
-- Query 1: Total deaths per continent using INNER JOIN + GROUP BY
SELECT c.continent,
       SUM(cd.deaths) AS total_deaths,
       COUNT(DISTINCT c.country_name) AS country_count
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
GROUP BY c.continent
ORDER BY total_deaths DESC;

-- Query 2: Average deaths per country by continent
SELECT c.continent,
       c.country_name,
       AVG(cd.deaths) AS avg_deaths
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
GROUP BY c.continent, c.country_name
ORDER BY c.continent, avg_deaths DESC;

-- Query 3: Total deaths per continent with country breakdown
SELECT c.continent,
       c.country_name,
       SUM(cd.deaths) AS total_deaths
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
GROUP BY c.continent, c.country_name
WITH ROLLUP;

-- Query 4: Death rate by continent (sum of deaths / sum of confirmed cases)
SELECT c.continent,
       SUM(cd.deaths) AS total_deaths,
       SUM(ck.confirmed_cases) AS total_confirmed,
       ROUND(SUM(cd.deaths) * 100.0 / SUM(ck.confirmed_cases), 2) AS death_rate_percent
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
INNER JOIN covid_cases ck ON cd.country_id = ck.country_id AND cd.report_date = ck.report_date
GROUP BY c.continent
ORDER BY death_rate_percent DESC;

-- Query 5: Top continent by total deaths
SELECT c.continent, SUM(cd.deaths) AS total_deaths
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
GROUP BY c.continent
ORDER BY total_deaths DESC
LIMIT 1;
