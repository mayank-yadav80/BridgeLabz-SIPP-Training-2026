-- Use Case 2: Join COVID Deaths and Vaccination Data
-- Objective: Consolidate death counts and vaccination statuses using LEFT JOIN

USE covid_db_joins;

-- Create covid_deaths table
CREATE TABLE covid_deaths (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    deaths INT DEFAULT 0,
    mortality_rate DECIMAL(5, 2) DEFAULT 0.00,
    FOREIGN KEY (country_id) REFERENCES countries(country_id),
    UNIQUE KEY unique_country_date (country_id, report_date)
);

-- Create covid_vaccines table
CREATE TABLE covid_vaccines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country_id INT NOT NULL,
    report_date DATE NOT NULL,
    total_vaccinated BIGINT DEFAULT 0,
    first_dose BIGINT DEFAULT 0,
    second_dose BIGINT DEFAULT 0,
    vaccination_rate DECIMAL(5, 2) DEFAULT 0.00,
    FOREIGN KEY (country_id) REFERENCES countries(country_id),
    UNIQUE KEY unique_country_date (country_id, report_date)
);

-- Insert death data for all countries
INSERT INTO covid_deaths (country_id, report_date, deaths, mortality_rate) VALUES
(1, '2021-05-01', 215000, 1.10),
(1, '2021-06-01', 340000, 1.21),
(2, '2021-05-01', 575000, 1.78),
(2, '2021-06-01', 598000, 1.79),
(3, '2021-05-01', 127000, 2.89),
(3, '2021-06-01', 128000, 2.84),
(4, '2021-05-01', 430000, 2.79),
(4, '2021-06-01', 480000, 2.81),
(5, '2021-05-01', 87000, 2.42),
(5, '2021-06-01', 90000, 2.43);

-- Insert vaccination data (missing some entries to demonstrate LEFT JOIN)
INSERT INTO covid_vaccines (country_id, report_date, total_vaccinated, first_dose, second_dose, vaccination_rate) VALUES
(1, '2021-05-01', 160000000, 120000000, 40000000, 11.59),
(1, '2021-06-01', 250000000, 180000000, 70000000, 18.12),
(2, '2021-05-01', 250000000, 140000000, 110000000, 75.53),
(2, '2021-06-01', 280000000, 150000000, 130000000, 84.59),
(3, '2021-05-01', 50000000, 35000000, 15000000, 73.65);
-- Note: No vaccination data for Germany (country_id=5) and UK (country_id=3) on 2021-06-01

-- LEFT JOIN: Show all death records, even if vaccination data is missing
SELECT c.country_name,
       cd.report_date,
       cd.deaths,
       cd.mortality_rate,
       cv.total_vaccinated,
       cv.vaccination_rate
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv
    ON cd.country_id = cv.country_id AND cd.report_date = cv.report_date
INNER JOIN countries c ON cd.country_id = c.country_id
ORDER BY c.country_name, cd.report_date;

-- Show only records with missing vaccination data
SELECT c.country_name, cd.report_date, cd.deaths
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv
    ON cd.country_id = cv.country_id AND cd.report_date = cv.report_date
INNER JOIN countries c ON cd.country_id = c.country_id
WHERE cv.country_id IS NULL
ORDER BY c.country_name, cd.report_date;

-- Full summary with COALESCE for missing values
SELECT c.country_name,
       cd.report_date,
       cd.deaths,
       COALESCE(cv.total_vaccinated, 0) AS total_vaccinated,
       COALESCE(cv.vaccination_rate, 0) AS vaccination_rate
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv
    ON cd.country_id = cv.country_id AND cd.report_date = cv.report_date
INNER JOIN countries c ON cd.country_id = c.country_id
ORDER BY c.country_name, cd.report_date;
