CREATE TABLE theatres (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(150) NOT NULL,
  description VARCHAR(500),
  contact_number VARCHAR(20) NOT NULL,
  contact_email VARCHAR(120) NOT NULL,
  status VARCHAR(40) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE theatre_addresses (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  theatre_id BIGINT NOT NULL UNIQUE,
  address_line_1 VARCHAR(150) NOT NULL,
  address_line_2 VARCHAR(150),
  city VARCHAR(80) NOT NULL,
  state VARCHAR(80) NOT NULL,
  country VARCHAR(80) NOT NULL,
  pincode VARCHAR(20) NOT NULL,
  latitude DOUBLE,
  longitude DOUBLE,
  CONSTRAINT fk_theatre_address_theatre FOREIGN KEY (theatre_id) REFERENCES theatres(id)
);

CREATE TABLE theatre_facilities (
  theatre_id BIGINT NOT NULL,
  facility VARCHAR(50) NOT NULL,
  CONSTRAINT fk_theatre_facility_theatre FOREIGN KEY (theatre_id) REFERENCES theatres(id)
);

CREATE TABLE screens (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  theatre_id BIGINT NOT NULL,
  screen_name VARCHAR(120) NOT NULL,
  screen_type VARCHAR(40) NOT NULL,
  total_seats INT NOT NULL,
  status VARCHAR(40) NOT NULL,
  layout_id BIGINT,
  CONSTRAINT fk_screen_theatre FOREIGN KEY (theatre_id) REFERENCES theatres(id)
);
