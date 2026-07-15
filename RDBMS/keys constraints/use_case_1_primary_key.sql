-- Use Case 1: Define Primary Keys in COVID Tables
-- Objective: Ensure each country has only one COVID record per reporting date
-- using a composite primary key

CREATE DATABASE IF NOT EXISTS covid_db_pk;
USE covid_db_pk;

-- Table with composite primary key on (country, report_date)
CREATE TABLE covid_cases (
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT DEFAULT 0,
    PRIMARY KEY (country, report_date)
);

-- Insert valid records (no duplicates for same country + date)
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2021-05-01', 19500000, 215000, 17500000, 1380004385),
('India', '2021-06-01', 28000000, 340000, 25500000, 1380004385),
('USA', '2021-05-01', 32300000, 575000, 25000000, 331002651),
('USA', '2021-06-01', 33500000, 598000, 27500000, 331002651),
('UK', '2021-05-01', 4400000, 127000, 3500000, 67886011);

-- This will FAIL due to duplicate primary key (India, 2021-05-01)
-- INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths)
-- VALUES ('India', '2021-05-01', 19600000, 220000);

-- Verify data
SELECT * FROM covid_cases ORDER BY country, report_date;

-- Show table structure with primary key
DESCRIBE covid_cases;

-- Show key information
SHOW CREATE TABLE covid_cases;
