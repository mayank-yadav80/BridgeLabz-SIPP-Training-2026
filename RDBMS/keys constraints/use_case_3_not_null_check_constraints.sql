-- Use Case 3: Add Constraints to Ensure Data Quality
-- Objective: Apply NOT NULL and CHECK constraints on critical columns

CREATE DATABASE IF NOT EXISTS covid_db_constraints;
USE covid_db_constraints;

-- Table with NOT NULL and CHECK constraints
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT DEFAULT 0,
    CHECK (deaths <= confirmed_cases),
    CHECK (confirmed_cases >= 0),
    CHECK (deaths >= 0),
    CHECK (recoveries >= 0),
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Insert valid records
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2021-05-01', 19500000, 215000, 17500000, 1380004385),
('India', '2021-06-01', 28000000, 340000, 25500000, 1380004385),
('USA', '2021-05-01', 32300000, 575000, 25000000, 331002651),
('USA', '2021-06-01', 33500000, 598000, 27500000, 331002651),
('UK', '2021-05-01', 4400000, 127000, 3500000, 67886011);

-- This will FAIL: deaths (500000) > confirmed_cases (100000)
-- INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths)
-- VALUES ('Test', '2021-01-01', 100000, 500000);

-- This will FAIL: NULL in NOT NULL column
-- INSERT INTO covid_cases (report_date, confirmed_cases, deaths)
-- VALUES ('2021-01-01', 100000, 5000);

-- This will FAIL: negative confirmed_cases
-- INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths)
-- VALUES ('Test', '2021-01-01', -100, 50);

-- Verify data
SELECT * FROM covid_cases ORDER BY country, report_date;

-- Show constraints
DESCRIBE covid_cases;
SHOW CREATE TABLE covid_cases;
