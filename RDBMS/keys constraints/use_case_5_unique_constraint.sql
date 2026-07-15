-- Use Case 5: Prevent Duplicate Country-Date Entries
-- Objective: Enforce uniqueness on the combination of Country and Date

CREATE DATABASE IF NOT EXISTS covid_db_unique;
USE covid_db_unique;

-- Table with UNIQUE constraint on (country, report_date)
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT DEFAULT 0,
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Insert valid unique records
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2021-05-01', 19500000, 215000, 17500000, 1380004385),
('India', '2021-06-01', 28000000, 340000, 25500000, 1380004385),
('USA', '2021-05-01', 32300000, 575000, 25000000, 331002651),
('USA', '2021-06-01', 33500000, 598000, 27500000, 331002651),
('UK', '2021-05-01', 4400000, 127000, 3500000, 67886011),
('UK', '2021-06-01', 4500000, 128000, 4000000, 67886011);

-- This will FAIL: duplicate (India, 2021-05-01) already exists
-- INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths)
-- VALUES ('India', '2021-05-01', 19600000, 220000);

-- This is VALID: same country, different date
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2021-07-01', 30500000, 400000, 29500000, 1380004385);

-- This is VALID: same date, different country
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('Germany', '2021-05-01', 3600000, 87000, 3300000, 83783942);

-- Verify data - no duplicates exist
SELECT country, report_date, confirmed_cases, deaths
FROM covid_cases
ORDER BY country, report_date;

-- Demonstrate: check for any duplicate attempts
SELECT country, report_date, COUNT(*) as record_count
FROM covid_cases
GROUP BY country, report_date
HAVING COUNT(*) > 1;

-- Show unique constraint details
DESCRIBE covid_cases;
SHOW CREATE TABLE covid_cases;
