-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
-- Objective: Retrieve the country with the highest confirmed cases on a specific date

CREATE DATABASE IF NOT EXISTS covid_db_joins;
USE covid_db_joins;

-- Reference table: countries
CREATE TABLE countries (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL,
    continent VARCHAR(50),
    population BIGINT
);

-- covid_cases table
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recoveries INT DEFAULT 0,
    FOREIGN KEY (country_id) REFERENCES countries(country_id),
    UNIQUE KEY unique_country_date (country_id, report_date)
);

-- Insert sample data
INSERT INTO countries (country_name, continent, population) VALUES
('India', 'Asia', 1380004385),
('USA', 'North America', 331002651),
('UK', 'Europe', 67886011),
('Brazil', 'South America', 212559417),
('Germany', 'Europe', 83783942);

INSERT INTO covid_cases (country_id, report_date, confirmed_cases, deaths, recoveries) VALUES
(1, '2021-05-01', 19500000, 215000, 17500000),
(1, '2021-06-01', 28000000, 340000, 25500000),
(2, '2021-05-01', 32300000, 575000, 25000000),
(2, '2021-06-01', 33500000, 598000, 27500000),
(3, '2021-05-01', 4400000, 127000, 3500000),
(3, '2021-06-01', 4500000, 128000, 4000000),
(4, '2021-05-01', 15400000, 430000, 13500000),
(4, '2021-06-01', 17100000, 480000, 15200000),
(5, '2021-05-01', 3600000, 87000, 3300000),
(5, '2021-06-01', 3700000, 90000, 3500000);

-- INNER JOIN to get country name with case data
SELECT c.country_name, c.continent, ck.report_date, ck.confirmed_cases
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
WHERE ck.report_date = '2021-06-01'
ORDER BY ck.confirmed_cases DESC;

-- Find the country with the highest confirmed cases on 2021-06-01
SELECT c.country_name, ck.confirmed_cases, ck.report_date
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
WHERE ck.report_date = '2021-06-01'
ORDER BY ck.confirmed_cases DESC
LIMIT 1;

-- Find highest confirmed cases for each country across all dates
SELECT c.country_name, MAX(ck.confirmed_cases) AS max_confirmed
FROM covid_cases ck
INNER JOIN countries c ON ck.country_id = c.country_id
GROUP BY c.country_name
ORDER BY max_confirmed DESC;
