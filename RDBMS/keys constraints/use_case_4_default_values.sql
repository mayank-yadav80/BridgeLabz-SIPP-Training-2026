-- Use Case 4: Set Default Values
-- Objective: Automatically assign default values when no value is provided

CREATE DATABASE IF NOT EXISTS covid_db_defaults;
USE covid_db_defaults;

-- Table with DEFAULT constraints
CREATE TABLE covid_cases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT NOT NULL DEFAULT 0,
    deaths INT NOT NULL DEFAULT 0,
    recoveries INT DEFAULT 0,
    population BIGINT DEFAULT 0,
    vaccination_rate DECIMAL(5, 2) DEFAULT 0.00,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE KEY unique_country_date (country, report_date)
);

-- Insert without specifying recoveries, vaccination_rate, last_updated (uses defaults)
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, population) VALUES
('India', '2021-05-01', 19500000, 215000, 1380004385),
('USA', '2021-05-01', 32300000, 575000, 331002651),
('UK', '2021-05-01', 4400000, 127000, 67886011);

-- Insert with some defaults overridden
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, vaccination_rate) VALUES
('India', '2021-06-01', 28000000, 340000, 25500000, 18.12),
('USA', '2021-06-01', 33500000, 598000, 27500000, 84.59);

-- Verify default values were applied
SELECT country, report_date, confirmed_cases, deaths, recoveries,
       vaccination_rate, last_updated
FROM covid_cases
ORDER BY country, report_date;

-- Show table structure with defaults
DESCRIBE covid_cases;
SHOW CREATE TABLE covid_cases;

-- Demonstrate last_updated auto-update
UPDATE covid_cases
SET confirmed_cases = confirmed_cases + 100000
WHERE country = 'India' AND report_date = '2021-05-01';

-- Check that last_updated was automatically refreshed
SELECT country, report_date, confirmed_cases, last_updated
FROM covid_cases
WHERE country = 'India' AND report_date = '2021-05-01';
