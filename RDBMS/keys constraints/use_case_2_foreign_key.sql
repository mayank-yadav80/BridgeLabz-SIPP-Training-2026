-- Use Case 2: Create Foreign Key Relationships
-- Objective: Establish referential integrity between covid_cases and countries table

CREATE DATABASE IF NOT EXISTS covid_db_fk;
USE covid_db_fk;

-- Reference table: countries
CREATE TABLE countries (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL UNIQUE,
    continent VARCHAR(50),
    population BIGINT,
    iso_code VARCHAR(10)
);

-- covid_cases table with foreign key to countries
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT DEFAULT 0,
    deaths INT DEFAULT 0,
    recoveries INT DEFAULT 0,
    UNIQUE KEY unique_country_date (country_id, report_date),
    FOREIGN KEY (country_id) REFERENCES countries(country_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Insert valid countries
INSERT INTO countries (country_name, continent, population, iso_code) VALUES
('India', 'Asia', 1380004385, 'IND'),
('USA', 'North America', 331002651, 'USA'),
('UK', 'Europe', 67886011, 'GBR'),
('Germany', 'Europe', 83783942, 'DEU'),
('Brazil', 'South America', 212559417, 'BRA');

-- Insert COVID records using valid country_id
INSERT INTO covid_cases (country_id, report_date, confirmed_cases, deaths, recoveries) VALUES
(1, '2021-05-01', 19500000, 215000, 17500000),
(1, '2021-06-01', 28000000, 340000, 25500000),
(2, '2021-05-01', 32300000, 575000, 25000000),
(2, '2021-06-01', 33500000, 598000, 27500000),
(3, '2021-05-01', 4400000, 127000, 3500000);

-- This will FAIL due to foreign key constraint (country_id 999 doesn't exist)
-- INSERT INTO covid_cases (country_id, report_date, confirmed_cases)
-- VALUES (999, '2021-05-01', 1000000);

-- Verify referential integrity with JOIN
SELECT c.country_name, c.continent,
       ck.report_date, ck.confirmed_cases, ck.deaths
FROM covid_cases ck
JOIN countries c ON ck.country_id = c.country_id
ORDER BY c.country_name, ck.report_date;

-- Show foreign key constraint details
DESCRIBE covid_cases;
SHOW CREATE TABLE covid_cases;
