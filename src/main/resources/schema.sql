DROP TABLE IF EXISTS LEAD;

CREATE TABLE LEAD (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mobile VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  location_type VARCHAR(250) NOT NULL,
  location_string VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL,
  communication VARCHAR(250)
);