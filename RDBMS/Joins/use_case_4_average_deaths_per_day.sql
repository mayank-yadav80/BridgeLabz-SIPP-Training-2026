-- Use Case 4: Calculate Average New Deaths Per Day
-- Objective: Track global trend of average daily COVID deaths over time

USE covid_db_joins;

-- Query 1: Average deaths per day across all countries, ordered by date
SELECT report_date,
       AVG(deaths) AS avg_daily_deaths,
       SUM(deaths) AS total_deaths,
       COUNT(*) AS countries_reported
FROM covid_deaths
GROUP BY report_date
ORDER BY report_date;

-- Query 2: Average deaths with country names, ordered by date and deaths
SELECT c.country_name,
       cd.report_date,
       cd.deaths,
       AVG(cd.deaths) OVER (ORDER BY cd.report_date) AS running_avg_deaths
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
ORDER BY cd.report_date, cd.deaths DESC;

-- Query 3: Monthly average deaths by country
SELECT c.country_name,
       DATE_FORMAT(cd.report_date, '%Y-%m') AS month,
       AVG(cd.deaths) AS avg_monthly_deaths,
       MIN(cd.deaths) AS min_deaths,
       MAX(cd.deaths) AS max_deaths
FROM covid_deaths cd
INNER JOIN countries c ON cd.country_id = c.country_id
GROUP BY c.country_name, DATE_FORMAT(cd.report_date, '%Y-%m')
ORDER BY c.country_name, month;

-- Query 4: Global daily statistics with ORDER BY
SELECT cd.report_date,
       COUNT(DISTINCT cd.country_id) AS num_countries,
       SUM(cd.deaths) AS total_global_deaths,
       ROUND(AVG(cd.deaths), 0) AS avg_deaths_per_country
FROM covid_deaths cd
GROUP BY cd.report_date
ORDER BY cd.report_date ASC;

-- Query 5: Date with highest average deaths
SELECT report_date,
       AVG(deaths) AS avg_daily_deaths
FROM covid_deaths
GROUP BY report_date
ORDER BY avg_daily_deaths DESC
LIMIT 1;
