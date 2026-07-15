-- Task 2: Insert Initial COVID Data
-- Objective: Populate the database with sample COVID records

USE covid_db;

-- Insert single record
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population)
VALUES ('India', '2021-05-01', 19500000, 215000, 17500000, 1380004385);

-- Insert multiple records for India
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('India', '2021-06-01', 28000000, 340000, 25500000, 1380004385),
('India', '2021-07-01', 30500000, 400000, 29500000, 1380004385),
('India', '2021-08-01', 31800000, 425000, 31000000, 1380004385);

-- Insert multiple records for USA
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('USA', '2021-05-01', 32300000, 575000, 25000000, 331002651),
('USA', '2021-06-01', 33500000, 598000, 27500000, 331002651),
('USA', '2021-07-01', 34200000, 610000, 29000000, 331002651),
('USA', '2021-08-01', 35800000, 625000, 30500000, 331002651);

-- Insert multiple records for UK
INSERT INTO covid_cases (country, report_date, confirmed_cases, deaths, recoveries, population) VALUES
('UK', '2021-05-01', 4400000, 127000, 3500000, 67886011),
('UK', '2021-06-01', 4500000, 128000, 4000000, 67886011),
('UK', '2021-07-01', 4900000, 129000, 4300000, 67886011),
('UK', '2021-08-01', 6200000, 131000, 5000000, 67886011);

-- Insert records into covid_deaths
INSERT INTO covid_deaths (country, report_date, deaths, recovery_rate, mortality_rate) VALUES
('India', '2021-05-01', 215000, 89.74, 1.10),
('India', '2021-06-01', 340000, 91.07, 1.21),
('USA', '2021-05-01', 575000, 77.40, 1.78),
('USA', '2021-06-01', 598000, 82.09, 1.79),
('UK', '2021-05-01', 127000, 79.55, 2.89),
('UK', '2021-06-01', 128000, 88.89, 2.84);

-- Insert records into covid_vaccines
INSERT INTO covid_vaccines (country, report_date, total_vaccinated, first_dose, second_dose, booster_dose, vaccination_rate) VALUES
('India', '2021-05-01', 160000000, 120000000, 40000000, 0, 11.59),
('India', '2021-06-01', 250000000, 180000000, 70000000, 0, 18.12),
('USA', '2021-05-01', 250000000, 140000000, 110000000, 0, 75.53),
('USA', '2021-06-01', 280000000, 150000000, 130000000, 0, 84.59),
('UK', '2021-05-01', 50000000, 35000000, 15000000, 0, 73.65),
('UK', '2021-06-01', 58000000, 40000000, 18000000, 0, 85.44);

-- Verify inserted data
SELECT * FROM covid_cases ORDER BY country, report_date;
SELECT * FROM covid_deaths ORDER BY country, report_date;
SELECT * FROM covid_vaccines ORDER BY country, report_date;
