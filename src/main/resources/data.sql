
INSERT INTO address (street, postal_code, city) VALUES ('Storgatan 1', '12345', 'Stockholm');
INSERT INTO address (street, postal_code, city) VALUES ('Centralgatan 15', '34567', 'Malmö');
INSERT INTO address (street, postal_code, city) VALUES ('Skogsvägen 3', '45678', 'Uppsala');
INSERT INTO address (street, postal_code, city) VALUES ('Havsgränd 9', '56789', 'Lund');
INSERT INTO address (street, postal_code, city) VALUES ('Fjällgatan 7', '83145', 'Östersund');

INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Anna', 'Svensson', 'anna@example.com', null, '1990-05-14', 1);

INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Erik', 'Johansson', 'erik@example.com', '0734567890', '1985-11-22', 1);

INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Maria', 'Lindgren', 'maria@example.com', '0723344556', '1992-07-30', 2);

INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Oskar', 'Nilsson', 'oskar@example.com', '0767891234', '1988-01-10', 3);

INSERT INTO member (first_name, last_name, email, phone, date_of_birth, address_id)
VALUES ('Lisa', 'Andersson', 'lisa@example.com', null, '1995-09-25', 4);
