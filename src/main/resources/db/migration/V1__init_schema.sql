-- Schema initialization for Resource Management App

CREATE TABLE location (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          street_address VARCHAR(255) NOT NULL,
                          city VARCHAR(100) NOT NULL,
                          postal_code VARCHAR(20) NOT NULL,
                          country_code VARCHAR(2) NOT NULL
);

CREATE TABLE resource (
                          id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          type VARCHAR(50) NOT NULL,
                          country_code VARCHAR(2) NOT NULL,
                          location_id BIGINT UNIQUE NOT NULL,
                          CONSTRAINT fk_location FOREIGN KEY (location_id) REFERENCES location(id) ON DELETE CASCADE
);

CREATE TABLE characteristic (
                                id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                code VARCHAR(5) NOT NULL,
                                type VARCHAR(50) NOT NULL,
                                value VARCHAR(255) NOT NULL,
                                resource_id BIGINT NOT NULL,
                                CONSTRAINT fk_resource FOREIGN KEY (resource_id) REFERENCES resource(id) ON DELETE CASCADE
);

CREATE INDEX idx_characteristic_code ON characteristic(code);
CREATE INDEX idx_resource_type ON resource(type);
CREATE INDEX idx_location_country ON location(country_code);
